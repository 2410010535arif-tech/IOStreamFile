package bagian3.kontak;

public class MainKontak {

    public static void main(String[] args) {

        BukuKontak buku = new BukuKontak("kontak.txt");

        buku.tambahKontak(
                new Kontak(
                        "Andi",
                        "0811111",
                        "andi@gmail.com"));

        buku.tambahKontak(
                new Kontak(
                        "Budi",
                        "0822222",
                        "budi@gmail.com"));

        buku.tambahKontak(
                new Kontak(
                        "Citra",
                        "0833333",
                        "citra@gmail.com"));

        buku.simpanKeBerkas();

        buku.cariKontak("Budi");

        buku.hapusKontak("Andi");

        BukuKontak bukuBaru =
                new BukuKontak("kontak.txt");

        bukuBaru.muatDariBerkas();
        bukuBaru.tampilkanSemua();

        System.out.println(
                "Jumlah kontak : "
                        + bukuBaru.jumlahKontak());
    }
}