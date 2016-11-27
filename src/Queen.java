/**
 * Created by Vikram on 2016-10-19.
 * This class is a template for the queen object
 */
public class Queen extends Piece {

    public Queen(String owner, PieceLocation location, ChessGame game){
        this.setOwner(owner);
        this.setLocation(location);
        this.game = game;
        this.game.getChessBoard().placePieceAt(this);
    }

    public boolean canMoveTo(PieceLocation newLocation){
        return (super.canMoveDiagonally(this.getLocation(), newLocation, this.getLocation().getDifference(newLocation).getRow())
                || super.canMoveStraight(this.getLocation(), newLocation));
    }

    @Override
    public String toString(){
        if(this.getOwner().equals("White")){
            return " " + Character.toLowerCase(this.QueenID);
        }
        else return " " + this.QueenID;
    }
}
