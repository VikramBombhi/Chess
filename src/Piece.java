/**
 * Created by Vikram on 2016-09-28.
 */
public abstract class Piece {
    abstract boolean canMoveTo(PieceLocation newLocation);
    abstract void moveTo(PieceLocation location);
    abstract int getRow();
    abstract int getCol();
}