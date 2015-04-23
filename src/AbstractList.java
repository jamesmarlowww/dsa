/**
 * Created by James on 4/21/2015.
 */
public interface AbstractList <E> {

    public int size();

    public boolean isEmpty();

    public void add(int index, Card card);

    public void add(Card card);

    public String toString();


}
