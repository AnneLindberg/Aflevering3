package networking.client;

import networking.shared.Message;
import utility.PropertyChangeSubject;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public interface Client extends PropertyChangeSubject
{
  void sendMessage(Message message);
  void setUsername(String username);
  void startClient() throws RemoteException, NotBoundException;
  void greetingsMessage(Message message);
}
