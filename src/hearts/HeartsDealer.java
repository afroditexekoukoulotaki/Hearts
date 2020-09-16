package hearts;

import hearts.gui.CardIcon;


public class HeartsDealer extends Human implements CardsDealer {
    
    private final Deck deck;
    private Card[] shuffledCards;
    private int round;
    
    public HeartsDealer(String name, String lastName, int age) {
        super(name, lastName, age);
        this.deck = new Deck();
        this.round = 0;
        shuffling();
    }

    public HeartsDealer() {
        this.deck = null;
        this.setInformation("no info");
    }
    
    @Override
    public void introduceSelf(){
        System.out.println(getInformation());
    }
    
    /**
     * print 52 shuffled cards
     */
    @Override
    public void showDeck(){
        System.out.println("Shuffled deck:");
        for(int i=0; i < 52; i++){
            System.out.print(this.shuffledCards[i].toString() + " ");
        }
        System.out.println();
    }
    
    /** 
     * Για να βάλουμε στην μεταβλητή x έναν τυχαίο αριθμό από το 0 έως το 51 
     * χρησιμοποιούμε την εντολή: int x = (int) ( Math.random() * 52 );
     * @return  μία τυχαία κάρτα από την τράπουλα.
     */
    @Override
    public Card dealRandomCard(){
        
        Card[][] cards;
        byte random1, random2;
        
        cards = this.deck.getCards();
        random1 = (byte) ( Math.random() * 13 );
        random2 = (byte) ( Math.random() * 4 );
        
        return cards[random2][random1];
    }
    
    /** 
     * μοιράζει χαρτιά στους παίκτες.
     * Ο dealer να μοιράζει τα χαρτιά εναλλάξ στους 2 παίκτες και όχι 5 στον 
     * ένα πρώτα και μετά 5 στον άλλον. Ο dealer να ανακατεύει την τράπουλα 
     * και μετά να μοιράζει στους παίκτες τα 10 πρώτα φύλλα και όχι να μοιράζει 
     * 10 τυχαία φύλλα μέσα από την τράπουλα (κα πρέπει να ψάξετε στο API).
     */
    @Override
    public void dealToPlayers(HeartsPlayer player1, HeartsPlayer player2){
        
        Card[] cards1 = new Card[5], cards2 = new Card[5];
        CardIcon[] cardsIcon1 = new CardIcon[5];
        CardIcon[] cardsIcon2 = new CardIcon[5];
        
        // distributing cards to two players alternately
        // in each round
        int k = 0;
        for(int i = (this.round -1) * 10; i < ((this.round -1) * 10) + 10; i+=2){
            cards1[k] = this.shuffledCards[i];
            cards2[k] = this.shuffledCards[i+1];
            k++;
        }
        player1.setCards(cards1);
        player2.setCards(cards2);
        
        for (int i = 0; i < 5; i++) {
            cardsIcon1[i] = new CardIcon(player1.getCards()[i].getcardName(), 
                    getClass().getResource("gui/cards/cards/" + player1.getCards()[i].getcardName() + ".png"));
        }
        for (int i = 0; i < 5; i++) {
            cardsIcon2[i] = new CardIcon(player2.getCards()[i].getcardName(), 
                    getClass().getResource("gui/cards/cards/" + player2.getCards()[i].getcardName() + ".png"));
        }
        player1.setCardIcons(cardsIcon1);
        player2.setCardIcons(cardsIcon2);
    }
    
    /**
     * αποφασίζει τον νικητή του παιχνιδιού
     * @param player1
     * @param player2 
     */
    @Override
    public void decideWinner(HeartsPlayer player1, HeartsPlayer player2){
        int hearts1 = 0, hearts2 = 0;
        
        // we count the hearts of each player
        for(int i=0; i < 5; i++){
            
            if(player1.getCards()[i].getSymbol().equals("#")){
                hearts1++;
            }
            if(player2.getCards()[i].getSymbol().equals("#")){
                hearts2++;
            }
        }
        // 10 points more 
        if(hearts1 > hearts2){
            player1.setPoints( player1.getPoints() + (hearts1 - hearts2) * 10 );
        }
        else if(hearts1 < hearts2){
            player2.setPoints( player2.getPoints() +  (hearts2 - hearts1) * 10 );
        }
    }
    
    public void endRound(HeartsPlayer player1, HeartsPlayer player2){
        
    }
    
    public final void shuffling(){
        Card[] cardsOne;
        
        cardsOne = this.deck.cardsToOneDimension(); // now we have 52 cards to one dimension array
        this.shuffledCards = this.deck.shuffleCards(cardsOne); // now we hane 52 shuffled cards
        
        showDeck();
    }
    
    public void setRound(int round){
        this.round = round;
    }
    
    public int getRound(){
        return this.round;
    }
    
    public void startOver(){
        shuffling();
        this.round = 0;
    }
    
}
