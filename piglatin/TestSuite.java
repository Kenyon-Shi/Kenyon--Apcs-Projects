package piglatin;

public class TestSuite {
    // Run a bunch of basic tests on PigLatinTranslator
    public static int run() {
        int score = 0;
        int total = 12;

        // Single Words
        score += basicTest("eat", "eatay");
        score += basicTest("pig", "igpay");
        score += basicTest("trash", "ashtray");
        score += basicTest("null", "ullnay");

        // Capitalization
        score += basicTest("Trash", "Ashtray");
        score += basicTest("trash", "ashtray");
        score += basicTest("TrAsH", "AsHtray");

        // Punctuation
        score += basicTest("Trash.", "Ashtray.");
        score += basicTest("clean-cut", "ean-cutclay");

        // Empty and spaces
        score += basicTest("", "");
        score += basicTest("    ", "");

        // Multiple words
        score += basicTest("pigs eat trash", "igspay eatay ashtray");

        if (score >= total) {
            System.out.println("--- TEST PASSED! Congrats! ---");
        } else {
            System.out.println("--- TEST FAILED! :( Score: " + score + "/" + total + " ---");
        }

        return score;
    }

    public static int basicTest(String input, String expected) {
        String result = PigLatinTranslator.translate(input);
        if (result.equals(expected)) {
            System.out.println(" PASS: '" + input + "' -> '" + expected + "'");
            return 1;
        } else {
            System.out.println(" FAIL: '" + input + "', got '" + result + "', expected '" + expected + "'");
            return 0;
        }
    }

    public static void main(String[] args) {
        run();
    }
}