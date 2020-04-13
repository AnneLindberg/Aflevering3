package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.ViewController;

import java.io.IOException;
import java.rmi.NotBoundException;

public class ViewHandler
{
  private Scene chatScene;
  private Stage stage;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
  }

  public void start() throws IOException, NotBoundException {
    stage = new Stage();
    openLogInView();
  }

  public void openChatView() throws IOException, NotBoundException {
      Parent root = loadFXML("../view/chatview/chatView.fxml");
      stage.setTitle("ChatWindow");
      chatScene = new Scene(root);
      stage.setScene(chatScene);
      stage.show();
  }

  public void openLogInView() throws IOException, NotBoundException {
    Parent root = loadFXML("../view/loginview/logIn.fxml");
    stage.setTitle("Log In Window");
    Scene logInScene = new Scene(root);
    stage.setScene(logInScene);
    stage.show();

  }


  private Parent loadFXML(String path) throws IOException, NotBoundException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = null;
    try {
      root = loader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }

    ViewController controller = loader.getController();
    controller.init(this, viewModelFactory);
    return root;
  }
}
