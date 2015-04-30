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


    public boolean containsCard(Card card) {
        Card pointer = tailCard;
        int i = 60;
        while (pointer != null && i > 0) {
            if (card.getValue() == pointer.getValue() && card.getSuit() == pointer.getSuit()) {
                return true;
            }
            pointer = pointer.next;
            i--;
            //System.out.println(pointer.toString());
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
                Card newCard = new Card(s, c, index, true);
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

    public void addNewTail(Card card) {
        if (tailCard == null) {
            System.out.println("add new tail if");
            tailCard = card;

        } else {
            System.out.println("add new tail else");

            card.next = tailCard;
            tailCard = card;

        }
        count++;
    }

    //returns the second half of list
    //not the  real index. Index is how many cards from the tail
    public CardList cutOld(int index) {
        int i = count - index;
        Card<E> pointer = tailCard;
        while (index > 0) {
            index--;
            pointer = pointer.next;

        }
        tailCard = pointer;
        count = i;
        return cards;
    }

    public CardList cut(int i) {
        Stack<Card> stack = new Stack<>();
        CardList newList = new CardList();

        while (i >= 0) {
            stack.push(tailCard);
            moveTail();
            i--;
        }
        while (stack.size() > 0) {
            newList.addNewTail(stack.pop());
        }

        return newList;
    }


    public int distanceFromTail(Card card) {
        Card pointer = tailCard;
        int distance = 0;
        while (pointer != null && distance < count) {
            if (pointer.compareTo(card)) {
                return distance;
            }
            pointer = pointer.next;
            distance++;
        }
        return distance;


//        Card pointer = tailCard;
//        int distance =0;
//        while (pointer != null && distance < count) {
//            pointer = pointer.next;
//            distance++;
//        }
//        return distance;
    }

//    //addes the list in parametes to this class. new is added to end
//    public CardList linkMyVersion(CardList cardList) {
//        Stack<Card> stack = new Stack<>();
//        while (cardList.tailCard != null) {
//            stack.push(cardList.tailCard);
//            cardList.moveTail();
//        }
//        while (stack.size() > 0) {
//            cards.addNewTail(stack.pop());
//        }
//
//
//        return cards;
//    }

    //other list is list to add tail on.
    //removes all items from current list.
    public void link(CardList destinationList) {
        Stack<Card> stack = new Stack<>();

        int x = count;
        while (x > 0) {
            stack.push(tailCard);
            moveTail();
            x--;


        }
        System.out.println(stack.size()+"--------------------------- stack size should be 1 for one card");
        while (stack.size() > 0) {
            System.out.println(stack.get(0).toString());
            destinationList.addNewTail(stack.pop());
        }
    }

    public Card getHead() {
        Card pointer = tailCard;
        while (pointer.next != null) {
            pointer = pointer.next;
        }

        return pointer;
    }

    public boolean hasCard(Card c) {
        boolean result = false;
        Card pointer = tailCard;
        while (pointer != null) {
            if (c.compareTo(pointer)) {
                return true;
            }
            pointer = pointer.next;
            System.out.println(result);

        }
        return result;

    }


    //deletes the tail. makes .next the new tail
    public Card moveTail() {
        if (tailCard.next == null) {
            tailCard = null;
        } else {
            tailCard.next.setShow(true);
            tailCard = tailCard.next;
        }

        count--;
        return tailCard;
    }


    //prints list with tail at the end
    @Override
    public String toString() {
        //list with tail at start
        String s = "";
        Card pointer = tailCard;
        if (tailCard == null) return "Empty";
        int x = count;
        while (pointer != null && x > 0) {
            if (pointer.getShow()) {
                s += pointer + ", ";
            } else {
                s += "BACK, ";
            }

            pointer = pointer.next;
            x--;
        }

        //reverse list, so tail is at end

        String newString = "";
        String[] splitString = s.split(" ");


        List<String> list = Arrays.asList(splitString);
        Collections.reverse(list);
        splitString = (String[]) list.toArray();

        for (String ss : splitString) {
            newString += ss;
        }


        return newString;
    }


    public void add(int i, Card newCard) {
        if (count < i || i < 0) return;

        if (isEmpty()) {
            tailCard = newCard;
        } else {
            Card<E> previous = tailCard;
            Card<E> pointer = tailCard.next;
            int x = 0;
            while (i > 0) {
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
