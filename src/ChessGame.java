/**
 * Created by Vikram on 2016-09-29.
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
        PieceLocation location = new PieceLocation(0,1);
        Knight knight = new Knight("Black", location, PlayGame.game);
        chessBoard.addPiece(knight);
    }

    public ChessBoard getChessBoard(){
        return chessBoard;
    }

    //Ask ChessBoard to move piece from location to newLocation
    public void movePiece(PieceLocation location, PieceLocation newLocation){
        chessBoard.movePiece(location, newLocation);
    }
}
