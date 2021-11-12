package view;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    JFrame frame;
    JButton btnLogin, btnRegistrasi, btnLihatData;

    public MainMenu(){
        //Button
        btnLogin = new JButton("Login Pengguna");
        btnLogin.setBounds(100, 60, 400, 80);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
        btnLogin.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MenuLogin();
            }
        });

        btnRegistrasi = new JButton("Registrasi Pengguna Baru");
        btnRegistrasi.setBounds(100, 190, 400, 80);
        btnRegistrasi.setFont(new Font("Arial", Font.BOLD, 16));
        btnRegistrasi.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
        btnRegistrasi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MenuRegistrasi();
            }
        });

        btnLihatData = new JButton("Lihat Data Pengguna Berdasarkan Kategori Dipilih");
        btnLihatData.setBounds(100, 320, 400, 80);
        btnLihatData.setFont(new Font("Arial", Font.BOLD, 16));
        btnLihatData.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
        btnLihatData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LihatDataPerKategori();
            }
        });

        //Frame
        frame = new JFrame("Main Menu");
        frame.setSize(600, 500);


        frame.add(btnLogin);
        frame.add(btnRegistrasi);
        frame.add(btnLihatData);

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
