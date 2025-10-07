import javax.swing.JOptionPane;

public class SistemPenerimaanProgrammer {
    public static void main(String[] args) {
        // Input nilai coding (0–100)
        int nilaiCoding = Integer.parseInt(JOptionPane.showInputDialog("Masukkan nilai coding (0-100):"));
        // Input nilai interview (A/B/C/D)
        String nilaiInterview = JOptionPane.showInputDialog("Masukkan nilai interview (A/B/C/D):").toUpperCase();

        String hasilCoding;
        String hasilInterview;

        // Penilaian coding
        if (nilaiCoding > 80) {
            hasilCoding = "LOLOS";
        } else if (nilaiCoding >= 60 && nilaiCoding <= 80) {
            hasilCoding = "DIPERTIMBANGKAN";
        } else {
            hasilCoding = "GAGAL";
        }

        // Penilaian interview
        if (nilaiInterview.equals("A") || nilaiInterview.equals("B")) {
            hasilInterview = "LOLOS";
        } else {
            hasilInterview = "GAGAL";
        }

        // Keputusan akhir
        if ((hasilCoding.equals("LOLOS") || hasilCoding.equals("DIPERTIMBANGKAN")) && hasilInterview.equals("LOLOS")) {
            System.out.println("Selamat Kamu Berhasil Menjadi Calon Programmer");
        } else {
            System.out.println("Maaf Kamu Belum Berhasil Menjadi Calon Programmer");
        }
    }
}
