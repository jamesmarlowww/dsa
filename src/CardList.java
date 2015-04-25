/**
 * Created by James on 4/21/2015.
 */
public class CardList<E> implements AbstractList<E> {
    private CardList cards;
    private int openedIndex;
    private Card tailCard;
    private int count;

    public CardList() {
        tailCard = null;
        this.cards = cards;
        count = 0;
        openedIndex = 1;
    }

    public CardList(CardList cardlist) {
        this.cards =cardlist;
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

    //return i .. count
//    public CardList cut(int index) {
//        Card pointer = tailCard;
//        CardList newCardList = new CardList();
//        for (int i = 1; i <= count; i++) {
//
//            pointer = pointer.next;
//            if(i >= index) {
//                System.out.println("in if loop");
//                newCardList.add(pointer);
//            }
//        }
//
//        this.tailCard = (Card<E>) newCardList.getTailCard();
//        this.cards = newCardList;
//        this.count = newCardList.count;
//        return cards;
//    }

    public Card getTailCard() {
        return tailCard;
    }

    public void add(Card card) {
        Card current = tailCard;
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

    // cuts list at i, returns larger section
    public CardList cut(int i) {
        CardList newList = new CardList();
        Card pointer = tailCard;
        if (i == 0) {

        } else {
            int x = 0;
            while (x < cards.size()) {

                if (x > i) {
                    newList.add(pointer);
                }
                pointer = pointer.next;
                x++;
            }
        }
        cards = newList;
        count = cards.size();
        tailCard = cards.getTailCard();
        return newList;
    }

    // adds the new list onto the end
//    public void link(Card<Integer> list) {
//        Card<Integer> newList = new Card();
//        int x = list.size();
//        while (x > 0) {
//            newList.add(list.get(0));
//            x--;
//        }
//    }

    public Card moveTail() {
        Card temp = tailCard;
        tailCard = tailCard.next;

        return tailCard;
    }

    @Override
    public String toString() {
        String s = "";
        Card pointer = tailCard;
        int x = count;
        while (pointer != null && x > 0) {
            s += pointer + ", ";
            pointer = pointer.next;
            x--;
        }
        return s;
    }

    public void add(int index, Card card) {
    }


}
