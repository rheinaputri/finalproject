import java.util.Scanner;

public class Gudang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int stok, barangmasuk, barangkeluar, lakukan, total, opsi;
        String login, username, password, namabarang, kode, next;

        String[][] barang = new String[7][4];
        int[][] jumlah = new int[7][1];

        // barang[0][0] = "Kode Barang";
        // barang[0][1] = "Nama Barang";
        // barang[0][2] = "Lokasi";
        // barang[0][3] = "jumlah";

        barang[0][0] = "666222";
        barang[0][1] = "Beras";
        barang[0][2] = "Rak 1";
        jumlah[0][0] = 50;

        barang[1][0] = "666333";
        barang[1][1] = "Mie Instan";
        barang[1][2] = "Rak 2";
        jumlah[1][0] = 65;

        barang[2][0] = "666444";
        barang[2][1] = "Snack";
        barang[2][2] = "Rak 3";
        jumlah[2][0] = 25;

        barang[3][0] = "666555";
        barang[3][1] = "Roti";
        barang[3][2] = "Rak 4";
        jumlah[3][0] = 100;

        System.out.println("================ Login ================");
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
            System.out.print("Lakukan \t: ");
            lakukan = sc.nextInt();
            // dataBarang
            if (lakukan == 1) {
                System.out.println(" ");
                printHeader();
                for (int i = 0; i < barang.length; i++) {
                    System.out.printf("%-15s %-15s %-15s %s\n", barang[i][0], barang[i][1], barang[i][2], jumlah[i][0]);
                }
                System.out.println("=================================================");
                // barangMasuk
            } else if (lakukan == 2) {
                System.out.println("1. Barang baru");
                System.out.println("2. Barang yang sudah ada");
                System.out.print("Pilih opsi: ");
                opsi = sc.nextInt();
                if (opsi == 1) {                   
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

                                System.out.print("\nInput barang masuk lagi? (y/n): ");
                                next = sc.next();
                                if (next.equalsIgnoreCase("n")) {
                                    break;
                                }
                            }
                        }
                    }
                } else if (opsi == 2) {
                    // int i = 0;
                    while (true) {
                        System.out.print("Tanggal \t: ");
                        String tanggalMasuk = sc.next();
                        System.out.print("Kode Barang \t: ");
                        String kodeBarangMasuk = sc.next();
                        String namaBarangMasuk = ""; // Menyesuaikan nilai pada array data barang
                        int indexBarangMasuk = -1;
                        for (int i = 0; i < barang.length; i++) {
                            if (barang[i][0].equals(kodeBarangMasuk)) {
                                namaBarangMasuk = barang[i][1];
                                indexBarangMasuk = i;
                                break;
                            }
                        }
                        System.out.println("Nama Barang \t: " + namaBarangMasuk);
                        String lokasiMasuk = ""; // Menyesuaikan nilai pada array data barang
                        for (int i = 0; i < barang.length; i++) {
                            if (barang[i][0].equals(kodeBarangMasuk)) {
                                lokasiMasuk = barang[i][2];
                                indexBarangMasuk = i;
                                break;
                            }
                        }
                        if (indexBarangMasuk != -1) {
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
                            System.out.println("Barang tidak ditemukan.");
                        }

                        // i++;

                        System.out.println();
                        System.out.print("\nInput barang masuk lagi? (y/n): ");
                        next = sc.nextLine();

                        if (next.equalsIgnoreCase("n")) {
                            break;
                        }
                    }
                }
                // barangkeluar
            } else if (lakukan == 3) {
                // int i = 1;
                while (true) {
                    System.out.print("Tanggal \t: ");
                    String tanggalKeluar = sc.next();
                    System.out.print("Kode Barang \t: ");
                    String kodeBarangKeluar = sc.next();
                    String namaBarangKeluar = ""; // Menyesuaikan nilai pada array data barang
                    int indexBarangKeluar = -1;
                    for (int i = 1; i < barang.length; i++) {
                        if (barang[i][0].equals(kodeBarangKeluar)) {
                            namaBarangKeluar = barang[i][1];
                            indexBarangKeluar = i;
                            break;

                        }
                    }
                    System.out.println("Nama Barang \t: " + namaBarangKeluar);
                    String lokasiKeluar = ""; // Menyesuaikan nilai pada array data barang
                    for (int i = 1; i < barang.length; i++) {
                        if (barang[i][0].equals(kodeBarangKeluar)) {
                            lokasiKeluar = barang[i][2];
                            indexBarangKeluar = i;
                            break;

                        }
                    }
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
                        System.out.println("Barang tidak ditemukan.");
                    }

                    // i++;

                    System.out.println();
                    System.out.print("\nInput barang keluar lagi? (y/n): ");
                    next = sc.nextLine();

                    if (next.equalsIgnoreCase("n")) {
                        break;
                    }
                }
            } else if (lakukan == 7) {
                // Update Data Barang
                System.out.print("\n=================== Update Data Barang ===================");
                while (true) {
                    System.out.print("\nMasukkan kode barang: ");
                    kode = sc.next();
                    int kodeUpdate = -1;

                    for (int i = 1; i < barang.length; i++) {
                        if (barang[i][0].equals(kode)) {
                            kodeUpdate = i;
                            break;
                        }
                    }

                    if (kodeUpdate != -1) {
                        // Tampilkan data barang yang ditemukan
                        System.out.println("\nData barang yang ditemukan:");
                        printHeader();
                        System.out.printf("%-15s %-15s %-15s %-15s\n", barang[kodeUpdate][0], barang[kodeUpdate][1],
                                barang[kodeUpdate][2], jumlah[kodeUpdate][0]);
                        System.out.println(" "); 

                        // Masukkan data baru
                        System.out.println("Nama atau lokasi baru");
                        System.out.print("\nNama Barang : ");
                        sc.nextLine();
                        namabarang = sc.nextLine();
                        System.out.print("Lokasi Baru : ");
                        String lokasi = sc.nextLine();
                        // sc.nextLine();

                        // Update data barang
                        barang[kodeUpdate][1] = namabarang;
                        // barang[kodeUpdate][2] = quantity;
                        barang[kodeUpdate][2] = lokasi;

                        // Tampilkan data barang yang sudah diupdate
                        System.out.println("\nData barang berhasil diupdate!");
                        printHeader();
                        System.out.printf("%-15s %-15s %-15s %-15s", barang[kodeUpdate][0], barang[kodeUpdate][1],
                                barang[kodeUpdate][2], jumlah[kodeUpdate][0]);
                    } else {
                        System.out.println("Barang dengan kode " + kodeUpdate + " tidak ditemukan");
                    }

                    System.out.println();
                    System.out.print("\nInput update data barang lagi? (y/n): ");
                    next = sc.nextLine();

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
        System.out.printf("%-15s %-15s %-15s %-15s\n", "Kode Barang", "Nama Barang", "Lokasi", "jumlah");
    }
    
}