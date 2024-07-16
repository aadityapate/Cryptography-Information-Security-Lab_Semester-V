// Write a Java program to perform encryption and decryption using Caesar Cipher algorithm.

import java.util.Scanner;
public class CaesarCipher 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text to encrypt/decrypt: ");
        String text = scanner.nextLine();
        System.out.print("Enter the key (a number between 1 and 25): ");
        int key = scanner.nextInt();

        String encryptedText = encrypt(text, key);
        String decryptedText = decrypt(encryptedText, key);

        System.out.println("\nEncryption:");
        System.out.println("Original text: " + text);
        System.out.println("Encrypted text: " + encryptedText);

        System.out.println("\nDecryption:");
        System.out.println("Encrypted text: " + encryptedText);
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close();
    }

    public static String encrypt(String text, int key) 
    {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) 
        {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) 
            {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                ch = (char) (((ch - base + key) % 26) + base);
            }
            result.append(ch);
        }

        return result.toString();
    }

    public static String decrypt(String text, int key) 
    {
        return encrypt(text, 26 - key);
    }
}