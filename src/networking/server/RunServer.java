package networking.server;

import java.io.IOException;

public class RunServer {
    public static void main(String[] args) throws IOException {
        SocketServer es = new SocketServer();
        es.start();
    }
}
