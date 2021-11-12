package controller;

import model.CategoryUser;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.User;

public class Controller {
    static DatabaseHandler conn = new DatabaseHandler();

    // SELECT ALL from table user
    public static ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM user";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setIdUser(rs.getInt("idUser"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIdCategory(rs.getInt("idCategory"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (users);
    }

    public static ArrayList<User> getAllUsers(int category) {
        ArrayList<User> users = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM user WHERE idCategory='" + category + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setIdUser(rs.getInt("idUser"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIdCategory(rs.getInt("idCategory"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (users);
    }

    // SELECT WHERE
    public static User getUser(String email, char[] pass) {
        conn.connect();
        String password="";
        for (int i=0; i<pass.length; i++){
            password+=pass[i];
        }
        String query = "SELECT * FROM user WHERE email='"+ email + "'&&password='" + password + "'";
        User user = new User();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                user.setIdUser(rs.getInt("idUser"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIdCategory(rs.getInt("idCategory"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (user);
    }

    // UPDATE
    public static boolean updateUser(User user) {
        conn.connect();
        String query = "UPDATE user SET name='" + user.getName() + "', "
                + "email='" + user.getEmail() + "', ";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public static ArrayList<CategoryUser> getKategori() {
        conn.connect();
        String query = "SELECT * FROM categoryuser";
        ArrayList<CategoryUser> kategori = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CategoryUser category = new CategoryUser();
                category.setIdCategory(rs.getInt("idCategory"));
                category.setName(rs.getString("name"));
                kategori.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (kategori);
    }

    public static boolean insertNewUser(User user) {
        conn.connect();
        String query = "INSERT INTO user VALUES(?, ?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, user.getIdUser());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setInt(5, user.getIdCategory());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public String [][] konversiListToArray(ArrayList<User> list){
        String hasil[][]=new String[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            User currentUser= list.get(i);
            hasil[i][0]=Integer.toString(currentUser.getIdUser());
            hasil[i][1]=currentUser.getName();
            hasil[i][2]=currentUser.getEmail();
            hasil[i][3]=currentUser.getPassword();
            hasil[i][4]=Integer.toString(currentUser.getIdCategory());
        }
        return hasil;
    }
}
