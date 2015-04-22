/**
 * Created by james on 4/22/2015.
 */
public class main {

    public static void main(String[] args) {
        CircLinkList<Card> cll = new CircLinkList<>();

        Card.Suit[] suit = Card.Suit.values();
        Card.CardNum[] card = Card.CardNum.values();

        int index =0;
        for (Card.Suit s : suit) {
            for (Card.CardNum c : card) {
                Card newCard = new Card(s, c, index);
                cll.add(newCard.getCardIndex(), newCard);
                index++;
            }
        }

        System.out.println(cll.toString());

}
}
