package core;

import networking.client.RMIClient;

import java.io.IOException;

public class ClientFactory
{
    private RMIClient RMIClient;

    public RMIClient getRMIClient() throws IOException
    {
    if(RMIClient == null){
        //client = new SocketClient();
    }
    return RMIClient;
    }
}
