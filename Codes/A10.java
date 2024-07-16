// Calculate the message digest of a text using the MD5 algorithm in JAVA.

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class A10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a text to calculate its MD5 hash: ");
        String inputText = scanner.nextLine();

        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] inputBytes = inputText.getBytes();
            byte[] hash = md5.digest(inputBytes);

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = String.format("%02x", b);
                hexString.append(hex);
            }

            String md5Hash = hexString.toString();
            System.out.println("MD5 Hash: " + md5Hash);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("MD5 algorithm not found.");
        }

        scanner.close();
    }
}
