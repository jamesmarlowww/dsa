import java.util.Scanner;

/**
 * Created by james on 4/22/2015.
 */
public class Solitaire {
    private CardDeck deck;
    private CardStack[] stacks;
    private CardList[] list;
    private static Solitaire solitaire;


    public static void main(String[] args) {
        solitaire = new Solitaire();

        showGUI(solitaire);
        startGame();


    }

    public Solitaire() {

        list = new CardList[7];
        stacks = new CardStack[4];
        deck = new CardDeck();
        deck.init();
        deck.fisherYatesShuffle();

        stacks[0] = new CardStack();
        stacks[1] = new CardStack();
        stacks[2] = new CardStack();
        stacks[3] = new CardStack();

//        for(CardList c: list) {
//            c = new CardList();
//        }
        list[0] = new CardList();
        list[1] = new CardList();
        list[2] = new CardList();
        list[3] = new CardList();
        list[4] = new CardList();
        list[5] = new CardList();
        list[6] = new CardList();


        int x = 1;
        for (int i = 0; i < 7; i++) {
            boolean reached = false;
            for (int j = i + 1; j > 0; j--) {
                list[i].add(list[i].size(), deck.takeCard());
                list[i].getTailCard().setShow(false);
                reached = true;


            }
        }
    }

    //Should create a gui then start the game
    public static void showGUI(Solitaire game) {

    }

    //Runs a loop that accepts commands until either a quit command is given or the player wins. Should attempt to perform any commands given, and prints all messages back to the user.
    public static void startGame() {
        System.out.println("/////////    Welcome to my Solitaire game    ///////// ");
        System.out.println("\n// To view all the possible moves enter 'moves' \n");

        while (true) {
            System.out.println(gameDetails());
            System.out.println("\n// Your next move: ");
            Scanner scan = new Scanner(System.in);
            String store = scan.nextLine();

            executeCommand(store);
        }
    }


    // executeCommand(String commmand): Perform whatever command indicates if the rules allow it and return a success message. If the command is invalid, return a warning instead.
    public static void executeCommand(String command) {
        String[] s = command.split(" ");

        if (sendToStack(s)) return;
        if(link(s)) return;


        switch (command) {
            case "DrawCard":
                solitaire.deck.drawCard();
                return;
            case "DeckTo 1": ///these need to be refactored
                if (checkMovePossible(0, solitaire.deck.getTailCard()))
                    solitaire.list[0].add(solitaire.list[0].size(), solitaire.deck.takeCard());
                return;
            case "DeckTo 2":
                if (checkMovePossible(1, solitaire.deck.getTailCard()))
                    solitaire.list[1].add(solitaire.list[1].size(), solitaire.deck.takeCard());
                return;
            case "DeckTo 3":
                if (checkMovePossible(2, solitaire.deck.getTailCard()))
                    solitaire.list[2].add(solitaire.list[2].size(), solitaire.deck.takeCard());
                return;
            case "DeckTo 4":
                if (checkMovePossible(3, solitaire.deck.getTailCard()))
                    solitaire.list[3].add(solitaire.list[3].size(), solitaire.deck.takeCard());
                return;
            case "DeckTo 5":
                if (checkMovePossible(4, solitaire.deck.getTailCard()))
                    solitaire.list[4].add(solitaire.list[4].size(), solitaire.deck.takeCard());
                return;
            case "DeckTo 6":
                if (checkMovePossible(5, solitaire.deck.getTailCard()))
                    solitaire.list[5].add(solitaire.list[5].size(), solitaire.deck.takeCard());
                return;
            case "DeckTo 7":
                if (checkMovePossible(6, solitaire.deck.getTailCard()))
                    solitaire.list[6].add(solitaire.list[6].size(), solitaire.deck.takeCard());
                return;
            case "Link":
                return;
            case "Send":
                return;
            case "d":
                solitaire.deck.drawCard();
                return;
            case "moves":
                System.out.println(moves());
                return;
            case "Restart":
                solitaire = new Solitaire();
                return;
            case "quit":
                System.exit(0);
                return;
            case "Quit":
                System.exit(0);
                return;
            default:
                System.out.println("\nPlease enter a valid command\n");
                return;
        }
    }

    private static boolean link(String[] s) {
        boolean result = false;

        if (s[0].equalsIgnoreCase("LINK")) {

            if (s[1].contains("CLUBS")|| s[1].contains("HEARTS")|| (s[1].contains("DIAMONDS"))|| s[1].contains("SPADES")) {
                String[] card = s[1].split("(?<=S)");
                if(card[0].equals("S")) {
                    card[0] = "SPADES";
                    card[1] = card[2];

                }
                Card c = new Card(Card.Suit.convertStringToEnum(card[0]), Card.CardNum.convertToEnum(card[1]), 1);

                int listNum = Integer.parseInt(s[2]);
                listNum--; //changes list shown number to number in list[].
                if (solitaire.list[listNum].getIndex(c)) //
                    if (checkMovePossible(listNum, c)) {
                        System.out.println("its working\n");
                        solitaire.list[listNum].link(solitaire.list[listNum].cut(solitaire.list[listNum].distanceFromTail()));
                    }

            }
        }
        return result;

    }


