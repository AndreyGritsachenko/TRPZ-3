package Services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class PreLoad extends Loader {

    public PreLoad(int priority){
        super(priority);
    }
    @Override
    public void load(String address) throws IOException {

        String currentDoc = null;

        URL url = new URL(address);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s;
        while((s = br.readLine())!=null){
            // System.out.println(s);
            currentDoc = currentDoc + s + "\n";
        }
        br.close();
//        System.out.println("Response is got from " + url);
//        Document html = Jsoup.parse(currentDoc);
//        String response = html.title();
//        response = response.substring(0,3);

        setDoc(currentDoc);
        System.out.println("PreLoad");
    }
}
