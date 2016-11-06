/**
 * Created by Vikram on 2016-10-21.
 */
public class Bishop extends Piece {

    public Bishop(String owner, PieceLocation location){
        this.setOwner(owner);
        this.setLocation(location);
    }

    public boolean canMoveTo(PieceLocation newLocation){
        return super.canMoveDiagonally(this.getLocation(), newLocation, this.getLocation().getDifference(newLocation).getRow());
    }

    @Override
    public String toString(){
        if(this.getOwner().equals("White")){
            return " " + Character.toLowerCase(this.BishopID);
        }
        else return " " + this.BishopID;
    }
}
