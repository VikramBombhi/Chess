/**
 * Created by Vikram on 2016-09-28.
 */
public class Knight extends Piece {
    private PieceLocation location;
    private String owner;
    private ChessGame game;

    public Knight(String team, int y, int x){
        owner = team;
        location = new PieceLocation(y, x);
    }

    public void moveTo(int row, int col){
        location.setLocation(row, col);
    }

    public int getRow(){
        return location.getRow();
    }

    public int getCol(){
        return location.getCol();
    }
}