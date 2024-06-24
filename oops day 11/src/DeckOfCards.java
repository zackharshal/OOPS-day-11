import java.util.HashSet;
import java.util.Set;
public class DeckOfCards {
    private static final int CARDS_PER_PLAYER = 9;
    private static final int MAX_PLAYERS = 4;

    private Player[] players;
    private Set<String> dealtCards;
    private String[] mixCards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "King", "Queen", "Jack", "Ace"};
    private String[] shapes = {"Club", "Diamond", "Hearts", "Spade"};
    private int numberOfPlayers;

    DeckOfCards() {
        players = new Player[MAX_PLAYERS];
        dealtCards = new HashSet<>();
        numberOfPlayers = 0;
    }
    public void addPlayer() {
        if (numberOfPlayers >= MAX_PLAYERS) {
            System.out.println("Cannot add more players. Maximum number of players reached.");
            return;
        }
        Player newPlayer = new Player();
        players[numberOfPlayers] = newPlayer;
        distributeCards(newPlayer);
        numberOfPlayers++;
    }

    private int randomIndex(int range) {
        return (int) (Math.random() * range);
    }

    private void distributeCards(Player player) {
        int limit = 0;
        while (limit < CARDS_PER_PLAYER) {
            int randShape = randomIndex(shapes.length);
            int randNumber = randomIndex(mixCards.length);
            String card = shapes[randShape] + "-" + mixCards[randNumber];

            if (!dealtCards.contains(card)) {
                player.shapes.add(shapes[randShape]);
                player.numbers.add(mixCards[randNumber]);
                dealtCards.add(card);
                limit++;
            }
        }
    }

    public void printInfo() {
        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = players[i];
            System.out.println("Player " + (i + 1) + " has cards:");
            for (int j = 0; j < CARDS_PER_PLAYER; j++) {
                System.out.println(player.shapes.get(j) + " " + player.numbers.get(j));
            }
        }
    }

    public static void main(String[] args) {
        DeckOfCards d1 = new DeckOfCards();
        d1.addPlayer();
        d1.addPlayer();
        d1.addPlayer();
        d1.addPlayer();
        d1.printInfo();
    }
}
