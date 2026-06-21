/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import view.BarangView;

public class MainApp {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new BarangView().setVisible(true);
        });
    }
    
}
