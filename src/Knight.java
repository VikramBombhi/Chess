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
        int newRow = newLocation.getRow();
        int newCol = newLocation.getCol();
        //checking if newLocation is on the board
        if(newRow > 7 || newCol > 7){
            return false;
        }
        //sets newRow and newCol to the difference between newLocation and current location of knight
        newRow -= this.getLocation().getRow();
        newCol -= this.getLocation().getCol();
        //returns true if either newRow or newCol changes by two and the other by one(hence moves in a 'L')
        return(Math.abs(newRow) == 2 && Math.abs(newCol) == 1 || Math.abs(newCol) == 2 && Math.abs(newRow) == 1 && !PlayGame.game.getChessBoard().getTiles()[newRow][newCol].getPiece().getOwner().equals(this.getOwner()));
    }

    @Override
    public String toString(){
        if(this.getOwner().equals("White")){
            return " " + Character.toLowerCase(this.KnightID);
        }
        else return " " + this.KnightID;
    }
}