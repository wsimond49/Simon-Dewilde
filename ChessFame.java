import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChessFame {
	
	private JFrame frame;
	private JButton buttons[][];
	private ChessGame game;
	
	public ChessFame(){
		buttons = new JButton[8][8];
		game = new ChessGame ("Black","White");
		makeFrame();
	}

	public void makeFrame(){
		frame = new JFrame("ChessGame");
		frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		makeMenuBar();
		startNewGame();
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void startNewGame(){
		JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel label = new JLabel("Welcome to the chess game");
		textPanel.add(label);

		JPanel gridPanel = new JPanel(new GridLayout(8,8));
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				
				buttons[i][j] = new JButton();
				
				if (game.getBoard().isPieceAt(i,j)){
					buttons[i][j].setText(Character.toString(game.getBoard().getPiece(i, j).getID()));
				}else{
					buttons[i][j].setText("");
				}
				
				buttons[i][j].setPreferredSize(new Dimension(40,40));
				buttons[i][j].addActionListener(new ButtonHandler(buttons[i][j], label));
				buttons[i][j].setVisible(true);
				gridPanel.add(buttons[i][j]);
				
				/*
				if (game.getBoard().isPieceAt(i,j)){
					buttons[i][j].setText(Character.toString(game.getBoard().getPiece(i, j).getID()));
				}else{
					buttons[i][j].setText("h");
				}
				*/
			}
		}

		frame.add(gridPanel);
		frame.add(textPanel);
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
			frame.validate();
		}
	}
	
	class QuitListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			System.exit(0);
		}
	}
}
