package tests;

import GUI.BrowserWindow;
import Services.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;

public class TestMain {
    public static void main(String[] args) throws IOException {


        BrowserWindow dude = new BrowserWindow();
        dude.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Loader preLoad = new PreLoad(Priority.PRELOAD);
//        Loader fullLoad = new FullLoader(Priority.FULLLOAD);
//
//        preLoad.setNextLoader(fullLoad);
//
//        preLoad.loaderManager("https://www.lenta.ru",Priority.PRELOAD);
//        System.out.println("DONE");
//        preLoad.loaderManager("https://www.lenta.ru", Priority.FULLLOAD);
//        System.out.println("GOOD");



//        IDawerService drawerService = new DrawerServiceProxi("http://www.lenta.ru");
//
//        drawerService.drowpage();




//        String doc = null;
//
//        String address = "https://developer.mozilla.org/ru/docs/Web/Guide/CSS/Getting_started/How_CSS_works";//"http://www.lenta.ru";
//        URL url = new URL(address);
//        BufferedReader br = null;
//        try {
//            br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String s;
//        while((s = br.readLine())!=null){
//            //System.out.println(s);
//            doc=doc + s + "\n";
//        }
//        br.close();
//
//        Document html = Jsoup.parse(doc);
//        Elements text = html.body().getElementsByTag("link").attr("rel", "stylesheet");
//        //System.out.println(text);
//
//        ArrayList<String> adresses = new ArrayList<>();
//
//        for (Element element:text) {
//            adresses.add(element.attr("href"));
//        }
//        for (String t:adresses
//             ) {
//            System.out.println(t);
//        }
//        String text = "301 Moved Permanently";
//        text = text.substring(0,3);
//        System.out.println(text);

//        String HTMLSTring = "<!DOCTYPE html>"
//                + "<html>"
//                + "<head>"
//                + "<title>JSoup Example</title>"
//                + "</head>"
//                + "<body>"
//                + "<table><tr><td><h1>HelloWorld</h1></tr>"
//                + "</table>"
//                + "</body>"
//                + "</html>";
//
//        Document html = Jsoup.parse(HTMLSTring);
//        String title = html.title();
//        String h1 = html.body().getElementsByTag("h1").text();
//
//        System.out.println("Input HTML String to JSoup :" + HTMLSTring);
//        System.out.println("After parsing, Title : " + title);
//        System.out.println("Afte parsing, Heading : " + h1);
//
//        // JSoup Example 2 - Reading HTML page from URL
//        Document doc;
//        try {
//            doc = Jsoup.connect("http://google.com/").get();
//            title = doc.title();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Jsoup Can read HTML page from URL, title : " + title);
//
//        // JSoup Example 3 - Parsing an HTML file in Java
//        //Document htmlFile = Jsoup.parse("login.html", "ISO-8859-1"); // wrong
////        Document htmlFile = null;
////        try {
////            htmlFile = Jsoup.parse(new File("login.html"), "ISO-8859-1");
////        } catch (IOException e) {
////            // TODO Auto-generated catch block
////            e.printStackTrace();
////        } // right
////        title = htmlFile.title();
////        Element div = htmlFile.getElementById("login");
////        String cssClass = div.className(); // getting class form HTML element
////
////        System.out.println("Jsoup can also parse HTML file directly");
////        System.out.println("title : " + title);
////        System.out.println("class of div tag : " + cssClass);

    }
}
