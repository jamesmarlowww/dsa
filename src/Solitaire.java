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
        System.out.println(deck.toString());
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



//        for (int i = 0; i < 1; i++) {
//            list[0].add(list[0].size(), deck.get(0));
//           deck.remove(0);
//        }
//
//        for (int i = 0; i < 2; i++) {
//            list[1].add(list[1].size(), deck.get(3));
//            deck.remove(3);
//        }
//
//        for (int i = 0; i < 3; i++) {
//            list[2].add(list[2].size(), deck.get(0));
//            deck.remove(0);
//        }
//
//        for (int i = 0; i < 4; i++) {
//            list[3].add(list[3].size(), deck.get(5));
//            deck.remove(5);
//        }
//
//        for (int i = 0; i < 5; i++) {
//            list[4].add(list[4].size(), deck.get(0));
//            deck.remove(0);
//        }
//        for (int i = 0; i < 6; i++) {
//            list[5].add(list[5].size(), deck.get(0));
//            deck.remove(0);
//        }
//        for (int i = 0; i < 7; i++) {
//            list[6].add(list[6].size(), deck.get(0));
//            deck.remove(0);
//        }


     //   doesnt work
        int x = 1;
        for (int i = 0; i<7; i++) {
            for (int j = i+1; j > 0; j--) {
                list[i].add(list[i].size(), deck.takeCard());

                x++;

            }
        }

//        System.out.println(deck.toString());
//
//        while (deck.size() > 0) {
//            System.out.println(deck.takeCard());
//            deck.takeCard();
//        }


//working
//        for (int i = 0; i<7; i++) {
//            for (int j = i+1; j > 0; j--) {
//
//            }
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

        String[] strArray = new String[] {command};

        switch (command) {
            case "DrawCard":
                solitaire.deck.drawCard();
                return;
            case "DeckTo 1":
                solitaire.list[0].add(solitaire.deck.takeCard());
                return;
            case "DeckTo 2":
                solitaire.list[1].add(solitaire.deck.takeCard());
                return;
            case "DeckTo 3":
                solitaire.list[2].add(solitaire.deck.takeCard());
                return;
            case "DeckTo 4":
                solitaire.list[3].add(solitaire.deck.takeCard());
                return;
            case "DeckTo 5":
                solitaire.list[4].add(solitaire.deck.takeCard());
                return;
            case "DeckTo 6":
                solitaire.list[5].add(solitaire.deck.takeCard());
                return;
            case "DeckTo 7":
                solitaire.list[6].add(solitaire.deck.takeCard());
                return;
            case "Link":
            case "Send":
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
                System.out.println("Please enter a valid command\n");
        }


    }


    private static String gameDetails() {
        String game = //"Card Lists: " + solitaire.deck.getTail();
                "// CardDeck: " + solitaire.deck.isEmptyString() + "  // Open Card: " + solitaire.deck.getTail() +
                        "\n// CardStacks: " + solitaire.stacks[0].viewTop() + " " + solitaire.stacks[1].viewTop() + " " + solitaire.stacks[2].viewTop() + " " + solitaire.stacks[3].viewTop()
                        + "\n// CardLists: \n// 1: " + solitaire.list[0].toString() + "\n// 2: " + solitaire.list[1].toString() + "\n// 3: " + solitaire.list[2].toString() + "\n// 4: " + solitaire.list[3].toString() + "\n// 5: "
                        + solitaire.list[4].toString() + "\n// 6: " + solitaire.list[5].toString() + "\n// 7: " + solitaire.list[6].toString();


        return game;
    }

    public static String moves() {
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
