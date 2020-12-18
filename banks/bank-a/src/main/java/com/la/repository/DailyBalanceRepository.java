package com.la.repository;

import com.la.model.DailyBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyBalanceRepository extends JpaRepository<DailyBalance, Long> {
}
