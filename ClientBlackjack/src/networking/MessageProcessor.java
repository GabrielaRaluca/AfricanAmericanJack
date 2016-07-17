package networking;

import javax.swing.SwingUtilities;

import gui.GameFrame;
import utilities.Card;

public class MessageProcessor {

	private Client client;
	private GameFrame gameFrame;
	private MessageProcessor currentProcessor;
	private volatile boolean myTurn;

	public MessageProcessor(Client client) {
		this.client = client;
		this.myTurn = false;
		currentProcessor = this;
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				gameFrame = new GameFrame(currentProcessor);
				gameFrame.setVisible(true);
			}

		});
	}

	public boolean isMyTurn()
	{
		return myTurn;
	}
	
	public void setMyTurn(boolean myTurn)
	{
		this.myTurn = myTurn;
	}
	
	public void process(Object messageReceived) {
		if (messageReceived instanceof Card) 
		{
			//System.out.println((Card) messageReceived);
			sendCard((Card) messageReceived);
		} 
		else if (messageReceived instanceof Integer) 
		{
			//System.out.println((Integer) messageReceived);
			sendTotal(messageReceived.toString());
		} 
		else if (messageReceived instanceof String) 
		{
			String message = messageReceived.toString();
			processString(message);
		}
	}

	private void processString(String message)
	{
		if(message.contains("Your turn is"))
		{
			char lastChar = message.charAt(message.length() - 1);
			int turn = Character.getNumericValue(lastChar);
			System.out.println(message);
			System.out.println(turn);
			gameFrame.updatePlayersName(gameFrame.getPanels().get(turn));
		}
		if(message.equals("Enter option: HIT/STAND"))
		{
			this.myTurn = true;
		}
		if(message.contains("Player") || message.equals("Dealer"))
		{
			sendCurrentPlayer(message);
		}
		if (message.equals("You Win") || message.equals("You Lost") || message.equals("Draw")
				|| message.equals("Dealer BUSTED! You Win!")) 
		{
			gameFrame.updateInfoLabel(message);
			this.client.setRunning(false);
		} 
		if (message.equals("BUSTED")) 
		{
			sendTotal("BUST");
			if(myTurn)
			{
				gameFrame.updateInfoLabel(message);
				myTurn = false;
				this.client.setRunning(false);
			}
		}
		if (message.equals("Dealer's turn"))
		{
			sendCurrentPlayer("Dealer");
		}
	}
	
	private void sendCard(Card card) {
		gameFrame.addCard(card);
	}

	private void sendTotal(String total) {
		gameFrame.setTotal(total);
	}

	private void sendCurrentPlayer(String currentPlayer) {
		gameFrame.setCurrentPlayer(currentPlayer);
	}

	public Client getClient() {
		return client;
	}
}
