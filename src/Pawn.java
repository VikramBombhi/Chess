/**
 * Created by Vikram on 2016-10-22.
 */
public class Pawn extends Piece {
    //the pawn can move forward two tiles on the first move
    private boolean firstmove = true;


    public Pawn(String owner, PieceLocation location){
        this.setOwner(owner);
        this.setLocation(location);
    }

    public boolean canMoveTo(PieceLocation newLocation){
        if(firstmove){
            firstmove = false;
            return (super.canMoveStraight(this.getLocation(), newLocation, 2*teamSign) || super.canMoveStraight(this.getLocation(), newLocation, 1*teamSign));
        }
        else return super.canMoveStraight(this.getLocation(), newLocation, 1);
    }

    @Override
    public String toString(){
        if(this.getOwner().equals("White")){
            return " " + Character.toLowerCase(this.PawnID);
        }
        else return " " + this.PawnID;
    }
}