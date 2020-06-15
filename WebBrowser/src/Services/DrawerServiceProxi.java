package Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.swing.*;

public class DrawerServiceProxi implements IDawerService {

    private String address;
    private String response;
    private DrawerService drawerService;
    private Document htmlDoc;
    private ChainBilder chainBilder;

    public DrawerServiceProxi(){
        //this.address = address;
        this.chainBilder = new ChainBilder();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private void getServerResponse() {
        //response = response from server

//        URL url = new URL(address);
//        BufferedReader br = null;
//        try {
//            br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String s;
//        while((s = br.readLine())!=null){
//            System.out.println(s);
//            htmlDoc =htmlDoc + s + "\n";
//        }
//        br.close();
//        System.out.println("Response is got from " + url);
        //address = adr;
        try {

            chainBilder.getPreLoad().loaderManager(address, Priority.PRELOAD);
            htmlDoc = Jsoup.parse(chainBilder.getPreLoad().getDoc());
            response = htmlDoc.title();
            response = response.substring(0, 3);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public DrawerService getDrawerService() {
        return drawerService;
    }

    @Override
    public void drowpage(JEditorPane display, JTextField addressbar){
        if (address != null) {


//            try{
//                display.setText("Page is loading");
//            }catch (Exception e){
//                System.out.println("Error");
//            }


            getServerResponse();

            if (drawerService == null) {
                //TODO: respons error adress
                drawerService = new DrawerService(address);
            }
            drawerService.drowpage(display,addressbar);
        }
    }
}
