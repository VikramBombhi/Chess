/**
 * Created by Vikram on 2016-09-28.
 * This is a abstract class extended by the Knight class
 */
public abstract class Piece {
    abstract boolean canMoveTo(PieceLocation newLocation);
    abstract void moveTo(PieceLocation location);
    abstract int getRow();
    abstract int getCol();
}