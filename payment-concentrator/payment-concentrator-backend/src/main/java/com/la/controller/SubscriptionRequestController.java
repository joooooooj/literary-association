package com.la.controller;

import com.la.service.SubscriptionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/request")
public class SubscriptionRequestController {

    @Autowired
    private SubscriptionRequestService subscriptionService;

    @PostMapping("/approve/{id}")
    @PreAuthorize("hasAuthority('APPROVE_REQUEST')")
    public ResponseEntity<?> approveRequest(@PathVariable("id") Long requestId) {
        try {
            subscriptionService.approveRequest(requestId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/decline/{id}")
    @PreAuthorize("hasAuthority('DECLINE_REQUEST')")
    public ResponseEntity<Boolean> declineRequest(@PathVariable("id") Long requestId) {
        try {
            return new ResponseEntity<Boolean>(subscriptionService.declineRequest(requestId), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
