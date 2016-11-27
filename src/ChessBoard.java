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
        return (tiles[location.getRow()][location.getCol()].getPiece() != null);
    }

    //Place piece using setPiece method from the Tile class
    public void placePieceAt(Piece piece){
        tiles[piece.getLocation().getRow()][piece.getLocation().getCol()].setPiece(piece);
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