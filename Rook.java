/**
 * Class that imitates the behavior of the Rook chess piece 
 * 
 * @author Simon Dewilde 
 * @version 3.0
 */
public class Rook extends ChessPiece
{

    /**
     * Constructor sets the owner, current game, the inital locaiton and the character ID of the Rook
     * 
     * @param player A String that corresponds the the owner of the Rook
     * @param game The ChessGame that the Rook is a part of
     * @param initialLocation A ChessLocation where the piece is to be placed at the begining of the game
     * 
     */
    public Rook(String player, ChessGame game, ChessLocation initialLocation)
    {
        super(player,game,initialLocation);
        if (player.equals("Black"))
        {id = 'R';}
        else{id = 'r';}
    }

    /**
     * The Rook can only move in stright lines up, down, left or right
     * Method checks if the move is legal and if it is, moves the Rook on the board
     * 
     * @param newLocation The proposed location where the Rook is to be moved to
     * 
     * @return Nothing.
     * 
     */
    public boolean moveTo(ChessLocation newLocation)
    {
        if ((super.getLocation().getRow() == newLocation.getRow()) ^ (super.getLocation().getCol() == newLocation.getCol())){
            if(!super.checkLineOfSight(super.getLocation(),newLocation)){
                super.moveTo(newLocation);
                return true;
            }else{
                System.out.println("This move is invalid due to shadowing");
            }            
        }else{
            System.out.println("This move is not a valid move for a Rook");
        }
        return false;
    }
    
    public void updateThreateningLocations()
    {
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                ChessLocation check = new ChessLocation(i,j);
                if ((super.getLocation().getRow() == check.getRow()) ^ (super.getLocation().getCol() == check.getCol())){
                    if(!super.checkLineOfSight(super.getLocation(),check)){
                        super.getThreateningLocations().add(check);
                    }
                }
            }
        }
    }
}
