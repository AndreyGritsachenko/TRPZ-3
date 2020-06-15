package GUI;

import Services.View;
import Services.DrawerFile;
import Services.IWorkMode;

import javax.swing.*;
import java.awt.*;

public class FileWindow extends JFrame{

    private JEditorPane display;
    private View displayOptions = new View();
    private DrawerFile drawer;

    public FileWindow(DrawerFile dr, IWorkMode workMode){

        drawer = dr;
        display = new JEditorPane();
        display.setEditable(false);
        displayOptions.setDisplayOption(workMode,display);


        add(new JScrollPane(display), BorderLayout.CENTER);

        drawer.showFile(display);

        setSize(1500, 700);
        setVisible(true);
    }
}
