//Write a Java program to implement RSA Algorithm.

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class A7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Generate two random prime numbers (in practice, use large prime numbers)
        BigInteger p = BigInteger.probablePrime(128, new SecureRandom());
        BigInteger q = BigInteger.probablePrime(128, new SecureRandom());

        // Calculate n = p * q
        BigInteger n = p.multiply(q);

        // Calculate Euler's totient function (φ(n))
        BigInteger phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // Choose a public exponent (e)
        BigInteger e = BigInteger.valueOf(65537); // Common choice

        // Calculate the private exponent (d)
        BigInteger d = e.modInverse(phiN);

        System.out.print("Enter the message: ");
        String inputMessage = scanner.nextLine();
        BigInteger message = new BigInteger(inputMessage.getBytes());

        // Encryption: ciphertext = message^e mod n
        BigInteger ciphertext = message.modPow(e, n);

        // Decryption: decryptedMessage = ciphertext^d mod n
        BigInteger decryptedMessage = ciphertext.modPow(d, n);

        System.out.println("Original message: " + inputMessage);
        System.out.println("Ciphertext: " + ciphertext);
        System.out.println("Decrypted message: " + new String(decryptedMessage.toByteArray()));

        scanner.close();
    }
}
