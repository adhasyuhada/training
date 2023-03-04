package main.java;

public class LuasBidang {

    public void menuBidang(){
        System.out.println("– pilih bidang yang di hitung –\n" +
                "1. persegi\n" +
                "2. lingkaran\n" +
                "3. segitiga\n" +
                "4. persegi panjang\n" +
                "0. kembali ke menu sebelumnya");
    }

    public int hitungPersegi(int panjang, int lebar){
        return panjang * lebar;
    }

    public double hitungLingkaran(double jari2){
        return 3.14 * jari2;

    }


    public double hitungSegitiga(int alas, int tinggi){
        return 0.5 * alas * tinggi;
    }

    public int hitungPersegiPanjang(int panjang, int lebar){
        return panjang * lebar;
    }


}
