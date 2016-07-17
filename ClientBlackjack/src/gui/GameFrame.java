package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import networking.MessageProcessor;
import utilities.Card;

public class GameFrame extends JFrame implements Visualizable {

	private JPanel contentPane;
	private JPanel panelDealer;
	private JPanel infoPanel;
	private JPanel panelPlayer1;
	private JPanel panelPlayer2;
	private JPanel panelPlayer3;
	private JPanel panelPlayer4;
	private JPanel buttonsContainer;
	private JPanel currentPanel;
	
	private JLabel dealerName;
	private JLabel totalDealer;
	private JLabel deckLabel;
	private JLabel infoLabel;
	private JLabel player1Name;
	private JLabel totalPlayer1;
	private JLabel player2Name;
	private JLabel totalPlayer2;
	private JLabel player3Name;
	private JLabel totalPlayer3;
	private JLabel player4Name;
	private JLabel totalPlayer4;
	
	private JLayeredPane layeredPaneDealer;
	private JLayeredPane layeredPanePlayer1;
	private JLayeredPane layeredPanePlayer2;
	private JLayeredPane layeredPanePlayer3;
	private JLayeredPane layeredPanePlayer4;
	
	private JButton hitButton;
	private JButton standButton;
	
	private ArrayList<JPanel> panels;
	
	private String currentPlayer;

