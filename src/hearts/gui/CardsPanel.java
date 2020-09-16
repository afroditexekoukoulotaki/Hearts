package hearts.gui;
import hearts.HeartsPlayer;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author afrodite
 */


public class CardsPanel extends JPanel{
    JPanel cardsGridPanel;
    JLabel label;
    
    public CardsPanel(HeartsPlayer player) {
        this.setLayout(new BorderLayout());
        cardsGridPanel = new JPanel();
        cardsGridPanel.setLayout(new GridLayout(1,5));
        
        for (int i = 0; i < 5; i++) {
            cardsGridPanel.add((player.getCardIcons()[i]).getLabel());
        }
        this.add(cardsGridPanel, BorderLayout.CENTER);
        label = new JLabel("<html>Number of Hearts: 0<br>Total Points: " 
                + player.getPoints() + "</html>");
        label.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        
        /**
         * This transparent border helps with margin
         */
        Border matteBorder = BorderFactory.createMatteBorder(
                0, 20, 0, 20, new Color(0, 0, 0, 0f));
        label.setBorder(matteBorder);
        label.setFont(GameFrame.FONT);
        this.add(label, BorderLayout.EAST);
    }

    public JPanel getCardsGridPanel() {
        return cardsGridPanel;
    }

    public JLabel getLabel() {
        return label;
    }
    
}
