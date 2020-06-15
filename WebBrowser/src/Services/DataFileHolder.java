package Services;

import java.util.ArrayList;

public class DataFileHolder {

    private ArrayList<CodeHolder> CSS;
    private ArrayList<CodeHolder> JS;

    public ArrayList<CodeHolder> getCSS() {
        return CSS;
    }

    public void setCSS(ArrayList<CodeHolder> CSS) {
        this.CSS = CSS;
    }

    public ArrayList<CodeHolder> getJS() {
        return JS;
    }

    public void setJS(ArrayList<CodeHolder> JS) {
        this.JS = JS;
    }

    public static class CSSDrawerFactory implements IDrawerFactory {
        @Override
        public DrawerFile createDrawFile(DataFileHolder holder) {
            return new DrawerCSSFile(holder);
        }
    }
}
