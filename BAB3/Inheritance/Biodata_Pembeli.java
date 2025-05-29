/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB3.Inheritance;

/**
 *
 * @author dedys
 */
public class Biodata_Pembeli extends Dealermotor {
    String nama, umur, nohp, alamat;

    public Biodata_Pembeli(String merk, String warna, String tahunmasuk, int harga, int jumlah,
                       String nama, String alamat, String umur, String nohp) {
    super(merk, warna, tahunmasuk, harga, jumlah);
    this.nama = nama;
    this.umur = umur;
    this.nohp = nohp;
    this.alamat = alamat;
}

}

