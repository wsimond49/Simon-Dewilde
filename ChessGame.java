/**
 * Initalizes the game and sets up the board with all the pieces on one side, also provides accesors for PlayGame
 * 
 * @author Simon Dewilde 
 * @version 2.0
 * 
 */
public class ChessGame
{
    private ChessBoard board;
    private String player1;
    private String player2;

    /**
     * Constructor creates a new ChessBoard object and all of the black pieces then places them on the board at their initial position
     * 
     * @param player1 A String that corresponds to the colour of player1
     * @param player2 A String that corresponds to the colour of player2
     * 
     */
    public ChessGame(String player1, String player2)
    {
        this.player1 = new String(player1);
        this.player2 = new String(player2);
        
        board = new ChessBoard();
        
        Rook R1 = new Rook(player1, this, new ChessLocation(0,0));
        Knight N1 = new Knight(player1, this, new ChessLocation(0,1));
        Bishop B1 = new Bishop(player1, this, new ChessLocation(0,2));
        Queen Q1 = new Queen(player1, this, new ChessLocation(0,3));
        King K1 = new King(player1, this, new ChessLocation(0,4));
        Bishop B2 = new Bishop(player1, this, new ChessLocation(0,5));
        Knight K2 = new Knight(player1, this, new ChessLocation(0,6));
        Rook R2 = new Rook(player1, this, new ChessLocation(0,7));
        Pawn P1 = new Pawn(player1, this, new ChessLocation(1,0));
        Pawn P2 = new Pawn(player1, this, new ChessLocation(1,1));
        Pawn P3 = new Pawn(player1, this, new ChessLocation(1,2));
        Pawn P4 = new Pawn(player1, this, new ChessLocation(1,3));
        Pawn P5 = new Pawn(player1, this, new ChessLocation(1,4));
        Pawn P6 = new Pawn(player1, this, new ChessLocation(1,5));
        Pawn P7 = new Pawn(player1, this, new ChessLocation(1,6));
        Pawn P8 = new Pawn(player1, this, new ChessLocation(1,7));
        
    }

        
    /**
     * Method that prints out the board that is currently in use
     * Uses the printBoard method from the ChessBoard class
     * 
     * @param Nothing.
     * 
     * @return Nothing.
     * 
     */
    public void printBoard()
    {
        board.printBoard();
    }
    
    /**
     * Getter that returns the ChessBoard object that is currently being used
     * 
     * @param Nothing.
     * 
     * @return ChessBoard That is initalized in the constructor
     * 
     */
    public ChessBoard getBoard()
    {
        return board;
    }
}
