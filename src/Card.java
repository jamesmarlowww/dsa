import java.awt.*;

/**
 * Created by James on 4/21/2015.
 */
public class Card<E> {
        private Suit suit;
        private int cardIndex;
        private Color cardColor;
        private int cardValue;
        private Card<E> next;

        public Card(Suit suit, CardNum num, int cardIndex) {
            this.suit = suit;
            this.cardValue = num.getNum();
            this.cardColor = suit.getCol();
            this.cardIndex = cardIndex;
        }

        public Card(Card card) {
            this.suit = card.getSuit();
            this.cardValue = card.getValue();
            this.cardColor = card.colour();
            this.cardIndex = card.getCardIndex();
        }

        public Card getNext() {
            return next;
        }

        public int getCardIndex() {
            return cardIndex;
        }

        public void setNext(Card next) {
            this.next = next;
        }

        /**
         * Returns the card’s suit
         */
        public Suit getSuit() {
            return suit;
        }

        /**
         * Returns the card’s value
         */
        public int getValue() {
            return cardValue;
        }


        public Card<E> getCard() {
            return Card.this;
        }

        /**
         * The colour of the card is ‘red’ if this card is a heart or diamond, and
         ‘black’ otherwise.
         */
        public Color colour() {
            return cardColor;
        }


        /**
         * toString: Returns a string representation of this card, including its suit and rank.
         Example: Ace of clubs would be ClubA, ten of diamonds would be Diamond10, and
         queen of spades would be SpadeQ.
         * @return
         */
        @Override
        public String toString() {
            return ""+suit+cardValue;
        }

        /**
         * paintThis(Graphics g) Draws the card. In the simple GUI, this should draw a
         Rectangle, with the string representation of the card written in the colour corresponding
         to the colour of the card (either black or red). (You don’t have to make
         it pretty)
         * @param g
         */
        public void paintThis(Graphics g) {

        }

        public enum Suit {
            CLUBS(Color.black), SPADES(Color.black), HEARTS(Color.RED), DIAMONDS(
                    Color.RED);

            private Color x;

            Suit(Color c) {
                this.x = c;
            }

            public Color getCol() {
                return this.x;
            }
        }

        public enum CardNum {
            ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(
                    9), TEN(10), JACK(11), QUEEN(12), KING(13);

            int x;

            CardNum(int index) {
                x = index;
            }

            public int getNum() {
                return this.x;
            }

        }


    }


