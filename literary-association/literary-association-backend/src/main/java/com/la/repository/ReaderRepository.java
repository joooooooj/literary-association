package com.la.repository;

import com.la.model.users.Reader;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReaderRepository extends UserRepository<Reader> {
    Reader findByUsername(String username);

    List<Reader> findByBetaIsTrue();
}
