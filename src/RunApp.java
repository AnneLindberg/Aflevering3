import javafx.application.Application;

public class  RunApp {
    public static void main(String[] args) {
        Application.launch(ClientApp.class);
    }
}



//TODO: Update when someone enters and leaves chat
//TODO: Clean up code
//TODO: Do project with RMI


/*TODO: The client needs 2 interfaces: 1 that extends Remote that has the connection with the Server(with the methods
   that only the server uses from the client), and another one for the client that extends Subject*/