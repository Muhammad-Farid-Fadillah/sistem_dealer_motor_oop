package BAB4.Enkapsulasii;

public class Biodata_Pembeli extends Dealermotor {
    private String nama, umur, nohp, alamat;

    public Biodata_Pembeli(String merk, String warna, String tahunmasuk, int harga, int jumlah,
                           String nama, String umur, String nohp, String alamat) {
        super(merk, warna, tahunmasuk, harga, jumlah);
        this.nama = nama;
        this.umur = umur;
        this.nohp = nohp;
        this.alamat = alamat;
    }

    public void tampilkanBiodata() {
        System.out.println("==============================");
        System.out.println("====== BIODATA PEMBELI =======");
        System.out.println("Nama   : " + nama);
        System.out.println("Umur   : " + umur);
        System.out.println("No HP  : " + nohp);
        System.out.println("Alamat : " + alamat);
        System.out.println("=== DATA MOTOR YANG DIBELI ===");
        tampilkanData();
    }
}
