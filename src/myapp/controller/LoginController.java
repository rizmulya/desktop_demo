/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myapp.controller;

import myapp.dao.UserDao;
import myapp.model.User;
import myapp.view.MainView;
import myapp.view.LoginView;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author rizm
 */
public class LoginController {
    private LoginView loginView;
    private UserDao userDao;
    private Runnable clearFieldsCallback;
    
    public LoginController(LoginView loginView, Runnable clearFieldsCallback) {
        this.loginView = loginView;
        this.userDao = new UserDao();
        this.clearFieldsCallback = clearFieldsCallback;
    }

    public void login(String username, String password) {
        try {
            User user = userDao.getUserByUsername(username);
            if (user != null && user.getPassword().equals(password)) {
                // if (user.getRole().equals("ADMIN"))
                MainView mainView = new MainView(user);
                mainView.setVisible(true);
                loginView.dispose();
            } else {
                JOptionPane.showMessageDialog(loginView, "Invalid credentials", "Login Error", JOptionPane.ERROR_MESSAGE);
                clearFieldsCallback.run();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(loginView, "Database error", "Login Error", JOptionPane.ERROR_MESSAGE);
            clearFieldsCallback.run();
        }
    }
}
