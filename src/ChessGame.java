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
        //creating&placing pieces manually for now should find a cleaner way later

        //create&place knights
        Knight knight = new Knight("Black", new PieceLocation(0, 1), PlayGame.game);
        chessBoard.placePieceAt(knight);

        knight = new Knight("Black", new PieceLocation(0, 6), PlayGame.game);
        chessBoard.placePieceAt(knight);

        //create&place queen
        Queen queen = new Queen("Black", new PieceLocation(0, 3), PlayGame.game);
        chessBoard.placePieceAt(queen);

        //create&place rooks
        Rook rook = new Rook("Black", new PieceLocation(0, 0), PlayGame.game);
        chessBoard.placePieceAt(rook);

        rook = new Rook("Black", new PieceLocation(0, 7), PlayGame.game);
        chessBoard.placePieceAt(rook);

        //create&place bishops
        Bishop bishop = new Bishop("Black", new PieceLocation(0, 2), PlayGame.game);
        chessBoard.placePieceAt(bishop);

        bishop = new Bishop("Black", new PieceLocation(0, 5), PlayGame.game);
        chessBoard.placePieceAt(bishop);
    }

    //returns the ChessBoard
    public ChessBoard getChessBoard(){
        return chessBoard;
    }
}
