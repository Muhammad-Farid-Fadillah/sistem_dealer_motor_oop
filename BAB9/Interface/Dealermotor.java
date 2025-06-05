package BAB9.Interface;

public abstract class Dealermotor {
    // Atribut private untuk enkapsulasi
    private String merk, warna, tahunMasuk, tipeBahanBakar;
    private int harga, jumlah;

    // Konstruktor untuk inisialisasi objek
    public Dealermotor(String merk, String warna, String tahunMasuk, String tipeBahanBakar, int harga, int jumlah) {
        this.merk = merk;
        this.warna = warna;
        this.tahunMasuk = tahunMasuk;
        this.tipeBahanBakar = tipeBahanBakar;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    // Getter untuk setiap atribut
    public String getMerk() { return merk; }
    public String getWarna() { return warna; }
    public String getTahunMasuk() { return tahunMasuk; }
    public String getTipeBahanBakar() { return tipeBahanBakar; }
    public int getHarga() { return harga; }
    public int getJumlah() { return jumlah; }

    // Setter untuk jumlah
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }

    // Method untuk menampilkan data motor
    public void tampilkanData() {
        System.out.println("---- Data Motor Dealer ----");
        System.out.println("Merk            : " + merk);
        System.out.println("Warna           : " + warna);
        System.out.println("Tahun Masuk     : " + tahunMasuk);
        System.out.println("Bahan Bakar     : " + tipeBahanBakar);
        System.out.println("Harga           : Rp " + harga);
        System.out.println("Stok Tersedia   : " + jumlah);
    }

    // Overloading method: menampilkan data dengan peringatan jika stok minim
    public void tampilkanData(int stokMinimal) {
        tampilkanData();
        if (jumlah < stokMinimal) {
            System.out.println("** Perhatian: Stok menipis! **");
        }
    }

    // Method untuk menambah stok
    public void tambahStok(int tambahan) {
        jumlah += tambahan;
        System.out.println("Stok ditambah: " + tambahan + " unit. Total stok: " + jumlah);
    }

    // Method untuk mengurangi stok saat penjualan
    public void kurangiStok(int jumlahTerjual) {
        if (jumlahTerjual > jumlah) {
            System.out.println("Stok tidak mencukupi!");
        } else {
            jumlah -= jumlahTerjual;
            System.out.println("Terjual " + jumlahTerjual + " unit. Sisa stok: " + jumlah);
        }
    }

    // Method abstract (akan diimplementasikan oleh subclass)
    public abstract double hitungDiskon(int jumlahUnit);
    public abstract void tampilkanPromo();

    // Overload method untuk promo dengan nama bulan
    public void tampilkanPromo(String bulan) {
        System.out.println("Promo bulan " + bulan + " akan segera diumumkan!");
    }
}