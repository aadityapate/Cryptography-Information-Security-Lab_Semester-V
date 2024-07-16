// Write a Java program to perform encryption and decryption using Hill Cipher algorithm.

import java.util.Scanner;
public class HillCipher 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        // Matrix key for encryption
        int[][] key = {
            {6, 24, 1},
            {13, 16, 10},
            {20, 17, 15}
        };
        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine();
        
        // Ensure the plaintext length is a multiple of the key matrix size
        int blockSize = key.length;
        int paddingNeeded = blockSize - (plaintext.length() % blockSize);
        for (int i = 0; i < paddingNeeded; i++) 
        {
            plaintext += "X";
        }
        System.out.println("Padding added: " + plaintext);
        
        // Encryption
        String encryptedText = encrypt(plaintext, key);
        System.out.println("Encrypted: " + encryptedText);
        
        // Decryption
        String decryptedText = decrypt(encryptedText, key);
        System.out.println("Decrypted: " + decryptedText);
        scanner.close();
    }
    
    public static String encrypt(String plaintext, int[][] key) {
        int blockSize = key.length;
        StringBuilder encryptedText = new StringBuilder();
        
        for (int i = 0; i < plaintext.length(); i += blockSize) {
            int[] block = new int[blockSize];
            for (int j = 0; j < blockSize; j++) {
                block[j] = plaintext.charAt(i + j) - 'A';
            }
            
            for (int j = 0; j < blockSize; j++) {
                int sum = 0;
                for (int k = 0; k < blockSize; k++) {
                    sum += key[j][k] * block[k];
                }
                encryptedText.append((char) ((sum % 26) + 'A'));
            }
        }
        
        return encryptedText.toString();
    }
    
    public static String decrypt(String encryptedText, int[][] key) {
        int blockSize = key.length;
        StringBuilder decryptedText = new StringBuilder();
        int[][] inverseKey = getInverseKey(key);
        
        for (int i = 0; i < encryptedText.length(); i += blockSize) {
            int[] block = new int[blockSize];
            for (int j = 0; j < blockSize; j++) {
                block[j] = encryptedText.charAt(i + j) - 'A';
            }
            
            for (int j = 0; j < blockSize; j++) {
                int sum = 0;
                for (int k = 0; k < blockSize; k++) {
                    sum += inverseKey[j][k] * block[k];
                }
                decryptedText.append((char) ((sum % 26) + 'A'));
            }
        }
        
        return decryptedText.toString();
    }
    
    public static int[][] getInverseKey(int[][] key) 
    {
        return key; // Placeholder for demonstration
    }
}
