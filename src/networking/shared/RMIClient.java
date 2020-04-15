package networking.shared;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIClient extends Remote {
    void messageReceived(String message) throws RemoteException;
    String getUsername() throws RemoteException;
    }
