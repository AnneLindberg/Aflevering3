package model;

import networking.shared.RMIClient;
import networking.shared.Message;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ModelManager implements Model {
  private PropertyChangeSupport property = new PropertyChangeSupport(this);  //Subject part
  private RMIClient RMIClient;

  public ModelManager(RMIClient RMIClient) throws IOException {
    this.RMIClient = RMIClient;
    try {
      this.RMIClient.startClient();
    } catch (NotBoundException e) {
      e.printStackTrace();
    }
    this.RMIClient.addListener("NewMessage", this::onNewMessage);
  }

  private void onNewMessage(PropertyChangeEvent event) {
    property.firePropertyChange("ToChatWindow", null, event.getNewValue());
  }

  public ModelManager()
  {

  }

  @Override
  public void setUserName(String name) throws RemoteException {
    this.RMIClient.setUsername(name);
  }

  @Override
  public void sendMessage(Message message) throws RemoteException {
    this.RMIClient.sendMessage(message);
  }

  @Override public void greetingsMessage(Message message) throws RemoteException {
    this.RMIClient.greetingsMessage(message);
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
