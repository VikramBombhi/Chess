/**
 * Created by Vikram on 2016-09-29.
 */
public class ChessGame {
    private ChessBoard chessBoard;

    public ChessGame(){
        chessBoard = new ChessBoard();
        createKnight("BLACK", 1, 1);
    }

    public ChessBoard getChessBoard(){
        return chessBoard;
    }

    public void movePiece(int y, int x, int newY, int newX){
        chessBoard.movePiece(y, x, newY, newX);
    }

    public void createKnight(String team, int y, int x){
        chessBoard.addPiece(new Knight(team, y, x), y, x);
    }
}
