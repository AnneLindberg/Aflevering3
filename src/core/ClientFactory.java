package core;

import networking.client.RMIClientImpl;
import networking.shared.RMIClient;

import java.io.IOException;

public class ClientFactory
{
    private RMIClient RMIClient;

    public RMIClient getRMIClient() throws IOException
    {
    if(RMIClient == null){
        //client = new SocketClient();
        this.RMIClient = new RMIClientImpl();
    }
    return RMIClient;
    }
}
