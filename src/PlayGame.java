/**
 * Created by Vikram on 2016-09-29.
 */
import java.util.Scanner;

public class PlayGame {
    private static Scanner userInput = new Scanner(System.in);
    public static ChessGame game;
    public ChessBoard board;

    public static void printBoard(){
        for(int y = 0; y<8; y++){
            System.out.print("\n");
            for(int x = 0; x<8; x++){
                System.out.print(game.getChessBoard().getTiles()[y][x]);//print the piece
            }
        }
    }

    public static void main(String args[]){
        game = new ChessGame();
        ChessBoard board = game.getChessBoard();
        while(true){
            printBoard();
            System.out.print("\n");

            //ask user for piece to move
            System.out.print("Select piece to move ex(row,col) or quit ex(q): ");
            String pieceLocation = userInput.nextLine();
            //quit game if user enters q
            if(pieceLocation.equals("q")){
                break;
            }
            //split coordinates by comma and remove any spaces
            String[] pieceLocationSplit = pieceLocation.split("\\s*,\\s*");
            int pieceLocationRow = Integer.parseInt(pieceLocationSplit[0]);
            int pieceLocationCol = Integer.parseInt(pieceLocationSplit[1]);
            PieceLocation currentLocation = new PieceLocation(pieceLocationRow, pieceLocationCol);
            //ask user where to move piece
            System.out.print("Enter where you want to move ex.(row,col): ");
            String moveLocation = userInput.nextLine();
            String[] moveLocationSplit = moveLocation.split("\\s*,\\s*");
            int moveLocationRow = Integer.parseInt(moveLocationSplit[0]);
            int moveLocationCol = Integer.parseInt(moveLocationSplit[1]);
            PieceLocation newLocation = new PieceLocation(moveLocationRow, moveLocationCol);
            //move piece
            game.movePiece(currentLocation, newLocation);
        }
    }
}
