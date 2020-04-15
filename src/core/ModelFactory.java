package core;

import model.*;

import java.io.IOException;
import java.rmi.NotBoundException;

public class ModelFactory
{
  private Model model;
  private ClientFactory clientFactory;

  public ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory=clientFactory;
  }

  public Model getModel() throws IOException, NotBoundException
  {
    if(model == null){
      model = new ModelManager(clientFactory.getClient());
    }
    return model;
  }
}