	private MessageProcessor processor;
	/**
	 * Launch the application.
	 */

	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	
	public GameFrame(MessageProcessor processor) {
		
		{
			 /* Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			  setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight()); */
			  //ASTA FOLOSIM PTR FULLSCREEN
			  this.processor = processor;
			  
			  panels = new ArrayList<JPanel>();
			  setResizable(false);
			  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			  setBounds(100, 100, 1269, 756);
			  contentPane = new JPanel();
			  contentPane.setBackground(new Color(60, 179, 113));
			  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			  setContentPane(contentPane);
			  GridBagLayout gbl_contentPane = new GridBagLayout();
			  gbl_contentPane.columnWidths = new int[]{314, 314, 322, 305, 0};
			  gbl_contentPane.rowHeights = new int[]{10, 215, 181, 251, 75, 0};
			  gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			  gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			  contentPane.setLayout(gbl_contentPane);
			  
			  panelDealer = new JPanel();
			  panelDealer.setBackground(new Color(60, 179, 113));
			  panelDealer.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			  panelDealer.setLayout(null);
			  GridBagConstraints gbc_panelDealer = new GridBagConstraints();
			  gbc_panelDealer.insets = new Insets(0, 0, 5, 5);
			  gbc_panelDealer.fill = GridBagConstraints.BOTH;
			  gbc_panelDealer.gridx = 0;
			  gbc_panelDealer.gridy = 1;
			  gbc_panelDealer.gridwidth = 3;
			  contentPane.add(panelDealer, gbc_panelDealer);
			  
			  dealerName = new JLabel("Dealer");
			  dealerName.setFont(new Font("Tahoma", Font.PLAIN, 20));
			  dealerName.setBounds(380, 0, 96, 40);
			  panelDealer.add(dealerName);
			  
			  totalDealer = new JLabel("Total:");
			  totalDealer.setFont(new Font("Tahoma", Font.PLAIN, 20));
			  totalDealer.setBounds(0, 37, 185, 25);
			  panelDealer.add(totalDealer);
			  
			  layeredPaneDealer = new JLayeredPane();
			  layeredPaneDealer.setBounds(10, 75, 363, 96);
			  panelDealer.add(layeredPaneDealer);
			  
			  deckLabel = new JLabel("");
			  GridBagConstraints gbc_deckLabel = new GridBagConstraints();
			  gbc_deckLabel.insets = new Insets(0, 0, 5, 0);
			  gbc_deckLabel.gridx = 3;
			  gbc_deckLabel.gridy = 1;
			  ImageIcon im2 = new ImageIcon(getClass().getResource("/resources/back.png"));
			  Image scaleImage2 = im2.getImage().getScaledInstance(130, 170,Image.SCALE_DEFAULT);
			  ImageIcon icon2 = new ImageIcon(scaleImage2);
			  deckLabel.setIcon(icon2);
			  contentPane.add(deckLabel, gbc_deckLabel);
			  
			  infoPanel = new JPanel();
			  infoPanel.setBackground(new Color(60, 179, 113));
			  infoPanel.setLayout(null);
			  GridBagConstraints gbc_infoPanel = new GridBagConstraints();
			  gbc_infoPanel.gridwidth = 4;
			  gbc_infoPanel.insets = new Insets(0, 0, 5, 0);
			  gbc_infoPanel.fill = GridBagConstraints.BOTH;
			  gbc_infoPanel.gridx = 0;
			  gbc_infoPanel.gridy = 2;
			  contentPane.add(infoPanel, gbc_infoPanel);
			  
			  infoLabel = new JLabel("BLACKJACK");
			  infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
			  infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
			  infoLabel.setBounds(346, 31, 583, 121);
			  infoPanel.add(infoLabel);
			  
			  panelPlayer1 = new JPanel();
			  panelPlayer1.setBackground(new Color(60, 179, 113));
			  panelPlayer1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			  panelPlayer1.setLayout(null);
			  GridBagConstraints gbc_panelPlayer1 = new GridBagConstraints();
			  gbc_panelPlayer1.insets = new Insets(0, 0, 5, 5);
			  gbc_panelPlayer1.fill = GridBagConstraints.BOTH;
			  gbc_panelPlayer1.gridx = 0;
			  gbc_panelPlayer1.gridy = 3;
			  contentPane.add(panelPlayer1, gbc_panelPlayer1);
			  panels.add(panelPlayer1);
			  
			  player1Name = new JLabel("Player 1");
			  player1Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
			  player1Name.setBounds(100, 0, 100, 25);
			  panelPlayer1.add(player1Name);
			  
			  totalPlayer1 = new JLabel("Total:");
			  totalPlayer1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			  totalPlayer1.setBounds(0, 60, 185, 20);
			  panelPlayer1.add(totalPlayer1);
			  
			  layeredPanePlayer1 = new JLayeredPane();
			  layeredPanePlayer1.setBounds(12, 135, 285, 96);
			  panelPlayer1.add(layeredPanePlayer1);
			  
			  panelPlayer2 = new JPanel();
			  panelPlayer2.setBackground(new Color(60, 179, 113));
			  panelPlayer2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			  panelPlayer2.setLayout(null);
			  GridBagConstraints gbc_panelPlayer2 = new GridBagConstraints();
			  gbc_panelPlayer2.insets = new Insets(0, 0, 5, 5);
			  gbc_panelPlayer2.fill = GridBagConstraints.BOTH;
			  gbc_panelPlayer2.gridx = 1;
			  gbc_panelPlayer2.gridy = 3;
			  contentPane.add(panelPlayer2, gbc_panelPlayer2);
			  panels.add(panelPlayer2);
			  
			  player2Name = new JLabel("Player 2");
			  player2Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
			  player2Name.setBounds(100, 0, 100, 25);
			  panelPlayer2.add(player2Name);
			  
			  totalPlayer2 = new JLabel("Total:");
			  totalPlayer2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			  totalPlayer2.setBounds(0, 60, 185, 20);
			  panelPlayer2.add(totalPlayer2);
			  
			  layeredPanePlayer2 = new JLayeredPane();
			  layeredPanePlayer2.setBounds(12, 135, 285, 96);
			  panelPlayer2.add(layeredPanePlayer2);
			  
			  panelPlayer3 = new JPanel();
			  panelPlayer3.setBackground(new Color(60, 179, 113));
			  panelPlayer3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			  panelPlayer3.setLayout(null);
			  GridBagConstraints gbc_panelPlayer3 = new GridBagConstraints();
			  gbc_panelPlayer3.insets = new Insets(0, 0, 5, 5);
			  gbc_panelPlayer3.fill = GridBagConstraints.BOTH;
			  gbc_panelPlayer3.gridx = 2;
			  gbc_panelPlayer3.gridy = 3;
			  contentPane.add(panelPlayer3, gbc_panelPlayer3);
			  panels.add(panelPlayer3);
			  
			  player3Name = new JLabel("Player 3");
			  player3Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
			  player3Name.setBounds(100, 0, 100, 25);
			  panelPlayer3.add(player3Name);
			  
			  totalPlayer3 = new JLabel("Total:");
			  totalPlayer3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			  totalPlayer3.setBounds(0, 60, 185, 20);
			  panelPlayer3.add(totalPlayer3);
			  
			  layeredPanePlayer3 = new JLayeredPane();
			  layeredPanePlayer3.setBounds(12, 135, 285, 96);
			  panelPlayer3.add(layeredPanePlayer3);
			  
			  panelPlayer4 = new JPanel();
			  panelPlayer4.setBackground(new Color(60, 179, 113));
			  panelPlayer4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			  panelPlayer4.setLayout(null);
			  GridBagConstraints gbc_panelPlayer4 = new GridBagConstraints();
			  gbc_panelPlayer4.insets = new Insets(0, 0, 5, 0);
			  gbc_panelPlayer4.fill = GridBagConstraints.BOTH;
			  gbc_panelPlayer4.gridx = 3;
			  gbc_panelPlayer4.gridy = 3;
			  contentPane.add(panelPlayer4, gbc_panelPlayer4);
			  panels.add(panelPlayer4);
			  
			  player4Name = new JLabel("Player 4");
			  player4Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
			  player4Name.setBounds(100, 0, 100, 25);
			  panelPlayer4.add(player4Name);
			  
			  totalPlayer4 = new JLabel("Total:");
			  totalPlayer4.setFont(new Font("Tahoma", Font.PLAIN, 20));
			  totalPlayer4.setBounds(0, 60, 185, 20);
			  panelPlayer4.add(totalPlayer4);
			  
			  layeredPanePlayer4 = new JLayeredPane();
			  layeredPanePlayer4.setBounds(12, 135, 285, 96);
			  panelPlayer4.add(layeredPanePlayer4);
			  
			  currentPanel = panelPlayer1;
			  
			  buttonsContainer = new JPanel();
			  buttonsContainer.setBackground(new Color(60, 179, 113));
			  buttonsContainer.setLayout(null);
			  GridBagConstraints gbc_buttonsContainer = new GridBagConstraints();
			  gbc_buttonsContainer.fill = GridBagConstraints.BOTH;
			  gbc_buttonsContainer.gridx = 0;
			  gbc_buttonsContainer.gridy = 4;
			  gbc_buttonsContainer.gridwidth = 4;
			  contentPane.add(buttonsContainer, gbc_buttonsContainer);
			  
			  hitButton = new JButton("HIT");
			  
			  hitButton.setBounds(483, 0, 97, 50);
			  buttonsContainer.add(hitButton);
			  
			  standButton = new JButton("STAND");
			  standButton.setBounds(670, 0, 97, 50);
			  buttonsContainer.add(standButton);
			 
			  setHandlers();
			 
			 }

	}

