package com.la.service.publish;

import com.la.model.publish.PublishBookRequest;
import com.la.model.users.Lector;
import com.la.model.users.SysUser;
import com.la.repository.LectorRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class SetLector implements JavaDelegate {

    @Autowired
    private LectorRepository lectorRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        List<Lector> lectorList = lectorRepository.findAll();
        Random rand = new Random();
        Lector randLector = lectorList.get(rand.nextInt(lectorList.size()));

        delegateExecution.setVariable("lector", randLector.getUsername());

        PublishBookRequest publishBookRequest = (PublishBookRequest) delegateExecution.getVariable("publishBookRequest");
        publishBookRequest.setLector(randLector.getUsername());
        delegateExecution.setVariable("publishBookRequest", publishBookRequest);

        System.err.println("Choosen lector with ID : " + delegateExecution.getVariable("lector"));
    }
}
