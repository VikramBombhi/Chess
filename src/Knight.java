/**
 * Created by Vikram on 2016-09-28.
 */
public class Knight extends Piece {
    private PieceLocation location;
    private String team;

    public Knight(String team, int y, int x){
        this.location.setLocation(y, x);
        this.team = team;
    }

    public void moveTo(int y, int x){
        this.location.setLocation(y, x);
    }

    public int getY(){
        return this.location.getY();
    }

    public int getX(){
        return this.location.getX();
    }
}
