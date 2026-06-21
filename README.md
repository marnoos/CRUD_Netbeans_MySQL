# 📦 CRUD Java Desktop Application (MVC & MySQL Laragon)

Aplikasi desktop Java yang menerapkan operasi **CRUD (Create, Read, Update, Delete)** untuk manajemen data barang toko. Proyek ini dibangun dengan menerapkan arsitektur **MVC (Model-View-Controller)** yang rapi dan memanfaatkan fitur visual **Drag-and-Drop GUI** pada NetBeans. 

Penyimpanan data pada versi ini sudah terintegrasi secara dinamis dengan basis data **MySQL** menggunakan server lokal **Laragon**.

---

## 🚀 Fitur Utama

* **Create (Tambah Data):** Memasukkan Kode, Nama, dan Harga barang ke dalam database MySQL.
* **Read (Tampilkan Data):** Memuat dan menampilkan seluruh data dari tabel database ke dalam komponen `JTable` secara otomatis saat aplikasi dibuka.
* **Update (Ubah Data):** Memperbarui informasi Nama atau Harga barang berdasarkan primary key (Kode Barang).
* **Delete (Hapus Data):** Menghapus data barang secara permanen dari database dengan konfirmasi keamanan (*Dialog Box*).
* **Mouse-Click Table Listener:** Memilih/mengklik baris data pada tabel akan otomatis memindahkan informasi tersebut kembali ke formulir input atas untuk mempermudah proses modifikasi data.
* **Input Data Validation:** Dilengkapi dengan *Exception Handling* (`NumberFormatException`) untuk mencegah aplikasi *crash* jika terjadi kesalahan input tipe data.

---

## 🏗️ Struktur Arsitektur Proyek (MVC)

Proyek ini dibagi secara modular ke dalam beberapa *package* terisolasi untuk memisahkan tanggung jawab kode secara profesional:

* **`config` (`Koneksi.java`):** Mengatur jembatan koneksi database menggunakan JDBC API.
* **`model` (`Barang.java`):** Merepresentasikan objek entitas data barang toko dengan konsep Enkapsulasi murni (*private fields* dengan *getter/setter*).
* **`controller` (`BarangController.java`):** Menangani seluruh logika bisnis kueri SQL (*INSERT, SELECT, UPDATE, DELETE*).
* **`view` (`BarangView.java`):** Mengatur seluruh antarmuka komponen grafis komputer (GUI) yang didesain menggunakan desainer visual *JFrame Form* NetBeans.
* **`main` (`MainApp.java`):** Gerbang utama *entry point* jalannya eksekusi program.

---

## 🛠️ Prasyarat & Unduhan Komponen

Sebelum menjalankan proyek, pastikan Anda telah mengunduh dan menyiapkan komponen berikut:

1. **Laragon (Sebagai Web Server & MySQL Engine):**
   * Berfungsi untuk menyediakan server database lokal MySQL.
   * 📥 [Unduh Laragon Disini](https://laragon.org/download/)

2. **MySQL Connector/J (JDBC Driver):**
   * Berfungsi sebagai pustaka (*library*) agar program Java dapat berkomunikasi dengan MySQL.
   * 📥 [Unduh MySQL Connector Disini](https://dev.mysql.com/downloads/connector/j/)
   * *Catatan: Setelah diunduh, tambahkan file `.jar` tersebut ke dalam folder **Libraries** proyek Anda di NetBeans.*

---

## 💻 Cara Menyiapkan Database di Laragon

1. Buka aplikasi **Laragon**, lalu klik tombol **Start All**.
2. Klik tombol **Database** (Laragon akan membuka *HeidiSQL* atau alat manajemen database bawaan).
3. Buat database baru dengan nama **`db_toko`**.
4. Masuk ke database tersebut, lalu jalankan perintah SQL berikut untuk membuat tabel `barang`:

```sql
CREATE TABLE barang (
    kode VARCHAR(10) PRIMARY KEY,
    nama VARCHAR(100) NOT NULL,
    harga DOUBLE NOT NULL
);
