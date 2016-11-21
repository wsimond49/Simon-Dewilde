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
        
        ChessLocation initial00 = new ChessLocation(0,0);
        Rook R1 = new Rook(player1, this, initial00);
        
        ChessLocation initial01 = new ChessLocation(0,1);
        Knight N1 = new Knight(player1, this, initial01);
        
        ChessLocation initial02 = new ChessLocation(0,2);
        Bishop B1 = new Bishop(player1, this, initial02);
        
        ChessLocation initial03 = new ChessLocation(0,3);
        Queen Q1 = new Queen(player1, this, initial03);
        
        ChessLocation initial04 = new ChessLocation(0,4);
        King K1 = new King(player1, this, initial04);
        
        ChessLocation initial05 = new ChessLocation(0,5);
        Bishop B2 = new Bishop(player1, this, initial05);
        
        ChessLocation initial06 = new ChessLocation(0,6);
        Knight K2 = new Knight(player1, this, initial06);
        
        ChessLocation initial07 = new ChessLocation(0,7);
        Rook R2 = new Rook(player1, this, initial07);
        
        ChessLocation initial10 = new ChessLocation(1,0);
        Pawn P1 = new Pawn(player1, this, initial10);
        
        ChessLocation initial11 = new ChessLocation(1,1);
        Pawn P2 = new Pawn(player1, this, initial11);
        
        ChessLocation initial12 = new ChessLocation(1,2);
        Pawn P3 = new Pawn(player1, this, initial12);
        
        ChessLocation initial13 = new ChessLocation(1,3);
        Pawn P4 = new Pawn(player1, this, initial13);
        
        ChessLocation initial14 = new ChessLocation(1,4);
        Pawn P5 = new Pawn(player1, this, initial14);
        
        ChessLocation initial15 = new ChessLocation(1,5);
        Pawn P6 = new Pawn(player1, this, initial15);
        
        ChessLocation initial16 = new ChessLocation(1,6);
        Pawn P7 = new Pawn(player1, this, initial16);
        
        ChessLocation initial17 = new ChessLocation(1,7);
        Pawn P8 = new Pawn(player1, this, initial17);
        
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
