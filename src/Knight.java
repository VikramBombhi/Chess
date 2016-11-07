/**
 * Created by Vikram on 2016-09-28.
 * This class extends the piece class and implements the knight piece
 */

public class Knight extends Piece {

    public Knight(String owner, PieceLocation location){
        this.setOwner(owner);
        this.setLocation(location);
    }

    //checks if knight can move to newLocation
    public boolean canMoveTo(PieceLocation newLocation){
        PieceLocation newLocaasd = this.getLocation().getDifference(newLocation);
        //returns true if either newRow or newCol changes by two and the other by one(hence moves in a 'L')
        if(PlayGame.game.getChessBoard().getTiles()[newLocation.getRow()][newLocation.getCol()].getPiece() != null
                && PlayGame.game.getChessBoard().getTiles()[newLocation.getRow()][newLocation.getCol()].getPiece().getOwner().equals(this.getOwner())){
            System.out.print("Hit team member! ");
            return false;
        }
        else return (Math.abs(newLocaasd.getRow()) == 2 && Math.abs(newLocaasd.getCol()) == 1
                || Math.abs(newLocaasd.getRow()) == 1 && Math.abs(newLocaasd.getCol()) == 2);
    }

    @Override
    public String toString(){
        if(this.getOwner().equals("White")){
            return " " + Character.toLowerCase(this.KnightID);
        }
        else return " " + this.KnightID;
    }
}