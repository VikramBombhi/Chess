/**
 * Created by Vikram on 2016-10-21.
 * This class is a template for rook object
 */
public class Rook extends Piece {

    public Rook(String owner, PieceLocation location, ChessGame game){
        this.setOwner(owner);
        this.setLocation(location);
        this.game = game;
        this.game.getChessBoard().placePieceAt(this);
    }

    public boolean canMoveTo(PieceLocation newLocation){
        return super.canMoveStraight(this.getLocation(), newLocation);
    }


    @Override
    public String toString(){
        if(this.getOwner().equals("White")){
            return " " + Character.toLowerCase(this.RookID);
        }
        else return " " + this.RookID;
    }
}