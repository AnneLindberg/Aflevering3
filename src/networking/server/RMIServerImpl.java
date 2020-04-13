package networking.server;

import networking.client.RMIClient;
import networking.client.RMIClientImpl;
import networking.shared.Message;

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
    public void sendMessage(Message message, String username) {
        client.sendMessage(message);
        updateClients(message);
        for (RMIClient myClient : this.clientsForBroadcast) {
            myClient.messageReceived(message);
        }
    }

    private void updateClients(Message message) {
        for (RMIClient client : this.clientsForBroadcast) {
            client.messageReceived(message);
        }
    }

    @Override
    public void setUsername(String username, RMIClient client) {
        client.setUsername(username);
    }

    @Override
    public void greetingsMessage(Message message, RMIClient notForMe) {
        for (RMIClient client : this.clientsForBroadcast) {
            if (client.equals(notForMe)) continue;
            client.greetingsMessage(message);
        }
    }

    @Override
    public void registerClient(RMIClient clientToRegister) {
        this.clientsForBroadcast.add(clientToRegister);
    }
}
