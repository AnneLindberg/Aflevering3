package networking.server;

import networking.client.RMIClient;
import networking.shared.Message;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServer extends Remote {
    void sendMessage(Message message, String username) throws RemoteException;
    void setUsername(String username, RMIClient client) throws RemoteException;
    void greetingsMessage(Message message, RMIClient client) throws RemoteException;
    void registerClient(RMIClient client) throws RemoteException;
}
