package com.la.repository;

import com.la.model.registration.WriterMembershipRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface WriterMembershipRequestRepository extends UserRepository<WriterMembershipRequest> {
}
