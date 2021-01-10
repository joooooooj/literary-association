package com.la.repository;

import com.la.model.Subscriber;

public interface SubscriberRepository extends UserRepository<Subscriber> {
    Subscriber getByClientId(String clientId);
}
