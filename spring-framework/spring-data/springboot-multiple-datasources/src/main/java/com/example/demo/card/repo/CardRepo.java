package com.example.demo.card.repo;

import com.example.demo.card.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepo extends JpaRepository<Card, Long> {
}
