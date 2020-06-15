package GUI;

import Services.*;
import P2P.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.Socket;
import javax.json.Json;
import javax.json.JsonObject;
import javax.swing.*;
import javax.swing.event.*;

public class BrowserWindow extends JFrame{
    private JTextField addressBar;
    private JEditorPane display;
    private JMenuBar menu;
    private View displayOption = new View();
    private IWorkMode[] workModes = new IWorkMode[]{
            new CommonWork(),
            new DebugWork()
    };
    private IWorkMode currentWorkmode;
    private DrawerServiceProxi drawer;
    private Server server;

    public BrowserWindow(){
        super("Browser");

        drawer = new DrawerServiceProxi();
        addressBar = new JTextField("https://");
        addressBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayOption.setDisplayOption(currentWorkmode,display);
                drawer.setAddress(e.getActionCommand());
                drawer.drowpage(display,addressBar);
                server.setMassage(display.getText());
            }
        });


        menu = new JMenuBar();
        // Добавление в главное меню выпадающих пунктов меню
        menu.add(createFileMenu());
        menu.add(createChangeRole());
        menu.add(createPortMenu());
        menu.add(createConectionMenu());
        setJMenuBar(menu);
        add(addressBar, BorderLayout.NORTH);


        display = new JEditorPane();
        display.setEditable(false);
        displayOption.setDisplayOption(workModes[0], display);
        display.addHyperlinkListener(new HyperlinkListener() {

            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
                    drawer.setAddress(e.getURL().toString());
                    drawer.drowpage(display,addressBar);
                }
            }
        });

        add(new JScrollPane(display),BorderLayout.CENTER);
        setSize(1500, 700);
        setVisible(true);


    }
    private JMenu createFileMenu(){
        JMenu file = new JMenu("Файл");
        JMenuItem cssfile = new JMenuItem("CSS");
        JMenuItem jsfile = new JMenuItem("JS");
        file.add(cssfile);
        file.addSeparator();
        file.add(jsfile);

        cssfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open CSSfile");
                createFileWindow(FileType.CSS);
            }
        });

        jsfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("open JSfile");
                createFileWindow(FileType.JS);
            }
        });
        return file;
    }

    private JMenu createPortMenu(){
        JMenu ports = new JMenu("Ports");
        for(int i = 4441; i<4445; i++){
            JMenuItem mi = new JMenuItem(Integer.toString(i));
            ports.add(mi);
            mi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println( mi.getText() + "activated port");
                    try{
//
                            server = new Server(Integer.parseInt(mi.getText()));
                            server.start();
//
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }


                }
            });
        }
        return ports;
    }

    private  JMenu createConectionMenu(){
        JMenu connection = new JMenu("Get");
        for(int i = 4441; i<4445; i++){
            JMenuItem mi = new JMenuItem(Integer.toString(i));
            connection.add(mi);
            mi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    try{
                        Socket socket = new Socket("localhost",Integer.parseInt(mi.getText()));

                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        JsonObject jsonObject = Json.createReader(bufferedReader).readObject();
                        display.setText(jsonObject.getString("massage"));

                        socket.close();
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            });
        }
        return connection;
    }
    private JButton createChangeRole(){
        JButton changeRole = new JButton("Common");
        currentWorkmode = workModes[0];
        changeRole.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(changeRole.getText().equalsIgnoreCase("common")){
                    currentWorkmode = workModes[1];
                    changeRole.setText("Debug");
                }
                else{
                    currentWorkmode = workModes[0];
                    changeRole.setText("Common");
                }
                String currentText = display.getText();
                displayOption.setDisplayOption(currentWorkmode,display);
                display.setText(currentText);

            }
        });
        return  changeRole;
    }

    private void createFileWindow(int type){
        IDrawerFactory factory = createDrawerByType(type);
        //TODO:getDrawermethod
        DrawerFile drawerFile = factory.createDrawFile(drawer.getDrawerService().getDataFiles());
        FileWindow fileWindow = new FileWindow(drawerFile, currentWorkmode);
    }

    static IDrawerFactory createDrawerByType(int type){
        if(type==FileType.CSS){
            return new DataFileHolder.CSSDrawerFactory();
        }
        else if(type==FileType.JS){
            return new JSDrawerFactory();
        }
        else {
            throw new RuntimeException("unknown type");
        }
    }


}
