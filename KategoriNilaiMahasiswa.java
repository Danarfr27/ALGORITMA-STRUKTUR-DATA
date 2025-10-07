import java.util.Scanner;

public class KategoriNilaiMahasiswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama mahasiswa: ");
        String nama = input.nextLine();

        System.out.print("Masukkan nilai akhir: ");
        double nilai = input.nextDouble();

        System.out.println("==============================");

        if (nilai >= 85 && nilai <= 100) {
            System.out.println(nama + " mendapatkan kategori A (Sangat Baik).");
        } else if (nilai >= 70 && nilai < 85) {
            System.out.println(nama + " mendapatkan kategori B (Baik).");
        } else if (nilai >= 55 && nilai < 70) {
            System.out.println(nama + " mendapatkan kategori C (Cukup).");
        } else if (nilai >= 40 && nilai < 55) {
            System.out.println(nama + " mendapatkan kategori D (Kurang).");
        } else if (nilai >= 0 && nilai < 40) {
            System.out.println(nama + " mendapatkan kategori E (Gagal).");
        } else {
            System.out.println("Nilai yang dimasukkan tidak valid!");
        }

        input.close();
    }
}
