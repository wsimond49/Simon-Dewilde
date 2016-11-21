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
        if (player.equals("Black")){
            id = 'N';
        }else{
            id = 'n';
        }
    }

    /**
     * The Knight can only move in a 2,1 or 1,2 pattern  
     * Method checks if the move is legal and if it is, moves the Knight on the board
     * 
     * @param newLocation The proposed location where the Knight is to be moved to
     * 
     * @return Nothing.
     * 
     */
    public void moveTo(ChessLocation newLocation)
    {
        if (Math.abs(super.getLocation().getCol() - newLocation.getCol())*Math.abs(super.getLocation().getRow() - newLocation.getRow()) == 2){
            super.moveTo(newLocation);           
        }else{
            System.out.println("This move is not a valid move for a Knight");
        }
    }
}
