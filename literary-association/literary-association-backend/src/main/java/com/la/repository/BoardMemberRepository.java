package com.la.repository;

import com.la.model.users.BoardMember;

import java.util.List;

public interface BoardMemberRepository extends UserRepository<BoardMember> {
    List<BoardMember> findAll();
}
