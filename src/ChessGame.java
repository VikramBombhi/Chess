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

        //Black pieces
        //create&place king
        King Bking = new King("Black", new PieceLocation(0, 4));
        chessBoard.placePieceAt(Bking);

        //create&place queen
        Queen Bqueen = new Queen("Black", new PieceLocation(0, 3));
        chessBoard.placePieceAt(Bqueen);

        //create&place bishops
        Bishop Bbishop = new Bishop("Black", new PieceLocation(0, 2));
        chessBoard.placePieceAt(Bbishop);

        Bbishop = new Bishop("Black", new PieceLocation(0, 5));
        chessBoard.placePieceAt(Bbishop);

        //create&place knights
        Knight Bknight = new Knight("Black", new PieceLocation(0, 1));
        chessBoard.placePieceAt(Bknight);

        Bknight = new Knight("Black", new PieceLocation(0, 6));
        chessBoard.placePieceAt(Bknight);

        //create&place rooks
        Rook Brook = new Rook("Black", new PieceLocation(0, 0));
        chessBoard.placePieceAt(Brook);

        Brook = new Rook("Black", new PieceLocation(0, 7));
        chessBoard.placePieceAt(Brook);

        //create&place pawns
        for(int col = 0; col < 8; col++){
            Pawn Bpawn = new Pawn("Black", new PieceLocation(1, col));
            chessBoard.placePieceAt(Bpawn);
        }

        //White pieces
        //create&place king
        King Wking = new King("White", new PieceLocation(7, 4));
        chessBoard.placePieceAt(Wking);

        //create&place queen
        Queen Wqueen = new Queen("White", new PieceLocation(7, 3));
        chessBoard.placePieceAt(Wqueen);

        //create&place bishops
        Bishop Wbishop = new Bishop("White", new PieceLocation(7, 2));
        chessBoard.placePieceAt(Wbishop);

        Wbishop = new Bishop("White", new PieceLocation(7, 5));
        chessBoard.placePieceAt(Wbishop);

        //create&place knights
        Knight Wknight = new Knight("White", new PieceLocation(7, 1));
        chessBoard.placePieceAt(Wknight);

        Wknight = new Knight("White", new PieceLocation(7, 6));
        chessBoard.placePieceAt(Wknight);

        //create&place rooks
        Rook Wrook = new Rook("White", new PieceLocation(7, 0));
        chessBoard.placePieceAt(Wrook);

        Wrook = new Rook("White", new PieceLocation(7, 7));
        chessBoard.placePieceAt(Wrook);

        //create&place pawns
        for(int col = 0; col < 8; col++){
            Pawn Wpawn = new Pawn("White", new PieceLocation(6, col));
            chessBoard.placePieceAt(Wpawn);
        }
    }

    //returns the ChessBoard
    public ChessBoard getChessBoard(){
        return chessBoard;
    }
}
