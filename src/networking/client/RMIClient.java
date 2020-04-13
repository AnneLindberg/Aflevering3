package networking.client;

import networking.shared.Message;
import utility.PropertyChangeSubject;

import java.io.IOException;

public interface RMIClient extends PropertyChangeSubject {
    void messageReceived(String message);
    String getUsername();
    void sendMessage(Message message);
    void setUsername(String username);
    void startClient() throws IOException;
    void greetingsMessage(Message message);
}
