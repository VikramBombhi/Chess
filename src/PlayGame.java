/*
 * Created by Vikram on 2016-09-29.
 * The PlayGame class implements the main method.
 */
import java.util.Scanner;

public class PlayGame {
    private static Scanner userInput = new Scanner(System.in);
    public static ChessGame game;
    private static String whosTurn = "White";

    private static void nextTurn(){
        if(whosTurn.equals("Black")){
            whosTurn = "White";
        }
        else whosTurn = "Black";
    }

    //This method takes the users input and converts it into a PieceLocation obj
    //@params: input is the string to be converted into PieceLocation obj
    private static PieceLocation parseCoordinates(String input){
        //split coordinates by comma and remove any spaces
        String[] locationSplit = input.split(",");
        int row = Integer.parseInt(locationSplit[0].trim());
        int col = Integer.parseInt(locationSplit[1].trim());
        if(row > 7 || col > 7){
            throw new IllegalArgumentException("Out of range");
        }
        return new PieceLocation(row, col);
    }

    public static void main(String args[]){
        game = new ChessGame();
        //game loop
        while(true){
            try{
                game.getChessBoard().printBoard();
                System.out.print("\n");
                System.out.println("i.) move");
                System.out.println("ii.) restart");
                System.out.println("iii.) quit");
                System.out.print("Select what you would like to do: ");
                String input = userInput.nextLine();

                if(input.equalsIgnoreCase("move")){
                    //ask user for piece to move
                    System.out.print("Select piece to move ex(row,col): ");
                    //@param currentLocation is the location of the piece that the user wants to move
                    PieceLocation currentLocation = parseCoordinates(userInput.nextLine());
                    //Check if a piece exists at currentLocation
                    if(!game.getChessBoard().isPieceAt(currentLocation)) {
                        throw new IllegalArgumentException("There is no piece there, the format for selecting a piece is (row, col) ex(0,1)");
                    }
                    if(!game.getChessBoard().getTiles()[currentLocation.getRow()][currentLocation.getCol()].getPiece().getOwner().equals(whosTurn)){
                        throw new IllegalArgumentException("Please select a piece on your team");
                    }
                    //ask user where to move piece
                    System.out.print("Enter where you want to move ex.(row,col): ");
                    PieceLocation newLocation = parseCoordinates(userInput.nextLine());
                    //move piece
                    game.getChessBoard().getTiles()[currentLocation.getRow()][currentLocation.getCol()].getPiece().moveTo(newLocation);
                    nextTurn();
                }
                if (input.equalsIgnoreCase("restart")){
                    throw new IllegalAccessException("restart");
                }
                if(input.equalsIgnoreCase("quit")){
                    throw new IllegalAccessException("quit");
                }
                else throw new IllegalAccessException("that is not a valid command, please select move, restart, or quit");
            }
            catch(Exception error){
                if(error.getMessage().equals("quit")){
                    System.out.println("Good game!");
                    break;
                }
                if(error.getMessage().equals("restart")){
                    System.out.println("Another one");
                    game = new ChessGame();
                }
                else System.out.println("Error Message: "+error.getMessage()+", ErrorCause: "+error.getCause());
            }
        }
    }
}
