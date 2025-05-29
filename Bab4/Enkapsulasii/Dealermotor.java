package BAB4.Enkapsulasii;

public class Dealermotor {
    private String merk, warna, tahunmasuk;
    private int harga, jumlah;

    public Dealermotor(String merk, String warna, String tahunmasuk, int harga, int jumlah) {
        this.merk = merk;
        this.warna = warna;
        this.tahunmasuk = tahunmasuk;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    // Getters & Setters
    public String getMerk() { return merk; }
    public String getWarna() { return warna; }
    public String getTahunmasuk() { return tahunmasuk; }
    public int getHarga() { return harga; }
    public int getJumlah() { return jumlah; }
    public void setWarna(String warna) { this.warna = warna; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }

    // Operasi
    public void tampilkanData() {
        System.out.println("----Data Motor Dealer----");
        System.out.println("Merk       : " + merk);
        System.out.println("Warna      : " + warna);
        System.out.println("Tahun      : " + tahunmasuk);
        System.out.println("Harga      : Rp " + harga);
        System.out.println("Stok       : " + jumlah);
    }

    public void gantiWarna(String warnaBaru) {
        System.out.println("Mengubah warna " + merk + " dari " +  warna + " menjadi " + warnaBaru);
        this.warna = warnaBaru;
    }

    public void tambahStok(int jumlahBaru) {
        jumlah += jumlahBaru;
        System.out.println( merk +" "+ "Stok ditambah " + jumlahBaru + ". Total: " + jumlah);
    }

    public void kurangiStok(int jumlahTerjual) {
        if (jumlahTerjual > jumlah) {
            System.out.println("Stok tidak cukup! Tersisa: " + jumlah);
        } else {
            jumlah -= jumlahTerjual;
            System.out.println(merk + " " +jumlahTerjual + " unit terjual. Sisa stok: " + jumlah);
        }
    }
}
