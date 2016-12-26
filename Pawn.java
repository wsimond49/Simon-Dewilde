
/**
 * Class that imitates the behavior of the Pawn chess piece 
 * 
 * @author Simon Dewilde 
 * @version 3.0
 */
public class Pawn extends ChessPiece
{
    //firstMove is used to keep track of the first move staus of the pawn as they can only move 2 spaces on their first move
    private boolean firstMove;

    /**
     * Constructor sets the owner, current game, the inital locaiton, the first move status and the character ID of the Pawn
     * 
     * @param player A String that corresponds the the owner of the Pawn
     * @param game The ChessGame that the Pawn is a part of
     * @param initialLocation A ChessLocation where the piece is to be placed at the begining of the game
     * 
     * 
     */
    public Pawn(String player, ChessGame game, ChessLocation initialLocation)
    {
        super(player,game,initialLocation);
        if (player.equals("Black"))
        {id = 'P';}
        else{id = 'p';}
        firstMove = true;
    }

    /**
     * The Pawn can move forward one square at a time or two if it is their first move
     * If there is an opponents piece on a single diagonal then it can capture that piece
     * Method checks if the move is legal and if it is, moves the Pawn on the board
     * 
     * @param newLocation The proposed ChessLocation where the Pawn is to be moved to
     * @param isThreat if isThreat is true the move is not actually taken just the return value is wanted
     * 
     * @return boolean true if the move was successful 
     * 
     */
    public boolean moveTo(ChessLocation newLocation, boolean isThreat)
    {
        int i = 1;
        if(super.getPlayer().equals("Black")){i = -1;}
        if (firstMove  && (super.getLocation().getRow()-newLocation.getRow() == i || super.getLocation().getRow()-newLocation.getRow() == 2*i) && super.getLocation().getCol()-newLocation.getCol() == 0){
            if(!super.checkLineOfSight(super.getLocation(),newLocation)){
                if(!isThreat){
                    super.moveTo(newLocation, false);
                    firstMove = false;
                    return true;
                }
                return false;
            }            
        }else if (super.getLocation().getRow() - newLocation.getRow() == i && super.getLocation().getCol()-newLocation.getCol() == 0){
            if(!super.checkLineOfSight(super.getLocation(),newLocation)){
                if(!isThreat){
                    super.moveTo(newLocation, false);
                    return true;
                }
                return false;
            }
        }else if(super.getLocation().getRow() - newLocation.getRow() == i && Math.abs(super.getLocation().getCol() - newLocation.getCol()) == 1 && super.getGame().getBoard().isPieceAt(newLocation.getRow(),newLocation.getCol()) && 
            !super.getGame().getBoard().getPiece(newLocation.getRow(),newLocation.getCol()).getPlayer().equals(this.getPlayer())){
            if(!isThreat){
                super.moveTo(newLocation, false);
            }
            return true;            
        }else{
            if(!isThreat){
                //System.out.println("This move is not valid");
            }
        } 
            
        return false;
    }
    
    /**
     * Fills the threateningLocations ArrayList with locations that the pawn threatens
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
