import java.util.Random;

/**
 * Created by james on 4/22/2015.
 */
public class CardDeck<E> implements AbstractList<E> {

    private int count;
    private Card<E> tailCard;
    private CardDeck cards;
    private static Random random;
    private Card currentCard;

    public CardDeck() {
        count = 0;
        tailCard = null;

    }

    public Card drawCard() {

        return null;

    }

    public Card takeCard() {


        return null;
    }

    public String isEmptyString() {
        String s = "";
        if (count <= 0)
            s = "Empty";
        else
            s = "Not Empty";

        return s;
    }




    public void init() {
        CardDeck cards = new CardDeck<>();

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
        this.tailCard = (Card<E>) cards.getTail();
    }



    public void fisherYatesShuffle() {
        int n = cards.count;
        for (int i = 0; i < cards.count; i++) {
            // Get a random index of the array past i.
            int random = i + (int) (Math.random() * (n - i));
            // Swap the random element with the present element.
            Card randomCard = cards.get(random);
            cards.set(random, cards.get(i));

            cards.set(i, randomCard);

        }
    }




    public Card<E> getTail() {
        return tailCard;
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

    public Card get(int i) {
        if (isEmpty() || count <= i || i < 0)
            return null;
        Card<E> pointer = tailCard.next;

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
            tailCard = tailCard.next.next;
        } else {
            Card<E> previous = tailCard.next;
            Card<E> pointer = tailCard.next.next;
            int tailCheck = i;

            while (i > 1) {
                previous = pointer;
                pointer = pointer.next;
                i--;
            }
            if (tailCheck == count - 1) // pointer is on the tail
            {
                if (previous == tailCard) // only one value in list
                    tailCard = null;
                else
                    tailCard = previous;
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

            if (tailCard == null) // list currently empty
            {
                tailCard = newCard;
                tailCard.next = newCard;
            } else {

                // newCard.next = tail.next;
                newCard.next = tailCard.next;
                tailCard.next = (newCard);

            }

        } else {


            Card<E> previous = tailCard.next; // previous = head
            Card<E> pointer = tailCard.next.next; // pointer =
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
    public void add(Card card) {
    }

    public void set(int i, Card c)
    //pre: 0<=i<size of list, e!=null
    //post: value at index i is changed to object e
    {
        if(c==null || count<=i || i < 0) return;     // index out of bounds
        Card<E> newNode = new Card(c);
        Card<E> pointer = tailCard.next.next;
        int tailCheck = i;

        if(i==0)                        // elemented added at start of list
        {
            newNode.setNext(pointer);
            tailCard.setNext(newNode);
        }
        else
        {
            Card<E> previous = tailCard.next;          //previous = head

            while(i>1)
            {
                previous = pointer;
                pointer = pointer.next;
                i--;
            }
            newNode.setNext(pointer.next);
            previous.setNext(newNode);
            if(tailCheck == count-1) tailCard = newNode;
        }
    }


    @Override
    public String toString() {



        //works i think
        String s = "";
        Card<E> sn = tailCard.next;
        int x = count;
        while (x > 0) {
            if (sn.next != null) {
                s += sn.toString() +", ";
                sn = sn.next;
            }
            x--;
        }


       return s;
    }


}
