package com.askie01.cards.repository;

import com.askie01.cards.entity.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardTypeRepository extends JpaRepository<CardType, Long> {
    Optional<CardType> findByName(String name);
}
