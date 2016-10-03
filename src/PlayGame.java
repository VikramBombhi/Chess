/**
 * Created by Vikram on 2016-09-29.
 */
import java.lang.reflect.Array;
import java.util.Scanner;

public class PlayGame {
    private static Scanner userInput = new Scanner(System.in);
    public static ChessGame game;
    public ChessBoard board;

    private static void printBoard(){
        for(int y = 0; y<8; y++){
            System.out.print("\n");
            for(int x = 0; x<8; x++){
                System.out.print(game.getChessBoard().getTiles()[y][x]);//print the piece
            }
        }
    }

    private static PieceLocation parseCoordinates(String input){
        //split coordinates by comma and remove any spaces
        String[] locationSplit = input.split(",");
        int row = Integer.parseInt(locationSplit[0].trim());
        int col = Integer.parseInt(locationSplit[1].trim());
        PieceLocation location = new PieceLocation(row, col);
        return location;
    }

    public static void main(String args[]){
        game = new ChessGame();
        ChessBoard board = game.getChessBoard();
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
                else{
                    System.out.print("You canot move there");
                }
            }
            else {
                System.out.print("There is no piece there, the format for selecting a piece is (row, col) ex(0,1)");
            }
        }
    }
}