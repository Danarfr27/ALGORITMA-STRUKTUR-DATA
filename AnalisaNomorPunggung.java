import java.util.Scanner;

public class AnalisaNomorPunggung {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama pemain: ");
        String nama = input.nextLine();

        System.out.print("Masukkan nomor punggung pemain: ");
        int nomor = input.nextInt();

        System.out.println("==============================");

        if (nomor >= 1 && nomor <= 5) {
            System.out.println(nama + " adalah pemain bertahan (Defender).");
        } else if (nomor >= 6 && nomor <= 10) {
            System.out.println(nama + " adalah pemain tengah (Midfielder).");
        } else if (nomor >= 11 && nomor <= 15) {
            System.out.println(nama + " adalah penyerang (Striker).");
        } else {
            System.out.println(nama + " adalah pemain cadangan atau belum terdaftar.");
        }

        input.close();
    }
}
