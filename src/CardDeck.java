import Card.Suit;
import Card.CardNum;
/**
 * Created by James on 4/21/2015.
 */
public class CardDeck {
    //private CircLinkedList cards;
    private Card currentCard;

    public CardDeck() {
        createDeckWrongMethod();

    }


    public static Card[] createDeckWrongMethod() {

        int size = 52;
        int index = 0;
        Card[] deck = new Card[size];

        Card.Suit[] suit = Card.Suit.values();
        Card.CardNum[] card = Card.CardNum.values();

        for (Suit s : suit) {
            for (CardNum c : card) {
                deck[index] = new Card(s, c, index);
                index++;
            }
        }

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

}
