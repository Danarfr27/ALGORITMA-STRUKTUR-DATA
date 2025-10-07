import javax.swing.JOptionPane;

public class AnalisaAnggotaMafia {
    public static void main(String[] args) {
        // Input data menggunakan JOptionPane
        String nama = JOptionPane.showInputDialog("Masukkan nama:");
        int umur = Integer.parseInt(JOptionPane.showInputDialog("Masukkan umur:"));
        String tempat = JOptionPane.showInputDialog("Masukkan tempat tinggal:");
        double tabungan = Double.parseDouble(JOptionPane.showInputDialog("Masukkan tabungan dalam dollar:"));

        // Analisa berdasarkan ciri-ciri
        if (umur > 40 &&
                (tempat.equalsIgnoreCase("Nevada") || tempat.equalsIgnoreCase("New York")
                        || tempat.equalsIgnoreCase("Havana"))
                &&
                tabungan > 10000000) {

            System.out.println(nama + " kemungkinan adalah seorang anggota mafia dengan pangkat Don.");

        } else if (umur >= 25 && umur <= 40 &&
                (tempat.equalsIgnoreCase("New Jersey") || tempat.equalsIgnoreCase("Manhattan")
                        || tempat.equalsIgnoreCase("Nevada"))
                &&
                tabungan >= 1000000 && tabungan <= 2000000) {

            System.out.println(nama + " kemungkinan adalah seorang anggota mafia dengan pangkat Underboss.");

        } else if (umur >= 18 && umur <= 24 &&
                (tempat.equalsIgnoreCase("California") || tempat.equalsIgnoreCase("Detroit")
                        || tempat.equalsIgnoreCase("Boston"))
                &&
                tabungan < 1000000) {

            System.out.println(nama + " kemungkinan adalah seorang anggota mafia dengan pangkat Capo.");

        } else {
            System.out.println(nama + " tidak mencurigakan.");
        }
    }
}
