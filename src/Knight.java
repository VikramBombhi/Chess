/**
 * Created by Vikram on 2016-09-28.
 * This class extends the piece class
 */

public class Knight extends Piece {
    private PieceLocation location;
    private String owner;
    private ChessGame game;

    public Knight(String team, PieceLocation initLocation, ChessGame game){
        this.owner = team;
        this.location = initLocation;
        this.game = game;
    }

    //returns location of knight
    public PieceLocation getLocation(){
        return location;
    }

    //returns string owner of knight
    public String getOwner(){
        return owner;
    }

    //returns game that knight belongs to
    public ChessGame getGame(){
        return game;
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
        newRow -= this.location.getRow();
        newCol -= this.location.getCol();
        //returns true if either newRow or newCol changes by two and the other by one(hence moves in a 'L')
        return(Math.abs(newRow) == 2 && Math.abs(newCol) == 1 || Math.abs(newCol) == 2 && Math.abs(newRow) == 1);
    }
}