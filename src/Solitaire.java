/**
 * Created by james on 4/22/2015.
 */
public class Solitaire {


    public static void main(String[] args) {





//        cl.cut(50);
//        System.out.println(cl.toString());



//        Card c = new Card(Card.Suit.CLUBS, Card.CardNum.ACE, 23);
//        Card c2 = new Card(Card.Suit.CLUBS, Card.CardNum.EIGHT, 3);
////        cl.add(c2);
////        cl.add(c);
//
//        //System.out.println(cl.toString());
//        // System.out.println(cl.size());
//
//        CardList cl = new CardList();
//        cl.add(c);
//        cl.add(c2);
//        cl.add(c);
//
//        CardList cardList = new CardList();
//        cardList.add(c);
//        cardList.add(c2);
//
//        cl.link(cardList);
//        System.out.println(cl.toString());

        CardList cl = new CardList();
        cl.init();
        System.out.println(cl.size());
        cl.cut(39);
        System.out.println(cl.toString());
        System.out.println(cl.size());



    }


}
