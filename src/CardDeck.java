

import javax.lang.model.element.NestingKind;

/**
 * Created by James on 4/21/2015.
 */
public class CardDeck {
    //private CircLinkedList cards;
    private Card currentCard;
    private Card[] deck;

    public CardDeck() {
        createDeckWrongMethod();

    }


    public static Card[] createDeckWrongMethod() {

        int size = 52;
        int index = 0;
        Card[] deck = new Card[size];

        Card.Suit[] suit = Card.Suit.values();
        Card.CardNum[] card = Card.CardNum.values();


        for (Card.Suit s : suit) {
            for (Card.CardNum c : card) {
                deck[index] = new Card(s, c, index);
                index++;
            }
        }
        deck = deck;
        return deck;
    }

    /**
     * Open the next card, if this is the tail card, return null.
     */
    public void drawCard() {

    }

    /**
     * Delete and return the current card (so we can place it in a list or a
     stack)
     */
    public void takeCard() {

    }

    public String toString() {
        String s = "";
        for (Card c : deck) {
            s+= c.getValue()+"";

        }
        return s;
    }

    public static void main(String[] args) {
        CardDeck deck = new CardDeck();
        //System.out.println(deck.get());

    }

}
