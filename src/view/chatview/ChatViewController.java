package view.chatview;

import core.ViewHandler;
import core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import view.ViewController;
import viewmodel.ChatViewModel;
import java.io.IOException;
import java.rmi.NotBoundException;

public class ChatViewController implements ViewController
{
  @FXML private TextArea chatWindow;
  @FXML private TextField userMessage;

  private ChatViewModel chatViewModel;
  private ViewHandler viewHandler;

  public ChatViewController()
  {
  }

  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
          throws IOException, NotBoundException {
    this.viewHandler = viewHandler;
    this.chatViewModel = viewModelFactory.getChatViewModel();
    this.userMessage.textProperty().bindBidirectional(chatViewModel.getUserMessageProperty());
    this.chatWindow.textProperty().bindBidirectional(chatViewModel.getPoolMessagesProperty());
  }

  public void OnSendMessage(ActionEvent actionEvent)
  {
    this.chatViewModel.sendMessage();
    userMessage.setText("");
  }

  public void addToChat(String msg){
    chatWindow.appendText(msg + "\n");
  }

  public void OnLogOut(ActionEvent actionEvent){
    System.exit(0);
  }


  public void onLogin(ActionEvent actionEvent)
  {
    try
    {
      viewHandler.openLogInView();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
