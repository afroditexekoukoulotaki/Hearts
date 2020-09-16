package hearts.gui;
import hearts.*;

/**
 *
 * @author afrodite
 */

import javax.swing.*;
import java.awt.*;
import static java.awt.Font.PLAIN;


public class GameFrame extends JFrame{
    private JPanel center, left;
    private JPanel player1Panel, dealerPanel, player2Panel;
    private JLabel player1Label, dealerLabel, player2Label;
    private CardIcon[] cardIcons;
    private HeartsDealer dealer;
    private JMenu menu;
    private JMenuItem newGame;
    private JMenuBar menuBar;
    public static Font FONT = new Font("Lucida Calligraphy",PLAIN,14);
    
    public static final int WIDTH = 860;
    public static final int HEIGHT = 600;
    
    public GameFrame(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setTitle("Hearts");
        setVisible(true);
        setLayout(new BorderLayout());
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2 - WIDTH/2, dim.height/2 - HEIGHT/2);
    }
    
    public void setParticipants(HeartsPlayer player1, HeartsPlayer player2, HeartsDealer dealer) {
        

        this.center = new JPanel();
        this.left = new JPanel();
        add(left, BorderLayout.WEST);
        left.setLayout(new GridLayout(3, 1));
        center.setLayout(new GridLayout(4, 1));
        add(center, BorderLayout.CENTER);
        cardIcons = new CardIcon[54];
        
        menu = new JMenu("Menu");
        menu.setFont(FONT);
        newGame = new JMenuItem("New Game");
        newGame.setFont(FONT);
        menu.add(newGame);
        menuBar = new JMenuBar();
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
        
        loadCardIcons();
        // now players have the empty icon
        initializePlayerCardIcons(player1, player2); 
        
        // Player 1 Panel

        this.player1Panel = new PlayerPanel(player1);
        left.add(player1Panel);
        
        // Dealer Panel
        this.dealerPanel = new JPanel();
        this.dealerPanel.setLayout(new GridLayout(2, 1));
        this.dealerLabel = new JLabel(dealer.getName());
        dealerLabel.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        dealerLabel.setFont(FONT);
        this.dealerPanel.add(dealerLabel);
        
        JPanel gridDealer = new JPanel();
        gridDealer.setLayout(new GridLayout(2,2));
        JButton introduceDealerButton = new JButton("Introduce");
        JButton showDeckDealerButton = new JButton("Show deck");
        JButton dealDealerButton = new JButton("Deal");
        JButton decideWinnerDealerButton = new JButton("Decide Winner");
        gridDealer.add(introduceDealerButton);
        gridDealer.add(showDeckDealerButton);
        gridDealer.add(dealDealerButton);
        gridDealer.add(decideWinnerDealerButton);
        
        
        
        dealerPanel.add(gridDealer);
        left.add(dealerPanel);
        
        // Player 2 panel

        this.player2Panel = new PlayerPanel(player2);
        left.add(player2Panel);
        
        // center
        JTextArea textInfo = new JTextArea("Welcome to the Hearts game!");
        textInfo.setFont(FONT);
        
        // (1,1)
        
        CardsPanel cardsPanel1 = new CardsPanel(player1);
        center.add( cardsPanel1);
        
        // (2,1)
        JPanel scrollPanel = new JPanel();
//        scrollPanel.setLayout(new FlowLayout());
        scrollPanel.setLayout(new GridLayout(4,13));
        for (int i = 0; i < 52; i++) {
            scrollPanel.add(cardIcons[i].getLabel());
        }
        JScrollPane scrollPane = new JScrollPane(scrollPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        scrollPanel.setBounds(0, 0, 20, 20);
        ShowDeckActionListener sd = new ShowDeckActionListener(scrollPanel, textInfo);
        showDeckDealerButton.addActionListener(sd);
        scrollPanel.setVisible(false); // prepei na kripsv ta periexomena oxi to panel
        this.center.add(scrollPane);
        
        
        // (3,1)
        this.center.add(textInfo);
        
        // (4,1)
        CardsPanel cardsPanel2 = new CardsPanel(player2);
        center.add(cardsPanel2);
        
        /**
         * Adding Action Listeners
         */
        DealActionListener dealAL = new DealActionListener(player1, player2, dealer, cardsPanel1.getCardsGridPanel(), cardsPanel2.getCardsGridPanel(), textInfo);
        dealDealerButton.addActionListener(dealAL);
        
        ((PlayerPanel)this.player1Panel).addActionListeners(player1, cardsPanel1.getCardsGridPanel(), cardsPanel1.getLabel(), textInfo);
        ((PlayerPanel)this.player2Panel).addActionListeners(player2, cardsPanel2.getCardsGridPanel(), cardsPanel2.getLabel(), textInfo);

        IntroduceActionListener dAL = new IntroduceActionListener(dealer, textInfo);
        introduceDealerButton.addActionListener(dAL);
        DecideWinnerActionListener dwAL = new DecideWinnerActionListener(player1, player2, dealer, cardsPanel1.getLabel(), cardsPanel2.getLabel(), cardsPanel1.getCardsGridPanel(), cardsPanel2.getCardsGridPanel(), textInfo);
        decideWinnerDealerButton.addActionListener(dwAL);
        
        // adding Action Listener to Menu -> New game
        NewGameActionListener newGameActionListener = new NewGameActionListener(this, player1,  player2,  dealer);
        newGame.addActionListener(newGameActionListener);
        
        repaint();
        revalidate();
    }
    
    private void loadCardIcons(){
        Deck deck = new Deck();
        Card[][] cards ;
        String cardNames[] = new String[54];
        cards = deck.getCards();
        
        int k=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cardNames[k++] = cards[i][j].getcardName();
            }
        }
        cardNames[52] = "backview";
        cardNames[53] = "empty";
        
        for (int i = 0; i < 54; i++) {
            this.cardIcons[i] = new CardIcon(cardNames[i], getClass().getResource("cards/cards/" + cardNames[i] + ".png"));
        }
    }
    
    public CardIcon[] getCardIcons(){
        return this.cardIcons;
    }
    
    public void initializePlayerCardIcons(HeartsPlayer player1, HeartsPlayer player2){
        System.out.println("initializePlayerCardIcons");
        CardIcon[] cards1 = new CardIcon[5];
        CardIcon[] cards2 = new CardIcon[5];
        
        for (int i = 0; i < 5; i++) {
            cards1[i] = new CardIcon("empty", getClass().getResource("cards/cards/empty.png"));
        }
        for (int i = 0; i < 5; i++) {
            cards2[i] = new CardIcon("empty", getClass().getResource("cards/cards/empty.png"));
        }
        player1.setCardIcons(cards1);
        player2.setCardIcons(cards2);
    }

    public JPanel getCenter() {
        return center;
    }

    public void setCenter(JPanel center) {
        this.center = center;
    }

    public JPanel getLeft() {
        return left;
    }

    public void setLeft(JPanel left) {
        this.left = left;
    }

    
    
}
