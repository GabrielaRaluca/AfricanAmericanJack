package utilities;

import java.util.ArrayList;
import java.util.Collections;

public class Deck 
{
    private ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<Card>();
        for(int i=1;i<=13;i++)
        {
            deck.add(new Card(i,"Diamonds"));
            deck.add(new Card(i,"Clubs"));
            deck.add(new Card(i,"Hearts"));
            deck.add(new Card(i,"Spades"));
        }
        Collections.shuffle(deck);
    }

    public Card drawCard() 
    {
        Card temp;
        temp = deck.get(deck.size()-1);
        deck.remove(deck.size()-1);
        return temp;
    }
}
