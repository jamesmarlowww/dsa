import java.awt.*;

/**
 * Created by James on 4/21/2015.
 */
public class Card<E> {
        private Suit suit;
        private int cardIndex;
        private Color cardColor;
        private int cardValue;
        public Card<E> next;
        private boolean show;


        public Card(Suit suit, CardNum num, int cardIndex, boolean show) {
            this.suit = suit;
            this.cardValue = num.getNum();
            this.cardColor = suit.getCol();
            this.cardIndex = cardIndex;
            this.show =show;
        }

        public Card(Card card) {
            this.suit = card.getSuit();
            this.cardValue = card.getValue();
            this.cardColor = card.colour();
            this.cardIndex = card.getCardIndex();
            show = true;
        }


    public void setShow(boolean show) {
        this.show = show;
    }

    public boolean getShow() {
        return show;
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


        public boolean hasNext() {
            boolean result = false;
            if(next != null) result = true;
            return result;
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

        public boolean compareTo(Card c) {
            boolean result = false;
            if(cardValue == c.cardValue && suit == c.getSuit()) {
                result = true;
            }

            return result;
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

            public static Suit convertStringToEnum(String s) {
                Suit suit = Suit.CLUBS;

                if(s.equals("SPADES")) suit = Suit.SPADES;
                if(s.equals("DIAMONDS")) suit = Suit.DIAMONDS;
                if(s.equals("HEARTS")) suit = Suit.HEARTS;
                if(s.equals("CLUBS")) {
                    suit = Suit.CLUBS;
                }

                return suit;
            }

            public Color getCol() {
                return this.x;
            }
        }

        public enum CardNum {
            ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(
                    9), TEN(10), JACK(11), QUEEN(12), KING(13);

            private int x;

            CardNum(int index) {
                x = index;
            }

            public static CardNum convertToEnum(String s) {
                    int i = Integer.parseInt(s);
                    if (s != null) {
                        for (CardNum b : CardNum.values()) {
                            if (i == b.x) {
                                return b;
                            }
                        }
                    }
                    throw new IllegalArgumentException("string to num conversion errro");

                }


            public int getNum() {
                return this.x;
            }

        }


    }


