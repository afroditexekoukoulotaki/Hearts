package hearts.gui;

import hearts.HeartsDealer;
import hearts.HeartsPlayer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author afrodite
 */
public class NewGameActionListener implements ActionListener{
    HeartsPlayer player1,  player2;
    HeartsDealer dealer;
    GameFrame frame ;
    
    public NewGameActionListener(GameFrame frame, HeartsPlayer player1, HeartsPlayer player2, HeartsDealer dealer) {
        this.player1 = player1;
        this.player2 = player2;
        this.dealer = dealer;
        this.frame = frame;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        // μου πήρε 5 ωρες να καταλάβω ότι η  μέθοδος removeAll δε δουλεύει σωστά
        frame.remove(frame.getCenter());
        frame.remove(frame.getLeft());
        
        player1.startOver();
        player2.startOver();
        dealer.startOver();
        
        frame.setParticipants(player1, player2, dealer);
        
        frame.repaint();
        frame.revalidate();
    }
    
}
