package main;

import networking.Server;

public class Main {

    public static void main(String[] args)
    {
        Server server = new Server();
        server.waitForConnections();
        server.getGameLogic().playGame();
    }
}
