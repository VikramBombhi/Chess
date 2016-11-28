public class Pawn extends Piece {
    //the pawn can move forward two tiles on the first move
    private boolean firstmove = true;


    public Pawn(String owner, PieceLocation location, ChessGame game){
        this.setOwner(owner);
        this.setLocation(location);
        this.game = game;
        this.game.getChessBoard().placePieceAt(this);
    }

    //Returns if move will kill enemy team member
    private boolean pawnAttack(PieceLocation newLocation){
        if(this.getLocation().getDifference(newLocation).getRow() == teamSign) {
                return (super.canMoveDiagonally(this.getLocation(), newLocation, 1) ||
                        super.canMoveDiagonally(this.getLocation(), newLocation, -1));
        }
        return false;
    }

    public boolean canMoveTo(PieceLocation newLocation){
        //if there is piece at newLocation and its a enemy team member return pawnAttack
        if(game.getChessBoard().isPieceAt(new PieceLocation(newLocation.getRow(), newLocation.getCol())) &&
                !game.getChessBoard().getTiles()[newLocation.getRow()][newLocation.getCol()].getPiece().getOwner().equals(this.getOwner())){
            firstmove = false;
            return pawnAttack(newLocation);
        }
        if(firstmove){
            if(super.canMoveStraight(this.getLocation(), newLocation, 2*teamSign) ||
                    super.canMoveStraight(this.getLocation(), newLocation, 1*teamSign)){
                firstmove = false;
                return true;
            }
        }
        return (super.canMoveStraight(this.getLocation(), newLocation, 1));
    }

    @Override
    public String toString(){
        if(this.getOwner().equals("White")){
            return " " + Character.toLowerCase(this.PawnID);
        }
        else return " " + this.PawnID;
    }
}