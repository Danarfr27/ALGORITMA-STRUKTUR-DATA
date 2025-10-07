import java.util.Scanner;

public class HitungKaloriOlahraga {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Program Penghitung Kalori Olahraga ===");

        // Input durasi masing-masing olahraga
        System.out.print("Masukkan waktu lari (menit): ");
        double waktuLari = input.nextDouble();

        System.out.print("Masukkan waktu push-up (menit): ");
        double waktuPushUp = input.nextDouble();

        System.out.print("Masukkan waktu plank (menit): ");
        double waktuPlank = input.nextDouble();

        // Rumus perhitungan kalori
        double kaloriLari = (waktuLari / 5) * 60;
        double kaloriPushUp = (waktuPushUp / 30) * 200;
        double kaloriPlank = waktuPlank * 5;

        // Total kalori
        double totalKalori = kaloriLari + kaloriPushUp + kaloriPlank;

        // Output
        System.out.println("\n=== Hasil Perhitungan Kalori ===");
        System.out.println("Kalori dari lari: " + kaloriLari + " kalori");
        System.out.println("Kalori dari push-up: " + kaloriPushUp + " kalori");
        System.out.println("Kalori dari plank: " + kaloriPlank + " kalori");
        System.out.println("---------------------------------");
        System.out.println("Total kalori terbakar: " + totalKalori + " kalori");

        input.close();
    }
}
