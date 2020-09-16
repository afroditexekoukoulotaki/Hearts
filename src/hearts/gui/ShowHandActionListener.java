package hearts.gui;

import hearts.HeartsDealer;
import hearts.HeartsPlayer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ShowHandActionListener implements ActionListener{
    private JPanel panel;
    private HeartsPlayer player;
    private JLabel label;
    private JTextArea textInfo;
    
    public ShowHandActionListener(HeartsPlayer player, JPanel panel, 
            JLabel label, JTextArea textInfo ) {
        this.player = player;
        this.panel = panel;
        this.label = label;
        this.textInfo = textInfo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int numberOfHearts = 0;
        
        try {
            this.panel.removeAll();
            for (int i = 0; i < 5; i++) {
                panel.add(player.getCardIcons()[i].getLabel());
            }

            // we count the hearts of the player
            for(int i=0; i < 5; i++){
                if(player.getCards()[i].getSymbol().equals("#")){
                    numberOfHearts++;
                }
            }
            label.setText("<html>Number of Hearts: " + numberOfHearts +  "<br>Total Points: " + player.getPoints() + "</html>");
            textInfo.setText("--" + player.getName() + "\n\nI have " + numberOfHearts + " hearts!");
            player.showHand();
            
            player.setCardsAreOpen(true);
        } catch (NullPointerException exception) {
            textInfo.setText("Cards have not been apportioned yet.\nPlease press the \"Deal\" button. ");
        }
    }
    
}
