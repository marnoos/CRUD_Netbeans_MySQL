/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import config.Koneksi;
import model.Barang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BarangController {
    // 1. C (CREATE) - Tambah Data ke MySQL
    public boolean tambahBarang(Barang b) {
        String sql = "INSERT INTO barang (kode, nama, harga) VALUES (?, ?, ?)";
        try (PreparedStatement ps = Koneksi.getKoneksi().prepareStatement(sql)) {
            ps.setString(1, b.getKode());
            ps.setString(2, b.getNama());
            ps.setDouble(3, b.getHarga());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error SQL Tambah: " + e.getMessage());
            return false;
        }
    }

    // 2. R (READ) - Ambil Semua Data dari MySQL
    public List<Barang> ambilSemuaBarang() {
        List<Barang> list = new ArrayList<>();
        String sql = "SELECT * FROM barang";
        try (Statement st = Koneksi.getKoneksi().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Barang b = new Barang(
                    rs.getString("kode"),
                    rs.getString("nama"),
                    rs.getDouble("harga")
                );
                list.add(b);
            }
        } catch (SQLException e) {
            System.err.println("Error SQL Baca: " + e.getMessage());
        }
        return list;
    }

    // 3. U (UPDATE) - Ubah Data Berdasarkan Kode
    public boolean ubahBarang(Barang b) {
        String sql = "UPDATE barang SET nama = ?, harga = ? WHERE kode = ?";
        try (PreparedStatement ps = Koneksi.getKoneksi().prepareStatement(sql)) {
            ps.setString(1, b.getNama());
            ps.setDouble(2, b.getHarga());
            ps.setString(3, b.getKode());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error SQL Ubah: " + e.getMessage());
            return false;
        }
    }

    // 4. D (DELETE) - Hapus Data Berdasarkan Kode
    public boolean hapusBarang(String kode) {
        String sql = "DELETE FROM barang WHERE kode = ?";
        try (PreparedStatement ps = Koneksi.getKoneksi().prepareStatement(sql)) {
            ps.setString(1, kode);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error SQL Hapus: " + e.getMessage());
            return false;
        }
    }
    
    
}
