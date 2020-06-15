package P2P;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client extends Thread{
    private BufferedReader bufferedReader;
    //private Socket  socket;

    public Client(Socket socket) throws IOException{
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

//    public Client(int port) throws IOException {
//        socket = new Socket("localhost", port);
//    }

    public void run(){
//        boolean flag = true;
//        while(flag){
//            try {
//                JsonObject jsonObject = Json.createReader(bufferedReader).readObject();
////                if(jsonObject.containsKey("username"))
////                    System.out.println("[" + jsonObject.getString("username") + "]:"+ jsonObject.getString("message"));
//            }catch (Exception e){
//                flag = false;
//                interrupt();
//            }
//        }
//        try {
//            System.out.println(  "connecting to port");
//            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
//            String str =bufferedReader.readLine();
//            System.out.println(  "connecting to port");
//            System.out.println(str);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        boolean flag = true;
        while(flag){
            try {
                JsonObject jsonObject = Json.createReader(bufferedReader).readObject();
                if(jsonObject.containsKey("massage"))
                    System.out.println(jsonObject.getString("message"));
            }catch (Exception e){
                flag = false;
                interrupt();
            }
        }

    }
}
