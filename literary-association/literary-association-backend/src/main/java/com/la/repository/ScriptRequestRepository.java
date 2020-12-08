package com.la.repository;

import com.la.model.ScriptRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScriptRequestRepository extends JpaRepository<ScriptRequest, Long> {
}
