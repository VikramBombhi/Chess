/**
 * Created by Vikram on 2016-09-29.
 */
public class ChessGame {
    private ChessBoard chessBoard;

    public ChessGame(){
        chessBoard = new ChessBoard();
        setupBoard();
    }

    private void setupBoard(){
        PieceLocation location = new PieceLocation(0,1);
        Knight knight = new Knight("Black", location, PlayGame.game);
        chessBoard.addPiece(knight);
    }

    public ChessBoard getChessBoard(){
        return chessBoard;
    }

    public void movePiece(PieceLocation location, PieceLocation newLocation){
        chessBoard.movePiece(location, newLocation);
    }
}
