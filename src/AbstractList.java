/**
 * Created by James on 4/21/2015.
 */
public interface AbstractList <E> {

    public int size();

    public boolean isEmpty();

    public Card get(int index);

    public void add(int index, Card card);


}
