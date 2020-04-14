package networking.shared;

import networking.shared.Message;
import utility.PropertyChangeSubject;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIClient extends PropertyChangeSubject, Remote {
    void messageReceived(String message) throws RemoteException;
    String getUsername() throws RemoteException;
    void sendMessage(Message message) throws RemoteException;
    void setUsername(String username) throws RemoteException;
    void startClient() throws RemoteException, IOException, NotBoundException;
    void greetingsMessage(Message message) throws RemoteException;
}
