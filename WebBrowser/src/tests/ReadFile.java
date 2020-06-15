package tests;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ReadFile extends JFrame{

    private JTextField addressBar;
    private JEditorPane display;

    public  ReadFile() {
        super("Test Browser");

        addressBar = new JTextField("http://");
        addressBar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                loadCrap(e.getActionCommand());
            }
        });

        add(addressBar, BorderLayout.NORTH);

        display = new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener(new HyperlinkListener() {

            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
                    loadCrap(e.getURL().toString());
                }
            }
        });

        add(new JScrollPane(display),BorderLayout.CENTER);
        setSize(1500, 700);
        setVisible(true);

    }

    private void loadCrap(String userText){
        try{
            display.setPage(userText);
            addressBar.setText(userText);
        }catch (Exception e){
            System.out.println("Error");
        }

    }


}