	private void setHandlers()
	{
		hitButtonHandler();
		standButtonHandler();
	}
	
	private void hitButtonHandler()
	{
		hitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){

					@Override
					protected Void doInBackground() throws Exception {
						// TODO Auto-generated method stub
						processor.getClient().sendMessage("HIT");
						return null;
					}
					
				};
				worker.execute();
			}
			
		});
	}
	
	private void standButtonHandler() {
		standButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

					@Override
					protected Void doInBackground() throws Exception {
						// TODO Auto-generated method stub
						processor.getClient().sendMessage("STAND");
						processor.setMyTurn(false);
						return null;
					}

				};
				worker.execute();

			}

		});
	}
	
	private void setCurrentPanel()
	{	
		currentPanel.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		
		if (currentPlayer.equals("Dealer")) 
		{
			currentPanel = panelDealer;
		} 
		if(currentPlayer.equals("Player 1"))
		{
			currentPanel = panelPlayer1;
		}
		if(currentPlayer.equals("Player 2"))
		{
			currentPanel = panelPlayer2;
		}
		if(currentPlayer.equals("Player 3"))
		{
			currentPanel = panelPlayer3;
		}
		if(currentPlayer.equals("Player 4"))
		{
			currentPanel = panelPlayer4;
		}
		currentPanel.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
	}
	
	public void updateInfoLabel(String message)
	{
		infoLabel.setText(message);
	}
	
	public ArrayList<JPanel> getPanels()
	{
		return panels;
	}
	
	public void updatePlayersName(JPanel panel)
	{
		int x = 100;
		int y = 0;
		
		Component component = panel.getComponentAt(x, y);
		JLabel label = (JLabel)component;
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				label.setText("YOU");
			}
			
		});
		
	}
	
	@Override
	public void addCard(Card card) 
	{
		// TODO Auto-generated method stub
		String path = "/resources/" + card.toString() + ".png";
		JLabel label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		ImageIcon image = new ImageIcon(this.getClass().getResource(path));
		Image scaleImage = image.getImage().getScaledInstance(55, 75, Image.SCALE_DEFAULT);
		ImageIcon icon = new ImageIcon(scaleImage);
		label.setIcon(icon);
		JLayeredPane currentPane;
		Component component;
		int x;
		int y;
		int nrOfCards;
		if(currentPlayer.equals("Dealer"))
		{
			x = 10;
			y = 75;
			component = currentPanel.getComponentAt(x, y);
			currentPane = (JLayeredPane)component;
			nrOfCards = currentPane.getComponentCount();

			if (nrOfCards > 0) {
				label.setBounds(currentPane.getComponent(0).getX() + 15, 0, 55, 75);
			} else {
				label.setBounds(0, 0, 55, 75);
			}

			currentPane.add(label, new Integer(nrOfCards), nrOfCards);
		}
		else
		{
			x = 12;
			y = 135;
			component = currentPanel.getComponentAt(x, y);
			currentPane = (JLayeredPane)component;
			nrOfCards = currentPane.getComponentCount();

			if (nrOfCards > 0) {
				label.setBounds(currentPane.getComponent(0).getX() + 15, 0, 55, 75);
			} else {
				label.setBounds(0, 0, 55, 75);
			}

			currentPane.add(label, new Integer(nrOfCards), nrOfCards);
		}
			
		
	}

	@Override
	public void setTotal(String total) 
	{
		int x;
		int y;
		Component component;

		String newText;
		JLabel label;
		
		// TODO Auto-generated method stub
		if(currentPlayer.equals("Dealer"))
		{
			x = 0;
			y = 37;
			
			component = currentPanel.getComponentAt(x, y);
			label = (JLabel) component;
			newText = "Total: " + total;
			label.setText(newText);	
				
		}
		else
		{
			x = 0;
			y = 60;
			
			component = currentPanel.getComponentAt(x, y);
			label = (JLabel) component;
			newText = "Total: " + total;
			label.setText(newText);	
		}
		
	}

	@Override
	public void setCurrentPlayer(String currentPlayer) 
	{
		// TODO Auto-generated method stub
		this.currentPlayer = currentPlayer;
		setCurrentPanel();
		
	}



}
