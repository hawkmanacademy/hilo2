package com.funkygames.funkyhilo.exception;

/**
 * Created by Anabela on 02/08/2015.
 */
public class NoMoreCardsInDeckException extends Exception {
    public NoMoreCardsInDeckException(){
        super("no more cards in deck");
    }

}
