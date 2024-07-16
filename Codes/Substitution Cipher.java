// Write a Java program to perform encryption and decryption using Substitution Cipher algorithm.

import java.util.Scanner;
public class SubstitutionCipher 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the text to encrypt: ");
        String plainText = scanner.nextLine();
        
        System.out.print("Enter the encryption key (shift value): ");
        int shift = scanner.nextInt();
        
        String encryptedText = encrypt(plainText, shift);
        System.out.println("Encrypted Text: " + encryptedText);
        
        String decryptedText = decrypt(encryptedText, shift);
        System.out.println("Decrypted Text: " + decryptedText);
        
        scanner.close();
    }
    public static String encrypt(String plainText, int shift) 
    {
        StringBuilder encrypted = new StringBuilder();
        
        for (char c : plainText.toCharArray()) 
        {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encrypted.append((char) ((c - base + shift) % 26 + base));
            } else {
                encrypted.append(c);
            }
        }
        
        return encrypted.toString();
    }
    public static String decrypt(String encryptedText, int shift) {
        return encrypt(encryptedText, 26 - shift); 
    }
}