/**
 * Created by Vikram on 2016-10-22.
 */
public class Pawn extends Piece {

    public Pawn(String owner, PieceLocation location, ChessGame game){
        this.setOwner(owner);
        this.setLocation(location);
        this.setGame(game);
    }

    public boolean canMoveTo(PieceLocation newLocation){
        return super.canMoveStraight(this.getLocation(), newLocation, 1);
    }

    @Override
    public String toString(){
        return " " + "p";
    }
}