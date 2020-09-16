package hearts.gui;

import hearts.HeartsDealer;
import hearts.HeartsPlayer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

/**
 *
 * @author afrodite
 */
public class IntroduceActionListener implements ActionListener {
    private HeartsPlayer player;
    private HeartsDealer dealer;
    private JTextArea textInfo;
    private int intConstractor;
    
    public IntroduceActionListener(HeartsPlayer player, JTextArea textInfo) {
        this.player = player;
        this.textInfo = textInfo;
        intConstractor = 1;
    }
    
    public IntroduceActionListener(HeartsDealer dealer, JTextArea textInfo) {
        this.dealer = dealer;
        this.textInfo = textInfo;
        intConstractor = 2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (intConstractor == 1) {
            textInfo.setText(player.getInformation());
            player.introduceSelf();
        } else if (intConstractor == 2) {
            textInfo.setText(dealer.getInformation());
            dealer.introduceSelf();
        }
    }
    
}
