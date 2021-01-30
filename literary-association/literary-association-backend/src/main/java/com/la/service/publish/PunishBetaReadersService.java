package com.la.service.publish;

import com.la.model.Email;
import com.la.model.publish.BetaReaderComment;
import com.la.model.publish.PublishBookRequest;
import com.la.model.users.Reader;
import com.la.repository.ReaderRepository;
import com.la.service.SendEmailService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PunishBetaReadersService implements JavaDelegate {

    @Autowired
    ReaderRepository readerRepository;

    @Autowired
    SendEmailService sendEmailService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        List<Reader> readerList = (List<Reader>) delegateExecution.getVariable("beta");
        PublishBookRequest publishBookRequest = (PublishBookRequest) delegateExecution.getVariable("publishBookRequest");
        List<BetaReaderComment> betaReaderCommentList = publishBookRequest.getBetaReaderCommentList();
        Map<String, BetaReaderComment> betaReaderComments = new HashMap<>();
        for (BetaReaderComment betaReaderComment : betaReaderCommentList) {
            betaReaderComments.put(betaReaderComment.getReader(), betaReaderComment);
        }
        for(Reader reader : readerList) {
            if (!betaReaderComments.containsKey(reader.getUsername())){
                punishBetaReader(reader);
            }
        }
    }

    private void punishBetaReader(Reader reader) {
        if (readerRepository.findById(reader.getId()).isPresent()){
            if ((reader.getPenaltyPoints() - 1) == -5){
                reader.setBeta(false);
                sendEmail(reader, true, -5);
            }
            else {
                reader.setPenaltyPoints(reader.getPenaltyPoints() - 1);
                sendEmail(reader, false, reader.getPenaltyPoints() - 1);
            }
            readerRepository.save(reader);
        }
    }

    private void sendEmail(Reader reader, boolean lostBeta, Integer penalty) {
        String emailBeta = reader.getEmail();
        System.err.println("TO BETA READER");
        System.err.println(emailBeta);

        Email email = new Email();
        email.setSubject("You have been punished");
        if (lostBeta) {
            email.setBody("You have -5 penalty points. You are no longer beta reader!");
        }
        else {
            email.setBody("Watch watch, if you reach -5 penalty points, you will lose beta reader role! You now have " + penalty + " points.");
        }
        email.setEmailFrom("VULKAN");
        email.setEmailTo("rento.office@gmail.com");
        sendEmailService.sendEmail(email);
    }
}
