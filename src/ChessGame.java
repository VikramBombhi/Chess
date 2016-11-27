import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Vikram on 2016-09-29.
 * ChessGame class creates the chessboard and sets up the board
 */
public class ChessGame {
    private ChessBoard chessBoard;
    private ArrayList<Piece> teamBlack;
    private ArrayList<Piece> teamWhite;

    public ChessGame(){
        chessBoard = new ChessBoard();
        teamBlack = new ArrayList<>();
        teamWhite = new ArrayList<>();
        placeTeam("Black", 0);
        placeTeam("White", 7);
    }

    //Place pieces on the board at the start of a  new ChessGame
    private void placeTeam(String team, int backRow){
        int col = 0;
        ArrayList teamArr;
        int pawnRow;
        if(team.equals("Black")){
            pawnRow = 1;
            teamArr = teamBlack;
        }
        else {
            pawnRow = 6;
            teamArr = teamWhite;
        }

        //Rook
        Piece rook = new Rook(team, new PieceLocation(backRow, col), this);
        teamArr.add(rook);
        rook = new Rook(team, new PieceLocation(backRow, 7-col), this);
        teamArr.add(rook);
        col += 1;

        //Knight
        Piece knight = new Knight(team, new PieceLocation(backRow, col), this);
        teamArr.add(knight);
        knight = new Knight(team, new PieceLocation(backRow, 7-col), this);
        teamArr.add(knight);
        col += 1;

        //Bishop
        Piece bishop = new Bishop(team, new PieceLocation(backRow, col), this);
        teamArr.add(bishop);
        bishop = new Bishop(team, new PieceLocation(backRow, 7-col), this);
        teamArr.add(bishop);
        col += 1;

        //Queen
        Piece queen = new Queen(team, new PieceLocation(backRow, col), this);
        teamArr.add(queen);
        col += 1;

        //King
        Piece king = new King(team, new PieceLocation(backRow, col), this);
        teamArr.add(king);

        //Pawns
        for(int pawnCol = 0; pawnCol < 8; pawnCol++){
            Piece pawn = new Pawn(team, new PieceLocation(pawnRow, pawnCol), this);
            teamArr.add(pawn);
        }
    }

    //returns the ChessBoard
    public ChessBoard getChessBoard(){
        return chessBoard;
    }

    public ArrayList getEnemyTeam(String team){
        if(team.equals("Black")){
            return teamWhite;
        }
        else return teamBlack;
    }

    public ArrayList getYourTeam(String team){
        if(team.equals("White")){
            return teamWhite;
        }
        else return teamBlack;
    }

}
