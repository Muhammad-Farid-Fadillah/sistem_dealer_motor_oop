package BAB9.Interface;

public class Honda extends Dealermotor implements PromoDealer {
    public Honda(String merk, String warna, String tahunMasuk, String bahanBakar, int harga, int jumlah) {
        super(merk, warna, tahunMasuk, bahanBakar, harga, jumlah);
    }

    @Override
    public void tampilkanPromo() {
        System.out.println("\uD83C\uDF89 PROMO HONDA BULAN INI \uD83C\uDF89");
        System.out.println("- Diskon 10% untuk pembelian 2 unit atau lebih");
        System.out.println("- Gratis servis & oli 3x");
    }

    @Override
    public double hitungDiskon(int jumlahUnit) {
        return (jumlahUnit > 1) ? 0.10 : 0.0;
    }
}
