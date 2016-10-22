/**
 * Created by Vikram on 2016-10-21.
 */
public class Bishop extends Piece {

    public Bishop(String owner, PieceLocation location, ChessGame game){
        this.setOwner(owner);
        this.setLocation(location);
        this.setGame(game);
    }

    public boolean canMoveTo(PieceLocation newLocation){
        return super.canMoveDiagonally(this.getLocation(), newLocation);
    }

    @Override
    public String toString(){
        return " " + "b";
    }
}
