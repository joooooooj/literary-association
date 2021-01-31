package com.la.repository;

import com.la.model.registration.SubmittedWork;
import com.la.model.registration.WriterMembershipRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmittedWorkRepository extends JpaRepository<SubmittedWork, Long> {
    SubmittedWork findByPathContaining(String processInstanceIdString);

    SubmittedWork findByWriterMembershipRequest(WriterMembershipRequest writerMembershipRequest);
}
