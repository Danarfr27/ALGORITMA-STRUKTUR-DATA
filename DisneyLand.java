import java.util.Scanner;

public class DisneyLand {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Program Tarif Wahana Disney Land ===");
        System.out.print("Masukkan umur anak (tahun): ");
        int umur = input.nextInt();

        System.out.print("Masukkan tinggi anak (cm): ");
        int tinggi = input.nextInt();

        int tarif = 0;
        boolean bolehMasuk = true;

        System.out.println("==============================");

        if (umur < 1) {
            System.out.println("Dilarang masuk");
            bolehMasuk = false;
        } else if (umur < 3) {
            tarif = 30000;
            if (tinggi > 70) {
                tarif += 10000;
            }
        } else if (umur < 7) {
            tarif = 40000;
            if (tinggi > 120) {
                tarif += 15000;
            }
        } else if (umur < 10) {
            tarif = 50000;
            if (tinggi > 150) {
                tarif += 20000;
            }
        } else {
            tarif = 80000;
        }

        if (bolehMasuk) {
            System.out.println("Tarif masuk: Rp " + tarif);
        }

        input.close();
    }
}
