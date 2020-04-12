package networking.client;

import networking.shared.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.net.Socket;

public class SocketClient implements Client{

  private PropertyChangeSupport support;
  private ClientSocketHandler handler;
    private String username;
    private PropertyChangeSupport property;

    public SocketClient()
        throws IOException
    {
      property = new PropertyChangeSupport(this);
    }

    public void startClient() throws IOException
    {
      Socket socket = new Socket("localhost", 2911);
      this.handler = new ClientSocketHandler(socket,this);

      Thread t = new Thread(handler);
      t.setDaemon(true);
      t.start();
    }

  public void messageReceived(String message) {
        System.out.println(message);
        property.firePropertyChange("NewMessage", null, message);
    }

    @Override public void sendMessage(Message message)
    {
        handler.sendMessage(message);
    }


  @Override public void greetingsMessage(Message message)
  {
    handler.greetingsMessage(message);
  }


  @Override
    public void addListener(String name, PropertyChangeListener listener) {
        property.addPropertyChangeListener(name, listener);
    }

    @Override
    public void removeListener(String name, PropertyChangeListener listener) {
        property.removePropertyChangeListener(name, listener);
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

}
