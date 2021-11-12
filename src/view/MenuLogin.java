package view;

import controller.Controller;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuLogin {
    JFrame frame;
    JLabel labelIconLogo, labelEmail, labelPassword;
    JTextField tfEmail;
    JPasswordField pfPassword;
    ImageIcon iconLogo;
    JButton btnBack, btnLogin;

    public MenuLogin(){
        //Frame
        frame = new JFrame("Menu Login");
        frame.setSize(460, 500);

        //logo
        labelIconLogo = new JLabel();
        iconLogo = new ImageIcon ("assets/instagram_logo.png");
        labelIconLogo.setIcon(iconLogo);
        labelIconLogo.setBounds(140,20,160,160);

        //label
        labelEmail = new JLabel("Email");
        labelEmail.setBounds(30,220,100,30);
        labelEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        labelPassword = new JLabel("Password");
        labelPassword.setBounds(30,270,100,30);
        labelPassword.setFont(new Font("Arial", Font.PLAIN, 16));

        //Text field
        tfEmail = new JTextField();
        tfEmail.setBounds(180,220,200,30);

        //Password field
        pfPassword = new JPasswordField();
        pfPassword.setBounds(180,270,200,30);

        //button
        btnBack = new JButton("Back");
        btnBack.setBounds(100,350,80,30);
        btnBack.setFont(new Font("Arial", Font.BOLD, 16));
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenu(new User());
            }
        });
        btnLogin = new JButton("Login");
        btnLogin.setBounds(230,350,80,30);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller controller =  new Controller();
                User user = controller.getUser(tfEmail.getText(),pfPassword.getPassword());
                if(user!=null){
                    JOptionPane.showMessageDialog(null, "Login berhasil");
                    frame.dispose();
                    new MainMenu(user);
                }else{
                    JOptionPane.showMessageDialog(null, "Username/Password salah");
                }
            }
        });

        frame.add(labelIconLogo);
        frame.add(labelEmail);
        frame.add(labelPassword);
        frame.add(tfEmail);
        frame.add(pfPassword);
        frame.add(btnLogin);
        frame.add(btnBack);

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
