package piglatin;

public class App {
    public static void main(String[] args)
    {
        /*  Introduction and TODO List

        This project is setup with four main classes:
            1. App - the main application
            2. Book - a class that creates the basic book objects.
                - a Book contains a representation of a real book.
                - Book has methods to read data in from various sources
                - Book also has methods to read data out.
            3. PigLatinTranslator - a static class
                - Used to implement your translator.
                - Has two public methods to take input and return a translated copy.
                    - Book translate(Book input)
                    - String translate(String input)
            4. TestSuite - a simple class that helps you test your work.
                - Just like CodingBat this class tries your code against various cases.
                - It will tell you which cases return expected output or not
         */


        // Run tests, comment out once they pass.
        int score = TestSuite.run();

        // Focus on TestSuite until you get a score of 5 or higher.
        if (score > 4)
        {
            // ---------- BOOK #1: Romeo and Juliet ----------
            Book book1 = new Book();
            book1.readFromUrl("Romeo and Juliet", "https://www.gutenberg.org/cache/epub/1513/pg1513.txt");

            System.out.println("\n--- Original Romeo and Juliet ---");
            book1.printLines(0, 2);

            Book translated1 = PigLatinTranslator.translate(book1);

            System.out.println("\n--- Pig Latin Romeo and Juliet ---");
            translated1.printLines(0, 2);

            translated1.writeToFile("RomeoAndJuliet_PigLatin.txt");
            System.out.println("✅ Saved: RomeoAndJuliet_PigLatin.txt");


            // ---------- BOOK #2: New Book (pg77136) ----------
            Book book2 = new Book();
            book2.readFromUrl("Project Gutenberg Book 77136", "https://www.gutenberg.org/cache/epub/77136/pg77136.txt");

            System.out.println("\n--- Original Book 77136 ---");
            book2.printLines(0, 2);

            Book translated2 = PigLatinTranslator.translate(book2);

            System.out.println("\n--- Pig Latin Book 77136 ---");
            translated2.printLines(0, 2);

            translated2.writeToFile("Book77136_PigLatin.txt");
            System.out.println("✅ Saved: Book77136_PigLatin.txt");


            System.out.println("\n🎉 Translation complete for both books!");
        }
    }
}