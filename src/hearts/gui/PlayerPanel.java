package hearts.gui;

import hearts.HeartsPlayer;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author afrodite
 */
public class PlayerPanel extends JPanel{
    private JLabel nameLabel;
    private JPanel flowPlayer;
    private JButton introduceButton, showHandButton;

    public PlayerPanel(HeartsPlayer player) {
        this.setLayout(new GridLayout(2, 1));
        nameLabel = new JLabel(player.getName());
        nameLabel.setFont(GameFrame.FONT);
        nameLabel.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        this.add(nameLabel);
        
        flowPlayer = new JPanel();
        flowPlayer.setLayout(new FlowLayout());
        introduceButton = new JButton("Introduce");
        showHandButton = new JButton("Show hand");
        flowPlayer.add(introduceButton);
        flowPlayer.add(showHandButton);
        flowPlayer.setName(player.getName());
        this.add(flowPlayer);
    }
    
    public void addActionListeners(HeartsPlayer player, JPanel cardsGridPanel, JLabel label, JTextArea textInfo){
        ShowHandActionListener showHandAL = new ShowHandActionListener(player, cardsGridPanel, label, textInfo);
        showHandButton.addActionListener(showHandAL);
        
        IntroduceActionListener introduceAL = new IntroduceActionListener(player, textInfo);
        introduceButton.addActionListener(introduceAL);
    }
    
}
