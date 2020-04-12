package model;

import networking.shared.Message;
import utility.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface Model extends PropertyChangeSubject{
    void setUserName(String name);
    void sendMessage(Message message);
    void greetingsMessage(Message message);
}
