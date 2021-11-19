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

public class UpdateData {
    JFrame frame;
    JLabel labelNama, labelEmail, labelKategori;
    JTextField tfNama, tfEmail;
    JButton btnBack, btnUpdate, btnDelete;
    JComboBox cbKategori;

    public UpdateData(User user){
        Controller c = new Controller();

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
//        labelPassword = new JLabel("Password");
//        labelPassword.setBounds(30,240,100,30);
//        labelPassword.setFont(new Font("Arial", Font.PLAIN, 16));
        labelKategori = new JLabel("Kategori");
        labelKategori.setBounds(30,170,100,30);
        labelKategori.setFont(new Font("Arial", Font.PLAIN, 16));

        //Text field
        tfNama = new JTextField(user.getName());
        tfNama.setBounds(180,50,200,30);
        tfEmail = new JTextField(user.getEmail());
        tfEmail.setBounds(180,110,200,30);

        //Password field
//        pfPassword = new JPasswordField(user.getPassword());
//        pfPassword.setBounds(180,240,200,30);

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
        cbKategori.setBounds(180, 170, 200, 30);
        for (int j=0; j< category.length; j++){
            if(user.getIdCategory()-1==j){
                cbKategori.setSelectedIndex(j);
            }
        }

        //button
        btnBack = new JButton("Back");
        btnBack.setBounds(70,320,80,30);
        btnBack.setFont(new Font("Arial", Font.BOLD, 16));
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenu(user);
            }
        });
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(170,320,120,30);
        btnUpdate.setFont(new Font("Arial", Font.BOLD, 16));
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(user.getEmail().equals(tfEmail.getText()) || !user.getEmail().equals(tfEmail.getText()) && !c.cekUserDiDataBase(tfEmail.getText())){
                    boolean update = c.updateUser(tfNama.getText(), tfEmail.getText(), cbKategori.getSelectedIndex()+1, user.getIdUser());
                    if(update){
                        User user = new UserManager().getInstance().getUser();
                        user.setIdCategory(cbKategori.getSelectedIndex()+1);
                        user.setName(tfNama.getText());
                        user.setEmail(tfEmail.getText());
                        JOptionPane.showMessageDialog(null, "Update berhasil");
                        frame.dispose();
                        new MainMenu(user);
                    }else{
                        JOptionPane.showMessageDialog(null, "Update gagal");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Email telah digunakan");
                }
            }
        });
        btnDelete = new JButton("Delete");
        btnDelete.setBounds(310,320,100,30);
        btnDelete.setFont(new Font("Arial", Font.BOLD, 16));
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller c = new Controller();
                boolean delete = c.deleteUser(user.getIdUser());
                if(delete){
                    new UserManager().getInstance().setUser(null);
                    JOptionPane.showMessageDialog(null, "Delete berhasil");
                    frame.dispose();
                    new MainMenu(new UserManager().getInstance().getUser());
                }else{
                    JOptionPane.showMessageDialog(null, "Delete gagal");
                }
            }
        });

        frame.add(labelNama);
        frame.add(labelEmail);
        frame.add(labelKategori);
        frame.add(tfEmail);
        frame.add(tfNama);
        frame.add(cbKategori);
        frame.add(btnBack);
        frame.add(btnUpdate);
        frame.add(btnDelete);

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
