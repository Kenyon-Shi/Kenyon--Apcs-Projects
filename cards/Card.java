package cards;

public class Card {
    private int suit;
    private int value;

    private static String[] SUITS = {"♦", "♣", "♥", "♠"};
    private static String[] VALUES = {"A", "2", "3", "4", "5", "6",
                                      "7", "8", "9", "10", "J", "Q", "K"};

    public Card(int suit, int value)
    {
        // clamp suit to 0–3
        if (suit < 0) suit = 0;
        if (suit > 3) suit = 3;

        // clamp value to 0–12
        if (value < 0) value = 0;
        if (value > 12) value = 12;

        this.suit = suit;
        this.value = value;
    }

    public String toString()
    {
        return SUITS[suit] + VALUES[value];
    }

    public int getValue()
    {
        return value;
    }
}
