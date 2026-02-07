import java.util.*;

public class Enc_Dec_HillChiper {
    private static final int MOD = 26;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hill Cipher - Enkripsi dan Dekripsi (Java)");
        System.out.println("Pilih mode: 1) Enkripsi  2) Dekripsi");
        int mode = readChoice(sc);

        System.out.print("Masukkan ukuran matriks kunci (n untuk n x n, e.g. 2 atau 3): ");
        int n = readInt(sc);
        System.out.println("Masukkan " + (n * n) + " elemen kunci (0..25) dipisah spasi atau newline):");
        int[][] key = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = readInt(sc);
                key[i][j] = mod(v, MOD);
            }
        }

        System.out.print("Masukkan teks pesan: ");
        String input = sc.nextLine();
        while (input.trim().isEmpty())
            input = sc.nextLine();

        String prepared = prepareText(input, n);
        if (mode == 1) {
            String cipher = encrypt(prepared, key);
            System.out.println("Hasil enkripsi: " + cipher);
        } else {
            int[][] inv = invertMatrixMod(key, MOD);
            if (inv == null) {
                System.out.println("Matriks kunci tidak dapat diinverskan modulo " + MOD + ". Dekripsi gagal.");
            } else {
                String plain = decrypt(prepared, inv);
                System.out.println("Hasil dekripsi (may contain padding X): " + plain);
            }
        }
        sc.close();
    }

    private static int readChoice(Scanner sc) {
        while (true) {
            System.out.print("Pilihan (1/2): ");
            String s = sc.nextLine().trim();
            if (s.equals("1"))
                return 1;
            if (s.equals("2"))
                return 2;
            System.out.println("Masukkan 1 atau 2.");
        }
    }

    private static int readInt(Scanner sc) {
        while (true) {
            String s = sc.next();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Bukan angka, coba lagi: ");
            }
        }
    }

    private static String prepareText(String text, int blockSize) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            if (c >= 'A' && c <= 'Z')
                sb.append(c);
        }
        while (sb.length() % blockSize != 0)
            sb.append('X');
        return sb.toString();
    }

    private static String encrypt(String plain, int[][] key) {
        int n = key.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < plain.length(); i += n) {
            int[] block = new int[n];
            for (int j = 0; j < n; j++)
                block[j] = plain.charAt(i + j) - 'A';
            int[] prod = multiplyMatrixVector(key, block);
            for (int v : prod)
                sb.append((char) (mod(v, MOD) + 'A'));
        }
        return sb.toString();
    }

    private static String decrypt(String cipher, int[][] invKey) {
        int n = invKey.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cipher.length(); i += n) {
            int[] block = new int[n];
            for (int j = 0; j < n; j++)
                block[j] = cipher.charAt(i + j) - 'A';
            int[] prod = multiplyMatrixVector(invKey, block);
            for (int v : prod)
                sb.append((char) (mod(v, MOD) + 'A'));
        }
        return sb.toString();
    }

    private static int[] multiplyMatrixVector(int[][] m, int[] v) {
        int n = m.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++)
                sum += m[i][j] * v[j];
            res[i] = mod(sum, MOD);
        }
        return res;
    }

    private static int mod(int a, int m) {
        int r = a % m;
        if (r < 0)
            r += m;
        return r;
    }

    // Inverse matrix modulo m. Returns null if not invertible.
    private static int[][] invertMatrixMod(int[][] matrix, int m) {
        int n = matrix.length;
        int det = determinant(matrix, m);
        det = mod(det, m);
        int detInv = modInverse(det, m);
        if (det == 0 || detInv == -1)
            return null;
        int[][] adj = adjugate(matrix, m);
        int[][] inv = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                inv[i][j] = mod(adj[i][j] * detInv, m);
        }
        return inv;
    }

    private static int[][] adjugate(int[][] a, int m) {
        int n = a.length;
        int[][] cof = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[][] minor = minor(a, i, j);
                int det = determinant(minor, m);
                int sign = ((i + j) % 2 == 0) ? 1 : -1;
                cof[i][j] = mod(sign * det, m);
            }
        }
        return transpose(cof);
    }

    private static int[][] transpose(int[][] a) {
        int n = a.length;
        int[][] t = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                t[i][j] = a[j][i];
        return t;
    }

    private static int[][] minor(int[][] a, int row, int col) {
        int n = a.length;
        int[][] m = new int[n - 1][n - 1];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (i == row)
                continue;
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == col)
                    continue;
                m[r][c] = a[i][j];
                c++;
            }
            r++;
        }
        return m;
    }

    private static int determinant(int[][] a, int m) {
        int n = a.length;
        if (n == 1)
            return mod(a[0][0], m);
        if (n == 2)
            return mod(a[0][0] * a[1][1] - a[0][1] * a[1][0], m);
        int det = 0;
        for (int j = 0; j < n; j++) {
            int sign = (j % 2 == 0) ? 1 : -1;
            int[][] sub = minor(a, 0, j);
            det += sign * a[0][j] * determinant(sub, m);
            det = mod(det, m);
        }
        return mod(det, m);
    }

    private static int modInverse(int a, int m) {
        a = mod(a, m);
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1)
                return x;
        }
        return -1; // no inverse
    }
}
