package main;

import model.User;
import view.MainMenu;

public class Main {

    public static void main(String[] args) {
        new MainMenu(new User());
    }
}
