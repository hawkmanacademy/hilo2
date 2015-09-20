package com.funkygames.funkyhilo.model;

import java.util.ArrayList;
import java.util.List;

import com.funkygames.funkyhilo.constants.Rank;
import com.funkygames.funkyhilo.constants.Suit;

public class CardFactory {
	public static List<Card> createCardList(){
		List<Card> cards = new ArrayList<Card>();
	
        //1 - for each Suit
        for (Suit suit : Suit.values()) {
            //2 - for each rank
            for (Rank rank : Rank.values()) {
                //3 - create a card with the rank and suit passed into the constructor
                Card card = new Card(rank, suit);

                //4 - add the newly created card to the cards lists
                cards.add(card);
            }
        }
		
		return cards;
	}
}
