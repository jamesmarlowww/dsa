

/**
 * Created by James on 4/24/2015.
 */
public class CardStack<E> implements StackInterface<E> {
    private CardList stack;
    private int count;

    public CardStack() {
        stack = new CardList();
        count = 0;
    }

    public boolean add(Card c) {
        boolean result = false;
        if(c.getValue()==count+1) {
            stack.add(c);
            count++;
            System.out.println("\nSuccess!\n");
            result = true;
        } else {
            System.out.println("\nTry again, you must add cards in ascending order\n");
        }
        return result;
    }

    public String toString() {
        return stack.toString();
    }

    public String viewTop() {
        String s = "Empty";
        try{
            if(stack.tailCard.toString() == null) {
                return s;
            } else {

            }
        } catch (NullPointerException n) {
            return s;
        }

        return stack.tailCard.toString();
    }



}
