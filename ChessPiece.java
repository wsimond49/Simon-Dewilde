/**
 * Super Class that all of the different chess pieces inherit from
 * 
 * @author Simon Dewilde 
 * @version 3.0
 */
public class ChessPiece
{
    private ChessGame game;
    private String player;
    private ChessLocation location;
    protected char id;
    /**
     * Constructor sets the owner of the piece (player1 or player2) and associates the piece with its game
     * 
     * @param owner A String that tells the piece what colour it is
     * @param game The current game that is being played 
     * 
     */
    public ChessPiece(String owner, ChessGame game, ChessLocation initialLocation)
    {
        player = owner;
        this.game = game;
        location = initialLocation;
        this.game.getBoard().placePieceAt(this,initialLocation);
    }
    
    /**
     * Accessor for the current game being played
     * 
     * @param Nothing.
     * 
     * @return ChessGame The current game being played
     * 
     */
    public ChessGame getGame()
    {
        return game;
    }
    
    /**
     * Accessor for the played associated with the piece
     * 
     * @param Nothing.
     * 
     * @return String Name of the player
     * 
     */
    public String getPlayer()
    {
        return player;
    }
    
    /**
     * Accessor for the current location of the piece
     * 
     * @param Nothing.
     * 
     * @reurn ChessLocation Where the piece is on the board
     * 
     */
    public ChessLocation getLocation()
    {
        return location;
    }
    
    /**
     * Accessor for the current row of the piece
     * 
     * @param Nothing.
     * 
     * @return int The row the piece is stored at
     * 
     */
    public int getRow()
    {
        return location.getRow();
    }
    
    /**
     * Accessor for the current column of the piece
     * 
     * @param Nothing.
     * 
     * @return int The column the piece is stored at
     * 
     */
    public int getCol()
    {
        return location.getCol();
    }
    
    /**
     * Accessor for the ID of the piece
     * 
     * @param Nothing.
     * 
     * @return char The chess character relating to that piece
     * 
     */
    public char getID()
    {
        return id;
    }

    /**
     * Mutator for the ID of the piece
     * 
     * @param newID Takes in the character that the id should be changed to
     * 
     * @return Nothing.
     * 
     */
    public void setID (char newID)
    {
        id = newID;
    }
    
    /**
     * Method to move at piece on the board from one location to another (Assumes the move is legal, legality has been checked before calling)
     * 
     * @param newLocation Takes in a new ChessLocation and moves the piece to that location while deleting the old location
     * 
     * @return Nothing.
     * 
     */
    public void moveTo (ChessLocation newLocation)
    {
            ChessLocation temp = new ChessLocation(this.getLocation().getRow(),this.getLocation().getCol());
            game.getBoard().placePieceAt(this,newLocation);
            location.setLocation(newLocation.getRow(), newLocation.getCol());
            game.getBoard().removePiece(temp);
    }
    /**
     * Method to check for shadowing of pieces and also checks if there is a piece in the final location
     * 
     * @param start The starting ChessLocation of the piece
     * @param end The proposed ending ChessLocation of the piece
     * 
     * @return boolean Returns true if there is a piece in the way or false if the path is clear
     * 
     */
    public boolean checkLineOfSight(ChessLocation start, ChessLocation end)
    {
        boolean check = false;
        
        //If the rows are the same then the piece is moving vetically (also checks for up or down)
        if (start.getRow() == end.getRow()){
            int constantRow = start.getRow();
            if (start.getCol() - end.getCol() < 0){
                for (int i = start.getCol()+1; i <= end.getCol(); i++){
                    check = game.getBoard().isPieceAt(constantRow, i);
                    if (check != false){
                        return check;
                    }
                }
            }else{
                for (int i = start.getCol()-1; i <= end.getCol(); i--){
                    check = game.getBoard().isPieceAt(constantRow, i);
                    if (check != false){
                        return check;
                    }
                }
            }
        //If the columns are the same then the piece is moving horizontally (also checks left or right)
        }else if (start.getCol() == end.getCol()){
            int constantCol = start.getCol();
            if (start.getRow() - end.getRow() < 0){
                for (int i = start.getRow()+1; i <= end.getRow(); i++){
                    check = game.getBoard().isPieceAt(i,constantCol);
                    if (check != false){
                        return check;
                    }
                }
            }else{
                for (int i = start.getRow()-1; i <= end.getRow(); i--){
                    check = game.getBoard().isPieceAt(i,constantCol);
                    if (check != false){
                        return check;
                    }
                }
            }
        //If the piece is going on a diagonal it will check whichever quadrent the piece is moving into
        }else if (Math.abs(start.getRow() - end.getRow()) == Math.abs(start.getCol() - end.getCol())){
           int i = start.getRow();
           int j = start.getCol();
           if (start.getRow() > end.getRow()){
               if (start.getCol() > end.getCol()){
                   //q2
                   i--;
                   j--;
                   while (j < end.getCol()){
                       check = game.getBoard().isPieceAt(i,j);
                       if (check != false){
                           return check;
                       }
                       i--;
                       j--;
                   }
               }else{
                   //q1
                   i--;
                   j++;
                   while (j < end.getCol()){
                       check = game.getBoard().isPieceAt(i,j);
                       if (check != false){
                           return check;
                       }
                       i--;
                       j++;
                   }
                  
               }
           }else{
               if (start.getCol() > end.getCol()){
                   //q3
                   i++;
                   j--;
                   while (j < end.getCol()){
                       check = game.getBoard().isPieceAt(i,j);
                       if (check != false){
                           return check;
                       }
                       i++;
                       j--;
                   }
               }else{
                   //q4
                   i++;
                   j++;
                   while (j < end.getCol()){
                       check = game.getBoard().isPieceAt(i,j);
                       if (check != false){
                           return check;
                       }
                       i++;
                       j++;
                   }
               }
           }
        }
        return check;
    }
}