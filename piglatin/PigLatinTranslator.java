package piglatin;

public class PigLatinTranslator {

    // Translate a whole Book, line by line
    public static Book translate(Book input) {
        Book translatedBook = new Book();
        translatedBook.setTitle(input.getTitle());

        // iterate through each line of the Book
        for (int i = 0; i < input.getLineCount(); i++) {
            String line = input.getLine(i);
            String translatedLine = translate(line); // call the string method
            translatedBook.appendLine(translatedLine);
        }

        return translatedBook;
    }

    // Translate a string (sentence or multiple words)
    public static String translate(String input) {
        if (input == null || input.trim().isEmpty()) return "";

        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                if (result.length() > 0) result.append(" ");
                result.append(translateWord(word));
            }
        }
        return result.toString();
    }

    // Translate a single word to Pig Latin
    private static String translateWord(String word) {
        if (word == null || word.isEmpty()) return "";

        String lower = word.toLowerCase();

        // Handle punctuation at the end
        String punctuation = "";
        if (!Character.isLetter(lower.charAt(lower.length() - 1))) {
            punctuation = lower.substring(lower.length() - 1);
            lower = lower.substring(0, lower.length() - 1);
        }

        int firstVowel = -1;
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if ("aeiou".indexOf(c) >= 0) {
                firstVowel = i;
                break;
            }
        }

        String result;
        if (firstVowel == 0) {
            result = lower + "ay"; // starts with vowel
        } else if (firstVowel > 0) {
            result = lower.substring(firstVowel) + lower.substring(0, firstVowel) + "ay";
        } else {
            result = lower + "ay"; // no vowels
        }

        // ✅ Fix capitalization correctly
        if (Character.isUpperCase(word.charAt(0))) {
            result = Character.toUpperCase(result.charAt(0)) + result.substring(1);
        } else {
            result = result.toLowerCase();
        }

        return result + punctuation;
    }
}