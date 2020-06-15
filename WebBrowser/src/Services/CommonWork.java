package Services;

import javax.swing.JEditorPane;
import java.awt.*;

public class CommonWork implements IWorkMode {
    @Override
    public void setOption(ViewEditor displayEditor, JEditorPane display) {
        display.setContentType("text/html");
    }

    @Override
    public void setOption(ViewColor displayColor, JEditorPane display) {
        display.setForeground(Color.BLACK);
        display.setBackground(Color.WHITE);
    }
}
