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
        Knight knight = new Knight("Black", new PieceLocation(0, 1));
        chessBoard.placePieceAt(knight);

        knight = new Knight("Black", new PieceLocation(0, 6));
        chessBoard.placePieceAt(knight);

        //create&place queen
        Queen queen = new Queen("Black", new PieceLocation(0, 3));
        chessBoard.placePieceAt(queen);

        //create&place rooks
        Rook rook = new Rook("Black", new PieceLocation(0, 0));
        chessBoard.placePieceAt(rook);

        rook = new Rook("Black", new PieceLocation(0, 7));
        chessBoard.placePieceAt(rook);

        //create&place bishops
        Bishop bishop = new Bishop("Black", new PieceLocation(0, 2));
        chessBoard.placePieceAt(bishop);

        bishop = new Bishop("Black", new PieceLocation(0, 5));
        chessBoard.placePieceAt(bishop);

        //create&place kings
        King king = new King("Black", new PieceLocation(0, 4));
        chessBoard.placePieceAt(king);

	//create&place pawns
	for(int col = 0; col < 8; col++){
		Pawn pawn = new Pawn("Black", new PieceLocation(1, col));
		chessBoard.placePieceAt(pawn);
	}
    }

    //returns the ChessBoard
    public ChessBoard getChessBoard(){
        return chessBoard;
    }
}
