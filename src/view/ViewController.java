package view;

import core.ViewHandler;
import core.ViewModelFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.rmi.NotBoundException;

public interface ViewController
{
  void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
          throws IOException, NotBoundException;
}