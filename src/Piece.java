/**
 * Created by Vikram on 2016-09-28.
 * This is a abstract class extended by the Knight class
 */
public abstract class Piece {
    abstract PieceLocation getLocation();
    abstract String getOwner();
    abstract ChessGame getGame();
    abstract boolean canMoveTo(PieceLocation newLocation);
}