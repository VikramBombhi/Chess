/**
 * Created by Vikram on 2016-09-28.
 */
public class ChessBoard {
    private Tile tiles[][] = new Tile[8][8];

    public ChessBoard(){
        for(int row = 0; row<8; row++){
            for(int col = 0; col<8; col++){
                tiles[row][col] = new Tile();
            }
        }
    }

    public Tile[][] getTiles(){
        return tiles;
    }

    public boolean isPieceAt(int row, int col){
        if(tiles[row][col].getPiece() == null){
            return false;
        }
        else{
            return true;
        }
    }

    public void addPiece(Piece piece, int row, int col){
        tiles[row][col].setPiece(piece);
    }

    public void removePiece(int row, int col){
        tiles[row][col].setPiece();
    }

    public void movePiece(int row, int col, int newRow, int newCol){
        tiles[newRow][newCol].setPiece(tiles[row][col].getPiece());
        tiles[newRow][newCol].move(newRow, newCol);
        removePiece(row, col);
    }
}