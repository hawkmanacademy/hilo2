package com.funkygames.funkyhilo.model;

import com.funkygames.funkyhilo.exception.NoMoreCardsInDeckException;

/**
 * Created by Anabela on 02/08/2015.
 */
public class Dealer {
    //dealer has a deck of cards
    private Deck deck;

    public Dealer() {
        //when a dealer is created, give them a new deck of cards
        this.deck = new Deck();
        shuffle();
    }

    public void shuffle(){
        this.deck.shuffle();
    }

    public Card deal() {
        //when the dealer is called, draw a card from the deck
        Card card = null;
        try {
            card = deck.drawCard();
        } catch (NoMoreCardsInDeckException e) {
            //if the deck is empty, create a new deck
            deck = new Deck();
            try {
                //if the deck is empty, create a new deck and deal again
                card = deck.drawCard();
            } catch (NoMoreCardsInDeckException e1) {
                throw new IllegalStateException("a new deck should always have at least one card");
            }

            System.out.println("run out of cards, print a new deck");
        }
        return card;
    }
}