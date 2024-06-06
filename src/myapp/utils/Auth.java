/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myapp.utils;

/**
 *
 * @author rizm
 */
public class Auth {
    public static boolean setAllowed(Object roles) {
        String userRole = UserSession.getInstance().getRole();
        if (roles instanceof String) {
            return userRole.equals(roles);
        } else if (roles instanceof String[]) {
            for (String role : (String[]) roles) {
                if (userRole.equals(role)) {
                    return true;
                }
            }
        }
        return false;
    }
}