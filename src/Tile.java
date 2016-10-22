/**
 * Created by Vikram on 2016-09-29.
 * Tiles exist at every location in the chessboard and contain Piece's
 */
public class Tile {
    private Piece piece;

    //All tiles contain no piece initially or in other words the board is clear
    public Tile(){
        this.piece = null;
    }

    //returns the piece that exists inside this tile
    public Piece getPiece() {
        return piece;
    }

    //sets piece inside tile to given piece
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    //removes piece from tile by setting tile to null
    public void removePiece(){
        this.piece = null;
    }

    //prints " k" if tile contains knight and " -" if it has no piece
    @Override
    public String toString(){
        if(piece == null){
            return " -";
        }
        else{
            //return " k";
            return piece.toString();
        }
    }
}
