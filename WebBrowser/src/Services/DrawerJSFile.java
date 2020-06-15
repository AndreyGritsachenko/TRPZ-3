package Services;

import java.util.ArrayList;

public class DrawerJSFile extends DrawerFile{
    private ArrayList<CodeHolder> list;
    public DrawerJSFile(DataFileHolder holder){
        list = holder.getJS();
    }

    @Override
    public String addTitle() {
        return "SCRIPTS \n";
    }

    @Override
    public String addContent() {

        String content = "\n";

        for (CodeHolder item: list) {

            content+=item.getTitle()+"\n\n\n";
            content+=item.getData()+"\n";
            content+="=========================================================\n";
        }
        return content;
    }
}
