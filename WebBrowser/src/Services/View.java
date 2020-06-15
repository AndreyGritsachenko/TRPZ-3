package Services;

import javax.swing.*;

public class View implements IViewOptions {

    private IViewOptions[] displayOptions;
    public View(){
        this.displayOptions = new IViewOptions[]{
                new ViewEditor(),
                new ViewColor()
        };
    }
    @Override
    public void setDisplayOption(IWorkMode workMode, JEditorPane display) {
        for (IViewOptions option:displayOptions) {
            option.setDisplayOption(workMode, display);
        }
    }
}
