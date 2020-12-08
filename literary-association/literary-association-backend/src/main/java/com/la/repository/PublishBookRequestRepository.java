package com.la.repository;

import com.la.model.PublishBookRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishBookRequestRepository extends JpaRepository<PublishBookRequest, Long> {
}
