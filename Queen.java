
/**
 * Class that imitates the behavior of the Queen chess piece 
 * 
 * @author Simon Dewilde 
 * @version 3.0
 */
public class Queen extends ChessPiece
{

    /**
     * Constructor sets the owner, current game, the inital locaiton and the character ID of the Queen
     * 
     * @param player A String that corresponds the the owner of the Queen
     * @param game The ChessGame that the Queen is a part of
     * @param initialLocation A ChessLocation where the piece is to be placed at the begining of the game
     * 
     */
    public Queen(String player, ChessGame game, ChessLocation initialLocation)
    {
        super(player,game,initialLocation);
        if (player.equals("Black"))
        {id = 'Q';}
        else{id = 'q';}
    }

    /**
     * The Queen can move in any direction and as far as she wishes 
     * Method checks if the move is legal and if it is, moves the Queen on the board
     * 
     * @param newLocation The proposed ChessLocation where the Queen is to be moved to
     * @param isThreat if isThreat is true the move is not actually taken just the return value is wanted
     * 
     * @return boolean true if the move was successful
     * 
     */
    public boolean moveTo(ChessLocation newLocation, boolean isThreat)
    {
        if (super.getLocation().getRow() == newLocation.getRow() && (super.getLocation().getCol() == newLocation.getCol())){
            return false;
        }
        if ((Math.abs(super.getLocation().getRow() - newLocation.getRow()) == Math.abs(super.getLocation().getCol() - newLocation.getCol())) ||
        (super.getLocation().getRow() == newLocation.getRow()) || (super.getLocation().getCol() == newLocation.getCol())){
            if(!super.checkLineOfSight(super.getLocation(),newLocation)){
                if(!isThreat){
                    super.moveTo(newLocation, false);
                }
                return true;
            }           
        }else{
            if(!isThreat){
                //System.out.println("This move is not valid");
            }
        }
        return false;
    }
    
    /**
     * Fills the threateningLocations ArrayList with locations that the queen threatens
     * 
     * @param Nothing.
     * 
     * @return Nothing.
     * 
     */
    public void updateThreateningLocations()
    {
        super.getThreateningLocations().clear();
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                ChessLocation check = new ChessLocation(i,j);
                if (this.moveTo(check,true)){
                    super.getThreateningLocations().add(check);
                }
            }
        }
    }
}
