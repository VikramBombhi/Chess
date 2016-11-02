/**
 * Created by Vikram on 2016-10-21.
 * This class is a template for rook object
 */
public class Rook extends Piece {

    public Rook(String owner, PieceLocation location){
        this.setOwner(owner);
        this.setLocation(location);
    }

    public boolean canMoveTo(PieceLocation newLocation){
        return super.canMoveStraight(this.getLocation(), newLocation);
    }

    @Override
    public String toString(){
        return " " + "r";
    }
}