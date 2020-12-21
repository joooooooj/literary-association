package com.la.repository;

import com.la.model.Card;
import com.la.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAllByName(String name);

    Client findByNameAndSurname(String name, String surname);

    Card findByPanAndSecurityCodeAndExpireDate(String pan, String securityCode, String expireDate);
}
