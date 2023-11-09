import java.util.Scanner;

public class BarangKeluar {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String kondisiBarang, keterangan;

        System.out.print("Input kondisi barang: ");
        kondisiBarang = sc.nextLine();

        switch (kondisiBarang.toLowerCase()) {
            case "hilang":
                keterangan = "tanggung jawab pegawai";
                break;
            case "rusak":
            case "kedaluwarsa":
                keterangan = "tanggung jawab perusahaan ";
                break;
            default:
                keterangan = "kondisi invalid";
        }
        System.out.println("barang" + " " + kondisiBarang + " " + "termasuk" + " " + keterangan);

    }
}
