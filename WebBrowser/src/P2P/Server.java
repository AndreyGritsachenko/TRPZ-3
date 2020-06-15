package P2P;

import javax.json.Json;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Server extends Thread {

    private ServerSocket serverSocket;
    private Set<ServerThread> serverThreads = new HashSet<ServerThread>();
    private String massage;
    private ServerThread serverThread;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    //    public Server(int port, String massage) throws IOException {
//        serverSocket = new ServerSocket(port);
//        this.massage = massage;
//    }
    public void run(){


        System.out.println("server start");
        try {


                Socket socket = serverSocket.accept();

                System.out.println("client conect");
                StringWriter stringWriter = new StringWriter();

                Json.createWriter(stringWriter).writeObject(Json.createObjectBuilder()
                        .add("massage", massage)
                        .build());

                PrintWriter pr = new PrintWriter(socket.getOutputStream());
                pr.println(stringWriter);
                pr.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }
//


    }

    public void sendMassage(String massage){

    }

    public ServerThread getServerThread() {
        return serverThread;
    }
}
