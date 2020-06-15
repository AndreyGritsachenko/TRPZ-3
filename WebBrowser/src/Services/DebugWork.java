package Services;

import javax.swing.*;
import java.awt.*;

public class DebugWork implements IWorkMode{
    @Override
    public void setOption(ViewEditor displayEditor, JEditorPane display) {
        display.setContentType("text/plain");
    }

    @Override
    public void setOption(ViewColor displayColor, JEditorPane display) {
        display.setForeground(Color.GREEN);
        display.setBackground(Color.BLACK);
    }
}
