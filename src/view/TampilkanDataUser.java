package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class TampilkanDataUser {
    JFrame frame;

    public TampilkanDataUser(int kategori){
        //Frame
        frame = new JFrame("Tampilkan data");
        frame.setSize(800, 800);

        Controller controller = new Controller();

        String [][] dataUser=controller.konversiListToArray(controller.getAllUsers(kategori));

        //init kolom
        String column[]={"idUser","Nama","Email","Password","idCategory"};

        //tabel data
        JTable tabelUser=new JTable(dataUser,column);
        JScrollPane sp=new JScrollPane(tabelUser);
        sp.setBounds(0, 0, 780, 700);

        JPanel contentPane = new JPanel(null);
        contentPane.add(sp);
        frame.setContentPane(contentPane);

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