        private static boolean checkMovePossible ( int list, Card card){
            boolean result = false;

            Card newPos = solitaire.list[list].getTailCard();

            if (solitaire.list[list].isEmpty()) {
                return true;
            }

            if (card.colour() != newPos.colour()) {
                if (card.getValue() == newPos.getValue() - 1) {
                    result = true;
                    System.out.println("\nMove is possible. Success!\n");

                } else {
                    System.out.println("\nThe new card must be one smaller than orignal\n"+newPos.toString()+ card.toString());
                }

            } else {
                System.out.println("\nCards are the same color. Cannot move card\n");
            }

            return result;
        }

        //check if any of the list has card as tail.
        private static boolean hasCard (Card card){
            for (CardList cl : solitaire.list) {
                Card c = cl.getTailCard();
                if (card.getValue() == c.getValue())
                    //   System.out.println("first statement");
                    if (card.getSuit() == c.getSuit()) {
                        //System.out.println("second loop");
                        return true;
                    }
            }
            System.out.println("\nYou can only send a tail card to a stack\n");
            return false;
        }

        //use after hasCard(). If it is possible to add card to stack
        private static void getAndDeleteTail (Card card){
            for (CardList cl : solitaire.list) {
                Card c = cl.getTailCard();
                if (card.getValue() == c.getValue() && card.getSuit() == c.getSuit()) {
                    cl.moveTail();

                }
            }
        }

        //needs to be refactord
        private static boolean sendToStack (String[]s){
            boolean result = false;
            if (s[0].equalsIgnoreCase("Send")) {

                if (s[1].contains("CLUBS")) {
                    String[] card = s[1].split("(?<=S)");
                    Card c = new Card(Card.Suit.CLUBS, Card.CardNum.convertToEnum(card[1]), 1);
                    if (hasCard(c))
                        if (solitaire.stacks[0].add(c))
                            getAndDeleteTail(c);
                    result = true;

                }
                if (s[1].contains("SPADES")) {
                    String[] card = s[1].split("(?<=S)");
                    card[0] = "SPADES";
                    card[1] = card[2];
                    Card c = new Card(Card.Suit.SPADES, Card.CardNum.convertToEnum(card[1]), 1);
                    if (hasCard(c))
                        if (solitaire.stacks[1].add(c))
                            getAndDeleteTail(c);
                    result = true;
                }
                if (s[1].contains("HEARTS")) {
                    String[] card = s[1].split("(?<=S)");
                    Card c = new Card(Card.Suit.HEARTS, Card.CardNum.convertToEnum(card[1]), 1);
                    if (hasCard(c))
                        if (solitaire.stacks[2].add(c))
                            getAndDeleteTail(c);
                    result = true;

                }
                if (s[1].contains("DIAMONDS")) {
                    String[] card = s[1].split("(?<=S)");
                    Card c = new Card(Card.Suit.DIAMONDS, Card.CardNum.convertToEnum(card[1]), 1);
                    if (hasCard(c))
                        if (solitaire.stacks[3].add(c))
                            getAndDeleteTail(c);
                    result = true;
                }


            }
            return result;
        }

        private static String gameDetails () {
            String game = //"Card Lists: " + solitaire.deck.getTail();
                    "// CardDeck: " + solitaire.deck.isEmptyString() + "  // Open Card: " + solitaire.deck.getTail() +
                            "\n// CardStacks: " + solitaire.stacks[0].viewTop() + " " + solitaire.stacks[1].viewTop() + " " + solitaire.stacks[2].viewTop() + " " + solitaire.stacks[3].viewTop()
                            + "\n// CardLists: \n// 1: " + solitaire.list[0].toString() + "\n// 2: " + solitaire.list[1].toString() + "\n// 3: " + solitaire.list[2].toString() + "\n// 4: " + solitaire.list[3].toString() + "\n// 5: "
                            + solitaire.list[4].toString() + "\n// 6: " + solitaire.list[5].toString() + "\n// 7: " + solitaire.list[6].toString();


            return game;
        }

        public static String moves () {
            String moves = ("\n-- DrawCard: Open the next card on the card deck.\n" +
                    "\n-- DeckTo x : Move one card from the deck to the xth list. For example the command\n" +
                    "DeckTo 3 moves the card that is currently open in the card deck to the third list.\n" +
                    "\n-- Link c x: Suppose c is a revealed card in a card list, and 1 ?x? 7. This command\n" +
                    "moves all cards below and including c in the same list to the xth list. For example the\n" +
                    "command Link Spade9 6 moves all card below and including Spade6 to the 6th card\n" +
                    "list; see the screenshot below.\n" +
                    "\n-- Send c: Suppose c is a tail card of a card list. This command moves the card c to\n" +
                    "the stack that corresponds to its suit.\n" +
                    "\n-- Restart: Restart the game.\n" +
                    "\n-- Quit: Stop the game");

            return moves;

        }

    }
