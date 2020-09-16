package hearts;

import java.util.Random;

public class Deck {
    /**
     * Πίνακας με τις κάρτες της τράπουλας
     */
    private Card[][] cards;
    
    
    /**
     * Γεμίζει τον πίνακα με 52 κάρτες
     */
    public Deck () {
        String types[] = {"$", "&", "#", "%"};
        String number;
        this.cards = new Card[4][13];
        
        for(int i=0; i < 13; i++){
            for(int j=0; j <4; j++){
                switch (i) {
                    case 0:
                        this.cards[j][i] = new Card(types[j], "A");
                        break;
                    case 10:
                        this.cards[j][i] = new Card(types[j], "J");
                        break;
                    case 11:
                        this.cards[j][i] = new Card(types[j], "Q");
                        break;
                    case 12:
                        this.cards[j][i] = new Card(types[j], "K");
                        break;
                    default:
                        this.cards[j][i] = new Card(types[j], Integer.toString(i+1));
                }
            }
        }
    }
    
    /**
     * game loads from file
     */
    public Deck (String path) {
        
    }
    
    public void setCards(Card[][] cards){
        this.cards = cards;
    }
    
    public Card[][] getCards(){
        return cards;
    }
    
    @Override
    public String toString(){
        String deck = "";
        for(int i=0; i < 4; i++){
            for(int j=0; j < 13; j++){
                deck += this.cards[i][j].toString() + " ";
            }
            deck += "\n";
        }
        return deck;
    }
    
    /**
     * transforms two dimension array cards to one dimension
     * @return  one dimension array with cards
     */
    public Card[] cardsToOneDimension(){
        Card[] newCards = new Card[52];
        int k=0;
        for(int i=0; i < 4; i++){
            for(int j=0; j < 13; j++){
                newCards[k++] = this.cards[i][j];
            }
        }
        return newCards;
    }
    
    /**
     * Implementing Fisher–Yates shuffle
     * @param   array 
     * @return  shuffled array with cards
     */
    public Card[] shuffleCards(Card[] array){
        Random rnd = new Random();
        for (int i = array.length - 1; i > 0; i--){
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Card a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
        return array;
    }
}
