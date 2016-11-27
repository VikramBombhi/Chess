import java.util.HashSet;

public class Pawn extends Piece {
    //the pawn can move forward two tiles on the first move
    private boolean firstmove = true;


    public Pawn(String owner, PieceLocation location, ChessGame game){
        this.setOwner(owner);
        this.setLocation(location);
        this.game = game;
        this.game.getChessBoard().placePieceAt(this);
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