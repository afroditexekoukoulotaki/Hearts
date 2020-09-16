package hearts.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author afrodite
 */
public class ShowDeckActionListener implements ActionListener{
    JPanel panel;
    JTextArea textInfo;

    public ShowDeckActionListener(JPanel panel, JTextArea textInfo) {
        this.panel = panel;
        this.textInfo = textInfo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.panel.setVisible(true);
        textInfo.setText("Please see the deck.");
    }
}