package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class GameFrame extends JFrame{
	

	private JPanel contentPane;
	private JPanel panelDealer,panelPlayer1,panelPlayer2,panelPlayer3,panelPlayer4,buttonsContainer;
	private JLabel player1Name,label,totalPlayer1,player2Name,totalPlayer2,totalPlayer3,player3Name,totalPlayer4,player4Name;
	private GridBagLayout gbl_contentPane;
	private JLayeredPane layeredPane_1,layeredPane_2,layeredPane_3,layeredPane_4;
	private GridBagConstraints gbc_panelDealer,gbc_panelPlayer1,gbc_panelPlayer2,gbc_panelPlayer3,gbc_panelPlayer4,gbc_buttonsContainer;
	private JButton hitButton,standButton;
	private ImageIcon im;
	private int turn = 0;
	private int setBound;
	private boolean noCards = true;
	private String currentPlayer;
	
	
	
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	
	public GameFrame() {
		background();
        jPanels();
		buttons();
		
	}
	
	   private void background(){
		   /*Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());*/ 
			//ASTA FOLOSIM PTR FULLSCREEN
			//Frame frame = new Frame();
			/*ImageIcon frameIcon = new ImageIcon("C:\\Users\\Gabriela\\Pictures\\2016\\Saved Pictures\\download.jpg");
			frame.setIconImage(frameIcon.getImage());*/
			//ICON CHANGE
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1269, 756);
			contentPane = new JPanel();
			contentPane.setForeground(Color.BLACK);
			contentPane.setBackground(new Color(60, 179, 113));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			gbl_contentPane = new GridBagLayout();
			gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_contentPane.rowHeights = new int[]{184, 195, 255, 75, 0};
			gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
			contentPane.setLayout(gbl_contentPane);
	   }
	   
	   private void jPanels(){
			panelDealer();
			panelPlayer1();
			panelPlayer2();
			panelPlayer3();
			panelPlayer4();
			panelButtons();
			
	   }
	
	
	    private void panelDealer(){
	    	panelDealer = new JPanel();
			panelDealer.setBackground(new Color(60, 179, 113));
			panelDealer.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panelDealer.setLayout(null);
			gbc_panelDealer = new GridBagConstraints();
			gbc_panelDealer.insets = new Insets(0, 0, 5, 0);
			gbc_panelDealer.fill = GridBagConstraints.BOTH;
			gbc_panelDealer.gridx = 0;
			gbc_panelDealer.gridy = 0;
			gbc_panelDealer.gridwidth = 4;
			contentPane.add(panelDealer, gbc_panelDealer);
	    }
	    
	    
	    
	    
	    private void panelPlayer1(){
	    	panelPlayer1 = new JPanel();
	    	panelPlayer1.setForeground(Color.BLACK);
			panelPlayer1.setBackground(new Color(60, 179, 113));
			panelPlayer1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
			panelPlayer1.setLayout(null);
			gbc_panelPlayer1 = new GridBagConstraints();
			gbc_panelPlayer1.insets = new Insets(0, 0, 5, 5);
			gbc_panelPlayer1.fill = GridBagConstraints.BOTH;
			gbc_panelPlayer1.gridx = 0;
			gbc_panelPlayer1.gridy = 2;
			contentPane.add(panelPlayer1, gbc_panelPlayer1);
			
		    player1Name = new JLabel("Player 1");
			player1Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
			player1Name.setBounds(94, 0, 100, 25);
			panelPlayer1.add(player1Name);
			
			layeredPane_1 = new JLayeredPane();
			layeredPane_1.setBounds(10, 165, 287, 78);
			panelPlayer1.add(layeredPane_1);
			
			totalPlayer1 = new JLabel("Total:");
			totalPlayer1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			totalPlayer1.setBounds(0, 60, 78, 16);
			panelPlayer1.add(totalPlayer1);
	    }
	    
	    
	    
	    
	    
	    private void panelPlayer2(){
	    	panelPlayer2 = new JPanel();
			panelPlayer2.setBackground(new Color(60, 179, 113));
			panelPlayer2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panelPlayer2.setLayout(null);
			gbc_panelPlayer2 = new GridBagConstraints();
			gbc_panelPlayer2.insets = new Insets(0, 0, 5, 5);
			gbc_panelPlayer2.fill = GridBagConstraints.BOTH;
			gbc_panelPlayer2.gridx = 1;
			gbc_panelPlayer2.gridy = 2;
			contentPane.add(panelPlayer2, gbc_panelPlayer2);
			
			player2Name = new JLabel("Player 2");
			player2Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
			player2Name.setBounds(102, 0, 99, 25);
			panelPlayer2.add(player2Name);
			totalPlayer2 = new JLabel("Total:");
			totalPlayer2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			totalPlayer2.setBounds(0, 60, 78, 16);
			panelPlayer2.add(totalPlayer2);
			
			layeredPane_2 = new JLayeredPane();
			layeredPane_2.setBounds(10, 165, 287, 78);
			panelPlayer2.add(layeredPane_2);
			
	    }
	    
	    
	    
	    
	    private void panelPlayer3(){
			panelPlayer3 = new JPanel();
			panelPlayer3.setBackground(new Color(60, 179, 113));
			panelPlayer3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panelPlayer3.setLayout(null);
			gbc_panelPlayer3 = new GridBagConstraints();
			gbc_panelPlayer3.insets = new Insets(0, 0, 5, 5);
			gbc_panelPlayer3.fill = GridBagConstraints.BOTH;
			gbc_panelPlayer3.gridx = 2;
			gbc_panelPlayer3.gridy = 2;
			contentPane.add(panelPlayer3, gbc_panelPlayer3);
			totalPlayer3 = new JLabel("Total:");
			totalPlayer3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			totalPlayer3.setBounds(0, 60, 78, 16);
			panelPlayer3.add(totalPlayer3);
			
			player3Name = new JLabel("Player 3");
			player3Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
			player3Name.setBounds(105, 0, 98, 25);
			panelPlayer3.add(player3Name);
			
			layeredPane_3 = new JLayeredPane();
			layeredPane_3.setBounds(10, 165, 287, 78);
			panelPlayer3.add(layeredPane_3);    	
	    }
	    
	    
	    
	    
	    private void panelPlayer4(){
	    	panelPlayer4 = new JPanel();
			panelPlayer4.setBackground(new Color(60, 179, 113));
			panelPlayer4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panelPlayer4.setLayout(null);
			gbc_panelPlayer4 = new GridBagConstraints();
			gbc_panelPlayer4.insets = new Insets(0, 0, 5, 0);
			gbc_panelPlayer4.fill = GridBagConstraints.BOTH;
			gbc_panelPlayer4.gridx = 3;
			gbc_panelPlayer4.gridy = 2;
			contentPane.add(panelPlayer4, gbc_panelPlayer4);
			totalPlayer4 = new JLabel("Total:");
			totalPlayer4.setFont(new Font("Tahoma", Font.PLAIN, 20));
			totalPlayer4.setBounds(0, 60, 78, 16);
			panelPlayer4.add(totalPlayer4);
			
			player4Name = new JLabel("Player 4");
			player4Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
			player4Name.setBounds(109, 0, 102, 25);
			panelPlayer4.add(player4Name);
			
			layeredPane_4 = new JLayeredPane();
			layeredPane_4.setBounds(10, 165, 287, 78);
			panelPlayer4.add(layeredPane_4);
	    }
	    
	    
	    
	    
	    private void panelButtons(){
	    	buttonsContainer = new JPanel();
			buttonsContainer.setBackground(new Color(60, 179, 113));
			buttonsContainer.setLayout(null);
			gbc_buttonsContainer = new GridBagConstraints();
			gbc_buttonsContainer.insets = new Insets(0, 0, 0, 5);
			gbc_buttonsContainer.fill = GridBagConstraints.BOTH;
			gbc_buttonsContainer.gridx = 0;
			gbc_buttonsContainer.gridy = 3;
			gbc_buttonsContainer.gridwidth = 4;
			contentPane.add(buttonsContainer, gbc_buttonsContainer);	
	    }
	   
	    
	    
	    private void buttons(){
	    	buttonsInitialization();
	    	buttonsActions();
	    }
	    
	    private void buttonsInitialization(){
	    	hitButton = new JButton("HIT");
			hitButton.setBounds(514, 13, 97, 50);
			buttonsContainer.add(hitButton);
			
			standButton = new JButton("STAND");
			standButton.setBounds(636, 13, 97, 50);
			buttonsContainer.add(standButton);
	    }
	    
	    private void buttonsActions(){
	    	
	    	hitButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
				
				Something ob = new Something();	
				ob.sendMessage("HIT");
				
                SwingWorker<Void, Void> hit = new SwingWorker<Void, Void>(){
						
					
					
					@Override
					protected Void doInBackground() throws Exception {
						if(noCards == true){
							noCards = false;
							setBound = 0;
						}
						else {
							setBound = setBound + 15;
						}
						
						return null;
					}

					@Override
					protected void done() {
						
						super.done();
					}
					
					
					
				};
				hit.execute();
				}
				
			});
			
			
			standButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
				
					
				Something ob = new Something();		
				ob.sendMessage("STAND");
				
				SwingWorker<Void, Void> stand = new SwingWorker<Void, Void>(){
						
					
					
					@Override
					protected Void doInBackground() throws Exception {
						turn++;
						return null;
					}

					@Override
					protected void done() {
						
						super.done();
					}
					
					
					
				};
				stand.execute();
				}
				
			});
	    }
	    
	    
			public void addCard(Card card){
				
						String location = "/img/" + card.toString() + ".png";
						label.setHorizontalAlignment(SwingConstants.TRAILING);
						im = new ImageIcon(this.getClass().getResource(location));
						Image scaleImage = im.getImage().getScaledInstance(55, 75,Image.SCALE_DEFAULT);
						ImageIcon icon = new ImageIcon(scaleImage);
						label.setIcon(icon);
						//label.setBounds(12, 0, 55,75);
						
						JLayeredPane layeredPane = new JLayeredPane();
						JPanel panel = new JPanel();
						switch (playersNumber()){
						
						
						case 1: panel = panelPlayer1;
								break;
						case 2: panel = panelPlayer2;
								break;
						case 3: panel = panelPlayer3;
								break;
						case 4: panel = panelPlayer4;
								break;
						default: break;
					
						}
						
						int nrOfCards = layeredPane.getComponentCount();
						
						if(nrOfCards > 0)
						{
							label.setBounds(layeredPane.getComponent(0).getX() + 15, 0, 55,75);
						}
						else
						{
							label.setBounds(0, 0, 55,75);
						}
							
						layeredPane_1.add(label, new Integer(nrOfCards), nrOfCards);
						
						panel.add(label);
								
					
			}
			
			public int playersNumber(){
				
				if (currentPlayer.equals("Dealer")){
					return 0;
				}
				String s = "" + currentPlayer.charAt(currentPlayer.length()-1);
				int x = Integer.parseInt(s);
				return x;
				
			}
			
			public void setCurrentPlayer(String currentPlayer){
				
				this.currentPlayer = currentPlayer;
				
			}
			
			public void setTotal(int total) {

				JPanel panel = new JPanel();
				
				switch (playersNumber()){
				
				
				case 1: panel = panelPlayer1;
						break;
				case 2: panel = panelPlayer2;
						break;
				case 3: panel = panelPlayer3;
						break;
				case 4: panel = panelPlayer4;
						break;
				default: break;
			
				}
				
				JLabel totalPlayer = new JLabel("Total: " + total);
				totalPlayer.setFont(new Font("Tahoma", Font.PLAIN, 20));
				totalPlayer.setBounds(0, 60, 78, 16);
				panel.add(totalPlayer);
				
			}


	
}
