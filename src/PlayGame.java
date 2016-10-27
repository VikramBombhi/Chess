/*
 * Created by Vikram on 2016-09-29.
 * The PlayGame class implements the main method.
 */
import java.util.Scanner;

public class PlayGame {
    private static Scanner userInput = new Scanner(System.in);
    public static ChessGame game;

    //This method takes the users input and converts it into a PieceLocation obj
    private static PieceLocation parseCoordinates(String input){
        //split coordinates by comma and remove any spaces
        String[] locationSplit = input.split(",");
        int row = Integer.parseInt(locationSplit[0].trim());
        int col = Integer.parseInt(locationSplit[1].trim());
        return new PieceLocation(row, col);
    }

    public static void main(String args[]){
        game = new ChessGame();
        //continue loop until user quits game
        while(true){
            game.getChessBoard().printBoard();
            System.out.print("\n");

            //ask user for piece to move
            System.out.print("Select piece to move ex(row,col) or quit ex(quit): ");
            String pieceLocation = userInput.nextLine();
            //quit game if user enters "quit"
            if(pieceLocation.equals("quit")){
                break;
            }
            //@param currentLocation is the location of the piece that the user wants to move
            PieceLocation currentLocation = parseCoordinates(pieceLocation);
            //Check if a piece exists at currentLocation
            if(game.getChessBoard().isPieceAt(currentLocation)){
                //ask user where to move piece
                System.out.print("Enter where you want to move ex.(row,col): ");
                String moveLocation = userInput.nextLine();
                PieceLocation newLocation = parseCoordinates(moveLocation);
                //Check if piece can move there
                if(game.getChessBoard().getTiles()[currentLocation.getRow()][currentLocation.getCol()].getPiece().canMoveTo(newLocation)) {
                    //move piece
                    game.getChessBoard().movePiece(currentLocation, newLocation);
                }
                //Print if users tries moving to out of bounds position
                else{
                    System.out.println("You cannot move there");
                }
            }
            //Print if user fails at selecting a piece that exists
            else {
                System.out.println("There is no piece there, the format for selecting a piece is (row, col) ex(0,1)");
            }
        }
    }
}
