import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

public class ButtonHandler implements ActionListener {

	private JButton button;
	private JButton buttons[][];
	private JLabel currentPlayerLabel;
	private JLabel warningsLabel;
	private ArrayList<ChessLocation> lastPressed;
	private int row;
	private int col;
	private ChessGame game;

	public ButtonHandler(JButton button, JLabel currentPlayerLabel, JLabel warningsLabel, JButton buttons[][], ChessGame game, ArrayList<ChessLocation> lastPressed, int row, int col){
		this.button = button;
		this.currentPlayerLabel = currentPlayerLabel;	
		this.warningsLabel = warningsLabel;
		this.lastPressed = lastPressed;
		this.row = row;
		this.col = col;
		this.game = game;
		this.buttons = buttons;
		if (game.getBoard().isPieceAt(row, col) && game.getBoard().getPiece(row, col).getPlayer().equals("White")){
			button.setForeground(Color.LIGHT_GRAY);
			button.setOpaque(true);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (!game.getBoard().isPieceAt(row, col) && lastPressed.isEmpty()){
			
			warningsLabel.setText("Warnings: No piece there");
			
		}else if (!lastPressed.isEmpty() || game.getBoard().getPiece(row,col).getPlayer().equals(button.getName())){
			
			if (lastPressed.isEmpty()){
				warningsLabel.setText("Warnings: none");
				lastPressed.add(new ChessLocation(row,col));
				button.setEnabled(false);
			}else{
				if(game.getBoard().getPiece(lastPressed.get(0)).moveTo(new ChessLocation(row,col), false)){
					warningsLabel.setText("Warnings: none");
					buttons[lastPressed.get(0).getRow()][lastPressed.get(0).getCol()].setEnabled(true);
					resetChar();
					winner();
					check();
					lastPressed.clear();
					changePlayers();
				}else{
					warningsLabel.setText("Warnings: This move is invalid");
					buttons[lastPressed.get(0).getRow()][lastPressed.get(0).getCol()].setEnabled(true);
					lastPressed.clear();
				}
			}
			
		}else{
			warningsLabel.setText("Warnings: Not your piece");
		}
	}
	
	/**
	 * Resets the character of every button on the board after a move has been made
	 * 
	 * @return Nothing.
	 */
	private void resetChar(){
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				if (game.getBoard().isPieceAt(i,j)){
					buttons[i][j].setText(Character.toString(game.getBoard().getPiece(i, j).getID()));
					if (game.getBoard().isPieceAt(row, col) && game.getBoard().getPiece(row, col).getPlayer().equals("White")){
						button.setForeground(Color.LIGHT_GRAY);
						button.setOpaque(true);
					}else if (game.getBoard().isPieceAt(row, col) && game.getBoard().getPiece(row, col).getPlayer().equals("Black")){
						button.setForeground(Color.BLACK);
						button.setOpaque(true);
					}
				}else{
					buttons[i][j].setText("");
					button.setForeground(Color.BLACK);
					button.setOpaque(true);
				}
			}
		}
	}
	
	/**
	 * Changes the player after a successful move, also changes the label at the bottom
	 * 
	 * @return Nothing.
	 */
	private void changePlayers(){
		if (button.getName().equals("Black")){
			for (int i = 0; i < 8; i++){
				for (int j = 0; j < 8; j++){
					buttons[i][j].setName("White");
				}
			}
		}else if (button.getName().equals("White")){
			for (int i = 0; i < 8; i++){
				for (int j = 0; j < 8; j++){
					buttons[i][j].setName("Black");
				}
			}				
		}
		currentPlayerLabel.setText("Current player: " + button.getName());
	}
	
	/**
	 * Updates the threatening locations of all the pieces and warns the players if a piece is in check
	 * 
	 * @return Nothing.
	 */
	private  void check(){
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				if (game.getBoard().isPieceAt(i,j)){
					game.getBoard().getPiece(i,j).updateThreateningLocations();
				}
			}
		}
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				if (game.getBoard().isPieceAt(i,j)){ 
					for (ChessLocation kingCheck : game.getBoard().getPiece(i,j).getThreateningLocations()){
						if (game.getBoard().isPieceAt(kingCheck.getRow(),kingCheck.getCol())){
							if (game.getBoard().getPiece(kingCheck.getRow(), kingCheck.getCol()).getID() == 'K'){
								warningsLabel.setText("Warnings: The white king is in check by the piece at " + i + "," + j);
							}else if (game.getBoard().getPiece(kingCheck.getRow(), kingCheck.getCol()).getID() == 'k'){
								warningsLabel.setText("Warnings: The black king is in check by the piece at " + i + "," + j);
							}
						}
					}
				}
			}
		}
	}
	
	
	
	private void winner(){
		ArrayList<Integer> x = new ArrayList<Integer>();
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				if (game.getBoard().isPieceAt(i, j)){
					if (game.getBoard().getPiece(i, j).getID() == 'K' || game.getBoard().getPiece(i, j).getID() == 'k'){
						x.add(1);
					}
				}
			}
		}
		if (x.size() == 1){
			currentPlayerLabel.setText("Congratulations!");
			warningsLabel.setText(button.getName() + " is the winner!");			
			for (int i = 0; i < 8; i++){
				for (int j = 0; j < 8; j++){
					buttons[i][j].setEnabled(false);
				}
			}
		}		
	}
}
