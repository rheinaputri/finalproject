import java.util.Scanner;

public class ProjectGudang {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int stok, barangMasuk, barangKeluar, total, total1, total2;
        stok = 500;

        System.out.println("Jumlah stok barang: " + stok);

        System.out.print("Masukkan jumlah barang yang baru masuk: ");
        barangMasuk = sc.nextInt();
        total1 = stok + barangMasuk;
        System.out.println("Total: " + total1);

        System.out.print("Masukkan jumlah barang yang baru keluar: ");
        barangKeluar = sc.nextInt();
        total2 = total1 - barangKeluar;
        System.out.println("Total: " + total2);

    }

}
