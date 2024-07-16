// Write a Java program to implement the DES algorithm logic.

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class A6 {

    public static void main(String[] args) {
        try {
            // Generate a DES key
            SecretKey secretKey = generateDESKey();

            // Take user input for plaintext message
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a message to encrypt: ");
            String plaintext = scanner.nextLine();

            // Encrypt the user input
            String encryptedText = encrypt(plaintext, secretKey);
            System.out.println("Encrypted: " + encryptedText);

            // Decrypt the message
            String decryptedText = decrypt(encryptedText, secretKey);
            System.out.println("Decrypted: " + decryptedText);

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SecretKey generateDESKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        return keyGenerator.generateKey();
    }

    public static String encrypt(String plaintext, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedText, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}
