package com.example.demo.card.controller;

import com.example.demo.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hprt/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public long getCount() {
        return cardService.getCardCount();
    }



}
