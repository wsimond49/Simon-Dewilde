/**
 * Class that imitates the behavior of the King chess piece 
 * 
 * @author Simon Dewilde
 * @version 3.0
 */
public class King extends ChessPiece
{

    /**
     * Constructor sets the owner, current game, the inital locaiton and the character ID of the King
     * 
     * @param player A String that corresponds the the owner of the King
     * @param game The ChessGame that the King is a part of
     * @param initialLocation A ChessLocation where the piece is to be placed at the begining of the game
     * 
     */
    public King(String player, ChessGame game, ChessLocation initialLocation)
    {
        super(player,game,initialLocation);
        if (player.equals("Black"))
        {id = 'K';}
        else{id = 'k';}
        updateThreateningLocations();
    }

    /**
     * The King can move in any direction but only one square at a time 
     * Method checks if the move is legal and if it is, moves the King on the board
     * 
     * @param newLocation The proposed location where the King is to be moved to
     * 
     * @return Nothing.
     * 
     */
    public boolean moveTo(ChessLocation newLocation, boolean isThreat)
    {
        if ((Math.abs(super.getLocation().getRow() - newLocation.getRow()) < 2) && (Math.abs(super.getLocation().getCol() - newLocation.getCol()) < 2)){
            if(!super.checkLineOfSight(super.getLocation(),newLocation)){
                if(!isThreat){
                    super.moveTo(newLocation, false);
                }
                return true;              
            }else if(!isThreat){
                System.out.println("This move is not valid");
            }
        }
        return false;
    }
    
    public void updateThreateningLocations()
    {
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                ChessLocation check = new ChessLocation(i,j);
                if (moveTo(check,true)){ 
                    super.getThreateningLocations().add(check);
                }
            }
        }
    }
}
