package Services;

import java.util.ArrayList;

public class DrawerCSSFile extends DrawerFile {
    private ArrayList<CodeHolder> list;
    public DrawerCSSFile(DataFileHolder holder){
        list = holder.getCSS();
    }

    @Override
    public String addTitle() {
        return "STYLES \n";
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
