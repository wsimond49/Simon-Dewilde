/**
 * Stores a 2-D array of ChessPieces that can be output in the shape of a chess board
 * 
 * @author Simon Dewilde
 * @version 2.0
 * 
 */
public class ChessBoard
{
    
    private ChessPiece board [][];

    /**
     * Constructor initalizes the 2-D array with null which is used to symbolize that there are no pieces in that position
     * 
     * @param Nothing.
     * 
     */
    public ChessBoard()
    {
        board = new ChessPiece [8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                board [i][j] = null;
            }
        }
    }

    /**
     * Method to print out the current chess board, it also prints the index along the side so users can
     * know where the piece is and where they want to place the next one
     * 
     * @param Nothing.
     * 
     * @return Nothing.
     * 
     */
    
    public void printBoard()
    {
       System.out.println("  0  1  2  3  4  5  6  7");
       for (int i = 0; i < 8; i++){
           System.out.print(i);
           for (int j = 0; j < 8; j++){
               if (board[i][j] != null){
                   System.out.print(" " + board[i][j].getID() + " ");
                }else{
                    System.out.print(" - ");
                }
            }
            System.out.println("");
        }
    }
    
    /**
     * Method checks if there is a piece currently at the given location
     * 
     * @param row Takes in the row that the user wants to check against
     * @param col Takes in the column that the user wants to check against
     * 
     * @return boolean Will return true if there is a piece at that location
     * 
     */
    public boolean isPieceAt (int row, int col)
    {
        if (row >= 0 && row <= 7 && col >=0 && col <=7){
            if (board[row][col] != null)
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Method returns the ChessPiece object at a given location
     * 
     * @param row Takes in the row where the ChessPiece is located
     * @param col Takes in the column where the ChessPiece is located
     * 
     * @return ChessPiece The ChessPiece that is at the given row & column
     * 
     */
    public ChessPiece getPiece (int row, int col)
    {
        if (row >= 0 && row <= 7 && col >=0 && col <=7){
            return board[row][col];
        }
        return null;
    }
    
    /**
     * Method needs to be called in conjunction with the remove piece so that after the piece location has been changed
     * Its old location is the then set back to the initial character
     * 
     * @param piece Needed to aquire the type of piece to place on the board
     * @param location Used to know where to place the piece 
     * 
     * @return Nothing.
     * 
     */
    public void placePieceAt (ChessPiece piece, ChessLocation location)
    {
        board[location.getRow()][location.getCol()] = piece;
    }
    
    /**
     * Method takes in a location and then sets that space in the array to null signifying that no piece remains there
     * 
     * @param ocation Takes in the position in the array that is to be replaced 
     * 
     * @return Nothing.
     * 
     */
    public void removePiece(ChessLocation location)
    {
        board[location.getRow()][location.getCol()] = null;
    }
}
