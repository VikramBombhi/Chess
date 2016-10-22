/**
 * Created by Vikram on 2016-09-28.
 * This is a abstract class extended by the Knight class
 */
public abstract class Piece {
    private ChessGame game;
    private String owner;
    private PieceLocation location;

    public ChessGame getGame(){
        return game;
    }

    public String getOwner(){
        return owner;
    }

    public PieceLocation getLocation(){
        return location;
    }

    public void setGame(ChessGame game){
        this.game = game;
    }

    public void setOwner(String owner){
        this.owner = owner;
    }

    public void setLocation(PieceLocation location){
        this.location = location;
    }

    //Checks if a piece is moving diagonally
    public boolean canMoveDiagonally(PieceLocation location, PieceLocation newLocation){
        return  location.getDifference(newLocation).getRow() == location.getDifference(newLocation).getCol();
    }

    //Checks if a piece is moving in a straight line
    public boolean canMoveStraight(PieceLocation location, PieceLocation newLocation){
        return location.getDifference(newLocation).getRow() == 0 || location.getDifference(newLocation).getCol() ==0;
    }

    abstract boolean canMoveTo(PieceLocation newLocation);
}