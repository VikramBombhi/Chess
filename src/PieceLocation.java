/**
 * Created by Vikram on 2016-09-29.
 */
public class PieceLocation {
    private int x, y;

    public PieceLocation(int newY, int newX){
        y = newY;
        x = newX;
    }

    public void setLocation(int newY, int newX){
        y = newY;
        x = newX;
    }

    public int getY(){
        return y;
    }

    public int getX(){
        return x;
    }
}
