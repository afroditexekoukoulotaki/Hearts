package hearts;

import hearts.gui.GameFrame;

/**
 *
 * @author afrodite
 */
public class Hearts {
    
    public static void main(String[] args) {
        startGame();
        
        
    }
    
    public static void startGame(){
        HeartsPlayer afrodite = new HeartsPlayer("Afrodite", "Xekoukoulotaki", 23);
        afrodite.setInformation("Hi! I'm Afrodite and I will play hearts with my friend Johanna.");
        HeartsPlayer johanna = new HeartsPlayer("Johanna", "Pergamali", 30);
        johanna.setInformation("I'm Johanna and I will win Afrodite!");
        HeartsDealer gogo = new HeartsDealer("Gogo", "Kartsonaki", 23);
        gogo.setInformation("I'm the Dealer. Let's start the game!");
        
        GameFrame frame = new GameFrame();
        frame.setParticipants(afrodite,johanna,gogo);
    }
}
