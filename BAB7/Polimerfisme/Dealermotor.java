package BAB7.Polimerfisme;

public abstract class Dealermotor {
    private String merk, warna, tahunMasuk, tipeBahanBakar;
    private int harga, jumlah;

    public Dealermotor(String merk, String warna, String tahunMasuk, String tipeBahanBakar, int harga, int jumlah) {
        this.merk = merk;
        this.warna = warna;
        this.tahunMasuk = tahunMasuk;
        this.tipeBahanBakar = tipeBahanBakar;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public String getMerk() { return merk; }
    public String getWarna() { return warna; }
    public String getTahunMasuk() { return tahunMasuk; }
    public String getTipeBahanBakar() { return tipeBahanBakar; }
    public int getHarga() { return harga; }
    public int getJumlah() { return jumlah; }

    public void setJumlah(int jumlah) { this.jumlah = jumlah; }

    public void tampilkanData() {
        System.out.println("---- Data Motor Dealer ----");
        System.out.println("Merk            : " + merk);
        System.out.println("Warna           : " + warna);
        System.out.println("Tahun Masuk     : " + tahunMasuk);
        System.out.println("Bahan Bakar     : " + tipeBahanBakar);
        System.out.println("Harga           : Rp " + harga);
        System.out.println("Stok Tersedia   : " + jumlah);
    }

    public void tampilkanData(int stokMinimal) {
        tampilkanData();
        if (jumlah < stokMinimal) {
            System.out.println("** Perhatian: Stok menipis! **");
        }
    }

    public void tambahStok(int tambahan) {
        jumlah += tambahan;
        System.out.println("Stok ditambah: " + tambahan + " unit. Total stok: " + jumlah);
    }

    public void kurangiStok(int jumlahTerjual) {
        if (jumlahTerjual > jumlah) {
            System.out.println("Stok tidak mencukupi!");
        } else {
            jumlah -= jumlahTerjual;
            System.out.println("Terjual " + jumlahTerjual + " unit. Sisa stok: " + jumlah);
        }
    }

    public abstract double hitungDiskon(int jumlahUnit);
    public abstract void tampilkanPromo();

    // Polimorfisme statis (overloading)
    public void tampilkanPromo(String bulan) {
        System.out.println("Promo bulan " + bulan + " akan segera diumumkan!");
    }
}
