

/**
 * Created by James on 4/24/2015.
 */
public class CardStack<E> implements StackInterface<E> {
    private CardList stack;

    public CardStack() {
        stack = new CardList();
    }

    public void add(Card c) {
        stack.add(c);
    }

    public String toString() {
        return stack.toString();
    }

    public String viewTop() {
        String s = "Empty";
        try{
            if(stack.tailCard.toString() == null) return s;
        } catch (NullPointerException n) {
            return s;
        }

        if(stack.tailCard.toString() == null) return s;
        else return stack.tailCard.toString();
    }



}
