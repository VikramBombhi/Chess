/**
 * Created by Vikram on 2016-09-28.
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

    public boolean canMoveTo(PieceLocation newLocation){
        int y = newLocation.getRow();
        int x = newLocation.getCol();
        if(y > 7 || x > 7){
            return false;
        }
        y -= this.location.getRow();
        x -= this.location.getCol();
        return(y == 2 && x ==1 || x == 2 && y==1);
    }

    public void moveTo(PieceLocation location){
        location.setLocation(location);
    }

    public int getRow(){
        return location.getRow();
    }

    public int getCol(){
        return location.getCol();
    }
}