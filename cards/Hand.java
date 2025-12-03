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
        //System.out.println("No more cards can be added.");
    }

    //length method: returns the number of cards in Hand 
    public int length() {
        return count;
    }

    // get method returns one card
    public Card get(int card) {
        return hand.get(card);
    }

    //remove method removes a card
    public Card remove(int card) {
        return hand.remove(card);
    }

    // toString method prints out all the cards
    public String toString() {
        String output = "";
        for (int i = 0; i < hand.size(); i++) {
            output += hand.get(i);
            output += "";
        }
        return output.substring(0, output.length()-1);
    }
}
