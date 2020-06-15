package Services;

import javax.swing.*;

public class ViewEditor implements IViewOptions {
    @Override
    public void setDisplayOption(IWorkMode workMode, JEditorPane display) {
        workMode.setOption(this, display);
    }
}
