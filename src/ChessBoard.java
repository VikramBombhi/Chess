/**
 * Created by Vikram on 2016-09-28.
 * ChessBoard class contains a 2D array representing the chessboard
 */
public class ChessBoard {
    //Initialize a 2D array containing a Tile obj
    private Tile tiles[][] = new Tile[8][8];

    //Assign Tile obj's to entire ChessBoard
    public ChessBoard(){
        for(int row = 0; row<8; row++){
            for(int col = 0; col<8; col++){
                tiles[row][col] = new Tile();
            }
        }
    }

    //returns the 2D array containing Tiles
    public Tile[][] getTiles(){
        return tiles;
    }

    //Check if Piece at location is null or not
    public boolean isPieceAt(PieceLocation location){
        if(tiles[location.getRow()][location.getCol()].getPiece() != null) {
            return true;
        }
        else throw new IllegalArgumentException("There is no piece there, the format for selecting a piece is (row, col) ex(0,1)");
    }

    //Place piece using setPiece method from the Tile class
    public void placePieceAt(Piece piece){
        tiles[piece.getLocation().getRow()][piece.getLocation().getCol()].setPiece(piece);
    }

    /*
    Move piece from location to newLocation in three steps
    1.) get piece from location and set it at newLocation
    2.) set the PieceLocation obj that exist inside the piece to newLocation
    3.) set piece at location to null
    */
    public void movePiece(PieceLocation location, PieceLocation newLocation){
        if(PlayGame.game.getChessBoard().getTiles()[location.getRow()][location.getCol()].getPiece().canMoveTo(newLocation)){
            tiles[newLocation.getRow()][newLocation.getCol()].setPiece(tiles[location.getRow()][location.getCol()].getPiece());
            tiles[newLocation.getRow()][newLocation.getCol()].getPiece().getLocation().setLocation(newLocation);
            tiles[location.getRow()][location.getCol()].removePiece();
        }
        else throw new IllegalArgumentException("Piece cannot move there");
    }

    //This method prints the ChessBoard including the row and col numbers
    public void printBoard(){
        System.out.println("  0 1 2 3 4 5 6 7");
        for(int row = 0; row<8; row++){
            System.out.print(row);
            for(int col = 0; col<8; col++){
                System.out.print(tiles[row][col]);//print the piece
            }
            System.out.println();
        }
    }
}