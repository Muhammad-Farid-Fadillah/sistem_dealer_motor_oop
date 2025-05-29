package BAB6.Abstract;

// Subclass dari Dealermotor
public class Honda extends Dealermotor {

    // Konstruktor: memanggil konstruktor dari superclass
    public Honda(String merk, String warna, String tahunMasuk, int harga, int jumlah) {
        super(merk, warna, tahunMasuk, harga, jumlah);
    }

    // Implementasi method abstract tampilkanPromo()
    @Override
    public void tampilkanPromo() {
        System.out.println("🎉 PROMO HONDA BULAN INI 🎉");
        System.out.println("- Cashback hingga Rp 2.000.000");
        System.out.println("- Gratis servis & oli 3x");
        System.out.println("- Hadiah langsung helm eksklusif");
    }
}
