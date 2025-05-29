package BAB6.Abstract;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Membuat objek motor Honda
        Honda motor = new Honda("Honda Vario 160", "Putih", "2024", 26000000, 10);

        // Tampilkan data motor & promo
        motor.tampilkanData();
        motor.tampilkanPromo();

        // Input jumlah pembelian
        System.out.print("\nBerapa unit yang ingin dibeli? ");
        int jumlahBeli = input.nextInt();

        // Buat objek pembayaran berdasarkan motor yang dibeli
        PembayaranDealer transaksi = new PembayaranDealer(motor, jumlahBeli);
        transaksi.tampilkanTagihan();

        // Input uang dari pembeli
        System.out.print("Masukkan uang pembeli: Rp ");
        int uang = input.nextInt();

        // Proses pembayaran
        transaksi.bayar(uang);

        input.close();
    }
}
