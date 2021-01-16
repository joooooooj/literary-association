package com.la.repository;

import com.la.model.Subscriber;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends UserRepository<Subscriber> {
    Subscriber getByClientId(String clientId);

    Subscriber findByUsername(String username);
}
