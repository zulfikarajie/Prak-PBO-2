/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tugas7_123220035;

/**
 *
 * @author apang
 */
import javax.swing.*;


public class Tugas7_123220035 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
              
                MovieView view = new MovieView();
                MovieDAO dao = new MovieDAOImpl();
                new MovieController(view, dao);
                view.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error initializing application: " + e.getMessage());
            }
        });
    }
}

