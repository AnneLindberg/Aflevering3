package core;

import model.*;

import java.io.IOException;

public class ModelFactory
{
  private Model model;
  private ClientFactory clientFactory;

  public ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory=clientFactory;
  }

  public Model getModel() throws IOException
  {
    if(model == null){
      model = new ModelManager(clientFactory.getRMIClient());
    }
    return model;
  }
}
