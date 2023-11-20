import java.util.Scanner;

public class Gudang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int stok, barangmasuk, barangkeluar, lakukan, total;
        String login, username, password, namabarang, kode, next;

        String[][] barang = new String[7][4];

        barang[0][0] = "Kode Barang";
        barang[0][1] = "Nama Barang";
        barang[0][2] = "Quantity";
        barang[0][3] = "Lokasi";

        barang[1][0] = "645748";
        barang[1][1] = "Beras";
        barang[1][2] = "50";
        barang[1][3] = "Rak 1";

        barang[2][0] = "694736";
        barang[2][1] = "Mie Instan";
        barang[2][2] = "65";
        barang[2][3] = "Rak 2";

        barang[3][0] = "698364";
        barang[3][1] = "Snack";
        barang[3][2] = "25";
        barang[3][3] = "Rak 3";

        barang[4][0] = "678342";
        barang[4][1] = "Roti";
        barang[4][2] = "100";
        barang[4][3] = "Rak 4";

        System.out.println("====== Login ======");
        System.out.print("Username : ");
        username = sc.nextLine();
        System.out.print("Password : ");
        password = sc.nextLine();

        while (true) {
            if (username.equalsIgnoreCase("Manager")) {
                System.out.println("==================== Manager ===================");
                System.out.println("1. Data Barang");
                System.out.println("2. Input Barang Masuk");
                System.out.println("3. Input Barang Keluar");
                System.out.println("4. Input Barang Rusak");
                System.out.println("5. Rekap Barang Banyak Terjual");
                System.out.println("6. Rekap Barang Habis");
                System.out.println("7. Update Data Barang");
                System.out.println("================================================");
            } else {
                System.out.println("==================== Karyawan ===================");
                System.out.println("1. Data Barang");
                System.out.println("2. Input Barang Masuk");
                System.out.println("3. Input Barang Keluar");
                System.out.println("4. Input Barang Rusak");
                System.out.println("5. Rekap Barang Banyak Terjual");
                System.out.println("6. Rekap Barang Habis");
                System.out.println("================================================");
            }
            System.out.print("Lakukan : ");
            lakukan = sc.nextInt();

            if (lakukan == 1) {
                //Menampilkan nilai array
                System.out.printf("%-15s %-15s %-15s %-15s\n", barang[0][0], barang[0][1], barang[0][2], barang[0][3]);

                for (int i = 1; i < barang.length; i++) {
                    System.out.printf("%-15s %-15s %-15s %-15s\n", barang[i][0], barang[i][1], barang[i][2], barang[i][3]);
                }
                System.out.println("=================================================");

            } else if (lakukan == 2) {
                //Mengisi nilai array
                int i = 1;
                while (true) {
                    System.out.print("Kode Barang : ");
                    String kodeBaru = sc.next();
                    barang[4+i][0] = kodeBaru;
                    System.out.print("Nama Barang : ");
                    String namaBaru = sc.next();
                    barang[4+i][1] = namaBaru;
                    System.out.print("Quantity : ");
                    String quantityBaru = sc.next();
                    barang[4+i][2] = quantityBaru;
                    System.out.print("Lokasi : ");
                    String lokasiBaru = sc.next();
                    barang[4+i][3] = lokasiBaru;
                    sc.nextLine();

                    i++;

                    System.out.print("Input barang masuk lagi?? (y/n): ");
                    next = sc.next();

                    if (next.equalsIgnoreCase("n")) {
                        break;
                    }
                }
            }

            System.out.print("Lanjut ke menu lain? (y/n): ");
            next = sc.nextLine();

            if (next.equalsIgnoreCase("n")) {
                break;
            }
            sc.nextLine();
            System.out.println();
        }
    }
}