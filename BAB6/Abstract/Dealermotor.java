package BAB6.Abstract;

// Menjadikan kelas sebagai abstract agar tidak bisa diinstansiasi langsung
public abstract class Dealermotor {
    // Deklarasi atribut dengan akses private (enkapsulasi)
    private String merk, warna, tahunMasuk;
    private int harga, jumlah;

    // Konstruktor untuk mengisi data awal saat objek dibuat
    public Dealermotor(String merk, String warna, String tahunMasuk, int harga, int jumlah) {
        this.merk = merk;
        this.warna = warna;
        this.tahunMasuk = tahunMasuk;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    // Getter: Mengambil nilai dari atribut (akses data)
    public String getMerk() { return merk; }
    public String getWarna() { return warna; }
    public String getTahunMasuk() { return tahunMasuk; }
    public int getHarga() { return harga; }
    public int getJumlah() { return jumlah; }

    // Setter: Mengubah nilai atribut tertentu
    public void setWarna(String warna) { this.warna = warna; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }

    // Menampilkan data lengkap motor
    public void tampilkanData() {
        System.out.println("---- Data Motor Dealer ----");
        System.out.println("Merk        : " + merk);
        System.out.println("Warna       : " + warna);
        System.out.println("Tahun Masuk : " + tahunMasuk);
        System.out.println("Harga       : Rp " + harga);
        System.out.println("Stok        : " + jumlah);
    }

    // Overloading: Menampilkan data + pengecekan jika stok di bawah batas minimal
    public void tampilkanData(int stokMinimal) {
        tampilkanData();  // Menampilkan data seperti biasa
        if (jumlah < stokMinimal) {
            System.out.println("** Perhatian: Stok di bawah batas minimal! **");
        }
    }

    // Mengganti warna motor
    public void gantiWarna(String warnaBaru) {
        System.out.println("Mengubah warna " + merk + " dari " + warna + " menjadi " + warnaBaru);
        this.warna = warnaBaru;
    }

    // Overloading: Ganti warna sekaligus tampilkan alasan perubahan
    public void gantiWarna(String warnaBaru, String alasan) {
        System.out.println("Mengubah warna " + merk + " dari " + warna + " menjadi " + warnaBaru);
        System.out.println("Alasan perubahan: " + alasan);
        this.warna = warnaBaru;
    }

    // Menambah stok motor
    public void tambahStok(int jumlahBaru) {
        jumlah += jumlahBaru;
        System.out.println("Stok " + merk + " ditambah " + jumlahBaru + ". Total: " + jumlah);
    }

    // Overloading: Tambah stok dengan nama supplier untuk catatan
    public void tambahStok(int jumlahBaru, String supplier) {
        jumlah += jumlahBaru;
        System.out.println("Stok " + merk + " ditambah " + jumlahBaru + " unit dari supplier " + supplier + ". Total: " + jumlah);
    }

    // Mengurangi stok saat motor terjual
    public void kurangiStok(int jumlahTerjual) {
        if (jumlahTerjual > jumlah) {
            // Validasi jika stok tidak cukup
            System.out.println("Stok tidak cukup! Tersisa: " + jumlah);
        } else {
            jumlah -= jumlahTerjual;
            System.out.println(merk + " terjual " + jumlahTerjual + " unit. Sisa stok: " + jumlah);
        }
    }

    // ✅ Method abstract: setiap subclass wajib mengimplementasikan promo-nya masing-masing
    public abstract void tampilkanPromo();
}
