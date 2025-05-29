package BAB5.Overloading;

public class PembayaranDealer extends Dealermotor {
    private int jumlahDibeli;
    private String metode, status, tanggal;

    // Konstruktor lengkap
    public PembayaranDealer(String merk, String warna, String tahunmasuk, int harga, int jumlahStok,
                            int jumlahDibeli, String metode, String status, String tanggal) {
        super(merk, warna, tahunmasuk, harga, jumlahStok); // Memanggil konstruktor dari Dealermotor
        this.jumlahDibeli = jumlahDibeli;
        this.metode = metode;
        this.status = status;
        this.tanggal = tanggal;
    }

    // Method untuk menghitung total bayar
    public int hitungTotalBayar() {
        return getHarga() * jumlahDibeli;
    }

    // Method untuk menampilkan informasi pembayaran
    public void tampilkanInfoPembayaran() {
        System.out.println("============================");
        System.out.println("=== INFORMASI PEMBAYARAN ===");
        System.out.println("Metode    : " + metode);
        System.out.println("Status    : " + status);
        System.out.println("Tanggal   : " + tanggal);
        System.out.println("Jumlah    : " + jumlahDibeli);
        System.out.println("Total     : Rp " + hitungTotalBayar());
        tampilkanData(); // Panggil method dari superclass
    }
}
