import java.util.Random;

public class Deck {

    private Card[] cards;
    private int topIndex; // next card to draw

    public Deck() {
        cards = new Card[52];
        resetDeck();
    }

    // helper to rebuild the deck (used for bonus fix)
    private void resetDeck() {
        int index = 0;
        for (int suit = 0; suit < 4; suit++) {
            for (int value = 0; value < 13; value++) {
                cards[index] = new Card(suit, value);
                index++;
            }
        }
        topIndex = 0;
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < cards.length; i++) {
            int swap = rand.nextInt(52);
            Card temp = cards[i];
            cards[i] = cards[swap];
            cards[swap] = temp;
        }
        topIndex = 0;
    }

    public void cut(int n) {
        if (n < 0) n = 0;
        if (n > 51) n = 51;

        Card[] newDeck = new Card[52];
        int pos = 0;

        for (int i = n; i < 52; i++) {
            newDeck[pos++] = cards[i];
        }
        for (int i = 0; i < n; i++) {
            newDeck[pos++] = cards[i];
        }

        cards = newDeck;
        topIndex = 0;
    }

    public Card draw() {
        // BONUS FIX — prevents index out of bounds
        if (topIndex >= 52) {
            resetDeck();
        }

        Card c = cards[topIndex];
        topIndex++;
        return c;
    }

    public void print(int num) {
        StringBuilder sb = new StringBuilder();
        int end = topIndex + num;
        if (end > 52) end = 52;

        for (int i = topIndex; i < end; i++) {
            sb.append(cards[i].toString());
            if (i < end - 1) sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}
