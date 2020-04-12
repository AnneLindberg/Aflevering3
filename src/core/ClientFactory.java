package core;

import networking.client.Client;
import networking.client.SocketClient;

import java.io.IOException;

public class ClientFactory
{
    private Client client;

    public Client getClient () throws IOException
    {
    if(client == null){
        client = new SocketClient();
    }
    return client;
    }
}
