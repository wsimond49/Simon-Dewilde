import java.util.Scanner;
import java.io.IOException;

/**
 * Creates the actual game and allows it to be played
 * 
 * @author Simon Dewilde
 * @version 3.0
 */
public class PlayGame
{

    /**
     * Constructor is empty becasue there are no instance variables and the main function is used
     * 
     */
    public PlayGame(){}

    /**
     * Calls playGame method to begin the player interface
     * 
     * @param args Unused.
     * 
     * @return Nothing.
     * 
     */
    public static void main(String[] args)
    {   
        playGame();
    }
    
    /**
     * Welcomes the user
     * Rotates between players asking if they want to move, reset or quit
     * Facilitates the moving and changing players
     * 
     * @param Nothing.
     * 
     * @return Nothing.
     * 
     */
    private static void playGame()
    {
        boolean continueGame = true;
        boolean valid = true;
        String currentPlayer = "White";
        String input = "";
       
        ChessGame game = new ChessGame("Black", "White");
        check(game);
       
        System.out.println("Welcome to Simon Dewilde's Chess game");
        System.out.println("White pieces are lowercase and Black pieces are UPPERCASE");
        System.out.println("The bottom player (White) will go first");
        
        while (continueGame)
        {
            System.out.println("---------------------------------------------------\n");
            game.getBoard().printBoard();
            System.out.println("\n---------------------------------------------------");
            System.out.println("It is " + currentPlayer + "s turn to move");
            
            getOption(game, "");
            input = getInput(true);
            
            int currentRow = Integer.parseInt(input.charAt(0) + "");
            int currentCol = Integer.parseInt(input.charAt(2) + "");
            
            if (currentRow >= 0 && currentRow <= 7 && currentCol >= 0 && currentCol <= 7){
                if (game.getBoard().isPieceAt(currentRow,currentCol)){
                    if(game.getBoard().getPiece(currentRow, currentCol).getPlayer().equals(currentPlayer)){
                       input = getInput(false);
                       
                       int futureRow = Integer.parseInt(input.charAt(0) + "");
                       int futureCol = Integer.parseInt(input.charAt(2) + "");      
                       
                       if (futureRow >= 0 && futureRow <= 7 && futureCol >= 0 && futureCol <= 7){
                           ChessLocation newLocation = new ChessLocation(futureRow, futureCol);
                           if(game.getBoard().isPieceAt(futureRow, futureCol) && (game.getBoard().getPiece(futureRow, futureCol).getID() == 'K' || game.getBoard().getPiece(futureRow, futureCol).getID() == 'k') &&
                           game.getBoard().getPiece(currentRow,currentCol).moveTo(newLocation, true)){
                               game.getBoard().getPiece(currentRow,currentCol).moveTo(newLocation, false);
                               System.out.println(currentPlayer + " is the winner!");
                               getOption(game, "q");
                           }
                           valid = game.getBoard().getPiece(currentRow,currentCol).moveTo(newLocation, false);
                           if(valid){
                               check(game);
                               if(currentPlayer.equals("White")){
                                   currentPlayer = "Black";
                               }else{
                                   currentPlayer = "White";
                               }
                           }
                       }else{
                           System.out.println("This move is out of bounds");
                       }
                    }else{
                        System.out.println("This is not your piece to move");
                    }
                }else{
                    System.out.println("There is no piece there");
                }
            }else{
                System.out.println("This position is out of bounds");
            }        
        }
    }
    
    /**
     * Asks for either a 'to' or 'from' coordinate set and gets the result as a string
     * 
     * @param startOrEnd boolean to know if they are being asked for a 'to' or 'from'
     * 
     * @return String the contents of the scan if they are valid, otherwise they are prompted again
     * 
     */
    private static String getInput(boolean startOrEnd)
    {
        Scanner scanner = new Scanner (System.in);
        String s = new String();
            
        boolean checkInput = true;
            
        while (checkInput){
            
            if(startOrEnd){
                System.out.print("Please enter the row then column of the piece you would like to move (R,C): ");
            }else{
                System.out.print("Please enter the row then column where you would like to move (R,C): ");
            }
            s = scanner.next();
            checkInput = false;
                
            if (s.length() != 3 || !Character.isDigit(s.charAt(0)) || !Character.isDigit(s.charAt(2))){
                System.out.println ("This is an invalid input, try again");
                checkInput = true;
            }                
         
        }
        return s;
    }
    
    /**
     * Asks the user if they want to move, quit or reset and will do the actual reset or quit if that is called
     * 
     * @param game used to print out the final board when the user quits
     * @param quitCheck if the king is captures then a "q" is passed and it defults to the quit case
     * 
     * @return Nothing.
     * 
     */
    private static void getOption (ChessGame game, String quitCheck)
    {    
        boolean validInput = true;
        String option = new String();
        while(validInput){
            if (quitCheck.equals("q")){
                 option = quitCheck;
            }else{
                System.out.println("Would you like to (M)ove, (Q)uit, or (R)estart?");
                Scanner scanner = new Scanner (System.in);
                option = scanner.next();
            }
            option = option.toLowerCase();
            if(option.equals("q")){
                System.out.println("\n\nThank you for playing this chess game");
                System.out.println("Here is the final layout of your chess game");
                game.getBoard().printBoard();
                System.out.println("\n\n");
                try {
                    Thread.sleep(2500);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                System.exit(0);
            }else if(option.equals("r")){
                System.out.print("\n\n\n\n\n");
                System.out.println("The game has been reset");
                playGame();
            }else if(option.equals("m")){
                validInput = false;
            }
        }
    }
    
    /**
     * Updates the threatening locations of all pieces and checks if the king is in any of those ArryLists
     * 
     * @param game used to get pieces on the board
     * 
     * @return Nothing.
     * 
     */
    private static void check (ChessGame game)
    {
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (game.getBoard().isPieceAt(i,j)){
                    game.getBoard().getPiece(i,j).updateThreateningLocations();
                }
            }
        }
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (game.getBoard().isPieceAt(i,j)){ 
                    for (ChessLocation kingCheck : game.getBoard().getPiece(i,j).getThreateningLocations()){
                        if (game.getBoard().isPieceAt(kingCheck.getRow(),kingCheck.getCol())){
                            if (game.getBoard().getPiece(kingCheck.getRow(), kingCheck.getCol()).getID() == 'K'){
                                System.out.println("The white king is in check by the piece at " + i + "," + j);
                            }else if (game.getBoard().getPiece(kingCheck.getRow(), kingCheck.getCol()).getID() == 'k'){
                                System.out.println("The black king is in check by the piece at " + i + "," + j);
                            }
                        }
                    }
                }
            }
        }
    }
}