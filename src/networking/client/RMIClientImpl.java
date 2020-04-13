package networking.client;

import networking.server.RMIServer;
import networking.shared.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClientImpl implements RMIClient{

    private String username;
    private PropertyChangeSupport property;
    private RMIServer server;

    public RMIClientImpl(String username, RMIServer server) {
        this.username = username;
        this.property = new PropertyChangeSupport(this);
        this.server = server;
    }

    @Override
    public void startClient() throws IOException {
        Registry registry = LocateRegistry.getRegistry("localhost", 2020);
        try {
            server = (RMIServer) registry.lookup("Server");
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void messageReceived(String message) {
        System.out.println("Received: " + message);
        property.firePropertyChange("NewMessage", null, message);
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public void sendMessage(Message message, String username) {
        server.sendMessage(message);
    }

    @Override
    public void setUsername(String username) {

    }


    @Override
    public void greetingsMessage(Message message) {

    }

    @Override
    public void addListener(String name, PropertyChangeListener listener) {
        this.property.addPropertyChangeListener(name, listener);
    }

    @Override
    public void removeListener(String name, PropertyChangeListener listener) {
        this.property.removePropertyChangeListener(name, listener);
    }
}
