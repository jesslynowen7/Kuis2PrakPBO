package view;

import controller.Controller;

import javax.swing.*;

public class TampilkanDataUser {
    JFrame frame;

    public TampilkanDataUser(){
        //Frame
        frame = new JFrame("Tampilkan data");
        frame.setSize(800, 800);

        Controller controller = new Controller();
        JPanel panel= new JPanel();
        panel.setBounds(0,0 , 1200, 1200);

        String [][] dataUser=controller.konversiListToArray(controller.getAllUsers());

        //init kolom
        String column[]={"idUser","Nama","Email","Password","idCategory"};

        //tabel data
        JTable tabelUser=new JTable(dataUser,column);
        tabelUser.setBounds(0,0,1200,1200);
        JScrollPane sp=new JScrollPane(tabelUser);
        panel.add(sp);
        frame.add(panel);

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
