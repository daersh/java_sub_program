package view;

import DTO.USERDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LobbyWindow extends JFrame{

    public LobbyWindow(){
        onLobbyWindow();

    }
    public void onLobbyWindow(){
        setTitle("Lobby");
        JPanel panel = new JPanel(new BorderLayout(2,2));

        JPanel MainPanel = new JPanel(new BorderLayout(2,2));
        JPanel LeftPanel = new JPanel(new BorderLayout(1,0));
        JPanel RightPanel = new JPanel(new BorderLayout(1,0));
        JPanel UpPanel = new JPanel(new BorderLayout(1,0));
        JPanel DownPanel = new JPanel(new BorderLayout(1,0));
        JPanel CenterPanel = new JPanel(new BorderLayout(1,0));

        makeLeftPanel(LeftPanel);
        makeLeftPanel(RightPanel);
        makeLeftPanel(DownPanel);
        makeLeftPanel(CenterPanel);

        JLabel UpLabel1 = new JLabel("HELLO WORLD");
        JLabel UpLabel2 = new JLabel("HELLO WORLD");
        UpPanel.add(UpLabel1,BorderLayout.CENTER);
        UpPanel.add(UpLabel2,BorderLayout.WEST);

        makeMainPanel(MainPanel, LeftPanel, RightPanel, UpPanel, DownPanel, CenterPanel);

        add(MainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }

    private static void makeLeftPanel(JPanel LeftPanel) {
        JButton leftbutton1 = new JButton("EAST");
        JButton leftbutton2 = new JButton("WEST");
        JButton leftbutton3 = new JButton("SOUTH");
        JButton leftbutton4 = new JButton("NORTH");
        JButton leftbutton5 = new JButton("CENTER");
        LeftPanel.add(leftbutton1,BorderLayout.EAST);
        LeftPanel.add(leftbutton2,BorderLayout.WEST);
        LeftPanel.add(leftbutton3,BorderLayout.SOUTH);
        LeftPanel.add(leftbutton4,BorderLayout.NORTH);
        LeftPanel.add(leftbutton5,BorderLayout.CENTER);

        Click(leftbutton1,"clicked");
        Click(leftbutton2,"clicked");
        Click(leftbutton3,"clicked");
        Click(leftbutton4,"clicked");
        Click(leftbutton5,"clicked");
    }

    private static void makeMainPanel(JPanel MainPanel, JPanel LeftPanel, JPanel RightPanel, JPanel UpPanel, JPanel DownPanel, JPanel CenterPanel) {
        MainPanel.add(LeftPanel,BorderLayout.WEST);
        MainPanel.add(RightPanel,BorderLayout.EAST);
        MainPanel.add(UpPanel,BorderLayout.NORTH);
        MainPanel.add(DownPanel,BorderLayout.SOUTH);
        MainPanel.add(CenterPanel,BorderLayout.CENTER);
    }

    private static void Click(JButton b, String a) {
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked");
                b.setText(a);
            }
        });
    }


}
