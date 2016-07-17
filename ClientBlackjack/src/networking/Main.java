package networking;

import java.io.IOException;
import java.net.Socket;

public class Main {
	private static Socket socket;
	private final static int PORT = 9999;
	private final static String IP = "localhost";
	private static Client client;
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try {
			socket = new Socket(IP, PORT);
			client = new Client(socket);
			client.startReading();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
