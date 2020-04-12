package networking.client;

import networking.shared.Message;
import utility.PropertyChangeSubject;

import java.io.IOException;

public interface Client extends PropertyChangeSubject {
    void messageReceived(String message);
    void sendMessage(Message message);
    String getUsername();
    void setUsername(String username);
    void startClient() throws IOException;
    void greetingsMessage(Message message);

}
