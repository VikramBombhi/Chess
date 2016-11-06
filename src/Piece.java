import java.util.HashMap;
import java.util.StringJoiner;

/**
 * Created by Vikram on 2016-09-28.
 * This is a abstract class extended by the Knight class
 */
public abstract class Piece {
    private String owner;
    private PieceLocation location;
    protected int teamSign = 1;
    protected char KingID = 'K';
    protected char QueenID = 'Q';
    protected char BishopID = 'B';
    protected char KnightID = 'N';
    protected char RookID = 'R';
    protected char PawnID = 'P';

    abstract boolean canMoveTo(PieceLocation newLocation);

    public String getOwner(){
        return owner;
    }

    public PieceLocation getLocation(){
        return location;
    }

    public void setOwner(String owner){
        this.owner = owner;
        if(owner.equals("WHITE")){
            teamSign = -1;
        }
    }

    public int getTeamSign(){
        return teamSign;
    }

    public void setLocation(PieceLocation location){
        this.location = location;
    }

    //Checks if a piece is moving diagonally and there are no team members along the way
    public boolean canMoveDiagonally(PieceLocation location, PieceLocation newLocation, int range){
        if(Math.abs(location.getDifference(newLocation).getRow()) == Math.abs(location.getDifference(newLocation).getCol()) && location.getDifference(newLocation).getRow() == range){
            return checkPath(newLocation);
        }
        else return false;
    }

    //Checks if a piece is moving in a straight line
    public boolean canMoveStraight(PieceLocation location, PieceLocation newLocation){
        return (Math.abs(location.getDifference(newLocation).getRow()) == 0 || Math.abs(location.getDifference(newLocation).getCol()) == 0) && checkPath(newLocation);
    }

    //Checks if a piece is moving diagonally within a range
    public boolean canMoveStraight(PieceLocation location, PieceLocation newLocation, int range){
        if((Math.abs(location.getDifference(newLocation).getRow()) == 0 && Math.abs(location.getDifference(newLocation).getCol()) == range)
                || (Math.abs(location.getDifference(newLocation).getCol()) == 0 && Math.abs(location.getDifference(newLocation).getRow()) == range)){
            return checkPath(newLocation);
        }
        else return false;
    }

    private boolean checkPath(PieceLocation newLocation){
        int rowDiffSign = Integer.signum(location.getDifference(newLocation).getRow());
        int colDiffSign = Integer.signum(location.getDifference(newLocation).getCol());
        int row = location.getRow()+rowDiffSign;
        int col = location.getCol()+colDiffSign;
        while(row!=newLocation.getRow()){
            if(PlayGame.game.getChessBoard().getTiles()[row][col].getPiece() != null &&
                    PlayGame.game.getChessBoard().getTiles()[row][col].getPiece().getOwner().equals(owner)){
                System.out.print("Hit team member! ");
                return false;
            }
            else{
                row+=rowDiffSign;
                col+=colDiffSign;
            }
        }
        return true;
    }
}