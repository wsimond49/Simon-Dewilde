import java.util.ArrayList;
/**
 * Super Class that all of the different chess pieces inherit from
 * 
 * @author Simon Dewilde 
 * @version 3.0
 */
public abstract class ChessPiece
{
    private ChessGame game;
    private String player;
    private ChessLocation location;
    protected char id;
    private ArrayList<ChessLocation> threateningLocations;
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
        location = null;
        this.game.getBoard().placePieceAt(this,initialLocation);
        threateningLocations = new ArrayList<ChessLocation>();
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
    
    public ArrayList<ChessLocation> getThreateningLocations()
    {
        return threateningLocations;
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
    
    public void setLocation(ChessLocation newLocation){
        location = newLocation;
    }
    
    public abstract void updateThreateningLocations();
    
    /**
     * Method to move at piece on the board from one location to another (Assumes the move is legal, legality has been checked before calling)
     * 
     * @param newLocation Takes in a new ChessLocation and moves the piece to that location while deleting the old location
     * 
     * @return Nothing.
     * 
     */
    public boolean moveTo (ChessLocation newLocation, boolean isThreat)
    {
        ChessLocation temp = new ChessLocation(this.getLocation().getRow(),this.getLocation().getCol());
        game.getBoard().placePieceAt(this,newLocation);
        game.getBoard().removePiece(temp);
        return true;
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
        boolean returnValue = false;
        int rowInc = end.getRow() - start.getRow();
        int colInc = end.getCol() - start.getCol();
        int numberOfSteps = Math.max(Math.abs(rowInc), Math.abs(colInc));
        
        if(rowInc == 0){
            if (colInc < 0){colInc = -1;}
            else {colInc = 1;}
        }
        if(colInc == 0){
            if (rowInc < 0){rowInc = -1;}
            else {rowInc = 1;}
        }
        
        for (int i = 1; i < numberOfSteps; i++){
            int row = start.getRow() + (rowInc * i);
            int col = start.getCol() + (colInc * i);
            if(game.getBoard().isPieceAt(row, col)){
                returnValue = true;
            }
        }
        if(game.getBoard().isPieceAt(end.getRow(), end.getCol()) && game.getBoard().getPiece(end.getRow(), end.getCol()).getPlayer().equals(player)){
            returnValue = true;
        }
        return returnValue;
    }
}