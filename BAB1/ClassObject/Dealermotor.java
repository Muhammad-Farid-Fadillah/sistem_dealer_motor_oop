/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB1.ClassObject;

/**
 *
 * @author dedys
 */
public class Dealermotor {
    String merk;
    String warna;
    String tahunmasuk;
    int harga;
    int jumlah;
    
//    method atau fungsi untul menampilkan data awal motor
    public void tampildata1(){
        System.out.println("Data Motor Dalam Dealer Kami");
        System.out.println("----------------------------");
        System.out.println("Merk : " + merk);
        System.out.println("Warna : " + warna);
        System.out.println("Jumlah : " + jumlah);
        System.out.println("Tahun Masuk : " + tahunmasuk);
        System.out.println("Harga : " + harga);
        System.out.println(" ");
}
    public void gantiWarna(String warnaBaru){
        warna = warnaBaru;
        System.out.println(" Warna baru untuk " + merk + " adalah " + warna);
    }
    // Method untuk menambah stok motor
    public void tambahStok(int jumlahBaru) {
        jumlah += jumlahBaru;
        System.out.println(jumlahBaru + " unit motor " + merk + " telah ditambahkan. Total stok: " + jumlah);
    }

    // Method untuk mengurangi stok motor saat penjualan
    public void kurangiStok(int jumlahTerjual) {
        if (jumlahTerjual > jumlah) {
            System.out.println("Stok tidak mencukupi! Tersedia hanya " + jumlah + " unit.");
        } else {
            jumlah -= jumlahTerjual;
            System.out.println(jumlahTerjual + " unit motor " + merk + " telah terjual. Sisa stok: " + jumlah);
        }
    }

    // Method untuk menghitung total harga dari semua unit motor yang tersedia
    public int hitungTotalHarga() {
        return jumlah * harga;
    }
}
