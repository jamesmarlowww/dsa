package src;

import javax.smartcardio.Card;

/**
 * Created by James on 4/21/2015.
 */
public class CircleLinkList {


    private int count;
    private SingleNode<Card> tail;

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
    public E get(int i) {
        if (isEmpty() || count <= i || i < 0)
            return null;
        SingleNode<E> pointer = tail.next;

        while (i > 0) {
            pointer = pointer.next;
            i--;
        }
        return pointer.value;
    }

    public void remove(int i) {
        if (i < 0 || i > count)
            return;

        if (i == 0) {
            tail = tail.next.next;
        } else {
            SingleNode<E> previous = tail.next;
            SingleNode<E> pointer = tail.next.next;
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
    public void add(int i, E e) {
        if (i < 0 || i > count || e == null) {
            return;
        }

        if (i == 0) {
            SingleNode<E> newNode = new SingleNode(e);
            if (tail == null) // list currently empty
            {
                tail = newNode;
                tail.next = newNode;
            } else {

                // newNode.next = tail.next;
                newNode.next = tail.next;
                tail.next = (newNode);

            }

        } else {

            SingleNode newNode = new SingleNode(e);
            SingleNode<E> previous = tail.next; // previous = head
            SingleNode<E> pointer = tail.next.next; // pointer =
            // head.next

            while (i > 1) {
                previous = pointer;
                pointer = pointer.next();
                i--;
            }
            newNode.next = pointer;
            previous.next = newNode;
        }
        count++;
    }

    @Override
    public boolean contains(E e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void set(int i, E e) {
        // TODO Auto-generated method stub

    }



}
