package BAB6.Abstract;

public class PembayaranDealer {
    private Dealermotor motor; // Objek motor dari kelas abstrak (Honda, Yamaha, dll)
    private int jumlahUnit;
    private int totalBayar;

    // Constructor menerima objek motor & jumlah yang dibeli
    public PembayaranDealer(Dealermotor motor, int jumlahUnit) {
        this.motor = motor;
        this.jumlahUnit = jumlahUnit;
        this.totalBayar = motor.getHarga() * jumlahUnit;
    }

    // Menampilkan detail transaksi
    public void tampilkanTagihan() {
        System.out.println("\n===== STRUK PEMBAYARAN =====");
        System.out.println("Merk Motor     : " + motor.getMerk());
        System.out.println("Warna          : " + motor.getWarna());
        System.out.println("Harga per Unit : Rp " + motor.getHarga());
        System.out.println("Jumlah Beli    : " + jumlahUnit);
        System.out.println("Total Bayar    : Rp " + totalBayar);
    }

    // Proses pembayaran dan validasi uang
    public void bayar(int uangDibayar) {
        System.out.println("Uang Dibayar   : Rp " + uangDibayar);
        if (uangDibayar < totalBayar) {
            System.out.println("❌ Uang tidak cukup. Kurang Rp " + (totalBayar - uangDibayar));
        } else {
            System.out.println("✅ Pembayaran berhasil. Kembalian: Rp " + (uangDibayar - totalBayar));
            motor.kurangiStok(jumlahUnit); // update stok di objek motor
        }
    }
}
