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
        return  Math.abs(location.getDifference(newLocation).getRow()) == Math.abs(location.getDifference(newLocation).getCol());
    }

    //Checks if a piece is moving in a straight line
    public boolean canMoveStraight(PieceLocation location, PieceLocation newLocation){
        return Math.abs(location.getDifference(newLocation).getRow()) == 0 || Math.abs(location.getDifference(newLocation).getCol()) == 0;
    }

    //Checks if a piece is moving in a straight line within a range
    public boolean canMoveDiagonally(PieceLocation location, PieceLocation newLocation, int range){
        return  Math.abs(location.getDifference(newLocation).getRow()) == Math.abs(location.getDifference(newLocation).getCol()) && Math.abs(location.getDifference(newLocation).getRow()) == range ;
    }

    //Checks if a piece is moving diagonally within a range
    public boolean canMoveStraight(PieceLocation location, PieceLocation newLocation, int range){
        return (Math.abs(location.getDifference(newLocation).getRow()) == 0 && Math.abs(location.getDifference(newLocation).getCol()) == range)|| (Math.abs(location.getDifference(newLocation).getCol()) == 0 && Math.abs(location.getDifference(newLocation).getRow()) == range);
    }


    abstract boolean canMoveTo(PieceLocation newLocation);
}