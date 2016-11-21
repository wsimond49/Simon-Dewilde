/**
 * Class that imitates the behavior of the Bishop chess piece
 * 
 * @author Simon Dewilde 
 * @version 3.0
 */
public class Bishop extends ChessPiece
{

    /**
     * Constructor sets the owner, current game, the inital locaiton and the character ID of the Bishop
     * 
     * @param player A String that corresponds the the owner of the Bishop
     * @param game The ChessGame that the Bishop is a part of
     * @param initialLocation A ChessLocation where the piece is to be placed at the begining of the game
     * 
     */
    public Bishop(String player, ChessGame game, ChessLocation initialLocation)
    {
        super(player,game,initialLocation);
        if (player.equals("Black")){
            id = 'B';
        }else{
            id = 'b';
        }
    }

    /**
     * The Bishop can only move in the diagonals 
     * Method checks if the move is legal and if it is, moves the Bishop on the board
     * 
     * @param newLocation The proposed location where the Bishop is to be moved to
     * 
     * @return Nothing.
     * 
     */
    public boolean moveTo(ChessLocation newLocation)
    {
        if (Math.abs(super.getLocation().getRow() - newLocation.getRow()) == Math.abs(super.getLocation().getCol() - newLocation.getCol())){
            if(!super.checkLineOfSight(super.getLocation(),newLocation)){
                super.moveTo(newLocation);
                return true;
            }else{
                System.out.println("This move is invalid due to shadowing");
            }            
        }else{
            System.out.println("This move is not a valid move for a Bishop");
        }
        return false;
    }
}
