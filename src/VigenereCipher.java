public class VigenereCipher {
    public static void main(String[] args) {
        encrypt();

        System.out.println("--------------------------------------------");

        decrypt();
    }

    private static void encrypt() {

        // KALIMAT YANG INGIN DIENKRIPSI
        String plainText = "Ini hari rabu";
        plainText = formatText(plainText);
        // KEY YANG INGIN DIGUNAKAN
        String key = "Hari";
        key = formatText(key);

        System.out.println("\nPlaintext = "+plainText);
        System.out.println("Panjang plaintext = "+plainText.length());
        System.out.println("Key = "+key);
        System.out.println("Panjang key = "+key.length());

        // MEMBUAT KEY BARU BERDASARKAN PANJANG PLAINTEXT
        StringBuilder keyBuilder = new StringBuilder();
        for (int i = 0, j = 0; i < plainText.length(); i++, j++) {
            if (j == key.length()) {
                j = 0;
            }
            keyBuilder.append(key.charAt(j));
        }
        String newKey = keyBuilder.toString();

        System.out.println("\nKey baru = "+newKey);

        // MEMBUAT CIPHERTEXT
        StringBuilder cipherBuilder = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char) (((plainText.charAt(i) + newKey.charAt(i)) % 26) + 'A');
                cipherBuilder.append(c);
            } else {
                cipherBuilder.append(c);
            }
        }
        String cipherText = cipherBuilder.toString();

        System.out.println("\nCiphertext = "+cipherText);
    }

    private static void decrypt() {

        // KALIMAT YANG INGIN DIENKRIPSI
        String cipherText = "PNZPHRZZHBL";
        cipherText = formatText(cipherText);
        // KEY YANG DIGUNAKAN
        String key = "Hari";
        key = formatText(key);

        System.out.println("\nCiphertext = "+cipherText);
        System.out.println("Panjang ciphertext = "+cipherText.length());
        System.out.println("Key = "+key);
        System.out.println("Panjang key = "+key.length());

        // MEMBUAT KEY BARU BERDASARKAN PANJANG CIPHERTEXT
        StringBuilder keyBuilder = new StringBuilder();
        for (int i = 0, j = 0; i < cipherText.length(); i++, j++) {
            if (j == key.length()) {
                j = 0;
            }
            keyBuilder.append(key.charAt(j));
        }
        String newKey = keyBuilder.toString();

        System.out.println("\nKey baru = "+newKey);

        // MEMBUAT PLAINTEXT
        StringBuilder textBuilder = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char) (((cipherText.charAt(i) - newKey.charAt(i) + 26) % 26) + 'A');
                textBuilder.append(c);
            } else {
                textBuilder.append(c);
            }
        }
        String plainText = textBuilder.toString();

        System.out.println("\nPlaintext = "+plainText);
    }

    private static String formatText(String text) {
        return text.replaceAll("\\s", "").toUpperCase();
    }
}
