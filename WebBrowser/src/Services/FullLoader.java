package Services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class FullLoader extends Loader {

    public FullLoader(int preority){
        super(preority);
    }


    @Override
    public void load(String data)  {
        DataFileHolder holder = new DataFileHolder();
        Document html = Jsoup.parse(data);
        Elements text = html.body().getElementsByTag("link").attr("rel", "stylesheet");

        ArrayList<CodeHolder> adrCSS = new ArrayList<>();

        for (Element element:text) {
            adrCSS.add(new CodeHolder(element.attr("href")));

        }

        text = html.body().getElementsByTag("style");

        for (Element element:text) {
            adrCSS.add(new CodeHolder("STYLE" + Integer.toString(text.indexOf(element)), element.data()));

        }

        holder.setCSS(adrCSS);

        text = html.getElementsByTag("script")   ;   //body().getElementsByTag("script");

        ArrayList<CodeHolder> scriptsJS = new ArrayList<>();


        for (Element element:text) {
//            scriptsJS.add(element.attr("src"));
//            System.out.println(element.attr("src"));
            scriptsJS.add(new CodeHolder("SCRIPT" + Integer.toString(text.indexOf(element)), element.data()));
        }

        holder.setJS(scriptsJS);

        setFiles(holder);


        System.out.println("FULLLOAD");

    }
}
