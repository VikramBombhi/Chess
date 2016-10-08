/**
 * Created by Vikram on 2016-09-28.
 */
public class ChessBoard {
    //Initialize a 2D array containing a Tile obj
    private Tile tiles[][] = new Tile[8][8];

    //Assign Tile obj's to entire ChessBoard
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

    //Check if a a piece at location can move to newLocation using the canMoveTo method from the Piece
    public boolean canMoveTo(PieceLocation location, PieceLocation newLocation){
        return tiles[location.getRow()][location.getCol()].getPiece().canMoveTo(newLocation);
    }

    //Check if Piece at location is null or not
    public boolean isPieceAt(PieceLocation location){
        if(tiles[location.getRow()][location.getCol()].getPiece() == null){
            return false;
        }
        else{
            return true;
        }
    }

    //Place piece using setPiece method from the Tile class
    public void addPiece(Piece piece){
        tiles[piece.getRow()][piece.getCol()].setPiece(piece);
    }

    /*
    Move piece from location to newLocation in three steps
    1.) get piece from location and set it at newLocation
    2.) set the PieceLocation obj that exist inside the piece to newLocation
    3.) set piece at location to null
    */
    public void movePiece(PieceLocation location, PieceLocation newLocation){
        tiles[newLocation.getRow()][newLocation.getCol()].setPiece(tiles[location.getRow()][location.getCol()].getPiece());
        tiles[newLocation.getRow()][newLocation.getCol()].getPiece().moveTo(newLocation);
        tiles[location.getRow()][location.getCol()].removePiece();
    }
}