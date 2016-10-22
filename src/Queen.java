/**
 * Created by Vikram on 2016-10-19.
 * This class is a template for the queen object
 */
public class Queen extends Piece {

    public Queen(String owner, PieceLocation location, ChessGame game){
        this.setOwner(owner);
        this.setLocation(location);
        this.setGame(game);
    }

    public boolean canMoveTo(PieceLocation newLocation){
        return (super.canMoveDiagonally(this.getLocation(), newLocation) || super.canMoveStraight(this.getLocation(), newLocation));
    }

    @Override
    public String toString(){
        return " " + "q";
    }
}
