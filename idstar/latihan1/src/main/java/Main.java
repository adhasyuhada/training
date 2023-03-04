package main.java;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LuasBidang luasBidang = new LuasBidang();
        Volum volum = new Volum();
        Scanner in = new Scanner(System.in);
        initMenu();
            try {
                int menu = in.nextInt();
                switch (menu){
                    case 1 :
                        luasBidang.menuBidang();
                        int pilihan = in.nextInt();
                        if(pilihan == 0){
                            main(null);
                        }else if(pilihan == 1){
                            System.out.println("— anda memilih persegi –");
                            System.out.print("Masukkan Panjang : ");
                            int panjang = in.nextInt();
                            System.out.print("Masukkan Lebar :");
                            int lebar = in.nextInt();
                            int luasPersegi = luasBidang.hitungPersegi(panjang, lebar);
                            System.out.println("Processing …");
                            System.out.println("Luas Persegi adalah = "+luasPersegi);
                            System.out.println("— tekan apa saja untuk ke menu utama –");
                            if(in.hasNext()){
                                main(null);
                            }
                        }else if(pilihan == 2){
                            System.out.println("— anda memilih lingkaran –");
                            System.out.print("Masukkan Jari Jari : ");
                            double jarijari = in.nextDouble();
                            double luasLingkaran = luasBidang.hitungLingkaran(jarijari);
                            System.out.println("Processing …");
                            System.out.println("Luas Lingkaran adalah = "+luasLingkaran);
                            System.out.println("— tekan apa saja untuk ke menu utama –");
                            if(in.hasNext()){
                                main(null);
                            }
                        }else if(pilihan == 3){
                            System.out.println("— anda memilih segitiga –");
                            System.out.print("Masukkan Alas : ");
                            int alas = in.nextInt();
                            System.out.print("Masukkan Tinggi : ");
                            int tinggi = in.nextInt();
                            double luasSegitiga = luasBidang.hitungSegitiga(alas, tinggi);
                            System.out.println("Processing …");
                            System.out.println("Luas Segitiga adalah = "+luasSegitiga);
                            System.out.println("— tekan apa saja untuk ke menu utama –");
                            if(in.hasNext()){
                                main(null);
                            }
                        } else if (pilihan == 4) {
                            System.out.println("— anda memilih persegi panjang –");
                            System.out.print("Masukkan Panjang : ");
                            int panjang = in.nextInt();
                            System.out.print("Masukkan Tinggi : ");
                            int lebar = in.nextInt();
                            int luasPersegiPanjang = luasBidang.hitungPersegiPanjang(panjang, lebar);
                            System.out.println("Processing …");
                            System.out.println("Luas Persegi Panjang adalah = "+luasPersegiPanjang);
                            System.out.println("— tekan apa saja untuk ke menu utama –");
                            if(in.hasNext()){
                                main(null);
                            }
                        }
                    case 2 :
                        volum.menuVolum();
                        int input = in.nextInt();
                        if(input == 0){
                            main(null);
                        }else if(input == 1){
                            System.out.println("— anda memilih kubus –");
                            System.out.print("Masukkan Sisi : ");
                            int sisi = in.nextInt();
                            int luasPersegi = volum.hitungKubus(sisi);
                            System.out.println("Processing …");
                            System.out.println("Volum Kubus adalah = "+luasPersegi);
                            System.out.println("— tekan apa saja untuk ke menu utama –");
                            if(in.hasNext()){
                                main(null);
                            }
                        }else if(input == 2){
                            System.out.println("— anda memilih balok –");
                            System.out.print("Masukkan Panjang : ");
                            int panjang = in.nextInt();
                            System.out.print("Masukkan Lebar : ");
                            int lebar = in.nextInt();
                            System.out.print("Masukkan Tinggi : ");
                            int tinggi = in.nextInt();
                            int volumBalok = volum.hitungBalok(panjang, lebar, tinggi);
                            System.out.println("Processing …");
                            System.out.println("Volum Balok adalah = "+volumBalok);
                            System.out.println("— tekan apa saja untuk ke menu utama –");
                            if(in.hasNext()){
                                main(null);
                            }
                        }else if(input == 3){
                            System.out.println("— anda memilih tabung –");
                            System.out.print("Masukkan Tinggi : ");
                            double tinggi = in.nextDouble();
                            System.out.print("Masukkan Jari - Jari : ");
                            double jari2 = in.nextDouble();
                            double volumTabung = volum.hitungTabung(tinggi, jari2);
                            System.out.println("Processing …");
                            System.out.println("Volum Tabung adalah = "+volumTabung);
                            System.out.println("— tekan apa saja untuk ke menu utama –");
                            if(in.hasNext()){
                                main(null);
                            }
                        }
                    case 0:
                        in.close();
                }
            }catch (InputMismatchException ime){
                System.out.println("Masukkan pilihan menggunakan angka");
                main(null);
            }catch (NoSuchElementException ns){
                in.close();
            }
    }

    private static void initMenu(){
        System.out.println("— kalkulator penghitung –\nMenu");
        System.out.println("1. Hitung Luas Bidang\n2. Hitung Volum\n0. Exit");
    }


    private static void hitungVolum(){
        System.out.println();
    }
}