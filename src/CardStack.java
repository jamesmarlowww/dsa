

/**
 * Created by James on 4/24/2015.
 */
public class CardStack<E> implements StackInterface<E> {
    private CardList stack = new CardList();


    public void add(Card c) {
        stack.add(c);
    }

    public String toString() {
        return stack.toString();
    }



}
