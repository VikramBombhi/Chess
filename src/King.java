/**
 * Created by Vikram on 2016-10-22.
 * This class is a template for the king object
 */
public class King extends Piece {

    public King(String owner, PieceLocation location){
        this.setOwner(owner);
        this.setLocation(location);
    }

    public boolean canMoveTo(PieceLocation newLocation){
        return super.canMoveStraight(this.getLocation(), newLocation, 1) ||
                super.canMoveDiagonally(this.getLocation(), newLocation, 1) ||
                super.canMoveStraight(this.getLocation(), newLocation, -1) ||
                super.canMoveDiagonally(this.getLocation(), newLocation, -1);
    }

    @Override
    public String toString(){
        if(this.getOwner().equals("White")){
            return " " + Character.toLowerCase(this.KingID);
        }
        else return " " + this.KingID;
    }
}