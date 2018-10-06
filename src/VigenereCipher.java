import java.util.Scanner;

public class VigenereCipher {
    public static void main(String[] args) {
        System.out.println("\nVIGENERE CIPHER\n\n1. Encryption\n2. Decryption");
        System.out.print("\nEnter your option number : ");
        Scanner reader = new Scanner(System.in);
        char c = reader.next().charAt(0);

        switch (c) {
            case 1:
                encrypt();
                break;
            case 2:
                decrypt();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    private static void encrypt() {

        String plainText = "THECRAZYPROGRAMMER222";
        plainText = formatText(plainText);
        String key = "HELLO";
        key = formatText(key);

        System.out.println(plainText);
        System.out.println(plainText.length());

        StringBuilder keyBuilder = new StringBuilder();
        for (int i = 0, j = 0; i < plainText.length(); i++, j++) {
            if (j == key.length()) {
                j = 0;
            }
            keyBuilder.append(key.charAt(j));
        }
        String newKey = keyBuilder.toString();

        System.out.println(newKey);

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

        System.out.println(cipherText);
        System.out.println(cipherText.length());

    }

    private static void decrypt() {

    }

    private static String formatText(String text) {
//        return text.replaceAll("\\s", "");//.toUpperCase();
        return text.replaceAll("\\s", "").toUpperCase();
    }
}
