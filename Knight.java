/**
 * Class that imitates the behavior of the Knight chess piece 
 * 
 * @author Simon Dewilde 
 * @version 3.0
 */
public class Knight extends ChessPiece
{
    /**
     * Constructor sets the owner, current game, the inital locaiton and the character ID of the Knight
     * 
     * @param player A String that corresponds the the owner of the Knight
     * @param game The ChessGame that the Knight is a part of
     * @param initialLocation A ChessLocation where the piece is to be placed at the begining of the game
     * 
     */
    public Knight(String player, ChessGame game, ChessLocation initialLocation)
    {
        super(player,game,initialLocation);
        if (player.equals("Black"))
        {id = 'N';}
        else{ id = 'n';}
    }

    /**
     * The Knight can only move in a 2,1 or 1,2 pattern  
     * Method checks if the move is legal and if it is, moves the Knight on the board
     * 
     * @param newLocation The proposed ChessLocation where the Knight is to be moved to
     * @param isThreat if isThreat is true the move is not actually taken just the return value is wanted
     * 
     * @return boolean true if the move was successful
     * 
     */
    public boolean moveTo(ChessLocation newLocation, boolean isThreat)
    {
        if (Math.abs(super.getLocation().getCol() - newLocation.getCol())*Math.abs(super.getLocation().getRow() - newLocation.getRow()) == 2 
        && (!super.getGame().getBoard().isPieceAt(newLocation.getRow(), newLocation.getCol()) || !super.getGame().getBoard().getPiece(newLocation.getRow(), newLocation.getCol()).getPlayer().equals(this.getPlayer()))){
            if(!isThreat){
                super.moveTo(newLocation, false);
            }
            return true;
        }else if(!isThreat){
            //System.out.println("This move is not valid");
        }
        return false;
    }
    
    /**
     * Fills the threateningLocations ArrayList with locations that the knight threatens
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
