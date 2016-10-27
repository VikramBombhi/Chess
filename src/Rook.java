/**
 * Created by Vikram on 2016-10-21.
 * This class is a template for rook object
 */
public class Rook extends Piece {

    public Rook(String owner, PieceLocation location, ChessGame game){
        this.setOwner(owner);
        this.setLocation(location);
        this.setGame(game);
    }

    public boolean canMoveTo(PieceLocation newLocation){
        return super.canMoveStraight(this.getLocation(), newLocation);
    }

    @Override
    public String toString(){
        return " " + "r";
    }
}