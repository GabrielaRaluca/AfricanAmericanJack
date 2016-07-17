package networking;

import javax.swing.SwingUtilities;

import gui.GameFrame;

public class MessageProcessor {

	private Client client;
	private GameFrame gameFrame;
	private MessageProcessor currentProcessor;
	
	public MessageProcessor(Client client)
	{
		this.client = client;
		currentProcessor = this;
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				gameFrame = new GameFrame(currentProcessor);
				gameFrame.setVisible(true);
			}
			
		});
	}
	
	public Client getClient()
	{
		return client;
	}
}
