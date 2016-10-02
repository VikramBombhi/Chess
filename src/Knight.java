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