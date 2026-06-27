package bagian2.bacatulis;

import java.io.*;

public class LatihanMandiri2 {

    public static void main(String[] args) {

        File file = new File("hari.txt");
        int jumlahBaris = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String data;

            while ((data = br.readLine()) != null) {
                jumlahBaris++;
            }

            br.close();

            System.out.println("Jumlah baris pada file hari.txt = " + jumlahBaris);

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan : " + e.getMessage());
        }
    }
}