package hearts;


public class Card {
    private String symbol, number, cardName;
    
    // card symbol number
    public Card(String cardName) {
        String[] items = cardName.split(" ");
        this.symbol = items[0];
        this.number = items[1];
        this.cardName = cardName;
        
    }
    
    public Card (String symbol, String number) {
        this.symbol = symbol;
        this.number = number;
        this.cardName = symbol + number;
    }
    
    public void setSymbol(String symbol){
        this.symbol = symbol;
    }
    
    public String getSymbol(){
        return this.symbol;
    }
    
    public void setNumber(String number){
        this.number = number;
    }
    
    public String getNumber(){
        return this.number;
    }
    
    public void setCardName(String name){
        this.cardName = name;
    }
    
    public String getcardName(){
        return this.cardName;
    }
    
    @Override
    public String toString() {
        //return this.symbol + this.number;
        return this.cardName;
    }
}
