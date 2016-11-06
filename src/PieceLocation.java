/**
 * Created by Vikram on 2016-09-29.
 * PieceLocation class is used to store location of all pieces
 */
public class PieceLocation {
    private int row, col;

    public PieceLocation(int newRow, int newCol){
        row = newRow;
        col = newCol;
    }

    //sets row and col to given location
    public void setLocation(PieceLocation location){
        row = location.getRow();
        col = location.getCol();
    }

    //returns row
    public int getRow(){
        return row;
    }

    //returns col
    public int getCol(){
        return col;
    }

    public PieceLocation getDifference(PieceLocation newLocation){
        int teamSign = PlayGame.game.getChessBoard().getTiles()[this.row][this.col].getPiece().getTeamSign();
        return (new PieceLocation((newLocation.getRow()-this.getRow())*teamSign, (newLocation.getCol()-this.getCol())*teamSign));
    }
}
