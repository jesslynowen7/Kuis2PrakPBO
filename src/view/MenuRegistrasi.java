package view;

import controller.Controller;
import model.CategoryUser;
import model.User;
import model.UserManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuRegistrasi {
    JFrame frame;
    JLabel labelNama, labelEmail, labelPassword, labelKategori;
    JTextField tfNama, tfEmail;
    JPasswordField pfPassword;
    JButton btnBack, btnRegistrasi;
    JComboBox cbKategori;

    public MenuRegistrasi(){
        //Frame
        frame = new JFrame("Menu Registrasi");
        frame.setSize(460, 500);

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
        tfNama = new JTextField();
        tfNama.setBounds(180,50,200,30);
        tfEmail = new JTextField();
        tfEmail.setBounds(180,110,200,30);

        //Password field
        pfPassword = new JPasswordField();
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
                new MainMenu(new UserManager().getInstance().getUser());
            }
        });
        btnRegistrasi = new JButton("Registrasi");
        btnRegistrasi.setBounds(200,320,140,30);
        btnRegistrasi.setFont(new Font("Arial", Font.BOLD, 16));
        btnRegistrasi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password="";
                char[] pass=pfPassword.getPassword();
                if(!tfNama.getText().equals("")&& !tfEmail.getText().equals("")){
                    if(pass.length<8){
                        JOptionPane.showMessageDialog(null, "Password kurang dari 8");
                    }else{
                        for (int j=0; j<pass.length; j++){
                            password+=pass[j];
                        }
                        User user = new User(0, tfNama.getText(),tfEmail.getText(),password,cbKategori.getSelectedIndex()+1);
                        boolean insert = controller.insertNewUser(user);
                        if (insert) {
                            JOptionPane.showMessageDialog(null, "Registrasi Berhasil");
                            frame.dispose();
                            new MainMenu(new UserManager().getInstance().getUser());
                        }else{
                            JOptionPane.showMessageDialog(null, "Registrasi gagal");
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Isi Fiels kosong");
                }

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
        frame.add(btnRegistrasi);

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
