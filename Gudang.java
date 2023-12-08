import java.util.Scanner;

public class Gudang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int stok, barangmasuk, barangkeluar, menu, total, opsi;
        String login, username, password, namabarang, next;

        String[][] barang = new String[7][4];
        int[][] jumlah = new int[7][1];
        String[][] keterangan = new String[7][1];

        barang[0][0] = "666222";
        barang[0][1] = "Beras";
        barang[0][2] = "Rak 1";
        jumlah[0][0] = 50;
        keterangan[0][0] = "";
        

        barang[1][0] = "666333";
        barang[1][1] = "Mie Instan";
        barang[1][2] = "Rak 2";
        jumlah[1][0] = 65;
        keterangan[0][0] = "";

        barang[2][0] = "666444";
        barang[2][1] = "Snack";
        barang[2][2] = "Rak 3";
        jumlah[2][0] = 25;
        keterangan[0][0] = "";

        barang[3][0] = "666555";
        barang[3][1] = "Roti";
        barang[3][2] = "Rak 4";
        jumlah[3][0] = 100;
        keterangan[0][0] = "";

        System.out.println("================ Login ================");
        System.out.print("Username : ");
        username = sc.nextLine();
        System.out.print("Password : ");
        password = sc.nextLine();

        while (true) {
            if (username.equalsIgnoreCase("Manager")) {
                System.out.println("==================== Manager ===================");
                System.out.println("1. Data Barang");
                System.out.println("2. Input Barang Baru");
                System.out.println("3. Input Barang Masuk");
                System.out.println("4. Input Barang Keluar");
                System.out.println("5. Input Barang Rusak");
                System.out.println("6. Rekap Barang Banyak Terjual");
                System.out.println("7. Rekap Barang Habis");
                System.out.println("8. Update Data Barang");
                System.out.println("================================================");
            } else {
                System.out.println("==================== Karyawan ===================");
                System.out.println("1. Data Barang");
                System.out.println("2. Input Barang Baru");
                System.out.println("3. Input Barang Masuk");
                System.out.println("4. Input Barang Keluar");
                System.out.println("5. Input Barang Rusak");
                System.out.println("6. Rekap Barang Banyak Terjual");
                System.out.println("7. Rekap Barang Habis");
                System.out.println("================================================");
            }
            System.out.print("Pilih menu \t: ");
            menu = sc.nextInt();
            // dataBarang
            if (menu == 1) {
                System.out.println(" ");
                printHeader();
                for (int i = 0; i < barang.length; i++) {
                    if(barang[i][0] != null) {
                        System.out.printf("%-15s %-15s %-15s %s\n", barang[i][0], barang[i][1], barang[i][2], jumlah[i][0]);
                    }
                }
                System.out.println("=================================================");
                // barangMasuk
            } else if (menu == 2) {
                for (int i = 0; i < barang.length; i++) {

                    if (barang[i][0] == null) {
                        System.out.print("Kode Barang \t: ");
                        String kodeBaru = sc.next();
                        sc.nextLine();
                        barang[i][0] = kodeBaru;
                    }

                    if (barang[i][1] == null) {
                        System.out.print("Nama Barang \t: ");
                        String namaBaru = sc.nextLine();
                        barang[i][1] = namaBaru;
                    }

                    if (barang[i][2] == null) {
                        System.out.print("Lokasi Barang \t: ");
                        String lokasiBaru = sc.nextLine();
                        barang[i][2] = lokasiBaru;

                        if (jumlah[i][0] == 0) {
                            System.out.print("Jumlah barang \t: ");
                            int jumlahBaru = sc.nextInt();
                            jumlah[i][0] = jumlahBaru;

                            System.out.println(" ");
                            printHeader();
                            System.out.printf("%-15s %-15s %-15s %-15s", barang[i][0],
                                    barang[i][1], barang[i][2],
                                    jumlah[i][0]);

                            System.out.print("\nInput barang baru lagi? (y/n): ");
                            next = sc.next();
                            if (next.equalsIgnoreCase("n")) {
                                break;
                            }
                        }
                    }
                }
            } else if (menu == 3) {
                while (true) {
                    System.out.print("Tanggal \t: ");
                    String tanggalMasuk = sc.next();
                    System.out.print("Kode Barang \t: ");
                    int kodeBarangMasuk = sc.nextInt();
                    String namaBarangMasuk = ""; // Menyesuaikan nilai pada array data barang
                    int indexBarangMasuk = -1;
            
                    // Check if the specified kodeBarangMasuk exists in the barang array
                    for (int i = 0; i < barang.length; i++) {
                        if (barang[i][0] != null && barang[i][0].equals(kodeBarangMasuk)) {
                            namaBarangMasuk = barang[i][1];
                            indexBarangMasuk = i;
                            break;
                        }
                    }
            
                    if (indexBarangMasuk != -1) {
                        System.out.println("Nama Barang \t: " + namaBarangMasuk);
                        System.out.print("Jumlah Masuk \t: ");
                        int jumlahMasuk = sc.nextInt();
                        jumlah[indexBarangMasuk][0] += jumlahMasuk;
                        sc.nextLine();
                        System.out.println(" ");
                        printHeader();
                        System.out.printf("%-15s %-15s %-15s %-15s", barang[indexBarangMasuk][0],
                                barang[indexBarangMasuk][1], barang[indexBarangMasuk][2],
                                jumlah[indexBarangMasuk][0]);
                    } else {
                        // Display message if barang is not found
                        System.out.println();
                        System.out.println("Barang tidak ditemukan.");
                    }
            
                    System.out.print("\nInput barang masuk lagi? (y/n): ");
                    next = sc.next();
            
                    if (next.equalsIgnoreCase("n")) {
                        break;
                    }
                }
            } else if (menu == 4) {
                // int i = 1;
                while (true) {
                    System.out.print("Tanggal \t: ");
                    String tanggalKeluar = sc.next();
                    System.out.print("Kode Barang \t: ");
                    String kodeBarangKeluar = sc.next();
                    String namaBarangKeluar = "";
                    int indexBarangKeluar = -1;
                    for (int i = 0; i < barang.length; i++) {
                        if (barang[i][0] != null && barang[i][0].equals(kodeBarangKeluar)) {
                            namaBarangKeluar = barang[i][1];
                            indexBarangKeluar = i;
                            break;
                        }
                    }
                    System.out.println("Nama Barang \t: " + namaBarangKeluar);

                    if (indexBarangKeluar != -1) {
                        System.out.print("Jumlah Keluar\t: ");
                        int jumlahKeluar = sc.nextInt();
                        jumlah[indexBarangKeluar][0] -= jumlahKeluar;
                        sc.nextLine();
                        System.out.println(" ");
                        printHeader();
                        System.out.printf("%-15s %-15s %-15s %-15s", barang[indexBarangKeluar][0],
                                barang[indexBarangKeluar][1], barang[indexBarangKeluar][2],
                                jumlah[indexBarangKeluar][0]);
                    } else {
                        System.out.println();
                        System.out.println("Barang tidak ditemukan.");
                    }

                    System.out.print("\nInput barang keluar lagi? (y/n): ");
                    next = sc.next();

                    if (next.equalsIgnoreCase("n")) {
                        break;
                    }
                }
            } else if (menu == 5){
                while (true) {
                    System.out.print("Kode Barang \t\t: ");
                    String kodeBarangRusak = sc.next();
                    String namaBarangRusak = ""; // Menyesuaikan nilai pada array data barang
                    int indexBarangRusak = -1;
                    for (int i = 0; i < barang.length; i++) {
                        if (barang[i][0].equals(kodeBarangRusak)) {
                            namaBarangRusak = barang[i][1];
                            indexBarangRusak = i;
                            break;

                        }
                    }
                        System.out.println("Nama Barang \t\t: " + namaBarangRusak);
                        String lokasiRusak = ""; // Menyesuaikan nilai pada array data barang
                        for (int i = 0; i < barang.length; i++) {
                            if (barang[i][0].equals(kodeBarangRusak)) {
                                lokasiRusak = barang[i][2];
                                indexBarangRusak = i;
                                break;

                            }
                    }
                
                    System.out.print("Keterangan \t\t: ");
                            String keteranganRusak = sc.next();
                                    keterangan[indexBarangRusak][0] = keteranganRusak;

                    if (indexBarangRusak != -1) {
                        System.out.print("Jumlah Barang Rusak \t: ");
                        int jumlahRusak = sc.nextInt();
                        jumlah[indexBarangRusak][0] -= jumlahRusak;
                        sc.nextLine();
                        System.out.println(" ");
                        // printHeader();
                        // System.out.println();
                        System.out.println("***************************** Input Barang Rusak *****************************");
                        System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", "Kode Barang", "Nama Barang", "Lokasi", "Jumlah Rusak", "Keterangan");
                        System.out.printf("%-15s %-15s %-15s %-15s %-15s", barang[indexBarangRusak][0],
                                barang[indexBarangRusak][1], barang[indexBarangRusak][2],
                                jumlah[indexBarangRusak][0], keterangan[indexBarangRusak][0]);
                    } else {
                        System.out.println("Barang tidak ditemukan.");
                    }

                        System.out.println();
                        System.out.print("\nInput barang rusak lagi? (y/n): ");
                        next = sc.nextLine();

                        if (next.equalsIgnoreCase("n")) {
                            break;
                            }
                }
            
            } else if (menu == 7) {
                System.out.println("Rekap Barang Habis:");
                System.out.println(" ");
                int indexBarangHabis = -1;
                boolean found = false;

                for (int i = 0; i < jumlah.length; i++) {
                    for (int j = 0; j < jumlah[i].length; j++) {
                        if (jumlah[i][0] == 0) {
                            indexBarangHabis = i;
                            if (indexBarangHabis != -1 && barang[indexBarangHabis][0] != null) {
                                found = true;
                                break;
                            }
                        }
                    }
                }

                if (found) {
                    System.out.printf("%-15s %-15s\n", "Kode Barang", "Nama Barang");
                }

                for (int i = 0; i < jumlah.length; i++) {
                    for (int j = 0; j < jumlah[i].length; j++) {
                        if (jumlah[i][0] == 0) {
                            indexBarangHabis = i;
                            if (indexBarangHabis != -1 && barang[indexBarangHabis][0] != null) {
                                System.out.printf("%-15s %-15s\n", barang[indexBarangHabis][0],
                                        barang[indexBarangHabis][1]);
                            }
                        }
                    }
                }

                if (!found) {
                    System.out.println("Tidak ada barang habis.");
                }

            } else if (menu == 8) {
                // Update Data Barang
                System.out.print("\n=================== Update Data Barang ===================");
                while (true) {
                    System.out.print("\nMasukkan kode barang: ");
                    String kodeUpdate = sc.next();
                    int indexUpdate = -1;

                    for (int i = 1; i < barang.length; i++) {
                        if (barang[i][0] != null && barang[i][0].equals(kodeUpdate)) {
                            indexUpdate = i;
                            break;
                        }
                    }

                    if (indexUpdate != -1) {
                        // Tampilkan data barang yang ditemukan
                        System.out.println("\nData barang yang ditemukan:");
                        printHeader();
                        System.out.printf("%-15s %-15s %-15s %-15s\n", barang[indexUpdate][0], barang[indexUpdate][1],
                                barang[indexUpdate][2], jumlah[indexUpdate][0]);
                        System.out.println(" ");

                        System.out.println("Nama atau lokasi baru");
                        System.out.print("\nNama Barang : ");
                        sc.nextLine();
                        namabarang = sc.nextLine();
                        System.out.print("Lokasi Baru : ");
                        String lokasi = sc.nextLine();

                        // Update data barang
                        barang[indexUpdate][1] = namabarang;
                        barang[indexUpdate][2] = lokasi;

                        // Tampilkan data barang yang sudah diupdate
                        System.out.println("\nData barang berhasil diupdate!");
                        printHeader();
                        System.out.printf("%-15s %-15s %-15s %-15s", barang[indexUpdate][0], barang[indexUpdate][1],
                                barang[indexUpdate][2], jumlah[indexUpdate][0]);
                    } else {
                        System.out.println();
                        System.out.println("Barang dengan kode " + indexUpdate + " tidak ditemukan");
                    }

                    System.out.print("\nInput update data barang lagi? (y/n): ");
                    next = sc.next();

                    if (next.equalsIgnoreCase("n")) {
                        break;
                    }
                }
            }

            System.out.print("\nLanjut ke menu lain? (y/n): ");
            next = sc.next();

            if (next.equalsIgnoreCase("n")) {
                System.out.println("***** SUCCESSFULLY *****");
                break;
            }
            System.out.println();
        }
    }

    static void printHeader() {
        System.out.printf("%-15s %-15s %-15s %-15s\n", "Kode Barang", "Nama Barang", "Lokasi", "Jumlah");
    }
}