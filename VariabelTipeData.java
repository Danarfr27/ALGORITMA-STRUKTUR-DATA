import java.util.Scanner;

public class GradeConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Konversi nilai angka ke huruf
            System.out.print("Masukkan nilai (0-100): ");
            int nilai = scanner.nextInt();
            if (nilai < 0 || nilai > 100) {
                System.out.println("Nilai huruf: Input tidak valid (harus 0-100)");
            } else {
                String grade = (nilai >= 85 && nilai <= 100) ? "A" :
                               (nilai >= 75 && nilai <= 84) ? "B" :
                               (nilai >= 65 && nilai <= 74) ? "C" :
                               (nilai >= 55 && nilai <= 64) ? "D" : "E";
                System.out.println("Nilai huruf: " + grade);
            }

            // Operasi aritmatika
            System.out.print("Input bilangan 1: ");
            double num1 = scanner.nextDouble();
            System.out.print("Input bilangan 2: ");
            double num2 = scanner.nextDouble();
            System.out.print("Input Operator (+, -, *, /, %): ");
            char operator = scanner.next().charAt(0);

            double hasil = 0;
            String operasi = "tidak valid";
            if (num2 == 0 && (operator == '/' || operator == '%')) {
                System.out.println("Hasil: Tidak dapat membagi atau modulus dengan nol");
            } else {
                hasil = (operator == '+') ? (num1 + num2) :
                        (operator == '-') ? (num1 - num2) :
                        (operator == '*') ? (num1 * num2) :
                        (operator == '/') ? (num1 / num2) :
                        (operator == '%') ? (num1 % num2) : 0;
                operasi = (operator == '+') ? "penjumlahan" :
                          (operator == '-') ? "pengurangan" :
                          (operator == '*') ? "perkalian" :
                          (operator == '/') ? "pembagian" :
                          (operator == '%') ? "modulus" : "tidak valid";
                System.out.println("Hasil " + operasi + " " + num1 + " dan " + num2 + " adalah " + hasil);
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid. Harap masukkan angka atau operator yang benar.");
        } finally {
            scanner.close();
        }
    }
}
