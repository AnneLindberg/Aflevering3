package core;

import viewmodel.ChatViewModel;
import viewmodel.LogInViewModel;

import java.io.IOException;
import java.rmi.NotBoundException;

public class ViewModelFactory
{
  private ChatViewModel chatViewModel;
  private LogInViewModel logInViewModel;
  private ModelFactory modelFactory;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  public ChatViewModel getChatViewModel() throws IOException, NotBoundException {
    if (chatViewModel == null)
    {
      chatViewModel = new ChatViewModel(modelFactory.getModel());
    }
    return chatViewModel;
  }

  public LogInViewModel getLogInViewModel() throws IOException, NotBoundException {
    if (logInViewModel == null)
    {
      logInViewModel = new LogInViewModel(modelFactory.getModel());
    }
    return logInViewModel;
  }
}
