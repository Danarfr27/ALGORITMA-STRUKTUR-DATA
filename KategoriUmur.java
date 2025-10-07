import javax.swing.JOptionPane;

public class KategoriUmur {
    public static void main(String[] args) {
        try {
            // Get input from user
            String inputUmur = JOptionPane.showInputDialog("Masukan Umur Lurds");
            int i_umur = Integer.parseInt(inputUmur); // Parse input to integer

            String kategori; // Declare kategori variable

            // Determine age category
            if (i_umur >= 0 && i_umur <= 12) {
                kategori = "Anak-Anak";
            } else if (i_umur >= 13 && i_umur <= 17) {
                kategori = "Remaja";
            } else if (i_umur >= 18 && i_umur <= 59) {
                kategori = "Dewasa";
            } else if (i_umur >= 60) {
                kategori = "Lansia";
            } else {
                kategori = "Kesalahan Input Umur";
            }

            // Show result
            JOptionPane.showMessageDialog(null, "Kategori: " + kategori, "Hasil Kategori Umur",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            // Handle non-numeric input
            JOptionPane.showMessageDialog(null, "Masukan harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}