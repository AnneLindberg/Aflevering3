package networking.shared;

import networking.shared.RMIClient;
import networking.shared.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServer extends Remote {
    void sendMessage(Message message) throws RemoteException;
    //void setUsername(String username, RMIClient client) throws RemoteException;
    void greetingsMessage(RMIClient client) throws RemoteException;
    void registerClient(RMIClient client) throws RemoteException;
    void broadcastMessage(String message) throws RemoteException;
}
