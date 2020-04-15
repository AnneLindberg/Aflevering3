package view.loginview;

import core.ViewHandler;
import core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.ViewController;
import viewmodel.LogInViewModel;
import java.io.IOException;

public class logInController implements ViewController
{
  @FXML private javafx.scene.control.TextField usernameTextField;
  private ViewHandler viewHandler;
  private LogInViewModel logInViewModel;

  public logInController()
  {
  }

  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory){
    try
    {
      this.logInViewModel = viewModelFactory.getLogInViewModel();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    this.viewHandler = viewHandler;
    this.usernameTextField.textProperty().bindBidirectional(logInViewModel.usernameProperty());
  }

  public void onLogInButton(ActionEvent actionEvent) {
   logInViewModel.login();
    try
    {
      viewHandler.openChatView();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
