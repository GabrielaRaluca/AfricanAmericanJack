package utilities;

import java.io.Serializable;

public class Card implements Serializable{

    public static final long serialVersionUID = 1L;

    private int value;
    private String suit;

    Card(int value, String suit)
    {
        this.value = value;
        this.suit = suit;
    }

    public int getValue()
    {
        return value;
    }


    @Override
    public String toString() {
        if(value == 1)
        {
            return "Ace of " + suit;
        }
        if(value == 11)
        {
            return "Jack of " + suit;
        }
        if(value == 12) {
            return "Queen of " + suit;
        }
        if(value == 13)
        {
            return "King of " + suit;
        }
        return value + " of " + suit;
    }
}
