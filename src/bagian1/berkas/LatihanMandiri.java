package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class LatihanMandiri {
    public static void main(String[] args) {

        File berkas = new File("sementara.txt");

        try {
            if (berkas.createNewFile()) {
                System.out.println("File berhasil dibuat.");
            } else {
                System.out.println("File sudah ada.");
            }

            System.out.println("Sebelum dihapus : " + berkas.exists());

            if (berkas.delete()) {
                System.out.println("File berhasil dihapus.");
            } else {
                System.out.println("File gagal dihapus.");
            }

            System.out.println("Sesudah dihapus : " + berkas.exists());

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}