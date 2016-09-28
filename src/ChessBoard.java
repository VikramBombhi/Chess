/**
 * Created by Vikram on 2016-09-28.
 */
public class ChessBoard {
    public enum Pieces {
        KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN
    }
    private int board[][] = new int[8][8];

    public ChessBoard(){

    }

    public int[][] getBoard(){
        return board;
    }

    public int pieceAt(int x, int y){
        return board[x][y];
    }

    public void addPiece(){

    }

    public void removePiece(){

    }
}