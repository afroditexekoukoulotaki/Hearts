package hearts;

import hearts.gui.CardIcon;

/** 
 * Κάθε παίκτης του παιχνιδιού κούπες έχει οπωσδήποτε 5 χαρτιά στο χέρι του 
 * (πίνακας από Card 5 θέσεων ο οποίος είναι κενός φυσικά πριν το μοίρασμα) 
 * και ένα ψευδώνυμο. 
 */

public class HeartsPlayer extends Human implements CardsPlayer{
    private Card[] cards;
    private String nickname;
    private int points;
    private CardIcon[] cardIcons;
    private boolean cardsAreOpen;
    
    public HeartsPlayer(String name, String lastName, int age) {
        super(name, lastName, age);
        this.cards = new Card[5];
        this.points = 0;
        nickname = "";
        cardIcons = new CardIcon[5];
        this.cardsAreOpen = false;
    }
    
    public void setCards(Card[] cards){
        this.cards = cards;
    }
    
    public Card[] getCards(){
        return this.cards;
    }
    
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    
    public String getNickname(){
        return this.nickname;
    }
    
    public void setPoints(int points){
        this.points = points;
    }
    
    public int getPoints(){
        return this.points;
    }

    public CardIcon[] getCardIcons() {
        return cardIcons;
    }

    public void setCardIcons(CardIcon[] cardIcons) {
        this.cardIcons = cardIcons;
    }
    
    public void startOver(){
        this.cards = new Card[5];
        this.points = 0;
        cardIcons = new CardIcon[5];
    }
    
    @Override
    public void introduceSelf(){
        System.out.println(getInformation());
    }

    @Override
    public void showHand() {
        System.out.println(getName() + "'s cards:");
        for(int i = 0; i < 5; i++){
            System.out.print(getCards()[i].getcardName()+ " ");
        }
        System.out.println();
    }

    public void setCardsAreOpen(boolean cardsAreOpen) {
        this.cardsAreOpen = cardsAreOpen;
    }

    public boolean isCardsAreOpen() {
        return cardsAreOpen;
    }

   
    
}
