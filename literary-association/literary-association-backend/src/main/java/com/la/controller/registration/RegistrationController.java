package com.la.controller.registration;

import com.la.model.dtos.WriterMembershipRequestDataNeededDTO;
import com.la.model.registration.WriterMembershipRequest;
import com.la.repository.WriterMembershipRequestRepository;
import com.la.security.TokenUtils;
import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/registration")
public class RegistrationController {

    @Autowired
    private IdentityService identityService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private FormService formService;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private WriterMembershipRequestRepository writerMembershipRequestRepository;

    // 6. KORAK / PREDUSLOV
    @GetMapping(value = "/request/self/{token:.+}")
    public ResponseEntity<?> getDataNeeded(@PathVariable String token) {
        String username = tokenUtils.getUsernameFromToken(token);
        User user = identityService.createUserQuery().userId(username).singleResult();

        if (user != null) {
            WriterMembershipRequest request = (WriterMembershipRequest) writerMembershipRequestRepository.findByUsername(username);

            WriterMembershipRequestDataNeededDTO dataNeeded = new WriterMembershipRequestDataNeededDTO();
            dataNeeded.setAttemptsNumber(request.getAttemptsNumber());
            dataNeeded.setPaymentDeadline(request.getPaymentDeadline());
            dataNeeded.setStatus(request.getStatus());
            dataNeeded.setSubmissionDeadline(request.getSubmissionDeadline());

            return new ResponseEntity<>(dataNeeded, HttpStatus.OK);
        }
        return new ResponseEntity<>("Not existing user", HttpStatus.BAD_REQUEST);
    }

}
