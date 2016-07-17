package networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

	private MessageProcessor processor;
	private Socket socket;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	private volatile Object messageReceived;
	
	private volatile boolean running;
	
	public Client(Socket socket)
	{
		this.socket = socket;
		processor = new MessageProcessor(this);
		
		try {
			input = new ObjectInputStream(socket.getInputStream());
			output = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startReading()
    {
		running = true;
        final Thread thread = new Thread(new Runnable()
        {	
			@Override
			public void run() {
				try {
					while (running) {
						messageReceived = input.readObject();
						processor.process(messageReceived);
					}

				} catch (IOException e) {
					e.printStackTrace();
					close();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					close();
				}
				close();
            }
        });
        thread.start();
    }
	
	public void sendMessage(String message)
	{
		try {
			this.output.writeObject(message);
			this.output.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void close()
	{
		try {
			input.close();
			output.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setRunning(boolean running)
	{
		this.running = running;
	}
}
