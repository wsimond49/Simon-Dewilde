
/**
 * Class that imitates the behavior of the Queen chess piece 
 * 
 * @author Simon Dewilde 
 * @version 2.0
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
        super(player,game);
         super.getLocation().setLocation(initialLocation.getRow(),initialLocation.getCol());
        super.setID('Q');
        game.getBoard().placePieceAt(this,initialLocation);
    }

    /**
     * The Queen can move in any direction and as far as she wishes 
     * Method checks if the move is legal and if it is, moves the Queen on the board
     * 
     * @param newLocation The proposed location where the Queen is to be moved to
     * 
     * @return Nothing.
     * 
     */
    public void moveTo(ChessLocation newLocation)
    {
       if ((Math.abs(super.getLocation().getRow() - newLocation.getRow()) == Math.abs(super.getLocation().getCol() - newLocation.getCol())) ^
       (super.getLocation().getRow() == newLocation.getRow()) ^
       (super.getLocation().getCol() == newLocation.getCol())){
            if(!super.checkLineOfSight(super.getLocation(),newLocation)){
                super.moveTo(newLocation);
            }else{
                System.out.println("This move is invalid due to shadowing");
            }            
        }else{
            System.out.println("This move is not a valid move for a Queen");
        }
    }
}
