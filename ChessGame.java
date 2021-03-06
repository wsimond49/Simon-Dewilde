/**
 * Initalizes the game and sets up the board with all the pieces on one side, also provides accesors for PlayGame
 * 
 * @author Simon Dewilde 
 * @version 3.0
 * 
 */
public class ChessGame
{
    private ChessBoard board;

    /**
     * Constructor creates a new ChessBoard object and all of the pieces then places them on the board at their initial position
     * 
     * @param player1 A String that corresponds to the colour of player1
     * @param player2 A String that corresponds to the colour of player2
     * 
     */
    public ChessGame(String player1, String player2)
    {        
        board = new ChessBoard();
        
        Rook R1 = new Rook(player1, this, new ChessLocation(0,0));
        Knight N1 = new Knight(player1, this, new ChessLocation(0,1));
        Bishop B1 = new Bishop(player1, this, new ChessLocation(0,2));
        Queen Q1 = new Queen(player1, this, new ChessLocation(0,3));
        King K1 = new King(player1, this, new ChessLocation(0,4));
        Bishop B2 = new Bishop(player1, this, new ChessLocation(0,5));
        Knight N2 = new Knight(player1, this, new ChessLocation(0,6));
        Rook R2 = new Rook(player1, this, new ChessLocation(0,7));
        Pawn P1 = new Pawn(player1, this, new ChessLocation(1,0));
        Pawn P2 = new Pawn(player1, this, new ChessLocation(1,1));
        Pawn P3 = new Pawn(player1, this, new ChessLocation(1,2));
        Pawn P4 = new Pawn(player1, this, new ChessLocation(1,3));
        Pawn P5 = new Pawn(player1, this, new ChessLocation(1,4));
        Pawn P6 = new Pawn(player1, this, new ChessLocation(1,5));
        Pawn P7 = new Pawn(player1, this, new ChessLocation(1,6));
        Pawn P8 = new Pawn(player1, this, new ChessLocation(1,7));
        
        Rook R3 = new Rook(player2, this, new ChessLocation(7,0));
        Knight N3 = new Knight(player2, this, new ChessLocation(7,1));
        Bishop B3 = new Bishop(player2, this, new ChessLocation(7,2));
        Queen Q2 = new Queen(player2, this, new ChessLocation(7,3));
        King K2 = new King(player2, this, new ChessLocation(7,4));
        Bishop B4 = new Bishop(player2, this, new ChessLocation(7,5));
        Knight N4 = new Knight(player2, this, new ChessLocation(7,6));
        Rook R4 = new Rook(player2, this, new ChessLocation(7,7));
        Pawn P9 = new Pawn(player2, this, new ChessLocation(6,0));
        Pawn P10 = new Pawn(player2, this, new ChessLocation(6,1));
        Pawn P11 = new Pawn(player2, this, new ChessLocation(6,2));
        Pawn P12 = new Pawn(player2, this, new ChessLocation(6,3));
        Pawn P13 = new Pawn(player2, this, new ChessLocation(6,4));
        Pawn P14 = new Pawn(player2, this, new ChessLocation(6,5));
        Pawn P15 = new Pawn(player2, this, new ChessLocation(6,6));
        Pawn P16 = new Pawn(player2, this, new ChessLocation(6,7));
        
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
