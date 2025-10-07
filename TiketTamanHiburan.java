import javax.swing.JOptionPane;

public class TiketTamanHiburan {
    public static void main(String[] args) {
        try {
            // Input jumlah tiket untuk masing-masing kategori
            String inputAnak = JOptionPane.showInputDialog("Jumlah tiket Anak-anak (0-12 tahun):");
            int jumlahAnak = Integer.parseInt(inputAnak);

            String inputRemaja = JOptionPane.showInputDialog("Jumlah tiket Remaja (13-17 tahun):");
            int jumlahRemaja = Integer.parseInt(inputRemaja);

            String inputDewasa = JOptionPane.showInputDialog("Jumlah tiket Dewasa (18-59 tahun):");
            int jumlahDewasa = Integer.parseInt(inputDewasa);

            String inputLansia = JOptionPane.showInputDialog("Jumlah tiket Lansia (60+ tahun):");
            int jumlahLansia = Integer.parseInt(inputLansia);

            // Harga per tiket untuk masing-masing kategori
            int hargaAnak = 10000; // Rp 10.000
            int hargaRemaja = 15000; // Rp 15.000
            int hargaDewasa = 25000; // Rp 25.000
            int hargaLansia = 0; // Gratis

            // Menghitung subtotal per kategori
            int subtotalAnak = hargaAnak * jumlahAnak;
            int subtotalRemaja = hargaRemaja * jumlahRemaja;
            int subtotalDewasa = hargaDewasa * jumlahDewasa;
            int subtotalLansia = hargaLansia * jumlahLansia;

            // Total sebelum diskon
            int totalHarga = subtotalAnak + subtotalRemaja + subtotalDewasa + subtotalLansia;

            // Menerapkan diskon 5% jika total > Rp 100.000
            double totalBayar = totalHarga;
            String infoDiskon = "";
            if (totalHarga > 100000) {
                totalBayar = totalHarga * 0.95; // Diskon 5%
                infoDiskon = " (Diskon 5%: Rp " + (totalHarga * 0.05) + ")";
            }

            // Menampilkan hasil
            String pesan = "Rincian Pembelian Tiket:\n\n" +
                    "Anak-anak: " + jumlahAnak + " tiket x Rp " + hargaAnak + " = Rp " + subtotalAnak + "\n" +
                    "Remaja: " + jumlahRemaja + " tiket x Rp " + hargaRemaja + " = Rp " + subtotalRemaja + "\n" +
                    "Dewasa: " + jumlahDewasa + " tiket x Rp " + hargaDewasa + " = Rp " + subtotalDewasa + "\n" +
                    "Lansia: " + jumlahLansia + " tiket x Rp " + hargaLansia + " = Rp " + subtotalLansia + "\n\n" +
                    "Total sebelum diskon: Rp " + totalHarga + "\n" +
                    "Total yang harus dibayar: Rp " + (int) totalBayar + infoDiskon;

            JOptionPane.showMessageDialog(null, pesan, "Hasil Perhitungan Tiket", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Masukkan harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Input dibatalkan!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }
}