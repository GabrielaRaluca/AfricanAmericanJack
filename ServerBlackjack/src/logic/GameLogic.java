package logic;

import networking.Server;
import networking.Serverthread;
import utilities.Card;
import utilities.Deck;

public class GameLogic 
{

	Server server;

	public GameLogic(Server server) 
	{
		this.server = server;
	}

	public void playGame() 
	{
		this.server.setTurn(0);
		sendTwoCardsToAllPlayers();
		clientsPlay();
		dealersPlay();
		sendResultsToAllPlayers();
		this.server.setGameEnded(true);
	}

	public void sendTwoCardsToAllPlayers() 
	{
		Deck deck = new Deck();
		this.server.setDeck(deck);

		Card card1;
		Card card2;

		System.out.println("Sending their cards");
		for (int i = 0; i < this.server.getThreads().size(); i++) 
		{
			card1 = deck.drawCard();
			card2 = deck.drawCard();

			Player player = new Player(card1, card2);
			this.server.getThreads().get(i).setPlayer(player);
			this.server.getThreads().get(i).sendMessage("You were dealt: ");

			this.server.getThreads().get(i).sendMessage(player.getHand().get(0));

			this.server.getThreads().get(i).sendMessage(player.getHand().get(1));

			this.server.getThreads().get(i).sendMessage("Your sums are: ");

			for (int j = 0; j < player.getTotal().size(); j++) {
				this.server.getThreads().get(i).sendMessage(player.getTotal().get(j));
			}

		}
		card1 = deck.drawCard();
		card2 = deck.drawCard();

		Player dealer = new Player(card1, card2);
		this.server.setDealer(dealer);

		System.out.println("Sending dealer card");
		for (int i = 0; i < this.server.getThreads().size(); i++) 
		{
			this.server.getThreads().get(i).sendMessage("Dealer has: ");
			this.server.getThreads().get(i).sendMessage(dealer.getHand().get(0));
		}
	}
	
	public void clientsPlay() 
	{

		int i = 0;
		this.server.getThreads().get(i).setWait(false);
		System.out.println("Player " + (i + 1) + "'s turn");
		while (i < this.server.getThreads().size() - 1 || !this.server.getThreads().get(this.server.getThreads().size() - 1).getFinished()) 
		{
			if (i < this.server.getThreads().size() - 1 && this.server.getThreads().get(i).getFinished()) 
			{
				i++;
				this.server.setTurn(i);
				this.server.getThreads().get(i).setWait(false);
				System.out.println("Player " + (i + 1) + "'s turn");
			}
		}

	}

	public void dealersPlay()
	{
		 while(!this.server.getDealer().getTotal().isEmpty() && this.server.getDealer().getTotal().get(0) < 17 )
	        {
	            this.server.getDealer().addCard(this.server.getDeck().drawCard());
	        }
	}
	
	public void sendResultsToAllPlayers() 
	{
		for (int i = 0; i < this.server.getThreads().size(); i++) 
		{
			if (!this.server.getThreads().get(i).getPlayer().getTotal().isEmpty())
			{
				if (!this.server.getDealer().getTotal().isEmpty()) 
				{

					int dealerTotal = this.server.getDealer().getTotal()
							.get(this.server.getDealer().getTotal().size() - 1);
					int playerTotal = this.server.getThreads().get(i).getPlayer().getTotal()
							.get(this.server.getThreads().get(i).getPlayer().getTotal().size() - 1);

					this.server.getThreads().get(i).sendMessage("Dealer has: ");

					this.server.getThreads().get(i).sendMessage(dealerTotal);

					if (dealerTotal > playerTotal) 
					{
						this.server.getThreads().get(i).sendMessage("You Lost");
					} 
					else if (dealerTotal == playerTotal) 
					{
						this.server.getThreads().get(i).sendMessage("Draw");
					}
					else 
					{
						this.server.getThreads().get(i).sendMessage("You Win");
					}
				} 
				else 
				{
					this.server.getThreads().get(i).sendMessage("Dealer BUSTED! You Win!");
				}
			}
		}
	}
	
	public void process(String option, Serverthread currentClient)
	{
		if (option.equals("HIT"))
        {
            Card newCard = server.getDeck().drawCard();
            currentClient.getPlayer().addCard(newCard);

            currentClient.sendMessage("You drew:");
  

            currentClient.sendMessage(currentClient.getPlayer().getHand().get(currentClient.getPlayer().getHand().size() - 1));
           

            if (currentClient.getPlayer().getTotal().isEmpty()) 
            {
                currentClient.sendMessage("BUSTED");
                currentClient.setFinished(true);
            }
            else
            {
                currentClient.sendMessage("Your hand:");

                for(int i = 0; i < currentClient.getPlayer().getHand().size(); i++)
                {
                	currentClient.sendMessage(currentClient.getPlayer().getHand().get(i));
                }

                currentClient.sendMessage("Your sums are:");
                

                for (int i = 0; i < currentClient.getPlayer().getTotal().size(); i++)
                {
                    currentClient.sendMessage(currentClient.getPlayer().getTotal().get(i));
                }
            }
        }

        if (option.equals("STAND"))
        {
            currentClient.setFinished(true);
            currentClient.sendMessage("Please wait for the results");
        }
	}
}
