import java.util.Scanner;

public class CaesarCipher {

    // Encryption method
    public static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char ch = (char) ((c - 'A' + key) % 26 + 'A');
                result.append(ch);
            } else if (Character.isLowerCase(c)) {
                char ch = (char) ((c - 'a' + key) % 26 + 'a');
                result.append(ch);
            } else {
                // Non-alphabetic characters remain unchanged
                result.append(c);
            }
        }
        return result.toString();
    }

    // Decryption method
    public static String decrypt(String text, int key) {
        return encrypt(text, -key); // just shift in reverse
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Caesar Cipher Program ===");
        System.out.print("Enter plaintext: ");
        String plaintext = scanner.nextLine();

        System.out.print("Enter key (shift value): ");
        int key = scanner.nextInt();

        // Encryption
        String ciphertext = encrypt(plaintext, key);
        System.out.println("\nEncrypted Text (Ciphertext): " + ciphertext);

        // Decryption
        String decryptedText = decrypt(ciphertext, key);
        System.out.println("Decrypted Text (Plaintext): " + decryptedText);

        scanner.close();
    }
}

