package hearts.gui;

import hearts.HeartsDealer;
import hearts.HeartsPlayer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author afrodite
 */
public class DecideWinnerActionListener implements ActionListener{
    private HeartsPlayer player1, player2;
    private HeartsDealer dealer;
    private JLabel label1, label2;
    private JPanel cardsGridPanel1, cardsGridPanel2;
    private JTextArea textInfo;
    
    public DecideWinnerActionListener(HeartsPlayer player1, HeartsPlayer player2, 
            HeartsDealer dealer, JLabel label1, JLabel label2, 
            JPanel cardsGridPanel1, JPanel cardsGridPanel2, JTextArea textInfo) {
        this.player1 = player1;
        this.player2 = player2;
        this.dealer = dealer;
        this.label1 = label1;
        this.label2 = label2;
        this.cardsGridPanel1 = cardsGridPanel1;
        this.cardsGridPanel2 = cardsGridPanel2;
        this.textInfo = textInfo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(player1.isCardsAreOpen() && player2.isCardsAreOpen()) {
                int prePoints1 = player1.getPoints(), prePoints2 = player2.getPoints();

                dealer.decideWinner(player1, player2);
                label1.setText("<html>Number of Hearts: 0<br>Total Points: " 
                        + player1.getPoints() + "</html>");
                label2.setText("<html>Number of Hearts: 0<br>Total Points: " 
                        + player2.getPoints() + "</html>");
                cardsGridPanel1.removeAll();
                cardsGridPanel2.removeAll();

                CardIcon[] cards1 = new CardIcon[5];
                CardIcon[] cards2 = new CardIcon[5];

                for (int i = 0; i < 5; i++) {
                    cards1[i] = new CardIcon("empty", getClass().getResource("cards/cards/empty.png"));
                    cardsGridPanel1.add(cards1[i].getLabel());
                }
                for (int i = 0; i < 5; i++) {
                    cards2[i] = new CardIcon("empty", getClass().getResource("cards/cards/empty.png"));
                    cardsGridPanel2.add(cards2[i].getLabel());
                }
                if(player1.getPoints() - prePoints1 > 0){
                    textInfo.setText("--Dealer: \n\n" + player1.getName() + " gets " 
                            + (player1.getPoints() - prePoints1) + " points!\n\nNew round begins!");
                }
                else if(player2.getPoints() - prePoints2 > 0) {
                    textInfo.setText("--Dealer: \n\n" + player2.getName() + " gets " 
                            + (player2.getPoints() - prePoints2) + " points!\n\nNew round begins!");
                }
                else {
                    textInfo.setText("--Dealer: \n\nTie!\n\nNew round begins!");
                }
            } else {
                textInfo.setText("--Dealer: \n\nReveal your cards first!");
            }
        }catch(Exception ex) {
            textInfo.setText("Cards have not been apportioned yet.\nPlease press the \"Deal\" button. ");
        }
    }
    
}
