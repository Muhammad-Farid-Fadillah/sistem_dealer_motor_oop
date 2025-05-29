package BAB5.Overloading;

public class Dealermotor {
    private String merk, warna, tahunmasuk;
    private int harga, jumlah;

    // Konstruktor utama
    public Dealermotor(String merk, String warna, String tahunmasuk, int harga, int jumlah) {
        this.merk = merk;
        this.warna = warna;
        this.tahunmasuk = tahunmasuk;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    // Getter & Setter
    public String getMerk() { return merk; }
    public String getWarna() { return warna; }
    public String getTahunmasuk() { return tahunmasuk; }
    public int getHarga() { return harga; }
    public int getJumlah() { return jumlah; }

    public void setWarna(String warna) { this.warna = warna; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }

    // Method: tampilkanData (Overloading)
    public void tampilkanData() {
        System.out.println("----Data Motor Dealer----");
        System.out.println("Merk       : " + merk);
        System.out.println("Warna      : " + warna);
        System.out.println("Tahun      : " + tahunmasuk);
        System.out.println("Harga      : Rp " + harga);
        System.out.println("Stok       : " + jumlah);
    }

    // Overload tampilkanData untuk kondisi stok minimum
    public void tampilkanData(int stokMinimal) {
        tampilkanData(); // Panggil method asli
        if (jumlah < stokMinimal) {
            System.out.println("**Perhatian: Stok di bawah batas minimal!**");
        }
    }

    // Method: gantiWarna (Overloading)
    public void gantiWarna(String warnaBaru) {
        System.out.println("Mengubah warna " + merk + " dari " + warna + " menjadi " + warnaBaru);
        this.warna = warnaBaru;
    }

    // Overload: gantiWarna dengan alasan perubahan
    public void gantiWarna(String warnaBaru, String alasan) {
        System.out.println("Mengubah warna " + merk + " dari " + warna + " menjadi " + warnaBaru);
        System.out.println("Alasan perubahan: " + alasan);
        this.warna = warnaBaru;
    }

    // Method: tambahStok (Overloading)
    public void tambahStok(int jumlahBaru) {
        jumlah += jumlahBaru;
        System.out.println(merk + " Stok ditambah " + jumlahBaru + ". Total: " + jumlah);
    }

    // Overload: tambahStok dengan nama supplier
    public void tambahStok(int jumlahBaru, String supplier) {
        jumlah += jumlahBaru;
        System.out.println("Stok " + merk + " ditambah " + jumlahBaru + " unit dari supplier " + supplier + ". Total: " + jumlah);
    }

    public void kurangiStok(int jumlahTerjual) {
        if (jumlahTerjual > jumlah) {
            System.out.println("Stok tidak cukup! Tersisa: " + jumlah);
        } else {
            jumlah -= jumlahTerjual;
            System.out.println(merk + " " + jumlahTerjual + " unit terjual. Sisa stok: " + jumlah);
        }
    }
}
