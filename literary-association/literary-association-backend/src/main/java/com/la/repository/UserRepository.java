package com.la.repository;

import com.la.model.users.SysUser;
import com.la.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<SysUser, Long> {

    SysUser findByUsername(String username);
    List<SysUser> findByType(String editor);
}
