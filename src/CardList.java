/**
 * Created by James on 4/21/2015.
 */
public class CardList<E> implements AbstractList<E> {
    private CardList cards;
    private int openedIndex;
    private Card tailCard;
    private int count;

    public CardList() {
        tailCard = null;
        this.cards = cards;
        count = 0;
        openedIndex = 1;
    }


    public int size() {
        return count;
    }

    public boolean isEmpty() {

        if (count > 0)
            return false;
        else
            return true;


    }


    public void init() {
        CardList<Card> newCardList = new CardList<>();

        Card.Suit[] suit = Card.Suit.values();
        Card.CardNum[] card = Card.CardNum.values();

        int index = 1;
        for (Card.Suit s : suit) {
            for (Card.CardNum c : card) {
                Card newCard = new Card(s, c, index);
                newCardList.add(newCard);
                index++;
            }
        }
        this.tailCard = (Card<E>) newCardList.getTailCard();
        this.cards = newCardList;
        this.count = newCardList.count;

    }


    public CardList cut(CardList cardList) {

        return null;
    }

    public Card getTailCard() {
        return tailCard;
    }

    public void add(Card card) {
        Card current = tailCard;
        int index = 1;

        if (isEmpty()) {
            tailCard = card;
        } else {

            while (current.previous != null) {
                current = current.previous;
            }
            current.previous = card;
        }
        count++;

    }

    public Card moveTail() {
        Card temp = tailCard;
        tailCard = tailCard.next;

        return tailCard;
    }

    @Override
    public String toString() {
        String s = "";
        Card pointer = tailCard;
        while (pointer != null) {
            s += pointer + ", ";
            pointer = pointer.previous;
        }

        return s;
    }

    public void add(int index, Card card) {
    }


}
