/**
 * Created by James on 4/21/2015.
 */
public class CardList<E> implements AbstractList<E>{
    private CardList cards;
    private int openedIndex;
    private Card tailCard;
    private int count;

    public CardList() {

        this.cards = cards;
    }


    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return (count > 0);
    }


    public CardList cut(CardList cardList) {

        return null;
    }



    public void add(Card card) {
        Card current = tailCard;
        int index = 1;
        Card<E> newCard = new Card(card);
        if (isEmpty()) {
            tailCard = newCard;
        } else {

            while (current.next != null) {
                current = current.next;
            }
            current.next = newCard;
        }
        count++;

    }

    public void add(int index, Card card) {}














}
