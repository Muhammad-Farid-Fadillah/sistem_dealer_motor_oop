package BAB4.Enkapsulasii;

public class Pembayaran {
    private Dealermotor motor;
    private int jumlahDibeli;
    private String metode, status, tanggal;

    public Pembayaran(Dealermotor motor, int jumlahDibeli, String metode, String status, String tanggal) {
        this.motor = motor;
        this.jumlahDibeli = jumlahDibeli;
        this.metode = metode;
        this.status = status;
        this.tanggal = tanggal;
    }

    public int hitungTotalBayar() {
        return motor.getHarga() * jumlahDibeli;
    }

    public void tampilkanInfoPembayaran() {
        System.out.println("============================");
        System.out.println("=== INFORMASI PEMBAYARAN ===");
        System.out.println("Metode    : " + metode);
        System.out.println("Status    : " + status);
        System.out.println("Tanggal   : " + tanggal);
        System.out.println("Jumlah    : " + jumlahDibeli);
        System.out.println("Total     : Rp " + hitungTotalBayar());
        motor.tampilkanData();
    }
}
