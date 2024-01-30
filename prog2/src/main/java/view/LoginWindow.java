package view;

import DTO.USERDTO;
import service.UserService;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow {
    private static UserService userService = new UserService();

    public static void OnLoginWindow(){
        JFrame f =new JFrame("로그인 창");
        JLabel l1_1 = new JLabel("User:");
        JTextField text = new JFormattedTextField();
        JLabel l1_2 = new JLabel("PW: ");
        JPasswordField value = new JPasswordField();
        JButton b1_1 = new JButton("Login");
        JLabel l3 = new JLabel("");
        JButton b1_2 = new JButton("register");
        make_f1(l1_1, text, l1_2, value, b1_1, l3, b1_2, f);

        JFrame f2 = new JFrame("Register");
        JLabel l2_1 = new JLabel("User:");
        JTextField text2 = new JFormattedTextField();
        JLabel l2_2 = new JLabel("PW: ");
        JPasswordField value2 = new JPasswordField();
        JButton b2_1 = new JButton("register");
        JLabel l2_3 = new JLabel("");
        make_f2(f2, l2_1, text2, l2_2, value2, b2_1, l2_3);

        b_click(b1_1, text, value, l3, f2, f);
        b2_1click(b2_1, text2, value2, l2_3, f2, f);


        click_RegisterStart(b1_2, f2, f);

    }

    private static void make_f1(JLabel l1_1, JTextField text, JLabel l1_2, JPasswordField value, JButton b1_1, JLabel l3, JButton b1_2, JFrame f) {
        l1_1.setBounds(20,20,80,30);
        text.setBounds(100,20,100,30);
        l1_2.setBounds(20,75,80,30);
        value.setBounds(100,75,100,30);
        b1_1.setBounds(100,120,80,30);
        l3.setBounds(100,200,80,30);
        b1_2.setBounds(100,160,80,30);

        f.add(l1_1);
        f.add(text);
        f.add(l1_2);
        f.add(value);
        f.add(b1_1);
        f.add(b1_2);
        f.add(l3);
        f.setSize(300,250);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private static void make_f2(JFrame f2, JLabel l2_1, JTextField text2, JLabel l2_2, JPasswordField value2, JButton b2_1, JLabel l2_3) {
        f2.setSize(400,300);
        l2_1.setBounds(20,20,80,30);

        text2.setBounds(100,20,100,30);

        l2_2.setBounds(20,75,80,30);

        value2.setBounds(100,75,100,30);

        b2_1.setBounds(100,120,80,30);

        l2_3.setBounds(100,160,80,30);

        f2.add(l2_1);
        f2.add(l2_2);
        f2.add(l2_3);
        f2.add(text2);
        f2.add(value2);
        f2.add(b2_1);
        f2.setLayout(null);
        f2.setVisible(false);
        f2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private static void b2_1click(JButton b2_1, JTextField text2, JPasswordField value2, JLabel l2_3, JFrame f2, JFrame f) {
        b2_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = text2.getText();
                String pw = new String(value2.getPassword());

                if (userService.register(id,pw)==1){
                    l2_3.setText("Register success! Go Login!");
                    f2.setVisible(false);
                    f.setVisible(true);
                }else{
                    l2_3.setText("Register fail.. Change Id");
                }
            }
        });
    }


    private static void click_RegisterStart(JButton b1_2, JFrame f2, JFrame f) {
        b1_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                f2.setVisible(true);
                f.setVisible(false);
            }
        });
    }

    private static void b_click(JButton b, JTextField text, JPasswordField value, JLabel l3, JFrame f2, JFrame f) {
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                USERDTO user = null;
                String id = text.getText();
                String pw = new String(value.getPassword());
                user = userService.Login(id,pw);

                if(user !=null){
                    l3.setText("Login!");
                    UserService.changeUser(user);
                    //설명. 다음 창 이동할 곳 결정 필요

                    f.setVisible(false);
                }else{
                    l3.setText("Not correct..");
                }
            }
        });
    }

}
