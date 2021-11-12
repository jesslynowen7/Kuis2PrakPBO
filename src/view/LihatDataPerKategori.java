package view;

import controller.Controller;
import model.CategoryUser;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LihatDataPerKategori {
    JFrame frame;
    JComboBox cbKategori;
    JButton btnBack, btnSearch;

    public LihatDataPerKategori(){
        Controller con = new Controller();

        //Frame
        frame = new JFrame("Tampilakn data");
        frame.setSize(800, 800);

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
        cbKategori.setBounds(50, 50, 200, 30);

        btnBack = new JButton("Back");
        btnBack.setBounds(50,100,100,30);
        btnBack.setFont(new Font("Arial", Font.BOLD, 16));
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenu(new User());
            }
        });

        btnSearch = new JButton("Search");
        btnSearch.setBounds(200,100,150,30);
        btnSearch.setFont(new Font("Arial", Font.BOLD, 16));
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TampilkanDataUser(cbKategori.getSelectedIndex()-1);
            }
        });

        frame.add(btnBack);
        frame.add(btnSearch);
        frame.add(cbKategori);

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
