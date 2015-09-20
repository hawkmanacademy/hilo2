package com.funkygames.funkyhilo.constants;

/**
 * Created by Anabela on 02/08/2015.
 */
public enum Rank {
    ACE(1), DEUCE(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

    private int intValue;

    private Rank(int intValue){
        this.intValue = intValue;

    }

    public int getIntValue(){
        return intValue;
    }
}
