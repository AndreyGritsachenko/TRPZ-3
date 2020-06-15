package Services;

import javax.swing.*;
import java.util.ArrayList;

public abstract class DrawerFile {
    private ArrayList<CodeHolder> list;

    public ArrayList<CodeHolder> getList() {
        return list;
    }

    public void setList(ArrayList<CodeHolder> list) {
        this.list = list;
    }



    public void showFile(JEditorPane display){
        try{
            String file = createFile() ;
            display.setText(file);
        }catch (Exception e){
            System.out.println("Error");
        }
    }

    public String createFile(){
        String file;
        file=addLine();
        file+=addTitle();
        file+=addLine();
        file+= addContent();
        return file;
    }

    public String addLine(){
        return "=============================================================\n";
    }

    public abstract String addTitle();
    public abstract String addContent();
}
