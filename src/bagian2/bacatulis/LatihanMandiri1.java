package bagian2.bacatulis;

import java.io.*;

public class LatihanMandiri1 {

    public static void main(String[] args) {

        try {
           
            FileWriter fw = new FileWriter("hari.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Senin");
            bw.newLine();
            bw.write("Selasa");
            bw.newLine();
            bw.write("Rabu");
            bw.newLine();
            bw.write("Kamis");
            bw.newLine();
            bw.write("Jumat");

            bw.close();

            System.out.println("Isi awal file:");
            tampilkanIsi();

          
            FileWriter tambah = new FileWriter("hari.txt", true);
            BufferedWriter bwTambah = new BufferedWriter(tambah);

            bwTambah.newLine();
            bwTambah.write("Sabtu");
            bwTambah.newLine();
            bwTambah.write("Minggu");

            bwTambah.close();

            System.out.println("\nIsi file setelah ditambah:");
            tampilkanIsi();

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan : " + e.getMessage());
        }
    }

    public static void tampilkanIsi() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hari.txt"));
        String data;

        while ((data = br.readLine()) != null) {
            System.out.println(data);
        }

        br.close();
    }
}