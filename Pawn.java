
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
        if (player.equals("Black")){
            id = 'P';
        }else{
            id = 'p';
        }
        firstMove = true;
    }

    /**
     * The Pawn can move forward one square at a time or two if it is their first move
     * Method checks if the move is legal and if it is, moves the Pawn on the board
     * 
     * @param newLocation The proposed location where the Pawn is to be moved to
     * 
     * @return Nothing.
     * 
     */
    public void moveTo(ChessLocation newLocation)
    {
        if(super.getPlayer().equals("Black")){
            if (firstMove && (super.getLocation().getRow() - newLocation.getRow() < 0) && (Math.abs(super.getLocation().getRow()-newLocation.getRow()) == 1 || Math.abs(super.getLocation().getRow()-newLocation.getRow()) == 2)){
                if(!super.checkLineOfSight(super.getLocation(),newLocation)){
                    super.moveTo(newLocation);
                    firstMove = false;
                }else{
                    System.out.println("This move is invalid due to shadowing");
                }            
            }else if ((Math.abs(super.getLocation().getRow() - newLocation.getRow()) == 1) && (super.getLocation().getRow() - newLocation.getRow() < 0)){
                if(!super.checkLineOfSight(super.getLocation(),newLocation)){
                    super.moveTo(newLocation);
                }else{
                    System.out.println("This move is invalid due to shadowing");
                }
            }else{
                System.out.println("This move is not a valid move for a Pawn");
            }    
        }else{
            if (firstMove && (super.getLocation().getRow() - newLocation.getRow() > 0) && (Math.abs(super.getLocation().getRow()-newLocation.getRow()) == 1 || Math.abs(super.getLocation().getRow()-newLocation.getRow()) == 2)){
                if(!super.checkLineOfSight(super.getLocation(),newLocation)){
                    super.moveTo(newLocation);
                    firstMove = false;
                }else{
                    System.out.println("This move is invalid due to shadowing");
                }            
            }else if ((Math.abs(super.getLocation().getRow() - newLocation.getRow()) == 1) && (super.getLocation().getRow() - newLocation.getRow() > 0)){
                if(!super.checkLineOfSight(super.getLocation(),newLocation)){
                    super.moveTo(newLocation);
                }else{
                    System.out.println("This move is invalid due to shadowing");
                }
            }else{
                System.out.println("This move is not a valid move for a Pawn");
            }
        }
    }
}
