import java.util.Scanner;

public class VigenereCipher {
    public static void main(String[] args) {

        encrypt();

        decrypt();

    }

    private static void encrypt() {

        // KALIMAT YANG INGIN DIENKRIPSI
        String plainText = "THECRAZYPROGRAMMER";
        plainText = formatText(plainText);
        // KEY YANG INGIN DIGUNAKAN
        String key = "HELLO";
        key = formatText(key);

        System.out.println("\nKalimat = "+plainText);
        System.out.println("Panjang kalimat = "+plainText.length());
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
        System.out.println("Panjang key baru = "+newKey.length());

        // MEMBUAT CIPHERTEXT
        StringBuilder cipherBuilder = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            if (c >= 'A' && c <= 'Z') {
//            if (c >= '!' && c <= '`'){
//                c = (char) (((plainText.charAt(i) + newKey.charAt(i)) % 94)+'!');
                c = (char) (((plainText.charAt(i) + newKey.charAt(i)) % 26) + 'A');
                cipherBuilder.append(c);
            } else {
                cipherBuilder.append(c);
            }
        }
        String cipherText = cipherBuilder.toString();

        System.out.println("\nCiphertext = "+cipherText);
        System.out.println("Panjang ciphertext = "+cipherText.length());

        System.out.println("--------------------------------------------");
    }

    private static void decrypt() {

        // KALIMAT YANG INGIN DIENKRIPSI
        String cipherText = "ALPNFHDJAFVKCLATIC";
        cipherText = formatText(cipherText);
        // KEY YANG DIGUNAKAN
        String key = "HELLO";
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
        System.out.println("Panjang key baru = "+newKey.length());

        // MEMBUAT PLAINTEXT
        StringBuilder textBuilder = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);
            if (c >= 'A' && c <= 'Z') {
//            if (c >= '!' && c <= '`'){
//                c = (char) (((cipherText.charAt(i) + newKey.charAt(i) + 94) % 94)+'!');
                c = (char) (((cipherText.charAt(i) - newKey.charAt(i) + 26) % 26) + 'A');
                textBuilder.append(c);
            } else {
                textBuilder.append(c);
            }
        }
        String plainText = textBuilder.toString();

        System.out.println("\nPlaintext = "+plainText);
        System.out.println("Panjang plaintext = "+plainText.length());

    }

    private static String formatText(String text) {
//        return text.replaceAll("\\s", "");//.toUpperCase();
        return text.replaceAll("\\s", "").toUpperCase();
    }
}
