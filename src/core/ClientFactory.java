package core;

import networking.client.Client;
import networking.client.RMIClientImpl;

public class ClientFactory
{
    private Client client;

    public Client getClient()
    {
    if(client == null){
        this.client = (Client) new RMIClientImpl();
    }
    return client;
    }
}
