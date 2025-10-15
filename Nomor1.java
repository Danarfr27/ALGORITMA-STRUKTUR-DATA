import java.util.Scanner;

public class CekPalindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== PROGRAM CEK PALINDROME ===");
        System.out.print("Masukkan kata atau kalimat: ");
        String teks = input.nextLine();

        // Hapus spasi dan ubah jadi huruf kecil agar adil saat dicek
        String asli = teks.replaceAll("\\s+", "").toLowerCase();
        String balik = new StringBuilder(asli).reverse().toString();

        if (asli.equals(balik)) {
            System.out.println("Hasil: \"" + teks + "\" adalah PALINDROME");
        } else {
            System.out.println("Hasil: \"" + teks + "\" bukan palindrome");
        }
    }
}