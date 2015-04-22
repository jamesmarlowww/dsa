/**
 * Created by James on 4/21/2015.
 */
public class CircleLinkList<E> implements AbstractList<E>{


    private int count;
    private Card<E> tail;


    public CircleLinkList() {
        count = 0;
        tail = null;
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
        Card pointer = tail.getNext();

        while (i > 0) {
            pointer = pointer.getNext();
            i--;
        }
        return pointer.getCard();
    }


    public void remove(int i) {
        if (i < 0 || i > count)
            return;

        if (i == 0) {
            tail = tail.getNext().getNext();
        } else {
            Card<E> previous = tail.getNext();
            Card<E> pointer = tail.getNext().getNext();
            int tailCheck = i;

            while (i > 1) {
                previous = pointer;
                pointer = pointer.getNext();
                i--;
            }
            if (tailCheck == count - 1) // pointer is on the tail
            {
                if (previous == tail) // only one value in list
                    tail = null;
                else
                    tail = previous;
            }
            previous = previous.getNext();
            previous = (pointer.getNext());
        }
        count--;

    }

    @Override
    public void add(int i, Card card) {
        if (i < 0 || i > count || card == null) {
            return;
        }

        if (i == 0) {
            Card<E> newNode = new Card<>(card);
            if (tail == null) // list currently empty
            {
                tail = newNode;
                tail = tail.getNext();
                tail = newNode;
            } else {

                newNode = newNode.getNext();
                newNode = tail.getNext();

                tail = tail.getNext();
                tail = (newNode);

            }

        } else {

            Card newNode = new Card(card);
            Card<E> previous = tail.getNext(); // previous = head
            Card<E> pointer = tail.getNext().getNext(); // pointer =
            // head.next

            while (i > 1) {
                previous = pointer;
                pointer = pointer.getNext();
                i--;
            }
            newNode = newNode.getNext();
            newNode= pointer;
            previous = previous.getNext();
            previous = newNode;
        }
        count++;
    }

    public void add(Card card) {
        Card pointer = tail;
        Card newCard = card;
        if(isEmpty()) {
            tail = newCard;
        } else {
            while(pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer = pointer.getNext();
            pointer = newCard;
        }

        count++;



    }


    @Override
    public String toString() {
        String s = "";
        Card pointer = tail;

        do {

            pointer = pointer.getNext();
        }
        while(pointer != tail);
        return s;
    }




}
