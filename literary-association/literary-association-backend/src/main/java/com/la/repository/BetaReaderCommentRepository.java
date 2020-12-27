package com.la.repository;

import com.la.model.users.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetaReaderCommentRepository extends JpaRepository<Reader, Long> {
}
