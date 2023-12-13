import java.util.Scanner;

public class Gudang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int menu;
        String username, password, namabarang, next;

        String[][] barang = new String[7][4];
        int[][] jumlah = new int[7][1];
        String[][] keterangan = new String[7][1];
        int[][] nilaiRusak = new int[jumlah.length][jumlah[0].length];
        int[][] terjual = new int[7][1];

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

//login
        while (true) {
            System.out.println();
            System.out.println("========================== Login ==========================");
            System.out.print("Username : ");
            username = sc.nextLine();
            System.out.print("Password : ");
            password = sc.nextLine();

            while (true) {
                if (username.equalsIgnoreCase("manager") && password.equalsIgnoreCase("manager")) {
                    // System.out.println();
                    System.out.println("========================= Manager =========================");
                    System.out.println("1. Data Barang");
                    System.out.println("2. Input Barang Baru");
                    System.out.println("3. Input Barang Masuk");
                    System.out.println("4. Input Barang Keluar");
                    System.out.println("5. Input Barang Rusak");
                    System.out.println("6. Rekap Barang Rusak");
                    System.out.println("7. Rekap Barang Banyak Terjual");
                    System.out.println("8. Rekap Barang Habis");
                    System.out.println("9. Update Data Barang");
                    System.out.println("===========================================================");
                } else if (username.equalsIgnoreCase("karyawan") && password.equalsIgnoreCase("karyawan")) {
                    // System.out.println();
                    System.out.println("========================= Karyawan =========================");
                    System.out.println("1. Data Barang");
                    System.out.println("2. Input Barang Baru");
                    System.out.println("3. Input Barang Masuk");
                    System.out.println("4. Input Barang Keluar");
                    System.out.println("5. Input Barang Rusak");
                    System.out.println("6. Rekap Barang Rusak");
                    System.out.println("7. Rekap Barang Banyak Terjual");
                    System.out.println("8. Rekap Barang Habis");
                    System.out.println("===========================================================");
                } else {
                    System.out.println();
                    System.out.println("username atau password tidak sesuai");
                    System.out.println();
                    break;
                }
                System.out.print("Pilih menu \t: ");
                menu = sc.nextInt();
                
                if (menu == 1) { 
// dataBarang
                    System.out.println("======================= DATA BARANG =======================");
                    printHeader();
                    for (int i = 0; i < barang.length; i++) {
                        if(barang[i][0] != null) {
                            System.out.printf("| %-15s | %-15s | %-10s | %-6s |\n", barang[i][0], barang[i][1], barang[i][2], jumlah[i][0]);
                        }
                    }
                    System.out.println("===========================================================");

                } else if (menu == 2) { 
//input barang baru
                    System.out.println("======================= BARANG BARU =======================");
                    System.out.println();
                    for (int i = 0; i < barang.length; i++) {

                        if (barang[i][0] == null) {
                            System.out.print("Tanggal \t: ");
                            String tanggalMasuk = sc.next();
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
                                System.out.printf("| %-15s | %-15s | %-10s | %-6s |\n", barang[i][0],
                                        barang[i][1], barang[i][2],
                                        jumlah[i][0]);
                                System.out.println("===========================================================");

                                System.out.print("\nInput barang baru lagi? (y/n): ");
                                next = sc.next();
                                if (next.equalsIgnoreCase("n")) {
                                    break;
                                }
                            }
                        }
                    } 
                
                } else if (menu == 3) { 
//input barang masuk
                    while (true) {
                        System.out.print("Tanggal \t: ");
                        String tanggalMasuk = sc.next();
                        System.out.print("Kode Barang \t: ");
                        String kodeBarangMasuk = sc.next();
                        String namaBarangMasuk = ""; // Menyesuaikan nilai pada array data barang
                        int jumlahBarang = 0;
                        int indexBarangMasuk = -1;
                
                        for (int i = 0; i < barang.length; i++) {
                            if (barang[i][0] != null && barang[i][0].equals(kodeBarangMasuk)) {
                                namaBarangMasuk = barang[i][1];
                                jumlahBarang = jumlah[i][0];
                                indexBarangMasuk = i;
                                break;
                            }
                        }
                
                        if (indexBarangMasuk != -1) {
                            System.out.println("Nama Barang \t: " + namaBarangMasuk);
                            System.out.println("Jumlah Barang \t: " + jumlahBarang);
                            System.out.print("Jumlah Masuk \t: ");
                            int jumlahMasuk = sc.nextInt();
                            jumlah[indexBarangMasuk][0] += jumlahMasuk;
                            sc.nextLine();
                            System.out.println(" ");
                            printHeader();
                            System.out.printf("| %-15s | %-15s | %-10s | %-6s |\n", barang[indexBarangMasuk][0],
                                    barang[indexBarangMasuk][1], barang[indexBarangMasuk][2],
                                    jumlah[indexBarangMasuk][0]);
                            System.out.println("===========================================================");
                        } else {
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
//input barang keluar
                    while (true) {
                        System.out.print("Tanggal \t: ");
                        String tanggalKeluar = sc.next();
                        System.out.print("Kode Barang \t: ");
                        String kodeBarangKeluar = sc.next();
                        String namaBarangKeluar = "";
                        int jumlahBarang = 0;
                        int indexBarangKeluar = -1;
                        for (int i = 0; i < barang.length; i++) {
                            if (barang[i][0] != null && barang[i][0].equals(kodeBarangKeluar)) {
                                namaBarangKeluar = barang[i][1];
                                jumlahBarang = jumlah[i][0];
                                indexBarangKeluar = i;
                                break;
                            }
                        }
                        
                        if (indexBarangKeluar != -1) {
                            System.out.println("Nama Barang \t: " + namaBarangKeluar);
                            System.out.println("Jumlah Barang \t: " + jumlahBarang);
                            System.out.print("Jumlah Keluar\t: ");
                            int jumlahKeluar = sc.nextInt();
                            jumlah[indexBarangKeluar][0] -= jumlahKeluar;
                            terjual[indexBarangKeluar][0] += jumlahKeluar;
                            sc.nextLine();
                            System.out.println(" ");
                            printHeader();
                            System.out.printf("| %-15s | %-15s | %-10s | %-6s |\n", barang[indexBarangKeluar][0],
                                    barang[indexBarangKeluar][1], barang[indexBarangKeluar][2],
                                    jumlah[indexBarangKeluar][0]);
                            System.out.println("===========================================================");
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
//input barang rusak
                    System.out.println();
                    System.out.println("***************************** Input Barang Rusak *****************************");
                    System.out.println();
                    while (true) {
                        System.out.print("Tanggal \t\t: ");
                        String tanggalMasuk = sc.next();
                        System.out.print("Kode Barang \t\t: ");
                        String kodeBarangRusak = sc.next();
                        String namaBarangRusak = ""; // Menyesuaikan nilai pada array data barang
                        int jumlahBarang = 0;
                        int indexBarangRusak = -1;

                        for (int i = 0; i < barang.length; i++) {
                            if (barang[i][0].equals(kodeBarangRusak)) {
                                namaBarangRusak = barang[i][1];
                                jumlahBarang = jumlah[i][0];
                                indexBarangRusak = i;
                                keterangan[indexBarangRusak][0] = "Rusak";
                                break;
                            }
                        }
                        
                        if (indexBarangRusak != -1) {
                            System.out.println("Nama Barang \t\t: " + namaBarangRusak);
                            System.out.println("Jumlah Barang \t\t: " + jumlahBarang);
                            System.out.print("Jumlah Barang Rusak \t: ");
                            int jumlahRusak = sc.nextInt();
                            jumlah[indexBarangRusak][0] -= jumlahRusak;
                            nilaiRusak[indexBarangRusak][0] = jumlahRusak;
                            sc.nextLine();
                            System.out.println(" ");
                            
                            System.out.println();
                            System.out.println("===================================================================================");
                            System.out.printf("| %-15s | %-15s | %-10s | %-12s | %-15s |\n", "Kode Barang", "Nama Barang", "Lokasi", "Jumlah Rusak", "Keterangan");
                            System.out.println("===================================================================================");
                            System.out.printf("| %-15s | %-15s | %-10s | %-12s | %-15s |\n", barang[indexBarangRusak][0],
                                    barang[indexBarangRusak][1], barang[indexBarangRusak][2],
                                    nilaiRusak[indexBarangRusak][0], keterangan[indexBarangRusak][0]);
                            System.out.println("===================================================================================");
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
                
                 } else if (menu == 6) { 
//rekap barang rusak
                    System.out.println("Rekap Barang Rusak:");
                    System.out.println(" ");
                    int indexBarangRusak = -1;
                    boolean found = false;
                
                    System.out.println("===================================================================================");
                    System.out.printf("| %-15s | %-15s | %-10s | %-12s | %-15s |\n", "Kode Barang", "Nama Barang", "Lokasi", "Jumlah Rusak", "Keterangan");
                    System.out.println("===================================================================================");
                
                    for (int i = 0; i < keterangan.length; i++) {
                        if (keterangan[i][0] != null && keterangan[i][0].equalsIgnoreCase("rusak")) {
                            indexBarangRusak = i;
                            if (indexBarangRusak != -1 && barang[indexBarangRusak][0] != null) {
                                
                                System.out.printf("| %-15s | %-15s | %-10s | %-12s | %-15s |\n", barang[indexBarangRusak][0],
                                    barang[indexBarangRusak][1], barang[indexBarangRusak][2], nilaiRusak[indexBarangRusak][0], keterangan[indexBarangRusak][0]);
                                found = true;
                            }
                        }
                    }
                
                    if (found) {
                        System.out.println("===================================================================================");
                    }
                
                    if (!found) {
                        System.out.printf("| %-15s | %-15s | %-10s | %-12s | %-15s |\n", "", "", "","", "");
                        System.out.println("===================================================================================");
                        System.out.println();
                        System.out.println("Tidak ada barang rusak.");
                    }
                } else if (menu == 7) { //input barang banyak terjual
                    //Rekap Barang Banyak Terjual
                    System.out.println("Rekap Barang Banyak Terjual");
                    System.out.println();
                    int maxIndex = -1;
                    int maxQuantity = 0;
                    boolean found = false;

                    System.out.println("=====================================");
                    System.out.printf("| %-15s | %-15s |\n", "Nama Barang", "Banyak Terjual");
                    System.out.println("=====================================");

                    for (int i = 0; i < terjual.length; i++) {
                        if (terjual[i][0] > maxQuantity) {
                            maxQuantity = terjual[i][0];
                            maxIndex = i;
                        }
                    }

                    if (maxIndex != -1 && barang[maxIndex][0] != null) {
                        System.out.printf("| %-15s | %-15s |\n", barang[maxIndex][1], terjual[maxIndex][0]);
                        found = true; 
                    }

                    if (found) {
                        System.out.println("=====================================");
                    }

                    if (!found) {
                        System.out.printf("| %-15s | %-15s |\n", "", "");
                        System.out.println("=====================================");
                        System.out.println();
                        System.out.println("Belum ada barang yang terjual");
                    }

                } else if (menu == 8) { //rekap barang habis
                    System.out.println("Rekap Barang Habis:");
                    System.out.println(" ");
                    int indexBarangHabis = -1;
                    boolean found = false;

                    System.out.println("=====================================");
                    System.out.printf("| %-15s | %-15s |\n", "Kode Barang", "Nama Barang");
                    System.out.println("=====================================");

                    for (int i = 0; i < jumlah.length; i++) {
                        if (jumlah[i][0] == 0) {
                            indexBarangHabis = i;
                            if (indexBarangHabis != -1 && barang[indexBarangHabis][0] != null) {
                                System.out.printf("| %-15s | %-15s |\n", barang[indexBarangHabis][0], barang[indexBarangHabis][1]);
                                found = true;                                
                            }
                        }
                    }

                    if (found) {
                        System.out.println("=====================================");
                    }

                    if (!found) {
                        System.out.printf("| %-15s | %-15s |\n", "", "");
                        System.out.println("=====================================");
                        System.out.println();
                        System.out.println("Tidak ada barang habis.");
                    }
//update barang
                } else if (menu == 9) {
                    if (username.equalsIgnoreCase("manager") && password.equalsIgnoreCase("manager" )) {
                        System.out.print("\n=================== Update Data Barang ===================");
                        System.out.println();
                        while (true) {
                            System.out.print("\nMasukkan kode barang: ");
                            String kodeUpdate = sc.next();
                            int indexUpdate = -1;

                            for (int i = 0; i < barang.length; i++) {
                                if (barang[i][0] != null && barang[i][0].equals(kodeUpdate)) {
                                    indexUpdate = i;
                                    break;
                                }
                            }

                            if (indexUpdate != -1) {
                                // Tampilkan data barang yang ditemukan
                                System.out.println("\nData barang yang ditemukan:");
                                printHeader();
                                System.out.printf("| %-15s | %-15s | %-10s | %-6s |\n", barang[indexUpdate][0], barang[indexUpdate][1],
                                        barang[indexUpdate][2], jumlah[indexUpdate][0]);
                                System.out.println("===========================================================");
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
                                System.out.println("\nData barang setelah di-update:]");
                                printHeader();
                                System.out.printf("| %-15s | %-15s | %-10s | %-6s |\n", barang[indexUpdate][0], barang[indexUpdate][1],
                                        barang[indexUpdate][2], jumlah[indexUpdate][0]);
                                System.out.println("===========================================================");        
                            } else {
                                System.out.println();
                                System.out.println("Barang dengan kode " + kodeUpdate + " tidak ditemukan");
                            }

                            System.out.print("\nUpdate data barang lagi? (y/n): ");
                            next = sc.next();

                            if (next.equalsIgnoreCase("n")) {
                                break;
                            }
                        }
                    } else {
                        System.out.println(" ");
                        System.out.println("Maaf, Anda tidak memiliki akses untuk menu ini.");
                    }  
                }

                System.out.print("\nLanjut ke menu lain? (y/n): ");
                next = sc.next();

                if (next.equalsIgnoreCase("n")) {
                    System.out.println(" ");
                    System.out.println("***** SUCCESSFULL *****");
                    System.exit(0);
                }
                System.out.println();
            }
        }
    }

    static void printHeader() {
        System.out.println("===========================================================");
        System.out.printf("| %-15s | %-15s | %-10s | %-5s |\n", "Kode Barang", "Nama Barang", "Lokasi", "Jumlah");
        System.out.println("===========================================================");
    }
}