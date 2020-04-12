package networking.client;

import networking.shared.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocketHandler implements Runnable{

    private Socket socket;
    private SocketClient client;
    private ObjectInputStream inFromServer;
    private ObjectOutputStream outToServer;

    public ClientSocketHandler(Socket socket, SocketClient client) {
        this.socket = socket;
        this.client = client;

        //Create communication streams
        try {
            outToServer = new ObjectOutputStream(socket.getOutputStream());
            inFromServer = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message message = (Message) inFromServer.readObject();
                client.messageReceived(message.getMessage());
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(Message msg){
        try {
            outToServer.writeObject(new Message(this.client.getUsername() + ": " + msg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void greetingsMessage(Message msg){
        try {
            outToServer.writeObject(new Message(this.client.getUsername() + "" + msg));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
