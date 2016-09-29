/**
 * Created by Vikram on 2016-09-29.
 */
public class PieceLocation {
    private int x, y;

    public PieceLocation(int y, int x){
        this.y = y;
        this.x = x;
    }

    public void setLocation(int y, int x){
        this.y = y;
        this.x = x;
    }

    public int getY(){
        return this.y;
    }

    public int getX(){
        return this.x;
    }
}
