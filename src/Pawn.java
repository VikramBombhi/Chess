public class Pawn extends Piece {
    //the pawn can move forward two tiles on the first move
    private boolean firstmove = true;


    public Pawn(String owner, PieceLocation location, ChessGame game){
        this.setOwner(owner);
        this.setLocation(location);
        this.game = game;
        this.game.getChessBoard().placePieceAt(this);
    }

    //Checks if move will kill enemy team
    private boolean pawnAttack(PieceLocation newLocation){
        if(this.getLocation().getDifference(newLocation).getRow() == teamSign) {
            if (game.getChessBoard().isPieceAt(new PieceLocation(newLocation.getRow(), newLocation.getCol())) &&
                    !game.getChessBoard().getTiles()[newLocation.getRow()][newLocation.getCol()].getPiece().getOwner().equals(this.getOwner())) {
                return (super.canMoveDiagonally(this.getLocation(), newLocation, 1) ||
                        super.canMoveDiagonally(this.getLocation(), newLocation, -1));
            }
        }
        return false;
    }

    public boolean canMoveTo(PieceLocation newLocation){
        if(firstmove){
            if(super.canMoveStraight(this.getLocation(), newLocation, 2*teamSign) ||
                    super.canMoveStraight(this.getLocation(), newLocation, 1*teamSign) ||
                    pawnAttack(newLocation)){
                firstmove = false;
                return true;
            }
        }
        return (super.canMoveStraight(this.getLocation(), newLocation, 1) ||
                pawnAttack(newLocation));
    }

    @Override
    public String toString(){
        if(this.getOwner().equals("White")){
            return " " + Character.toLowerCase(this.PawnID);
        }
        else return " " + this.PawnID;
    }
}