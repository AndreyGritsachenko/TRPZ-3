package P2P;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
    private Server server;
    private Socket socket;
    private PrintWriter printWriter;

    public ServerThread( Socket socket, Server server){
        this.socket = socket;
        this.server = server;
    }

    public void run(){
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.printWriter = new PrintWriter(socket.getOutputStream());
            while(true){
                server.sendMassage(bufferedReader.readLine());
            }
        }catch (Exception e){
            server.getServerThread().interrupt();
        }
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }
}
