// Calculate the message digest of a text using the SHA-1 algorithm in JAVA.

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class A9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a text to calculate its SHA-1 hash: ");
        String inputText = scanner.nextLine();

        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            byte[] inputBytes = inputText.getBytes();
            byte[] hash = sha1.digest(inputBytes);

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            String sha1Hash = hexString.toString();
            System.out.println("SHA-1 Hash: " + sha1Hash);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("SHA-1 algorithm not found.");
        }

        scanner.close();
    }
}
