package hearts.gui;

import hearts.HeartsDealer;
import hearts.HeartsPlayer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author afrodite
 */
public class DealActionListener implements ActionListener {
    private final HeartsDealer dealer;
    private HeartsPlayer player1, player2;
    private JPanel panel1, panel2;
    private CardIcon[] cards1, cards2;
    private JTextArea textInfo;

    public DealActionListener(HeartsPlayer player1, HeartsPlayer player2,
            HeartsDealer dealer, JPanel panel1, JPanel panel2, JTextArea textInfo) {
        this.player1 = player1;
        this.player2 = player2;
        this.dealer = dealer;
        this.panel1 = panel1;
        this.panel2 = panel2;
        this.textInfo = textInfo;
        cards1 = new CardIcon[5];
        cards2 = new CardIcon[5];
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // when deal is pressed, starts new round
            dealer.setRound(dealer.getRound() + 1);
            dealer.dealToPlayers(player1, player2);
            this.panel1.removeAll();
            this.panel2.removeAll();
            for (int i = 0; i < 5; i++){
                this.cards1[i] = new CardIcon("backview", getClass()
                        .getResource("cards/cards/backview.png"));
                this.cards2[i] = new CardIcon("backview", getClass()
                        .getResource("cards/cards/backview.png"));
            }
            for (int i = 0; i < 5; i++) {
                panel1.add(cards1[i].getLabel());
                panel2.add(cards2[i].getLabel());
            }
            textInfo.setText("--Dealer:\n\nI apportioned your cards, please reveal them.");
            // When Deal button is pressed, cards are closed
            player1.setCardsAreOpen(false);
            player2.setCardsAreOpen(false);
        } catch(Exception ex) {
            textInfo.setText("--Dealer:\n\nCards have been exhusted.");
        }
    }
    
}
