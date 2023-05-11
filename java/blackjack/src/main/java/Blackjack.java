import java.util.HashMap;
import java.util.Map;

public class Blackjack {

    // constants for the game
    private static final String STAND = "S";
    private static final String HIT = "H";
    private static final String WIN = "W";
    private static final String SPLIT = "P";
    private static Map<String, Integer> cards;

    public Blackjack() {
        if (cards == null) {
            cards = new HashMap<String, Integer>();
        }

        cards.put("ace", 11);
        cards.put("two", 2);
        cards.put("three", 3);
        cards.put("four", 4);
        cards.put("five", 5);
        cards.put("six", 6);
        cards.put("seven", 7);
        cards.put("eight", 8);
        cards.put("nine", 9);
        cards.put("ten", 10);
        cards.put("jack", 10);
        cards.put("queen", 10);
        cards.put("king", 10);
        cards.put("other", 0);
    }

    public int parseCard(String card) {
        return cards.get(card);
    }

    public boolean isBlackjack(String card1, String card2) {
        int total = parseCard(card1) + parseCard(card2);

        return total == 21;
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        if (isBlackjack && dealerScore != 10 && dealerScore != 11) {
            return WIN;
        } else if (!isBlackjack) {
            return SPLIT;
        } else {
            return STAND;
        }
    }

    public String smallHand(int handScore, int dealerScore) {
        if (handScore >= 17) {
            return STAND;
        } else if (handScore <= 11) {
            return HIT;
        } else if (handScore >= 12 && handScore <= 16) {
            if (dealerScore >= 7 ) {
                return HIT;
            }
            return STAND;
        }

        return STAND;
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);
        
        System.out.println("handScore: " + handScore);
        System.out.println("dealerScore: " + dealerScore);
        if (20 < handScore) {
            System.out.println("Calling large hand");
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            System.out.println("Calling small hand");
            return smallHand(handScore, dealerScore);
        }
    }
}
