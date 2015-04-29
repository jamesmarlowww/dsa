import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

/**
 * Created by James on 4/21/2015.
 */
public class CardList<E> implements AbstractList<E> {
    private CardList cards;
    private int openedIndex;
    public Card<E> tailCard;
    private int count;

    public CardList() {
        tailCard = null;
        this.cards = cards;
        count = 0;
        openedIndex = 1;
    }

    public CardList(CardList cardlist) {
        this.cards = cardlist;
        this.tailCard = cardlist.getTailCard();
        this.count = size();
    }


    public int size() {
        return count;
    }

    public boolean isEmpty() {
        if (count > 0)
            return false;
        else
            return true;
    }


    public boolean hasCard(Card card) {
        Card pointer = tailCard;

        while(pointer != null) {
            if(card.getValue() == pointer.getValue() && card.getSuit() == pointer.getSuit()) {
                return true;
            }
        }

        return false;
    }

    public void init() {
        CardList<Card> newCardList = new CardList<>();

        Card.Suit[] suit = Card.Suit.values();
        Card.CardNum[] card = Card.CardNum.values();

        int index = 1;
        for (Card.Suit s : suit) {
            for (Card.CardNum c : card) {
                Card newCard = new Card(s, c, index);
                newCardList.add(newCard);
                index++;
            }
        }
        this.tailCard = (Card<E>) newCardList.getTailCard();
        this.cards = newCardList;
        this.count = newCardList.count;

    }


    public Card getTailCard() {
        return tailCard;
    }

    public void add(Card card) {
        Card<E> current = tailCard;
        int index = 1;

        if (isEmpty()) {
            tailCard = card;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = card;
        }
        count++;

    }

    public CardList cut(int index) {
        int i = 52 - index;
        Card<E> pointer = tailCard;
        while (index > 0) {
            index--;
            pointer = pointer.next;

        }
        tailCard = pointer;
        count = i;


        return cards;
    }

    public Card moveTail() {
        Card temp = tailCard;
        tailCard = tailCard.next;
        count--;
        return temp;
    }




    //prints list with tail at the end
    @Override
    public String toString() {
        //list with tail at start
        String s = "";
        Card pointer = tailCard;
        if(tailCard ==null) return "Empty";
        int x = count;
        while (pointer != null && x > 0) {
            s += pointer + ", ";
            pointer = pointer.next;
            x--;
        }

        //reverse list, so tail is at end

        String newString ="";

        String[] splitString = s.split(" ");


        List<String> list = Arrays.asList(splitString);
        Collections.reverse(list);
        splitString = (String[]) list.toArray();

        for (String ss: splitString) {
            newString += ss;
        }


        return newString;
    }


    public void add(int i, Card newCard)
    {
        if(count<i || i < 0) return;

        if (isEmpty())
        {
            tailCard = newCard;
        }
        else
        {
            Card<E> previous = tailCard;
            Card<E> pointer = tailCard.next;
            int x = 0;
            while(i>0) {
                previous = pointer;
                pointer = pointer.next;
                i--;
            }
            newCard.next = pointer;
            previous.next = newCard;
        }
        count++;
    }


}
