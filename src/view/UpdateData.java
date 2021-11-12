package view;

import controller.Controller;
import model.CategoryUser;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdateData {
    JFrame frame;
    JLabel labelNama, labelEmail, labelPassword, labelKategori;
    JTextField tfNama, tfEmail;
    JPasswordField pfPassword;
    JButton btnBack, btnUpdate, btnDelete;
    JComboBox cbKategori;

    public UpdateData(User user){
        Controller con = new Controller();

        //Frame
        frame = new JFrame("Menu Registrasi");
        frame.setSize(500, 500);

        //label
        labelNama = new JLabel("Nama");
        labelNama.setBounds(30,50,100,30);
        labelNama.setFont(new Font("Arial", Font.PLAIN, 16));
        labelEmail = new JLabel("Email");
        labelEmail.setBounds(30,110,100,30);
        labelEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        labelPassword = new JLabel("Password");
        labelPassword.setBounds(30,170,100,30);
        labelPassword.setFont(new Font("Arial", Font.PLAIN, 16));
        labelKategori = new JLabel("Kategori");
        labelKategori.setBounds(30,240,100,30);
        labelKategori.setFont(new Font("Arial", Font.PLAIN, 16));

        //Text field
        tfNama = new JTextField(user.getName());
        tfNama.setBounds(180,50,200,30);
        tfEmail = new JTextField(user.getEmail());
        tfEmail.setBounds(180,110,200,30);

        //Password field
        pfPassword = new JPasswordField(user.getPassword());
        pfPassword.setBounds(180,170,200,30);

        //combo box
        Controller controller = new Controller();
        ArrayList<CategoryUser> kategori = controller.getKategori();
        String[] category = new String[kategori.size()];
        int i = 0;
        for (CategoryUser cat : kategori){
            category[i] = cat.getName();
            i++;
        }
        cbKategori = new JComboBox(category);
        cbKategori.setBounds(180, 240, 200, 30);

        //button
        btnBack = new JButton("Back");
        btnBack.setBounds(100,320,80,30);
        btnBack.setFont(new Font("Arial", Font.BOLD, 16));
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenu(user);
            }
        });
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(200,320,120,30);
        btnUpdate.setFont(new Font("Arial", Font.BOLD, 16));
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//
            }
        });
        btnDelete = new JButton("Delete");
        btnDelete.setBounds(340,320,100,30);
        btnDelete.setFont(new Font("Arial", Font.BOLD, 16));
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//
            }
        });

        frame.add(labelNama);
        frame.add(labelEmail);
        frame.add(labelPassword);
        frame.add(labelKategori);
        frame.add(tfEmail);
        frame.add(tfNama);
        frame.add(pfPassword);
        frame.add(cbKategori);
        frame.add(btnBack);
        frame.add(btnUpdate);
        frame.add(btnDelete);

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
