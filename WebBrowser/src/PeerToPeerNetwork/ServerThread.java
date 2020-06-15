package PeerToPeerNetwork;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Set;

public class ServerThread extends Thread {
    private ServerSocket serverSocket;
    private Set<ServerThreadThread> serverThreadThreads = new HashSet<ServerThreadThread>();

    public ServerThread(String port) throws IOException{
        serverSocket = new ServerSocket(Integer.valueOf(port));
    }

    public void run(){
        try{
            while(true){
//                ServerThreadThread serverThreadThread = new ServerThreadThread(serverSocket.accept(), this);
//                serverThreadThreads.add(serverThreadThread);
//                serverThreadThread.start();


            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendMassage(String massage){
        try{
            serverThreadThreads.forEach(t->t.getPrintWriter().println(massage));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Set<ServerThreadThread> getServerThreadThreads() {
        return serverThreadThreads;
    }
}
