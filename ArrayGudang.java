import java.util.Scanner;

public class ArrayGudang {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int deret = -1;
        String cari, snack[] = {"Oreo", "Tango", "Regal", "Twister", "Nextar"};

        System.out.println("");

        System.out.println("Data Barang Rak Snack: ");
        for (String i : snack) {
            System.out.println(i);
        }
        System.out.println("");
        
        System.out.print("Masukkan barang yang ingin dicari: ");
        cari = sc.nextLine();

        for (int i = 0; i < snack.length; i++) {
            if (snack[i].equalsIgnoreCase(cari)) {
                deret = i;
                System.out.println("Barang ada di deret ke-" + (deret + 1));
                System.out.println("");                
            }
        }

        if (deret == -1) {
            System.out.println("Barang tidak ditemukan");
            System.out.println("");
        }
    }
}