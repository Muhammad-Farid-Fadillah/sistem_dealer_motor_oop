package BAB9.Interface;

public class Yamaha extends Dealermotor implements PromoDealer {
    public Yamaha(String merk, String warna, String tahunMasuk, String bahanBakar, int harga, int jumlah) {
        super(merk, warna, tahunMasuk, bahanBakar, harga, jumlah);
    }

    @Override
    public void tampilkanPromo() {
        System.out.println("\uD83D\uDD25 PROMO YAMAHA MINGGU INI \uD83D\uDD25");
        System.out.println("- Diskon 7% untuk pembelian 2 unit atau lebih");
        System.out.println("- Bonus jaket exclusive");
    }

    @Override
    public double hitungDiskon(int jumlahUnit) {
        return (jumlahUnit >1) ? 0.07 : 0.0;
    }
}