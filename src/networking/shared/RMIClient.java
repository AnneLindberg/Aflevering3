package networking.shared;

import networking.shared.Message;
import utility.PropertyChangeSubject;

import java.io.IOException;
import java.rmi.NotBoundException;

public interface RMIClient extends PropertyChangeSubject {
    void messageReceived(String message);
    String getUsername();
    void sendMessage(Message message);
    void setUsername(String username);
    void startClient() throws IOException, NotBoundException;
    void greetingsMessage(Message message);
}
