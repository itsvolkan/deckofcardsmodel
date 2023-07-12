# Deck of Cards

This is a simple Java program that simulates a deck of playing cards. It allows you to shuffle the deck, deal hands of cards, and generate a histogram of the results.

## How to Use

1. Make sure you have Java installed on your system.
2. Clone this repository or download the source code.
3. Open a command prompt or terminal and navigate to the directory containing the source code files.
4. Compile the code by running the following command:
   ```
   javac Main.java
   ```
5. Run the program by executing the following command:
   ```
   java Main
   ```
6. Follow the instructions displayed on the screen to interact with the program.
   - Enter the number of suits and the maximum rank for the deck of cards.
   - Choose options to shuffle the deck, deal hands, generate a histogram, or quit the program.
   - If dealing hands or generating a histogram, specify the number of cards in each hand.

## Program Features

- Shuffle the deck of cards: Randomly reorders the cards in the deck.
- Deal one hand: Selects a specified number of cards from the top of the deck.
- Deal 100,000 times and generate a histogram: Simulates dealing hands 100,000 times and creates a histogram of the total values of the cards in each hand. The histogram is displayed with asterisks to represent the quantities, scaled down for better readability.

## UML Class Diagram

The program uses two classes:
- `Card`: Represents a playing card with a rank and a suit.
- `DeckOfCards`: Represents a deck of cards and provides methods to shuffle, deal, and generate a histogram.

Here's a simplified UML class diagram representing the relationship between the classes:

```
+--------------+          +----------------+
|     Card     |          |  DeckOfCards   |
+--------------+          +----------------+
| - rank: int  |          | - cards: Card[]|
| - suit: int  |          | - size: int    |
+--------------+          +----------------+
| + Card(rank: int, suit: int) |
| + getRank(): int              |
| + getSuit(): int              |
| + getValue(): int             |
| + toString(): String          |
+--------------+          |  + shuffle(): void          |
                           |  + getSize(): int           |
                           |  + getMinValue(): int       |
                           |  + getMaxValue(): int       |
                           |  + deal(numCards: int): Card[] |
                           |  + histogram(numCards: int): int[] |
                           |  + printHistogram(numCards: int): void |
                           |  + toString(): String       |
                           +-----------------------------+
```

## Dependencies

The program does not have any external dependencies. It is written in pure Java and uses only the standard Java libraries.

## License

This project is licensed under the MIT License. 

Feel free to explore, modify, and use the code as per the terms of the license.

## Contribution

Contributions to this project are welcome. If you find any issues or want to suggest improvements, please open an issue or submit a pull request.

## Author

This program was created by Volkan Aydogdu. You can contact me at itswolkan@gmail.com for any questions or feedback.

Enjoy playing with the deck of cards!
