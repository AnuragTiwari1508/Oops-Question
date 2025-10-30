// Question 17: String Character Counter
// Counts characters in a given string and displays the result

import java.util.Scanner;

public class Question17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("     STRING CHARACTER COUNTER");
        System.out.println("========================================\n");
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        // Count total characters
        int totalChars = input.length();
        
        // Count different types of characters
        int letters = 0;
        int digits = 0;
        int spaces = 0;
        int specialChars = 0;
        int vowels = 0;
        int consonants = 0;
        
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            
            if (Character.isLetter(ch)) {
                letters++;
                // Check for vowels
                char lowerCh = Character.toLowerCase(ch);
                if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || 
                    lowerCh == 'o' || lowerCh == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            } else if (Character.isDigit(ch)) {
                digits++;
            } else if (Character.isWhitespace(ch)) {
                spaces++;
            } else {
                specialChars++;
            }
        }
        
        // Count words (simple word count)
        String[] words = input.trim().split("\\s+");
        int wordCount = input.trim().isEmpty() ? 0 : words.length;
        
        // Display results
        System.out.println("\n========================================");
        System.out.println("CHARACTER COUNT RESULTS:");
        System.out.println("========================================");
        System.out.println("Input String: \"" + input + "\"");
        System.out.println("----------------------------------------");
        System.out.println("Total Characters: " + totalChars);
        System.out.println("Total Letters: " + letters);
        System.out.println("  - Vowels: " + vowels);
        System.out.println("  - Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Spaces: " + spaces);
        System.out.println("Special Characters: " + specialChars);
        System.out.println("Total Words: " + wordCount);
        System.out.println("========================================");
        
        // Character frequency (optional detailed analysis)
        System.out.println("\nCharacter Frequency Analysis:");
        System.out.println("========================================");
        
        int[] freq = new int[256];
        for (int i = 0; i < input.length(); i++) {
            freq[input.charAt(i)]++;
        }
        
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                char ch = (char) i;
                if (ch == ' ') {
                    System.out.println("'[space]' appears " + freq[i] + " time(s)");
                } else if (ch == '\n') {
                    System.out.println("'[newline]' appears " + freq[i] + " time(s)");
                } else if (ch == '\t') {
                    System.out.println("'[tab]' appears " + freq[i] + " time(s)");
                } else {
                    System.out.println("'" + ch + "' appears " + freq[i] + " time(s)");
                }
            }
        }
        
        System.out.println("========================================");
        
        scanner.close();
    }
}
