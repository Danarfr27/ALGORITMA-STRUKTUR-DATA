import java.util.Scanner;

public class AngkaPalindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== PROGRAM MENCARI ANGKA PALINDROME BERIKUTNYA ===");
        System.out.print("Masukkan sebuah angka: ");
        int angka = input.nextInt();

        int berikutnya = angka + 1;
        while (true) {
            if (cekPalindromeAngka(berikutnya)) {
                System.out.println("Angka palindrome setelah " + angka + " adalah " + berikutnya);
                break;
            }
            berikutnya++;
        }
    }

    // Fungsi untuk mengecek apakah angka palindrome
    public static boolean cekPalindromeAngka(int n) {
        String s = Integer.toString(n);
        String balik = new StringBuilder(s).reverse().toString();
        return s.equals(balik);
    }
}