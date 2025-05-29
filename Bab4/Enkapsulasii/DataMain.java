package BAB4.Enkapsulasii;

public class DataMain {
    public static void main(String[] args) {
        // Objek Motor
        Dealermotor motor1 = new Dealermotor("Honda CBR 2013", "Biru", "2025", 35000000, 10);
        Dealermotor motor2 = new Dealermotor("Yamaha RX King", "Hitam", "2023", 35000000, 5);

        // Tampilkan data awal
        motor1.tampilkanData();
        motor2.tampilkanData();

        // Modifikasi dan stok
        motor1.tambahStok(5);
        motor1.tampilkanData();
        motor2.gantiWarna("Kuning");
        motor2.kurangiStok(1);
        motor2.tampilkanData();

        // Biodata Pembeli
        Biodata_Pembeli pembeli = new Biodata_Pembeli(
            "Yamaha RX King", "Kuning", "2023", 35000000, 1,
            "Andi Pratama", "22", "081234567890", "Jl. Melati No. 10, Bandung"
        );
        pembeli.tampilkanBiodata();

        // Transaksi Pembayaran
        Pembayaran pembayaran = new Pembayaran(
            motor2, 1, "Transfer Bank", "Lunas", "29 April 2025"
        );
        pembayaran.tampilkanInfoPembayaran();
    }
}
