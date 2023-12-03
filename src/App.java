import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Input data pelanggan
            System.out.print("Nama Pelanggan : ");
            String namaPelanggan = scanner.nextLine();
            System.out.print("No. HP         : ");
            String noHP = scanner.nextLine();
            System.out.print("Alamat         : ");
            String alamat = scanner.nextLine();

            Pelanggan pelanggan = new Pelanggan(namaPelanggan, noHP, alamat);

            // Input data pembelian barang
            System.out.print("Kode Barang (111/112/113/114): ");
            String kodeBarang = scanner.nextLine();
            System.out.print("Jumlah Beli    : ");
            int jumlahBeli = scanner.nextInt();

            Barang barang = null;
            switch (kodeBarang) {
                case "111":
                    barang = new Produk("111", "Baju", 50000);
                    break;
                case "112":
                    barang = new Produk("112", "Celana", 30000);
                    break;
                case "113":
                    barang = new Produk("113", "Dress", 80000);
                    break;
                case "114":
                    barang = new Produk("114", "Aksesoris", 15000);
                    break;
                default:
                    throw new IllegalArgumentException("Kode barang tidak valid");
            }

            // Hitung total bayar
            double totalBayar = barang.getHarga() * jumlahBeli;

            // Tampilkan hasil
            tampilkanStruk(pelanggan, barang, jumlahBeli, totalBayar);

        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    private static void tampilkanStruk(Pelanggan pelanggan, Barang barang, int jumlahBeli, double totalBayar) {
        Date date = new Date();
        Date time = new Date();
        SimpleDateFormat fd = new SimpleDateFormat("hh:mm::ss");
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println(" ");
        System.out.println("RANIA CLOTHING");
        System.out.println("Tanggal        : " + fd.format(date));
        System.out.println("Waktu          : " + ft.format(time));
        System.out.println("========================");
        System.out.println("DATA PELANGGAN");
        System.out.println("--------------");
        System.out.println("Nama Pelanggan : " + pelanggan.getNama());
        System.out.println("No. HP         : " + pelanggan.getNoHP());
        System.out.println("Alamat         : " + pelanggan.getAlamat());
        System.out.println("++++++++++++++++++++++++");
        System.out.println("DATA PEMBELIAN BARANG");
        System.out.println("---------------------");
        System.out.println("Kode Barang    : " + barang.getKode());
        System.out.println("Nama Barang    : " + barang.getNama());
        System.out.println("Harga Barang   : " + barang.getHarga());
        System.out.println("Jumlah Beli    : " + jumlahBeli);
        System.out.println("TOTAL BAYAR    : " + totalBayar);
        System.out.println("++++++++++++++++++++++++");
        System.out.println("Kasir        : Rania Shofi Malika");
    }
}