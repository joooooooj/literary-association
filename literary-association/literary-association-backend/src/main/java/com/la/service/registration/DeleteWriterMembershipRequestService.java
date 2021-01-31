package com.la.service.registration;

import com.la.model.registration.WriterMembershipRequest;
import com.la.repository.UserRepository;
import com.la.repository.WriterMembershipRequestRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteWriterMembershipRequestService implements JavaDelegate {

    @Autowired
    private WriterMembershipRequestRepository writerMembershipRequestRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String username = (String) delegateExecution.getVariable("registeredUser");
        WriterMembershipRequest request = writerMembershipRequestRepository.findByUsername(username);

        // not working, cannot delete child
        //writerMembershipRequestRepository.deleteById(request.getId());

        System.err.println("PROCESS FINISHED...");
    }
}
