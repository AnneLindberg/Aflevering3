package view.loginview;

import core.ViewHandler;
import core.ViewModelFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.ViewController;
import viewmodel.LogInViewModel;

import java.awt.*;
import java.io.IOException;

public class logInController implements ViewController
{
  @FXML private javafx.scene.control.TextField usernameTextField;
  private ViewHandler viewHandler;
  private LogInViewModel logInViewModel;

  public logInController()
  {
  }

  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
      throws IOException
  {
    this.logInViewModel = viewModelFactory.getLogInViewModel();
    this.viewHandler = viewHandler;
    this.usernameTextField.textProperty().bindBidirectional(logInViewModel.usernameProperty());
  }

  public void onLogInButton(ActionEvent actionEvent) throws IOException
  {
   logInViewModel.login();
   viewHandler.openChatView();
  }
}
