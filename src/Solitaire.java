/**
 * Created by james on 4/22/2015.
 */
public class Solitaire {


    public static void main(String[] args) {
        CardDeck cd = new CardDeck();
        cd.init();
        Card c = new Card(Card.Suit.CLUBS, Card.CardNum.ACE, 52);
        cd.add(c.getCardIndex(),c);
        System.out.println(cd.size());



    }








}
