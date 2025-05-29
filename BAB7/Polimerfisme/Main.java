package BAB7.Polimerfisme;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Dealermotor honda = new Honda("Honda Vario", "Putih", "2024", "Bensin", 20000000, 10);
        Dealermotor yamaha = new Yamaha("Yamaha NMAX", "Hitam", "2023", "Bensin", 30000000, 5);

        System.out.println("===== SELAMAT DATANG DI DEALER MOTOR =====");

        Dealermotor motorDipilih = null;
        int pilihan = 0;

        // Loop input pilihan motor dengan validasi
        while (true) {
            try {
                System.out.println("1. Honda Vario");
                System.out.println("2. Yamaha NMAX");
                System.out.print("Pilih motor yang ingin dibeli (1/2): ");
                pilihan = input.nextInt();

                if (pilihan == 1) {
                    motorDipilih = honda;
                    break;
                } else if (pilihan == 2) {
                    motorDipilih = yamaha;
                    break;
                } else {
                    System.out.println("❌ Pilihan tidak valid, masukkan 1 atau 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Input harus berupa angka 1 atau 2.");
                input.next(); // buang input salah
            }
        }

        System.out.println("\n--- Data Motor yang Anda Pilih ---");
        motorDipilih.tampilkanData();
        motorDipilih.tampilkanPromo();

        int jumlah = 0;
        // Loop input jumlah unit dengan validasi
        while (true) {
            try {
                System.out.print("\nBerapa unit yang ingin Anda beli? ");
                jumlah = input.nextInt();

                if (jumlah <= 0) {
                    System.out.println("❌ Jumlah harus lebih dari 0.");
                } else if (jumlah > motorDipilih.getJumlah()) {
                    System.out.println("❌ Jumlah melebihi stok yang tersedia.");
                } else {
                    break; // valid input
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Input harus berupa angka.");
                input.next(); // buang input salah
            }
        }

        PembayaranDealer transaksi = new PembayaranDealer(motorDipilih, jumlah);
        transaksi.tampilkanTagihan();

        int uang = 0;
        // Loop input uang pembayaran dengan validasi
        while (true) {
            try {
                System.out.print("Masukkan jumlah uang Anda: Rp ");
                uang = input.nextInt();

                if (uang < transaksi.totalSetelahDiskon) {
                    System.out.println("❌ Uang kurang, silakan masukkan jumlah yang cukup.");
                } else {
                    break; // uang cukup
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Input harus berupa angka.");
                input.next(); // buang input salah
            }
        }

        transaksi.bayar(uang);

        System.out.println("\n--- Data Stok Setelah Transaksi ---");
        motorDipilih.tampilkanData(3);

        input.close();
    }
}
