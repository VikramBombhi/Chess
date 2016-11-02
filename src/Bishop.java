/**
 * Created by Vikram on 2016-10-21.
 */
public class Bishop extends Piece {

    public Bishop(String owner, PieceLocation location){
        this.setOwner(owner);
        this.setLocation(location);
    }

    public boolean canMoveTo(PieceLocation newLocation){
        return super.canMoveDiagonally(this.getLocation(), newLocation);
    }

    @Override
    public String toString(){
        return " " + "b";
    }
}
