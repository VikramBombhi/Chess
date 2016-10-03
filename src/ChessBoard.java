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

    public boolean canMoveTo(PieceLocation location, PieceLocation newLocation){
        return tiles[location.getRow()][location.getCol()].getPiece().canMoveTo(newLocation);
    }

    public boolean isPieceAt(PieceLocation location){
        if(tiles[location.getRow()][location.getCol()].getPiece() == null){
            return false;
        }
        else{
            return true;
        }
    }

    public void addPiece(Piece piece){
        tiles[piece.getRow()][piece.getCol()].setPiece(piece);
    }

    public void removePiece(int row, int col){
        tiles[row][col].setPiece();
    }

    public void movePiece(PieceLocation location, PieceLocation newLocation){
        tiles[newLocation.getRow()][newLocation.getCol()].setPiece(tiles[location.getRow()][location.getCol()].getPiece());
        tiles[newLocation.getRow()][newLocation.getCol()].move(newLocation);
        removePiece(location.getRow(), location.getCol());
    }
}