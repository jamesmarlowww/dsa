import java.util.Scanner;

/**
 * Created by james on 4/22/2015.
 */
public class Solitaire {
    private CardDeck deck;
    private static CardStack[] stacks;
    private static CardList[] list;

    public Solitaire() {
        list = new CardList[6];
        stacks = new CardStack[3];
        CardDeck deck = new CardDeck();
        deck.init();
        deck.fisherYatesShuffle();

        for (CardStack cs : stacks) {
            cs = new CardStack();
        }

        for (CardList cl : list) {
            cl = new CardList();
            cl.init();
        }


    }

    public static void main(String[] args) {
        Solitaire s = new Solitaire();
        showGUI(s);
        startGame();


//        System.out.println("Hello world");
        // System.out.println(s.deck.toString());


//
//        cl.cut(50);
//        System.out.println(cl.toString());


//        Card c = new Card(Card.Suit.CLUBS, Card.CardNum.ACE, 23);
//        Card c2 = new Card(Card.Suit.CLUBS, Card.CardNum.EIGHT, 3);
////        cl.add(c2);j
////        cl.add(c);
//
////        System.out.println(cl.toString());
////         System.out.println(cl.size());
//
//        CardList cl = new CardList();
//        cl.add(c);
//        cl.add(c2);
//        cl.add(c);
//
//        CardList cardList = new CardList();
//        cardList.add(c);
//        cardList.add(c2);

//        cardList.size();


//        CardList cl = new CardList();
//        cl.init();
//        System.out.println(cl.size());
//        cl.moveTail();
//        System.out.println(cl.toString());
//        System.out.println(cl.size());


    }

    //Should create a gui then start the game
    public static void showGUI(Solitaire game) {

    }

    //Runs a loop that accepts commands until either a quit command is given or the player wins. Should attempt to perform any commands given, and prints all messages back to the user.
    public static void startGame() {
        System.out.println("/////////    Welcome to my Solitaire game    ///////// ");
        System.out.println("\n// To view all the possible moves enter 'moves'");

        while(true) {
            Scanner scan = new Scanner(System.in);
            String store = scan.nextLine();
            System.out.println(gameDetails());
            executeCommand(store);
        }



    }



    // executeCommand(String commmand): Perform whatever command indicates if the rules allow it and return a success message. If the command is invalid, return a warning instead.
    public static void executeCommand(String command) {

        switch(command) {
            case "DrawCard":
            case "DeckTo":
            case "Link":
            case "Send":
            case "moves": System.out.println(moves()); return;
            case "Restart": startGame(); return;
            case "quit": System.exit(0); return;
            case "Quit": System.exit(0); return;
            default : System.out.println("Please enter a valid command\n");
        }


    }


    private static String gameDetails() {
        String game = "";


        return game;
    }

    public static String moves() {
        String moves = (  "\n-- DeckTo x : Move one card from the deck to the xth list. For example the command\n" +
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
