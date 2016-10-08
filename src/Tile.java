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

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void removePiece(){
        this.piece = null;
    }

    @Override
    public String toString(){
        if(piece == null){
            return "-";
        }
        else{
            return "k";
        }
    }
}
