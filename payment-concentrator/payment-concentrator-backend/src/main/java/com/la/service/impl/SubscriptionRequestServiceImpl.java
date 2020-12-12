package com.la.service.impl;

import com.la.dto.SubscriptionRequestDTO;
import com.la.mapper.SubscriptionRequestDTOMapper;
import com.la.model.PaymentMethod;
import com.la.model.Subscriber;
import com.la.model.SubscriptionRequest;
import com.la.repository.RoleRepository;
import com.la.repository.SubscriptionRequestRepository;
import com.la.repository.UserRepository;
import com.la.service.SubscriptionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service
public class SubscriptionRequestServiceImpl implements SubscriptionRequestService {

    @Autowired
    private SubscriptionRequestRepository subscriptionRequestRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private SubscriptionRequestDTOMapper mapper;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public List<SubscriptionRequest> getAll() {
        return subscriptionRequestRepository.findAll();
    }

    @Override
    public Long createRequest(SubscriptionRequestDTO requestDTO) throws ParseException {
        return (subscriptionRequestRepository.saveAndFlush(mapper.toEntity(requestDTO))).getId();
    }

    @Override
    public void approveRequest(Long requestId) {
        SubscriptionRequest request = subscriptionRequestRepository.getOne(requestId);
        Set<PaymentMethod> m = new HashSet<>(request.getPaymentMethods());

        // TO DO: send mail

        Subscriber newSubscriber = new Subscriber(request.getOrganizationName().toLowerCase(),
                encoder.encode(generatePassword()), request.getOrganizationEmail(), m);
        newSubscriber.setRoles(new HashSet<>(Collections.singletonList(roleRepository.findByName("ROLE_SUBSCRIBER"))));

        userRepository.save(newSubscriber);

        subscriptionRequestRepository.deleteById(requestId);
    }

    @Override
    public Boolean declineRequest(Long requestId) {
        try {
            subscriptionRequestRepository.deleteById(requestId);
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    private String generatePassword() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);
        return generatedString;
    }
}
