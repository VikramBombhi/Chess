/**
 * Created by Vikram on 2016-09-29.
 * ChessGame class creates the chessboard and sets up the board
 */
public class ChessGame {
    private ChessBoard chessBoard;

    public ChessGame(){
        chessBoard = new ChessBoard();
        setupBoard();
    }

    //Place pieces on the board at the start of a  new ChessGame
    private void setupBoard(){
        //creating a single piece manually for now because only a single knight exists
        Knight knight = new Knight("Black", new PieceLocation(0,1), PlayGame.game);
        chessBoard.placePieceAt(knight);
    }

    //returns the ChessBoard
    public ChessBoard getChessBoard(){
        return chessBoard;
    }
}
