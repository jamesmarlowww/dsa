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
        for (int i = 0; i<7; i++) {
            for (int j = i+1; j > 0; j--) {
                list[i].add(list[i].size(), deck.takeCard());
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

        if(s[0].equalsIgnoreCase("Send")) {
            if(s[1].contains("CLUBS")) {
                String[] card = s[1].split("(?<=S)");
                Card c = new Card(Card.Suit.CLUBS, Card.CardNum.convertToEnum(card[1]), 1);
                solitaire.stacks[0].add(c);


            }
            if(s[1].contains("SPADES")) {
                String[] card = s[1].split("(?<=S)");
                card[0] = "SPADES";
                card[1] = card[2];
            }
            if(s[1].contains("HEARTS")) {
                String[] card = s[1].split("(?<=S)");
                System.out.println(card[0]);
                System.out.println(card[1]);
            }
            if(s[1].contains("DIAMONDS")) {
                String[] card = s[1].split("(?<=S)");
                System.out.println(card[0]);
                System.out.println(card[1]);
            }


            return;
        }



        switch (command) {
            case "DrawCard":
                solitaire.deck.drawCard();
                return;
            case "DeckTo 1":
                solitaire.list[0].add(solitaire.list[0].size(),solitaire.deck.takeCard());
                return;
            case "DeckTo 2":
                solitaire.list[1].add(solitaire.list[1].size(),solitaire.deck.takeCard());
                return;
            case "DeckTo 3":
                solitaire.list[2].add(solitaire.list[2].size(),solitaire.deck.takeCard());
                return;
            case "DeckTo 4":
                solitaire.list[3].add(solitaire.list[3].size(),solitaire.deck.takeCard());
                return;
            case "DeckTo 5":
                solitaire.list[4].add(solitaire.list[4].size(),solitaire.deck.takeCard());
                return;
            case "DeckTo 6":
                solitaire.list[5].add(solitaire.list[5].size(), solitaire.deck.takeCard());
                return;
            case "DeckTo 7":
                solitaire.list[6].add(solitaire.list[6].size(), solitaire.deck.takeCard());
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
