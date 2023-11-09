import java.util.Scanner;

public class WhileBarangKeluar {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int jumlahBarang, barangKeluar, jumlahBarangMinim;

        System.out.print("Masukkan jumlah barang: ");
        jumlahBarang = sc.nextInt();
        System.out.print("Masukkan jumlah barang minimum: ");
        jumlahBarangMinim = sc.nextInt();
        System.out.println("");

        int i = 0;
        while (true) {
            System.out.print("Masukkan jumlah barang keluar hari ke-" + (i+1) + ": ");
            barangKeluar = sc.nextInt();

            i++;
            
            jumlahBarang -= barangKeluar;
            System.out.println("sisa barang saat ini: " + jumlahBarang);
            
            if (jumlahBarang == jumlahBarangMinim) {
                System.out.println("Jumlah barang sudah mencapai batas minimum");
                break;                
            } else if (jumlahBarang < jumlahBarangMinim) {
                System.out.println("Jumlah barang sudah melewati batas minimum");
                break;
            }
        }
    }
}