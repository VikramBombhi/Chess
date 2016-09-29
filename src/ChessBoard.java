/**
 * Created by Vikram on 2016-09-28.
 */
public class ChessBoard {
    private Tile board[][] = new Tile[8][8];

    public ChessBoard(){
        for(int x = 0; x<8; x++){
            for(int y = 0; y<8; y++){
                board[x][y] = new Tile();
            }
        }
    }

    public Object pieceAt(int x, int y){
        return board[y][x].getPiece();
    }

    public void addPiece(Piece piece, int y, int x){
        board[y][x].setPiece(piece);
    }

    public void removePiece(int y, int x){
        board[y][x].setPiece();
    }

    public void movePiece(int y, int x, int newY, int newX){
        board[y][x].move(y, x);
        board[newY][newX] = board[y][x];
        board[y][x].setPiece();
    }
}