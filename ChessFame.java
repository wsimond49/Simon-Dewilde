import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class ChessFame {
	
	private JFrame frame;
	private JButton buttons[][];
	private ChessGame game;
	private ArrayList<ChessLocation> lastPressed;
	
	public ChessFame(){
		buttons = new JButton[8][8];
		lastPressed = new ArrayList<ChessLocation>();
		makeFrame();
	}

	public void makeFrame(){
		frame = new JFrame("ChessGame");
		frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.PAGE_AXIS));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		makeMenuBar();
		startNewGame();
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void startNewGame(){
		
		game = new ChessGame ("Black","White");
		
		JPanel playerPanel = new JPanel();
		JLabel currentPlayerLabel = new JLabel("Welcome to the chess game, bottom goes first");
		playerPanel.add(currentPlayerLabel);
		JPanel warningPanel = new JPanel();
		JLabel warningsLabel = new JLabel("Warnings: none");
		warningPanel.add(warningsLabel);

		JPanel gridPanel = new JPanel(new GridLayout(8,8));
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				
				buttons[i][j] = new JButton();
				
				if (game.getBoard().isPieceAt(i,j)){
					buttons[i][j].setText(Character.toString(game.getBoard().getPiece(i, j).getID()));
				}else{
					buttons[i][j].setText("");
				}
				buttons[i][j].setName("White");
				buttons[i][j].setPreferredSize(new Dimension(60,60));
				buttons[i][j].setFocusPainted(false);
				buttons[i][j].addActionListener(new ButtonHandler(buttons[i][j], currentPlayerLabel, warningsLabel, buttons, game, lastPressed, i, j));
				buttons[i][j].setVisible(true);
				gridPanel.add(buttons[i][j]);
			}
		}

		frame.add(gridPanel);
		frame.add(playerPanel);
		frame.add(warningPanel);
	}
	
	public void makeMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu gameMenu = new JMenu("Game");
		menuBar.add(gameMenu);

		JMenuItem newGameItem = new JMenuItem ("New Game");
		newGameItem.addActionListener(new NewGameListener());
		gameMenu.add(newGameItem);

		JMenuItem quitItem = new JMenuItem ("Quit");
		quitItem.addActionListener(new QuitListener());
		gameMenu.add(quitItem);
	 }
	
	class NewGameListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			frame.getContentPane().removeAll();
			startNewGame();
			frame.validate();
		}
	}
	
	class QuitListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			System.exit(0);
		}
	}
}
