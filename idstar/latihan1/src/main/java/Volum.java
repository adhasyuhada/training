package main.java;

public class Volum {

    public void menuVolum(){
        System.out.println("– pilih bidang yang di hitung –\n" +
                "1. Kubus\n" +
                "2. Balok\n" +
                "3. Tabung\n" +
                "0. kembali ke menu sebelumnya");
    }

    public int hitungKubus(int sisi){
        return sisi * sisi * sisi;
    }

    public int hitungBalok(int panjang, int lebar, int tinggi){
        return panjang * lebar * tinggi;
    }

    public double hitungTabung(double tinggi, double jari2){
        return 3.14 * tinggi * jari2;
    }
}
