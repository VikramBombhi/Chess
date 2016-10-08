/**
 * Created by Vikram on 2016-09-29.
 * The PlayGame class implements the main method.
 */
import java.util.Scanner;

public class PlayGame {
    private static Scanner userInput = new Scanner(System.in);
    public static ChessGame game;

    //This method prints the ChessBoard
    private static void printBoard(){
        for(int y = 0; y<8; y++){
            System.out.print("\n");
            for(int x = 0; x<8; x++){
                System.out.print(game.getChessBoard().getTiles()[y][x]);//print the piece
            }
        }
    }

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
        ChessBoard board = game.getChessBoard();
        //continue loop until user quits game
        while(true){
            printBoard();
            System.out.print("\n");

            //ask user for piece to move
            System.out.print("Select piece to move ex(row,col) or quit ex(quit): ");
            String pieceLocation = userInput.nextLine();
            //quit game if user enters "quit"
            if(pieceLocation.equals("quit")){
                break;
            }
            PieceLocation currentLocation = parseCoordinates(pieceLocation);
            if(board.isPieceAt(currentLocation)){
                //ask user where to move piece
                System.out.print("Enter where you want to move ex.(row,col): ");
                String moveLocation = userInput.nextLine();
                PieceLocation newLocation = parseCoordinates(moveLocation);
                //Check if piece can move there
                if(board.canMoveTo(currentLocation, newLocation)){
                    //move piece
                    game.movePiece(currentLocation, newLocation);
                }
                //Print if users tries moving to out of bounds position
                else{
                    System.out.print("You canot move there");
                }
            }
            //Print if user fails at selecting a piece
            else {
                System.out.print("There is no piece there, the format for selecting a piece is (row, col) ex(0,1)");
            }
        }
    }
}