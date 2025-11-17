package cards;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> cards = new ArrayList<>();
    //int[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    //constructor w/ no parameters
    public Deck() {
        for (int s = 0; s < 4; s++) {
            for (int v = 0; v < 13; v++) {
                Card c = new Card(s, v);
                cards.add(c);
            }
        }
    }

    //shuffle method: randomizes order of deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    //cut method: check if deck is full, then section of cards moved to end of arraylist
    public void cut(int index) {
        if (cards.size() != 52) {
            System.out.println("Cut only works with full deck");
        }
        ArrayList<Card> top = new ArrayList<>(cards.subList(0,index));
        cards.subList(0,index).clear();
        cards.addAll(top);
    }

    //draw method: check cards size, then return first card, move all cards one space forward
    public Card draw() {
        if (cards.size() == 0) {
            return null;
        }
        Card top = cards.get(0);
        cards.remove(0);
        return top;

    }

    //print method: 
    public String print(int index) {
        String output = "";
        for (int i = 0; i < index; i++) {
            output += (cards.get(i)).toString() + " ";
        }
        return output.substring(0, output.length()-1);
    }

}