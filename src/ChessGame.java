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

    public void movePiece(int row, int col, int newY, int newX){
        chessBoard.movePiece(row, col, newY, newX);
    }

    public void createKnight(String team, int row, int col){
        chessBoard.addPiece(new Knight(team, row, col), row, col);
    }
}
