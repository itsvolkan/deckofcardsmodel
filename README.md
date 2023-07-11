Card        
- rank: int     
- suit: int     
+ Card(rank: int, suit: int)   
+ getRank(): int           
+ getSuit(): int          
+ getValue(): int              
+ toString(): String           
    
DeckOfCards     
- cards: Card[]  
- size: int      
+ DeckOfCards(maxRank: int, numSuits: int)
+ shuffle(): void
+ getSize(): int
+ getMinValue(): int
+ getMaxValue(): int
+ deal(numCards: int): Card[]
+ histogram(numCards: int): int[]
+ toString(): String



