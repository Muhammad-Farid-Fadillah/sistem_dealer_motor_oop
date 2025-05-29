package BAB7.Polimerfisme;

public class PembayaranDealer {
    Dealermotor motor;
    private int jumlahUnit;
    double diskon;
    int totalAwal;
    int totalSetelahDiskon;

    public PembayaranDealer(Dealermotor motor, int jumlahUnit) {
        this.motor = motor;
        this.jumlahUnit = jumlahUnit;
        this.diskon = motor.hitungDiskon(jumlahUnit);
        this.totalAwal = motor.getHarga() * jumlahUnit;
        this.totalSetelahDiskon = totalAwal - (int)(totalAwal * diskon);
    }

    public void tampilkanTagihan() {
        System.out.println("\n===== STRUK PEMBAYARAN =====");
        System.out.println("Merk            : " + motor.getMerk());
        System.out.println("Harga per Unit  : Rp " + motor.getHarga());
        System.out.println("Jumlah Beli     : " + jumlahUnit);
        System.out.println("Total Awal      : Rp " + totalAwal);
        System.out.println("Diskon          : " + (int)(diskon * 100) + "%");
        System.out.println("Total Bayar     : Rp " + totalSetelahDiskon);
    }

    public void bayar(int uang) {
        System.out.println("Uang Dibayar    : Rp " + uang);
        if (uang < totalSetelahDiskon) {
            System.out.println("❌ Uang kurang Rp " + (totalSetelahDiskon - uang));
        } else {
            System.out.println("✅ Pembayaran berhasil. Kembalian: Rp " + (uang - totalSetelahDiskon));
            motor.kurangiStok(jumlahUnit);
        }
    }
}
