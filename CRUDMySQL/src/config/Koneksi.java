/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection koneksi;

    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                // Catatan: Ubah port ke 3307 jika MySQL Laragon Anda menggunakan port 3307
                String url = "jdbc:mysql://localhost:3306/db_toko"; 
                String user = "root";
                String password = ""; // Default Laragon/XAMPP adalah kosong

                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("=> [SUKSES] Koneksi ke Database Toko Berhasil!");
            } catch (SQLException e) {
                System.err.println("=> [GAGAL] Koneksi Database Error: " + e.getMessage());
            }
        }
        return koneksi;
    }
    
}
