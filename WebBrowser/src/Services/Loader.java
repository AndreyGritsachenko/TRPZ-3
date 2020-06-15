package Services;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Loader {
    private int priority;
    private Loader nextLoader;
    private String adress;
    private String doc;
    private DataFileHolder files;

    public DataFileHolder getFiles() {
        return files;
    }

    public void setFiles(DataFileHolder files) {
        this.files = files;
    }





    public Loader(int priority) {
        this.priority = priority;
        this.adress = adress;
    }

    public void setNextLoader(Loader nextLoader) {
        this.nextLoader = nextLoader;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getAdress() {
        return adress;
    }

    public String getDoc() {
        return doc;
    }

    public void loaderManager(String address, int level) throws IOException {
        if(level >= priority){
            load(address);
        }
        if(nextLoader!=null){
            nextLoader.loaderManager(getDoc(), level);
        }
    }

    public abstract void load(String address) throws IOException;
}
