import java.util.ArrayList;

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

        //Kings
        King Bking = new King("Black", new PieceLocation(0, 4), this);
        King Wking = new King("White", new PieceLocation(7, 4), this);

        //Queens
        Queen Bqueen = new Queen("Black", new PieceLocation(0, 3), this);
        Queen Wqueen = new Queen("White", new PieceLocation(7, 3), this);

        //Bishops
        Bishop Bbishop = new Bishop("Black", new PieceLocation(0, 2), this);
        Bbishop = new Bishop("Black", new PieceLocation(0, 5), this);
        Bishop Wbishop = new Bishop("White", new PieceLocation(7, 2), this);
        Wbishop = new Bishop("White", new PieceLocation(7, 5), this);

        //Knights
        Knight Bknight = new Knight("Black", new PieceLocation(0, 1), this);
        Bknight = new Knight("Black", new PieceLocation(0, 6), this);
        Knight Wknight = new Knight("White", new PieceLocation(7, 1), this);
        Wknight = new Knight("White", new PieceLocation(7, 6), this);

        //Rooks
        Rook Brook = new Rook("Black", new PieceLocation(0, 0), this);
        Brook = new Rook("Black", new PieceLocation(0, 7), this);
        Rook Wrook = new Rook("White", new PieceLocation(7, 0), this);
        Wrook = new Rook("White", new PieceLocation(7, 7), this);

        //Pawns
        for(int col = 0; col < 8; col++){
            Pawn Bpawn = new Pawn("Black", new PieceLocation(1, col), this);
        }
        for(int col = 0; col < 8; col++){
            Pawn Wpawn = new Pawn("White", new PieceLocation(6, col), this);
        }
    }

    //returns the ChessBoard
    public ChessBoard getChessBoard(){
        return chessBoard;
    }
}
