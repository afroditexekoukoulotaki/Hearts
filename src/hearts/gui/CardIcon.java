package hearts.gui;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author afrodite
 */
public class CardIcon extends ImageIcon{
    private String name;
    private JLabel label;
    
    public CardIcon(String name){
        this.name = name;
        label = new JLabel();
        this.label.setIcon(this); // not sure
    }
    
    public CardIcon(URL location) {
        super(location);
        name = "";
        label = new JLabel();
        this.label.setIcon(this);
    }
    
    public CardIcon(String name, URL location) {
        super(location);
        this.name = name;
        label = new JLabel();
        this.label.setIcon(this);
    }
    
    public CardIcon(String name, String filename) {
        super(filename);
        this.name = name;
        label = new JLabel();
        this.label.setIcon(this);
    }
    
    public JLabel getLabel(){
        return this.label;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
}
