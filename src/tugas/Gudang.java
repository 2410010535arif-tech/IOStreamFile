package tugas;

import java.io.*;
import java.util.ArrayList;

public class Gudang {

    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private String namaFile;

    public Gudang(String namaFile) {
        this.namaFile = namaFile;
    }

    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    public void tampilkanSemua() {

        System.out.println("===== DAFTAR BARANG =====");

        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada data barang.");
            return;
        }

        int no = 1;

        for (Barang b : daftarBarang) {
            System.out.println(no + ".");
            System.out.println(b.info());
            System.out.println("------------------------");
            no++;
        }
    }

    public void simpanKeBerkas() {

        try (BufferedWriter bw =
                     new BufferedWriter(new FileWriter(namaFile))) {

            for (Barang b : daftarBarang) {
                bw.write(b.keBaris());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Gagal menyimpan data.");
        }
    }

    public void muatDariBerkas() {

        daftarBarang.clear();

        try (BufferedReader br =
                     new BufferedReader(new FileReader(namaFile))) {

            String data;

            while ((data = br.readLine()) != null) {

                String[] pecah = data.split(";");

                if (pecah.length == 3) {

                    String nama = pecah[0];
                    double harga = Double.parseDouble(pecah[1]);
                    int stok = Integer.parseInt(pecah[2]);

                    daftarBarang.add(
                            new Barang(nama, harga, stok));
                }
            }

        } catch (IOException e) {
            System.out.println("File tidak ditemukan.");
        }
    }

    public double totalNilai() {

        double total = 0;

        for (Barang b : daftarBarang) {
            total += b.getHarga() * b.getStok();
        }

        return total;
    }
}