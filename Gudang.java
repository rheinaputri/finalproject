import java.util.Scanner;

public class Gudang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int stok, barangmasuk, barangkeluar;
        int total;
        String login, username, password, lakukan, namabarang, kode, quantity, lokasi, next;

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

        System.out.printf("%-15s %-15s %-15s %-15s\n", barang[0][0], barang[0][1], barang[0][2], barang[0][3]);

        for (int i = 1; i < barang.length; i++) {
            System.out.printf("%-15s %-15s %-15s %-15s\n", barang[i][0], barang[i][1], barang[i][2], barang[i][3]);
        }
        System.out.println("=================================================");

        System.out.print("Username : ");
        username = sc.nextLine();

        System.out.print("Password : ");
        password = sc.nextLine();

        while (true) {
            if (username.equalsIgnoreCase("Manager")) {
                System.out.println("==================== Manager ===================");
                System.out.println("- Input Barang Masuk");
                System.out.println("- Input Barang Keluar");
                System.out.println("- Input Barang Rusak");
                System.out.println("- Update Data Barang");
                System.out.println("- Rekap barang banyak terjual");
                System.out.println("- Rekap barang habis");
                System.out.println("- Data Barang");
                System.out.println("================================================");
            } else {
                System.out.println("==================== Karyawan ===================");
                System.out.println("- Input Barang Masuk");
                System.out.println("- Input Barang Keluar");
                System.out.println("- Input Barang Rusak");
                System.out.println("- Rekap barang banyak terjual");
                System.out.println("- Rekap barang habis");
                System.out.println("- Data Barang");
                System.out.println("================================================");
            }
            System.out.print("Lakukan : ");
            lakukan = sc.nextLine();

//barang masuk
            if (lakukan.equalsIgnoreCase("Input Barang Masuk")) {
                //Mengisi nilai array data barang keluar
                System.out.print("Tanggal : ");
                String tanggal = sc.nextLine();
                System.out.print("Kode Barang : ");
                String kodeBaru = sc.nextLine();
                barang[5][0] = kodeBaru;
                System.out.print("Nama Barang : ");
                String namaBaru = sc.nextLine();
                barang[5][1] = namaBaru;
                System.out.print("Quantity : ");
                String quantityBaru = sc.nextLine();
                barang[5][2] = quantityBaru;
                System.out.print("Lokasi : ");
                String lokasiBaru = sc.nextLine();

//barang keluar
            } else if (lakukan.equalsIgnoreCase("input barang keluar")) {
                System.out.print("Tanggal : ");
                String tanggalKeluar = sc.nextLine();
                System.out.print("Kode Barang : ");
                String kodeBarangKeluar = sc.nextLine();
                System.out.print("Nama Barang  : ");
                String namaBarangKeluar = sc.nextLine();
                System.out.print("Quantity : ");
                String quantityKeluar = sc.nextLine();
                System.out.print("Lokasi di ");
                String lokasiKeluar = "";  // Menyesuaikan nilai pada array data barang
                for (int i = 1; i < barang.length; i++) {
                    if (barang[i][0].equals(kodeBarangKeluar)) {
                        lokasiKeluar = barang[i][3];
                        break;
                    }
                }

                // Menampilkan data barang keluar
                System.out.println("Tanggal : " + tanggalKeluar);
                System.out.println("Kode Barang : " + kodeBarangKeluar);
                System.out.println("Nama Barang : " + namaBarangKeluar);
                System.out.println("Quantity : " + quantityKeluar);
                System.out.println("Lokasi di " + lokasiKeluar);


//data barang
            } else if (lakukan.equalsIgnoreCase("data barang")) {
                //Menampilkan nilai array
                System.out.printf("%-15s %-15s %-15s %-15s\n", barang[0][0], barang[0][1], barang[0][2], barang[0][3]);

                for (int i = 1; i < barang.length; i++) {
                    System.out.printf("%-15s %-15s %-15s %-15s\n", barang[i][0], barang[i][1], barang[i][2], barang[i][3]);
                }
                System.out.println("=================================================");
                }
                
            

            System.out.print("Lanjut ke menu lain? (y/n): ");
            next = sc.next();

            if (next.equalsIgnoreCase("n")) {
                break;
            }
            sc.nextLine();
            System.out.println();

//Update data barang
            System.out.print("Masukkan kode barang: ");
            kode = sc.nextLine();
            int kodeUpdate = -1;
            
            for (int i =1; i <barang.length; i++) {
                if (barang[i][0].equals(kode)) {
                    kodeUpdate = i;
                    break;
                }
            }
            if (kodeUpdate != -1) {
                System.out.println("\nData barang yang ditemukan: ");
                System.out.printf("%-15s %-15s %-15s %-15s\n", barang[kodeUpdate][0], barang[kodeUpdate][1], barang[kodeUpdate][2], barang[kodeUpdate][3]);

                System.out.print("\nNama barang: ");
                namabarang =sc.nextLine();
                System.out.print("Quantity: ");
                quantity = sc.nextLine();
                System.out.print("Lokasi baru: ");
                lokasi = sc.nextLine();

                barang[kodeUpdate][1] = namabarang;
                barang[kodeUpdate][2] = quantity;
                barang[kodeUpdate][3] = lokasi;

                System.out.println("\nData barang berhasil diperbarui!");
                System.out.printf("%-15s %-15s %-15s %-15s\n", barang[kodeUpdate][0], barang[kodeUpdate][1], barang[kodeUpdate][2], barang[kodeUpdate][3]);
            } else {
                System.out.println("Barang dengan kode " + kodeUpdate + " tidak ditemukan.");
            }
        }
    }
}