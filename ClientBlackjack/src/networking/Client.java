package networking;

import java.net.Socket;

public class Client {

	private MessageProcessor processor;
	private Socket socket;
	
	public Client(Socket socket)
	{
		this.socket = socket;
		processor = new MessageProcessor(this);
	}
	public void sendMessage(String message)
	{
		
	}
}
