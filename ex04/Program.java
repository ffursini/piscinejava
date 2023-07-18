package ex04;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = scanner.nextLine();
        scanner.close();

        Map<Character, Integer> charCount = new HashMap<>();

        // Count character occurrences
        for (char c : text.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }

        // Sort characters by occurrence in descending order
        List<Character> sortedChars = new ArrayList<>(charCount.keySet());
        sortedChars.sort((a, b) -> {
            int countDiff = charCount.get(b) - charCount.get(a);
            if (countDiff == 0) {
                return a - b;
            }
            return countDiff;
        });

        // Find the maximum count
        int maxCount = 0;
        for (int count : charCount.values()) {
            maxCount = Math.max(maxCount, count);
        }

        // Display the histogram
        for (int i = maxCount; i > 0; i--) {
            for (Character c : sortedChars.subList(0, Math.min(sortedChars.size(), 10))) {
                int count = charCount.getOrDefault(c, 0);
                if (count >= i) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        for (Character c : sortedChars.subList(0, Math.min(sortedChars.size(), 10))) {
            System.out.print(c + " ");
        }
        System.out.println();

        for (Character c : sortedChars.subList(0, Math.min(sortedChars.size(), 10))) {
            int count = charCount.getOrDefault(c, 0);
            if (count >= 10) {
                System.out.print(count);
            } else {
                System.out.print(count + " ");
            }
        }
    }
}
