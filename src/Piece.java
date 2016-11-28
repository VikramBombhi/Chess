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

    protected void setOwner(String owner){
        this.owner = owner;
        if(owner.equals("WHITE")){
            teamSign = -1;
        }
    }

    public int getTeamSign(){
        return teamSign;
    }

    protected void setLocation(PieceLocation location){
        this.location = location;
    }

    //range checking is introduced so pieces like the pawn cannot move across the board but can still use the same methods as other pieces
    //Checks if a piece is moving diagonally within a given range and there are no team members along the way
    protected boolean canMoveDiagonally(PieceLocation location, PieceLocation newLocation, int range){
        return (Math.abs(location.getDifference(newLocation).getRow()) == Math.abs(location.getDifference(newLocation).getCol())
                && location.getDifference(newLocation).getRow() == range)
                && checkPath(newLocation);
    }

    //Checks if a piece is moving in a straight line, there is no range check for this method
    protected boolean canMoveStraight(PieceLocation location, PieceLocation newLocation){
        return (Math.abs(location.getDifference(newLocation).getRow()) == 0
                || Math.abs(location.getDifference(newLocation).getCol()) == 0)
                && checkPath(newLocation);
    }

    //Checks if a piece is moving diagonally within a range
    protected boolean canMoveStraight(PieceLocation location, PieceLocation newLocation, int range){
        return ((Math.abs(location.getDifference(newLocation).getRow()) == 0 && Math.abs(location.getDifference(newLocation).getCol()) == range)
                || (Math.abs(location.getDifference(newLocation).getRow()) == range && Math.abs(location.getDifference(newLocation).getCol()) == 0))
                && checkPath(newLocation);
    }

    //checks if any kings are threatened
    private void check(){
        //checks if enemy team is now under check because of your move
        for(Object obj : game.getEnemyTeam(this.owner)){
            Piece enemy = (Piece) obj;
            if(enemy.toString().toLowerCase().equals(" k")){
                for(Object obj2 : game.getYourTeam(this.owner)){
                    Piece teamMember = (Piece) obj2;
                    if(teamMember.canMoveTo(enemy.getLocation())) {
                        System.out.println("team " + enemy.getOwner() + " is now in check");
                        break;
                    }
                }
                break;
            }
        }

        //checks if your team is now under check because or your move
        for(Object obj : game.getYourTeam(this.owner)){
            Piece teamMember = (Piece) obj;
            if(teamMember.toString().toLowerCase().equals(" k")){
                for(Object obj2 : game.getEnemyTeam(this.owner)){
                    Piece enemy = (Piece) obj2;
                    if(enemy.canMoveTo(teamMember.getLocation())) {
                            System.out.println("team " + teamMember.getOwner() + " is now in check");
                            break;
                    }
                }
                break;
            }
        }
    }

    //checks the path between the piece location and newLocation for and team members
    private boolean checkPath(PieceLocation newLocation){
        //check if team member is at newLocation
        if(game.getChessBoard().getTiles()[newLocation.getRow()][newLocation.getCol()].getPiece().getOwner().equals(owner)){
            return false;
        }

        int rowDiffSign = Integer.signum(location.getDifference(newLocation).getRow()); //is the direction of movement(row)
        int colDiffSign = Integer.signum(location.getDifference(newLocation).getCol()); //is the direction of movement(col)
        int row = location.getRow()+ rowDiffSign; //start checking for collisions one square forward in direction of movement
        int col = location.getCol() + colDiffSign; //start checking for collisions one square forward in direction of movement

        //check if any piece is between location and newLocation
        while(row!=newLocation.getRow() || col!=newLocation.getCol()){
            if(game.getChessBoard().isPieceAt(new PieceLocation(row, col))){
                System.out.print("There is a piece in the way ");
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
    1.) if piece exists at newLocation remove it from its team HashSet
    2.) get piece from location and set it at newLocation
    3.) set the PieceLocation of moving piece to newLocation
    4.) set piece at location to null
    */
    public void moveTo(PieceLocation newLocation){
        if(this.canMoveTo(newLocation)){
            if(game.getChessBoard().isPieceAt(newLocation) &&
                    !game.getChessBoard().getTiles()[newLocation.getRow()][newLocation.getCol()].getPiece().getOwner().equals(this.owner)){
                game.getEnemyTeam(this.owner).remove(game.getChessBoard().getTiles()[newLocation.getRow()][newLocation.getCol()].getPiece());
            }
            game.getChessBoard().getTiles()[newLocation.getRow()][newLocation.getCol()].setPiece(this);
            game.getChessBoard().getTiles()[location.getRow()][location.getCol()].removePiece();
            this.setLocation(newLocation);
            check();

        }
        else throw new IllegalArgumentException("Piece cannot move there");
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) {
            return false;
        }
        if (!Piece.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        Piece piece = (Piece) obj;
        return (piece.getOwner().equals(this.owner) && piece.getLocation().equals(this.location));
    }
}