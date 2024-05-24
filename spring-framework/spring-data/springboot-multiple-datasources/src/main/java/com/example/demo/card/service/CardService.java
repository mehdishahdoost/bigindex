package com.example.demo.card.service;


import com.example.demo.card.repo.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    private CardRepo cardRepo;

    public long getCardCount() {
        return cardRepo.count();
    }
}
