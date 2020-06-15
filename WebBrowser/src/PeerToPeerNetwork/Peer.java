package PeerToPeerNetwork;

import javax.json.Json;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.Socket;

public class Peer
{
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(">enter un & p:");
        String[] setupValue = bufferedReader.readLine().split(" ");
        ServerThread serverThread = new ServerThread(setupValue[1]);
        serverThread.start();
        new Peer().updateListenToPeers(bufferedReader,setupValue[0],serverThread);
    }

    public void updateListenToPeers(BufferedReader bufferedReader, String un, ServerThread serverThread) throws Exception{
        System.out.println(">enter hostname&port");
        System.out.println("Ready to recive massage from");
        String input = bufferedReader.readLine();
        String[] inputValues = input.split(" ");

        if(!input.equals("s")) for (int i = 0; i<inputValues[i].length(); i++){
            String[] address = inputValues[i].split(":");
            Socket socket = null;
            try{
                socket = new Socket(address[0], Integer.valueOf(address[1]));
                new PeerThread(socket).start();
            }catch (Exception e){
                if(socket!=null)socket.close();
                else System.out.println("invalid input... Skiping to next step");
            }
        }

        communicate(bufferedReader, un, serverThread);
    }

    public void communicate(BufferedReader bufferedReader, String username, ServerThread serverThread){
        try{
            System.out.println(">you can now comunicate(e to exit, c to change");
            boolean flag = true;
            while(flag){
                String massage = bufferedReader.readLine();
                if(massage.equals("e")){
                    flag = false;
                    break;
                }else if(massage.equals("c")){
                    updateListenToPeers(bufferedReader, username, serverThread);
                }else{
                    StringWriter stringWriter = new StringWriter();
                    Json.createWriter(stringWriter).writeObject(Json.createObjectBuilder()
                                                   .add("username", username)
                                                   .add("massage", massage)
                                                   .build());
                    serverThread.sendMassage(stringWriter.toString());
                }
                System.exit(0);
            }
        }catch (Exception e){

        }
    }
}
