package utility;

import java.beans.PropertyChangeListener;

public interface PropertyChangeSubject
{
   void addListener(String name, PropertyChangeListener listener);
   void removeListener(String name, PropertyChangeListener listener);
}
