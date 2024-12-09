import java.util.Scanner;
//Linda Octaviani(15)
//Yulike Dwi Nurcahyani(28)
public class Prestasi {
    // Deklarasi array untuk menyimpan data prestasi
    static String[][] prestasi = new String[10000][5]; // Maksimum data awal 10000
    static int jumlahData = 0; // Counter jumlah data prestasi yang tersimpan
    static Scanner scanner = new Scanner(System.in);

    // Fungsi untuk menambahkan prestasi mahasiswa
    public static void tambahPrestasi() {
        if (jumlahData >= prestasi.length) {
            System.out.println("Kapasitas penyimpanan penuh! Tidak dapat menambahkan data baru.");
            return;
        }

        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Jenis Prestasi: ");
        String jenis = scanner.nextLine();

        //Validasi tingkat
        String tingkat;
        while (true) {
            System.out.print("Masukkan Tingkat Prestasi (Lokal/Nasional/Internasional): ");
            tingkat = scanner.nextLine();
            if (tingkat.equalsIgnoreCase("Lokal") || tingkat.equalsIgnoreCase("Nasional") || tingkat.equalsIgnoreCase("Internasional")) {
                break;
            } else {
                System.out.println("Tingkat prestasi tidak valid! Harap masukkan Lokal, Nasional, atau Internasional.");
            }
        }

        //Validasi tahun
        int tahun;
        while (true) {
            System.out.print("Masukkan Tahun Prestasi (2010 - " + java.time.Year.now() + "): ");
            tahun = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer
            if (tahun >= 2010 && tahun <= java.time.Year.now().getValue()) {
                break;
            } else {
                System.out.println("Tahun prestasi tidak valid. Coba lagi.");
            }
        }

        // Menyimpan data ke array
        prestasi[jumlahData][0] = nama;
        prestasi[jumlahData][1] = nim;
        prestasi[jumlahData][2] = jenis;
        prestasi[jumlahData][3] = tingkat;
        prestasi[jumlahData][4] = String.valueOf(tahun); //Mengubah menjadi String, karena data pada array harus memiliki tipe data yang sama.
        jumlahData++; //Menambahkan nilai

        System.out.println("Data prestasi berhasil ditambahkan.");
    }

    // Fungsi untuk menampilkan semua data prestasi menggunakan nested loop
    public static void tampilkanPrestasi() {
        if (jumlahData == 0) {
            System.out.println("Belum ada data prestasi yang tercatat.");
            return;
        }

        System.out.println("\n=== DAFTAR SEMUA PRESTASI ===");
        System.out.printf("%-10s %-15s %-21s %-18s %-22s\n", "Nama", "NIM", "Jenis Prestasi", "Tingkat", "Tahun");
        /* Printf = Mencetak teks dengan format tertentu
            "%-10s"
             - berarti teks akan diratakan ke kiri.
            10 berarti lebar kolom adalah 10 karakter.
             s berarti tipe data yang dimasukkan adalah String.
            \n menambahkan baris baru.
        */

        for (int i = 0; i < jumlahData; i++) {
            // Nested loop untuk mencetak setiap elemen dalam baris (data prestasi)
            for (int j = 0; j < prestasi[i].length; j++) {
                System.out.print(prestasi[i][j] + "    |    ");
            }
            System.out.println(); // Pindah ke baris berikutnya setelah mencetak satu data prestasi
        }
        System.out.println();
    }

    // Fungsi untuk menganalisis prestasi berdasarkan jenis
    public static void analisisPrestasi() {
        if (jumlahData == 0) {
            System.out.println("Belum ada data prestasi.");
            return;
        }

        System.out.print("Masukkan Jenis Prestasi yang ingin dianalisis: ");
        String jenisDicari = scanner.nextLine();

        System.out.println("\n=== Analisis Prestasi ===");
        boolean ditemukan = false;
        for (int i = 0; i < jumlahData; i++) {
            if (prestasi[i][2].equalsIgnoreCase(jenisDicari)) {
                System.out.printf("Nama: %s | NIM: %s | Jenis: %s | Tingkat: %s | Tahun: %s\n",
                    prestasi[i][0], prestasi[i][1], prestasi[i][2], prestasi[i][3], prestasi[i][4]);
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada data prestasi dengan jenis: " + jenisDicari);
        }
        System.out.println();
    }

    // Fungsi untuk menganalisis prestasi berdasarkan tahun
     public static void analisisPrestasiTahun() {
        if (jumlahData == 0) {
            System.out.println("Belum ada data prestasi.");
            return;
        }

        System.out.print("Masukkan Tahun Prestasi yang ingin dianalisis: ");
        int tahunDicari = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer

        System.out.println("\n=== Analisis Prestasi Berdasarkan Tahun ===");
        boolean ditemukan = false;
        for (int i = 0; i < jumlahData; i++) {
            if (Integer.parseInt(prestasi[i][4]) == tahunDicari) {
                System.out.printf("Nama: %s | NIM: %s | Jenis: %s | Tingkat: %s | Tahun: %s\n",
                    prestasi[i][0], prestasi[i][1], prestasi[i][2], prestasi[i][3], prestasi[i][4]);
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada data prestasi dengan tahun: " + tahunDicari);
        }
        System.out.println();
    } 
    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("\n=== PENCATATAN PRESTASI MAHASISWA ===");
            System.out.println("1. Tambah Data Prestasi");
            System.out.println("2. Tampilkan Semua Prestasi");
            System.out.println("3. Analisis Prestasi Berdasarkan Jenis");
            System.out.println("4. Analisis Prestasi Berdasarkan Tahun");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    tambahPrestasi();
                    break;
                case 2:
                    tampilkanPrestasi();
                    break;
                case 3:
                    analisisPrestasi();
                    break;
                case 4:
                    analisisPrestasiTahun();
                    break;
                case 5:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }
        } while (pilihan != 5);
    }
}
