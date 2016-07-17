package gui;

import utilities.Card;

public interface Visualizable 
{
	public void addCard(Card card);
    public void setTotal(int total);
    public void setCurrentPlayer(String currentPlayer);
}
