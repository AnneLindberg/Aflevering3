package model;

import networking.shared.Message;
import utility.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;

public interface Model extends PropertyChangeSubject{
    void setUserName(String name) throws RemoteException;
    void sendMessage(Message message) throws RemoteException;
    void greetingsMessage(Message message) throws RemoteException;
}
