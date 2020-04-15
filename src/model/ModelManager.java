package model;

import networking.client.Client;
import networking.shared.Message;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ModelManager implements Model {
  private PropertyChangeSupport property = new PropertyChangeSupport(this);  //Subject part
  private Client client;

  public ModelManager(Client client) throws RemoteException, NotBoundException
  {
    this.client = client;
    this.client.startClient();
    this.client.addListener("NewMessage", this::onNewMessage);
  }

  private void onNewMessage(PropertyChangeEvent event) {
    property.firePropertyChange("ToChatWindow", null, event.getNewValue());
  }

  public ModelManager()
  {

  }

  @Override
  public void setUserName(String name)
  {
    this.client.setUsername(name);
  }

  @Override
  public void sendMessage(Message message)
  {
    this.client.sendMessage(message);
  }

  @Override public void greetingsMessage(Message message)
  {
    this.client.greetingsMessage(message);
  }

  @Override
  public void addListener(String name, PropertyChangeListener listener) {
    if (name == null) {
      property.addPropertyChangeListener(listener);
    } else {
      property.addPropertyChangeListener(name, listener);
    }
  }

  @Override
  public void removeListener(String name, PropertyChangeListener listener) {
    if (name == null) {
      property.removePropertyChangeListener(listener);
    } else {
      property.removePropertyChangeListener(name, listener);
    }
  }

}
