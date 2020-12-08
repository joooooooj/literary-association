package com.la.repository;

import com.la.model.BoardMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardMemberCommentRepository extends JpaRepository<BoardMember, Long> {
}
