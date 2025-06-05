package BAB9.Interface;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Membuat objek Honda dan Yamaha dengan tipe induk
        Dealermotor honda = new Honda("Honda Vario", "Putih", "2024", "Bensin", 20000000, 10);
        Dealermotor yamaha = new Yamaha("Yamaha NMAX", "Hitam", "2023", "Bensin", 30000000, 5);

        System.out.println("===== SELAMAT DATANG DI DEALER MOTOR =====");
        System.out.println("1. Honda Vario");
        System.out.println("2. Yamaha NMAX");
        System.out.print("Pilih motor yang ingin dibeli (1/2): ");
        int pilihan = input.nextInt();

        Dealermotor motorDipilih;
        if (pilihan == 1) {
            motorDipilih = honda;
        } else if (pilihan == 2) {
            motorDipilih = yamaha;
        } else {
            System.out.println("❌ Pilihan tidak valid.");
            input.close();
            return;
        }

        // Tampilkan detail dan promo motor
        System.out.println("\n--- Data Motor yang Anda Pilih ---");
        motorDipilih.tampilkanData();
        motorDipilih.tampilkanPromo();

        // Input jumlah beli
        System.out.print("\nBerapa unit yang ingin Anda beli? ");
        int jumlah = input.nextInt();

        // Proses transaksi
        PembayaranDealer transaksi = new PembayaranDealer(motorDipilih, jumlah);
        transaksi.tampilkanTagihan();

        // Input uang pembayaran
        System.out.print("Masukkan jumlah uang Anda: Rp ");
        int uang = input.nextInt();
        transaksi.bayar(uang);

        // Tampilkan stok setelah transaksi
        System.out.println("\n--- Data Stok Setelah Transaksi ---");
        motorDipilih.tampilkanData(3); // peringatan jika stok di bawah 3

        input.close();
    }
}
