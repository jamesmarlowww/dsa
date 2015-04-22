/**
 * Created by james on 4/22/2015.
 */
public class CardDeck<E> implements AbstractList<E> {

    private int count;
    private Card<E> tail;
    private CardDeck cards;
    private Card currentCard;

    public CardDeck() {
        count = 0;
        tail = null;
    }

    public Card drawCard() {

        return null;

    }

    public Card takeCard() {


        return null;
    }

    public void init() {
        CardDeck<Card> cards = new CardDeck<>();

        Card.Suit[] suit = Card.Suit.values();
        Card.CardNum[] card = Card.CardNum.values();

        int index = 0;
        for (Card.Suit s : suit) {
            for (Card.CardNum c : card) {
                Card newCard = new Card(s, c, index);
                cards.add(newCard.getCardIndex(), newCard);
                index++;
            }
        }
        this.cards = cards;
        this.count = cards.count;
        this.tail = (Card<E>) cards.getTail();
    }

    public Card<E> getTail() {
        return tail;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        if (count <= 0)
            return true;
        else
            return false;
    }

    @Override
    public Card get(int i) {
        if (isEmpty() || count <= i || i < 0)
            return null;
        Card<E> pointer = tail.next;

        while (i > 0) {
            pointer = pointer.next;
            i--;
        }
        return pointer;
    }

    public void remove(int i) {
        if (i < 0 || i > count)
            return;

        if (i == 0) {
            tail = tail.next.next;
        } else {
            Card<E> previous = tail.next;
            Card<E> pointer = tail.next.next;
            int tailCheck = i;

            while (i > 1) {
                previous = pointer;
                pointer = pointer.next;
                i--;
            }
            if (tailCheck == count - 1) // pointer is on the tail
            {
                if (previous == tail) // only one value in list
                    tail = null;
                else
                    tail = previous;
            }
            previous.next = (pointer.next);
        }
        count--;

    }

    @Override
    public void add(int i, Card card) {
        if (i < 0 || i > count || card == null) {
            return;
        }
        Card newCard = new Card(card);
        if (i == 0) {

            if (tail == null) // list currently empty
            {
                tail = newCard;
                tail.next = newCard;
            } else {

                // newCard.next = tail.next;
                newCard.next = tail.next;
                tail.next = (newCard);

            }

        } else {


            Card<E> previous = tail.next; // previous = head
            Card<E> pointer = tail.next.next; // pointer =
            // head.next

            while (i > 1) {
                previous = pointer;
                pointer = pointer.next;
                i--;
            }
            newCard.next = pointer;
            previous.next = newCard;
        }
        count++;
    }



    @Override
    public String toString() {
        String s = "";
        Card<E> sn = tail.next;
        int x = count;
        while(x > 0) {
            if(sn.next != null    ) {
                System.out.println(sn.toString());
                sn = sn.next;
            }
            x--;
        }
        return s;
    }



}
