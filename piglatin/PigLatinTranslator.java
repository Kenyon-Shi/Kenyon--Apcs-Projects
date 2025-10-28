package piglatin;
import java.util.Scanner;

public class PigLatinTranslator {

    /* ---------- Translate entire book ---------- */
    public static Book translate(Book input) {
        Book outBook = new Book();
        outBook.setTitle(input.getTitle() + " (Pig-Latin)");

        for (int i = 0; i < input.getLineCount(); i++) {
            String original = input.getLine(i);
            String pigLine = translate(original);  // App.java expects THIS version
            outBook.appendLine(pigLine);
        }
        return outBook;
    }

    /* ---------- Translate one line ---------- */
    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");
        if (input == null || input.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        Scanner sc = new Scanner(input);

        while (sc.hasNext()) {
            if (result.length() > 0) result.append(" ");
            result.append(translateWord(sc.next()));
        }

        sc.close();
        return result.toString();
    }

    /* ---------- Translate single word ---------- */
    private static String translateWord(String word) {
        if (word.isEmpty()) return word;

        // 1. Separate trailing punctuation
        int end = word.length();
        while (end > 0 && !Character.isLetter(word.charAt(end - 1))) {
            end--;
        }
        String letters = word.substring(0, end);
        String punctuation = word.substring(end);

        // 2. Record capitalization pattern
        boolean[] upper = new boolean[letters.length()];
        for (int i = 0; i < letters.length(); i++) {
            upper[i] = Character.isUpperCase(letters.charAt(i));
        }

        // 3. Convert to lowercase
        letters = letters.toLowerCase();

        // 4. Find first vowel
        int vowelPos = -1;
        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);
            if ("aeiou".indexOf(ch) >= 0) {
                vowelPos = i;
                break;
            }
        }

        // 5. Build Pig Latin version
        String pig;
        if (vowelPos == 0) {
            pig = letters + "ay";  // starts with vowel
        } else if (vowelPos > 0) {
            pig = letters.substring(vowelPos) + letters.substring(0, vowelPos) + "ay";
        } else {
            pig = letters + "ay";  // no vowels
        }

        // 6. Restore capitalization
        StringBuilder rebuilt = new StringBuilder();
        for (int i = 0; i < pig.length(); i++) {
            char ch = pig.charAt(i);
            if (i < upper.length && upper[i] && Character.isLetter(ch)) {
                rebuilt.append(Character.toUpperCase(ch));
            } else {
                rebuilt.append(ch);
            }
        }

        return rebuilt.toString() + punctuation;
    }
}
