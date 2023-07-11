import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Card {
    private int rank;
    private int suit;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return rank * suit;
    }

    @Override
    public String toString() {
        return "Card S" + suit + "R" + rank;
    }
}

class DeckOfCards {
    private Card[] cards;
    private int size;

    public DeckOfCards(int maxRank, int numSuits) {
        size = maxRank * numSuits;
        cards = new Card[size];
        int index = 0;
        for (int suit = 1; suit <= numSuits; suit++) {
            for (int rank = 1; rank <= maxRank; rank++) {
                cards[index] = new Card(rank, suit);
                index++;
            }
        }
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int j = random.nextInt(size);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    public int getSize() {
        return size;
    }

    public int getMinValue() {
        int minValue = Integer.MAX_VALUE;
        for (Card card : cards) {
            int value = card.getValue();
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }

    public int getMaxValue() {
        int maxValue = Integer.MIN_VALUE;
        for (Card card : cards) {
            int value = card.getValue();
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public Card[] deal(int numCards) {
        Card[] hand = new Card[numCards];
        for (int i = 0; i < numCards; i++) {
            hand[i] = cards[i];
        }
        return hand;
    }

    public int[] histogram(int numCards) {
        int[] histogram = new int[numCards * getMaxValue() + 1];
        for (int i = 0; i < 100000; i++) {
            shuffle();
            Card[] hand = deal(numCards);
            int totalValue = 0;
            for (Card card : hand) {
                totalValue += card.getValue();
            }
            histogram[totalValue]++;
        }
        return histogram;
    }

    public void printHistogram(int numCards) {
        int[] histogram = histogram(numCards);
        int maxCount = Arrays.stream(histogram).max().orElse(0);
        int scale = (int) Math.ceil(maxCount / 20.0); // Scale down the numbers

        for (int i = 0; i < histogram.length; i++) {
            if (histogram[i] != 0) {
                System.out.print(i + ": " + histogram[i] + " ");
                int asterisksCount = histogram[i] / scale;
                for (int j = 0; j < asterisksCount; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

    @Override
    public String toString() {
        String topCard = cards[0].toString();
        int minValue = getMinValue();
        int maxValue = getMaxValue();
        return "Deck of " + size + " cards: low = " + minValue + " high = " + maxValue + " top = " + topCard;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many suits? ");
        int numSuits = scanner.nextInt();

        System.out.print("How many ranks? ");
        int maxRank = scanner.nextInt();

        DeckOfCards deck = new DeckOfCards(maxRank, numSuits);
        System.out.println(deck);

        int choice;
        do {
            System.out.print("1=shuffle, 2=deal 1 hand, 3=deal 100000 times, 4=quit: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    deck.shuffle();
                    System.out.println(deck);
                    break;
                case 2:
                    System.out.print("How many cards? ");
                    int numCards = scanner.nextInt();
                    Card[] hand = deck.deal(numCards);
                    for (Card card : hand) {
                        System.out.print(card + " ");
                    }
                    System.out.println();
                    System.out.println(deck);
                    break;
                case 3:
                    System.out.print("How many cards? ");
                    numCards = scanner.nextInt();
                    deck.printHistogram(numCards);
                    System.out.println(deck);
                    break;
                case 4:
                    System.out.println("BYE!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
