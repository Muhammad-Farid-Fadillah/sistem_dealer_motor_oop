package BAB7.Polimerfisme;

public class Yamaha extends Dealermotor {
    public Yamaha(String merk, String warna, String tahunMasuk, String bahanBakar, int harga, int jumlah) {
        super(merk, warna, tahunMasuk, bahanBakar, harga, jumlah);
    }

    @Override
    public void tampilkanPromo() {
        System.out.println("🔥 PROMO YAMAHA MINGGU INI 🔥");
        System.out.println("- Diskon 7% untuk pembelian ≥ 2 unit");
        System.out.println("- Bonus jaket exclusive");
    }

    @Override
    public double hitungDiskon(int jumlahUnit) {
        return (jumlahUnit >= 2) ? 0.07 : 0.0;
    }
}
