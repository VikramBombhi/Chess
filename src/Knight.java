/**
 * Created by Vikram on 2016-09-28.
 */
public class Knight extends Piece {
    private PieceLocation location;
    private String owner;

    public Knight(String team, int y, int x){
        owner = team;
        location = new PieceLocation(y, x);
    }

    public void moveTo(int y, int x){
        location.setLocation(y, x);
    }

    public int getY(){
        return location.getY();
    }

    public int getX(){
        return location.getX();
    }
}
