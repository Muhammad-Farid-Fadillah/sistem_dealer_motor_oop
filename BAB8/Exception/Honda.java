package BAB7.Polimerfisme;

public class Honda extends Dealermotor {
    public Honda(String merk, String warna, String tahunMasuk, String bahanBakar, int harga, int jumlah) {
        super(merk, warna, tahunMasuk, bahanBakar, harga, jumlah);
    }

    @Override
    public void tampilkanPromo() {
        System.out.println("🎉 PROMO HONDA BULAN INI 🎉");
        System.out.println("- Diskon 10% untuk pembelian ≥ 2 unit");
        System.out.println("- Gratis servis & oli 3x");
    }

    @Override
    public double hitungDiskon(int jumlahUnit) {
        return (jumlahUnit >= 2) ? 0.10 : 0.0;
    }
}
