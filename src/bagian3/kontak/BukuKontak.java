package bagian3.kontak;

import java.io.*;
import java.util.ArrayList;

public class BukuKontak {

    private ArrayList<Kontak> daftar = new ArrayList<>();
    private String namaBerkas;

    public BukuKontak(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    public void tambahKontak(Kontak kontak) {
        daftar.add(kontak);
    }

    public void tampilkanSemua() {

        System.out.println("== Daftar Kontak ==");

        for (int i = 0; i < daftar.size(); i++) {
            System.out.println((i + 1) + ". "
                    + daftar.get(i).info());
        }
    }

    public void simpanKeBerkas() {

        try (PrintWriter penulis =
                     new PrintWriter(new FileWriter(namaBerkas))) {

            for (Kontak k : daftar) {
                penulis.println(k.keBaris());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void muatDariBerkas() {

        daftar.clear();

        try (BufferedReader pembaca =
                     new BufferedReader(new FileReader(namaBerkas))) {

            String baris;

            while ((baris = pembaca.readLine()) != null) {

                String[] bagian = baris.split(";");

                if (bagian.length == 3) {
                    daftar.add(
                            new Kontak(
                                    bagian[0],
                                    bagian[1],
                                    bagian[2]
                            )
                    );
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cariKontak(String nama) {

        for (Kontak k : daftar) {
            if (k.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Ditemukan : " + k.info());
                return;
            }
        }

        System.out.println("Kontak tidak ditemukan");
    }

    public void hapusKontak(String nama) {

        for (int i = 0; i < daftar.size(); i++) {

            if (daftar.get(i).getNama().equalsIgnoreCase(nama)) {

                daftar.remove(i);
                simpanKeBerkas();

                System.out.println("Kontak berhasil dihapus");
                return;
            }
        }

        System.out.println("Kontak tidak ditemukan");
    }

    public int jumlahKontak() {
        return daftar.size();
    }
}