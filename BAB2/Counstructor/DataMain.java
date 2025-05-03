/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB2.Counstructor;

/**
 *
 * @author dedys
 */
public class DataMain {
    public static void main(String[] args){
        // Membuat objek Motor
        Dealermotor motor1 = new Dealermotor("Honda CBR 2013", "Biru", "2025", 35000000, 10);
        Dealermotor motor2 = new Dealermotor("Yamaha RX King", "Hitam", "2024", 35000000, 10);
        
        // Menampilkan informasi motor
        motor1.tampildata1();
        motor2.tampildata1();
        
        // Mengganti data motor
        motor2.warna = ("Kuning");
        
        // Menampilkan informasi motor
        System.out.println("Data berhasil Di ubah");
        motor1.tambahStok(10);
        motor1.tampildata1();
        motor2.kurangiStok(5);
        motor2.tampildata1();
    }
}
