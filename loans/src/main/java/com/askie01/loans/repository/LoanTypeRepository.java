package com.askie01.loans.repository;

import com.askie01.loans.entity.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanTypeRepository extends JpaRepository<LoanType, Long> {
    Optional<LoanType> findByName(String name);
}
