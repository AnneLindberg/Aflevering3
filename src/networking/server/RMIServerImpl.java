package networking.server;

import networking.shared.RMIClient;
import networking.shared.Message;
import networking.shared.RMIServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RMIServerImpl implements RMIServer {
    private List<RMIClient> clientsForBroadcast;

    public RMIServerImpl() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.clientsForBroadcast = new ArrayList<>();
    }

    @Override
    public void sendMessage(Message message) {
        broadcastMessage(message.toString());
        for (RMIClient myClient : this.clientsForBroadcast) {
            myClient.messageReceived(message.toString());
        }
    }

    @Override
    public void broadcastMessage(String message) {
        for (RMIClient client : this.clientsForBroadcast) {
            client.messageReceived(message);
        }
    }

    /*@Override
    public void setUsername(String username, RMIClient client) {
        for (RMIClient myClient : this.clientsForBroadcast) {
            if (myClient.equals(client)){
                myClient.setUsername(username);
            }
        }
    }*/

    @Override
    public void greetingsMessage(RMIClient notForMe) {
        for (RMIClient client : this.clientsForBroadcast) {
            if (client.equals(notForMe)) continue;
            client.messageReceived(notForMe.getUsername() + " has entered the chat");
        }
    }

    @Override
    public void registerClient(RMIClient clientToRegister) {
        this.clientsForBroadcast.add(clientToRegister);
    }
}
