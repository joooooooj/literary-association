package com.la.repository;

import com.la.model.BuyerRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRequestRepository extends JpaRepository<BuyerRequest, Long> {
}
