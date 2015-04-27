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
        System.out.println("add");

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

    public void test(CardList cardList) {
        System.out.println("dfjaklsjkf ajksdfklsajf");
    }

//    public void link(CardList cardList) {
//        System.out.println("sdfdsf");
//        int x = cardList.count;
//
//        while(x>0) {
//            System.out.println("sdfdsf");
//            cards.add(cardList.tailCard);
//            cardList.tailCard = cardList.tailCard.next;
//            tailCard = tailCard.next;
//
//            x--;
//        }

       // return cards;
//    }


    public Card moveTail() {
        tailCard = tailCard.next;
        count--;
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

    public void add(int i, Card newCard)
    {
        if(count<i || i < 0) return;

        //Card<E> newCard = c;
        if (isEmpty())
        {
            // no nodes in the list so add newCard at start
            tailCard = newCard;
        }
        else
        {
            Card<E> previous = tailCard;
            Card<E> pointer = tailCard.next;
            int x = 0;
            while(i>0)
            {

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
