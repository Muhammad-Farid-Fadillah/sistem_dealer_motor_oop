package BAB5.Overloading;

public class Main {
    public static void main(String[] args) {
        // Membuat objek Biodata_Pembeli
        Biodata_Pembeli pembeli = new Biodata_Pembeli(
            "Yamaha NMAX",    // merk
            "Hitam",          // warna
            "2024",           // tahun masuk
            31000000,         // harga
            3,                // jumlah unit dibeli
            "Rina Amelia",    // nama pembeli
            "24",             // umur
            "081234567890",   // no hp
            "Jl. Melati No. 5, Jakarta" // alamat
        );

        // Menampilkan biodata + data motor
        pembeli.tampilkanBiodata();
        pembeli.gantiWarna("Hijau", "Unit Habis");
        pembeli.tampilkanBiodata();
    }
}
