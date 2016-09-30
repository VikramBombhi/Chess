/**
 * Created by Vikram on 2016-09-29.
 */
import java.util.Scanner;

public class PlayGame {
    public static Scanner userInput = new Scanner(System.in);
    public static ChessGame game;

    public static void printBoard(){
        for(int y = 0; y<8; y++){
            System.out.print("\n");
            for(int x = 0; x<8; x++){
                System.out.print(game.getChessBoard().getTiles()[y][x]);//print the piece
            }
        }
    }

    public ChessGame getGame(){
        return game;
    }

    public static void main(String args[]){
        game = new ChessGame();

        while(true){
            printBoard();
            System.out.print("\n");
            System.out.print("Select piece to move ex(0,3) or quit ex(q): ");
            String pieceLocation = userInput.nextLine();

            if(pieceLocation.equals("q")){
                break;
            }

            System.out.print("Enter where you want to move ex.(0,1): ");
            String moveLocation = userInput.nextLine();

            String[] pieceLocationSplit = pieceLocation.split("\\s*,\\s*");
            int pieceLocationY = Integer.parseInt(pieceLocationSplit[0]);
            int pieceLocationX = Integer.parseInt(pieceLocationSplit[1]);
            String[] moveLocationSplit = moveLocation.split("\\s*,\\s*");
            int moveLocationY = Integer.parseInt(moveLocationSplit[0]);
            int moveLocationX = Integer.parseInt(moveLocationSplit[1]);
            game.movePiece(pieceLocationY, pieceLocationX, moveLocationY, moveLocationX);
        }
    }
}
