package piglatin;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Book {
    private String title;
    private ArrayList<String> text = new ArrayList<String>();

    public Book() {
        // Empty book - no code needed here.
    }

    // Helper to debug code
    // Prints out a range of lines from a book
    public void printLines(int start, int length) {
        System.out.println("Lines " + start + " to " + (start + length) + " of book: " + title);
        for (int i = start; i < start + length; i++) {
            if (i < text.size()) {
                System.out.println(i + ": " + text.get(i));
            } else {
                System.out.println(i + ": line not in book.");
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLine(int lineNumber) {
        return text.get(lineNumber);
    }

    public int getLineCount() {
        return text.size();
    }

    public void appendLine(String line) {
        text.add(line);
    }

    public void readFromString(String title, String string) {
        this.title = title;
        Scanner sc = new Scanner(string);
        while (sc.hasNextLine()) {
            text.add(sc.nextLine());
        }
        sc.close();
    }

    public void readFromUrl(String title, String url) {
        this.title = title;
        try {
            URL bookUrl = URI.create(url).toURL();
            Scanner sc = new Scanner(bookUrl.openStream());
            while (sc.hasNextLine()) {
                text.add(sc.nextLine());
            }
            sc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeToFile(String name) {
        try (PrintWriter out = new PrintWriter(name)) {
            for (String line : text) {
                out.println(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
