package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;
import networking.shared.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ChatViewModel implements PropertyChangeListener
{
  private Model userModel;
  private StringProperty userMessage;
  private StringProperty poolMessages;


  public ChatViewModel(Model userModel)
  {
    this.userModel = userModel;
    this.userMessage = new SimpleStringProperty();
    this.poolMessages = new SimpleStringProperty();
    poolMessages.setValue("");
    this.userModel.addListener("ToChatWindow", this);
  }

  public StringProperty getUserMessageProperty()
  {
    return userMessage;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    Platform.runLater(()->{
      if (evt.getPropertyName().equalsIgnoreCase("ToChatWindow")){
        this.poolMessages.setValue(this.poolMessages.getValue() + evt.getNewValue() + "\n");
      }
    });
  }


  public StringProperty getPoolMessagesProperty()
  {
    return poolMessages;
  }

  public void sendMessage() {
    Message message = new Message(userMessage.getValue());
    this.userModel.sendMessage(message);
    this.userMessage.setValue("");
  }
}
