package cards;

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> hand = new ArrayList<>();
    private int max;
    private int count = 0;
    public Hand(int max) {
        this.max = max;
    }

    //add method: add one card to Hand 
    public void add(Card card) {
        if (hand.size() != max) {
            hand.add(card);
            count++;
        }
        System.out.println("No more cards can be added");
    }

    //length method: returns the number of cards in Hand 
    public int length() {
        return count;
    }

    // 
    public Card get(int card) {
        return hand.get(card);
    }
}
