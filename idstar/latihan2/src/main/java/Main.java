package main.java;

import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String dir = System.getProperty("user.dir");
        try {
            menuFileCSV();
            int input = in.nextInt();

            switch (input){
                case 0:
//                    in.close();
                    break;
                case 1:
                    generateKaryawan(dir);
                    if(in.nextInt() == 0){
                        main(null);
                    }
                    break;
                case 2:
                    generateTraining(dir);
                    if(in.nextInt() == 0){
                        main(null);
                    }
                    break;
                case 3:
                    generateKaryawan(dir);
                    generateTraining(dir);
                    if(in.nextInt() == 0){
                        main(null);
                    }
                    break;
            }
        } catch (FileNotFoundException e){
            System.out.println("— File tidak ditemukan di " + e.getMessage() +
                    "\n0. kembali ke menu utama");
            main(null);
        } catch (IOException ie){
            System.out.println("Error " + ie.getMessage());
        } catch (InputMismatchException ime){
            System.out.println("Masukkan pilihan menggunakan angka");
            main(null);
        }catch (NoSuchElementException ns){
            in.close();
        }
    }


    private static void generateKaryawan(String dir) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(dir.concat("\\karyawan.csv")));
        FileOutputStream fos = new FileOutputStream(dir.concat("\\karyawan.txt"));
        BufferedOutputStream bo = new BufferedOutputStream(fos);
        String text = "";
        while ((text = br.readLine()) != null){
            bo.write(text.concat("\n").getBytes());
        }
        br.close();
        bo.close();
        fos.close();
        System.out.println("— File berhasil di generate direktori "+ dir.concat("\\karyawan.txt"));
        System.out.println("0. kembali ke menu utama");
    }

    private static void generateTraining(String dir) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(dir.concat("\\training.csv")));
        FileOutputStream fos = new FileOutputStream(dir.concat("\\training.txt"));
        BufferedOutputStream bo = new BufferedOutputStream(fos);
        String text = "";
        while ((text = br.readLine()) != null){
            bo.write(text.concat("\n").getBytes());
        }
        br.close();
        bo.close();
        fos.close();
        System.out.println("— File berhasil di generate direktori "+ dir.concat("\\training.txt"));
        System.out.println("0. kembali ke menu utama");
    }

    private static void  menuFileCSV(){
        System.out.println("menu mencetak file csv menjadi txt\n" +
                "1. generate file txt dari data karyawan\n" +
                "2. generate file txt dari data training\n" +
                "3. generate file txt dari keduanya\n" +
                "0. exit");
    }
}