import java.util.Scanner;
import java.io.IOException;

/**
 * Creates the actual game and allows the user to move the black pieces around the board
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
     * Main function where the game is actually played.
     * Begins by explaining that is is a demo and asks if the user wants to start a game.
     * 
     * Prints out the board and then propts the user for the row and column of the piece they want to move.
     * If there is a piece there it will promt them for where they would like to move that piece to.
     * The updated board is then printed.
     * Cycle continues until the user quits and then prints out the final board.
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
    
    private static void playGame()
    {
        boolean continueGame = true;
        String currentPlayer = "White";
        String input = "";
       
        ChessGame game = new ChessGame("Black", "White");
       
        System.out.println("Welcome to Simon Dewilde's Chess game");
        System.out.println("The bottom player (White) will go first");
        
        while (continueGame)
        {
            System.out.println("---------------------------------------------------\n");
            game.getBoard().printBoard();
            System.out.println("\n---------------------------------------------------");
            
            getOption(game);
            input = getInput(true);
            
            int currentRow = Integer.parseInt(input.charAt(0) + "");
            int currentCol = Integer.parseInt(input.charAt(2) + "");
            
            if (currentRow >= 0 && currentRow <= 7 && currentCol >= 0 && currentCol <= 7){
                if (game.getBoard().isPieceAt(currentRow,currentCol)){
                   input = getInput(false);
                   
                   int futureRow = Integer.parseInt(input.charAt(0) + "");
                   int futureCol = Integer.parseInt(input.charAt(2) + "");      
                   
                   if (futureRow >= 0 && futureRow <= 7 && futureCol >= 0 && futureCol <= 7){
                       ChessLocation newLocation = new ChessLocation(futureRow, futureCol);
                   
                       game.getBoard().getPiece(currentRow,currentCol).moveTo(newLocation, false);
                   }else{
                       System.out.println("This move is out of bounds");
                   }
                }else{
                    System.out.println("There is no piece there");
                }
            }else{
                System.out.println("This position is out of bounds");
            }        
        }
    }
    
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
    
    private static void getOption (ChessGame game)
    {    
        boolean validInput = true;
        while(validInput){
            System.out.println("Would you like to Move(M), Quit(Q), or Restart(R)?");
            Scanner scanner = new Scanner (System.in);
            String option = scanner.next();
            option.toLowerCase();
            if(option.equals("q")){
                System.out.println("\n\nThank you for playing this chess game");
                System.out.println("Here is the final layout of your chess game");
                game.getBoard().printBoard();
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
}