package com.la.repository;

import com.la.model.users.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}
