package Services;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class DrawerService implements IDawerService {

    private String address;
    private Document htmlDoc;
    private ChainBilder chainBilder;
    private DataFileHolder dataFiles;

    public DataFileHolder getDataFiles() {
        return dataFiles;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DrawerService(String url) {
        this.address = url;
        this.chainBilder = new ChainBilder();
    }

    private void load() {

        try {
            chainBilder.getPreLoad().loaderManager(address, Priority.FULLLOAD);
            htmlDoc = Jsoup.parse(chainBilder.getPreLoad().getDoc());
            dataFiles = chainBilder.getFullLoad().getFiles();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void drowpage(JEditorPane display, JTextField addressbar){
        load();
        //drowing page useing specia class
//        System.out.println(htmlDoc);
//        System.out.println("page");


        try{
            String html = htmlDoc.html();
            display.setText(html);
            addressbar.setText(address);
        }catch (Exception e){
            System.out.println("Error");
        }

    }
}
