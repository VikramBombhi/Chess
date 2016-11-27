import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Vikram on 2016-09-28.
 * This is a abstract class extended by the Knight class
 * Everything has been tested for the top team(BLACK) however everything should work for bottom team as well(WHITE)
 */
public abstract class Piece {
    private String owner;
    private PieceLocation location;
    protected ChessGame game;
    //teamSign is a easy way to use methods for both teams, it works by essentially flipping the board when it comes to calculations
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

    //range checking is introduced so pieces like the pawn cannot move across the board but can still use the same methods as other pieces
    //Checks if a piece is moving diagonally within a given range and there are no team members along the way
    public boolean canMoveDiagonally(PieceLocation location, PieceLocation newLocation, int range){
        return (Math.abs(location.getDifference(newLocation).getRow()) == Math.abs(location.getDifference(newLocation).getCol())
                && location.getDifference(newLocation).getRow() == range)
                && checkPath(newLocation);
    }

    //Checks if a piece is moving in a straight line, there is no range check for this method
    public boolean canMoveStraight(PieceLocation location, PieceLocation newLocation){
        return (Math.abs(location.getDifference(newLocation).getRow()) == 0
                || Math.abs(location.getDifference(newLocation).getCol()) == 0)
                && checkPath(newLocation);
    }

    //Checks if a piece is moving diagonally within a range
    public boolean canMoveStraight(PieceLocation location, PieceLocation newLocation, int range){
        return ((Math.abs(location.getDifference(newLocation).getRow()) == 0 && Math.abs(location.getDifference(newLocation).getCol()) == range)
                || (Math.abs(location.getDifference(newLocation).getRow()) == range && Math.abs(location.getDifference(newLocation).getCol()) == 0))
                && checkPath(newLocation);
    }

    public void threating(){
        for(Object obj : game.getEnemyTeam(this.owner)){
            Piece enemy = (Piece) obj;
            if(enemy.toString().toLowerCase().equals(" k")){
                if(this.canMoveTo(enemy.getLocation())) {
                    System.out.println("Team " + enemy.getOwner() + "'s king is under check");
                }
            }
        }
        for(Object obj : game.getYourTeam(this.owner)){
            Piece enemy = (Piece) obj;
            if(enemy.toString().toLowerCase().equals(" k")){
                if(this.canMoveTo(enemy.getLocation())) {
                    System.out.println("Team " + enemy.getOwner() + "'s king is under check");
                }
            }
        }
    }

    //checks the path between the piece location and newLocation for and team members
    private boolean checkPath(PieceLocation newLocation){
        int rowDiffSign = Integer.signum(location.getDifference(newLocation).getRow()); //is the direction of movement(row)
        int colDiffSign = Integer.signum(location.getDifference(newLocation).getCol()); //is the direction of movement(col)
        int row = location.getRow()+ rowDiffSign; //start checking for collisions one square forward in direction of movement
        int col = location.getCol() + colDiffSign; //start checking for collisions one square forward in direction of movement
        while(row!=newLocation.getRow() + rowDiffSign || col!=newLocation.getCol() + colDiffSign){
            if(game.getChessBoard().isPieceAt(new PieceLocation(row, col)) &&
                    game.getChessBoard().getTiles()[row][col].getPiece().getOwner().equals(owner)){
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

    /*
    Move piece from location to newLocation in three steps
    1.) get piece from location and set it at newLocation
    2.) set the PieceLocation obj that exist inside the piece to newLocation
    3.) set piece at location to null
    */
    public void moveTo(PieceLocation newLocation){
        if(this.canMoveTo(newLocation)){
            game.getChessBoard().getTiles()[newLocation.getRow()][newLocation.getCol()].setPiece(this);
            game.getChessBoard().getTiles()[location.getRow()][location.getCol()].removePiece();
            this.setLocation(newLocation);
            if(game.getChessBoard().isPieceAt(newLocation)){
                game.getEnemyTeam(this.owner).remove(game.getChessBoard().getTiles()[newLocation.getRow()][newLocation.getCol()].getPiece());
            }
            threating();

        }
        else throw new IllegalArgumentException("Piece cannot move there");
    }
}