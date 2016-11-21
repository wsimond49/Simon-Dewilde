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
        if (player.equals("Black")){
            id = 'K';
        }else{
            id = 'k';
        }
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
    public void moveTo(ChessLocation newLocation)
    {
        if ((Math.abs(super.getLocation().getRow() - newLocation.getRow()) == 1) || (Math.abs(super.getLocation().getCol() - newLocation.getCol()) == 1)){
            if(!super.checkLineOfSight(super.getLocation(),newLocation)){
                super.moveTo(newLocation);
            }else{
                System.out.println("This move is invalid due to shadowing");
            }            
        }else{
            System.out.println("This move is not a valid move for a King");
        }
    }
}
