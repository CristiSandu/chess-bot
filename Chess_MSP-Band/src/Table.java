import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Table {

    private HashMap<Integer,Square> squaresMap = new HashMap<>();

    public Table(){
        standardGame();
    }

// Table -> Square -> Piece
    private void standardGame(){
        squaresMap.clear();

        //linia 1
        squaresMap.put(Constants.A1, new Square(Constants.A1, new Rook(Color.WHITE,this)));
        squaresMap.put(Constants.B1, new Square(Constants.B1, new Knight(Color.WHITE, this)));
        squaresMap.put(Constants.C1, new Square(Constants.C1, new Bishop(Color.WHITE,this)));
        squaresMap.put(Constants.D1, new Square(Constants.D1, new Queen(Color.WHITE, this)));
        squaresMap.put(Constants.E1, new Square(Constants.E1, new King(Color.WHITE,this)));
        squaresMap.put(Constants.F1, new Square(Constants.F1, new Bishop(Color.WHITE, this)));
        squaresMap.put(Constants.G1, new Square(Constants.G1, new Knight(Color.WHITE, this)));
        squaresMap.put(Constants.H1, new Square(Constants.H1, new Rook(Color.WHITE,this)));

        //linia 2
        squaresMap.put(Constants.A2, new Square(Constants.A2, new Pawn(Color.WHITE, this)));
        squaresMap.put(Constants.B2, new Square(Constants.B2, new Pawn(Color.WHITE, this)));
        squaresMap.put(Constants.C2, new Square(Constants.C2, new Pawn(Color.WHITE, this)));
        squaresMap.put(Constants.D2, new Square(Constants.D2, new Pawn(Color.WHITE, this)));
        squaresMap.put(Constants.E2, new Square(Constants.E2, new Pawn(Color.WHITE, this)));
        squaresMap.put(Constants.F2, new Square(Constants.F2, new Pawn(Color.WHITE, this)));
        squaresMap.put(Constants.G2, new Square(Constants.G2, new Pawn(Color.WHITE, this)));
        squaresMap.put(Constants.H2, new Square(Constants.H2, new Pawn(Color.WHITE, this)));

        //linia 3
        squaresMap.put(Constants.A3, new Square(Constants.A3, null));
        squaresMap.put(Constants.B3, new Square(Constants.B3, null));
        squaresMap.put(Constants.C3, new Square(Constants.C3, null));
        squaresMap.put(Constants.D3, new Square(Constants.D3, null));
        squaresMap.put(Constants.E3, new Square(Constants.E3, null));
        squaresMap.put(Constants.F3, new Square(Constants.F3, null));
        squaresMap.put(Constants.G3, new Square(Constants.G3, null));
        squaresMap.put(Constants.H3, new Square(Constants.H3, null));

        //linia 4
        squaresMap.put(Constants.A4, new Square(Constants.A4, null));
        squaresMap.put(Constants.B4, new Square(Constants.B4, null));
        squaresMap.put(Constants.C4, new Square(Constants.C4, null));
        squaresMap.put(Constants.D4, new Square(Constants.D4, null));
        squaresMap.put(Constants.E4, new Square(Constants.E4, null));
        squaresMap.put(Constants.F4, new Square(Constants.F4, null));
        squaresMap.put(Constants.G4, new Square(Constants.G4, null));
        squaresMap.put(Constants.H4, new Square(Constants.H4, null));

        //linia 5
        squaresMap.put(Constants.A5, new Square(Constants.A5, null));
        squaresMap.put(Constants.B5, new Square(Constants.B5, null));
        squaresMap.put(Constants.C5, new Square(Constants.C5, null));
        squaresMap.put(Constants.D5, new Square(Constants.D5, null));
        squaresMap.put(Constants.E5, new Square(Constants.E5, null));
        squaresMap.put(Constants.F5, new Square(Constants.F5, null));
        squaresMap.put(Constants.G5, new Square(Constants.G5, null));
        squaresMap.put(Constants.H5, new Square(Constants.H5, null));

        //linia 6
        squaresMap.put(Constants.A6, new Square(Constants.A6, null));
        squaresMap.put(Constants.B6, new Square(Constants.B6, null));
        squaresMap.put(Constants.C6, new Square(Constants.C6, null));
        squaresMap.put(Constants.D6, new Square(Constants.D6, null));
        squaresMap.put(Constants.E6, new Square(Constants.E6, null));
        squaresMap.put(Constants.F6, new Square(Constants.F6, null));
        squaresMap.put(Constants.G6, new Square(Constants.G6, null));
        squaresMap.put(Constants.H6, new Square(Constants.H6, null));

        //linia 7
        squaresMap.put(Constants.A7, new Square(Constants.A7, new Pawn(Color.BLACK, this)));
        squaresMap.put(Constants.B7, new Square(Constants.B7, new Pawn(Color.BLACK, this)));
        squaresMap.put(Constants.C7, new Square(Constants.C7, new Pawn(Color.BLACK, this)));
        squaresMap.put(Constants.D7, new Square(Constants.D7, new Pawn(Color.BLACK, this)));
        squaresMap.put(Constants.E7, new Square(Constants.E7, new Pawn(Color.BLACK, this)));
        squaresMap.put(Constants.F7, new Square(Constants.F7, new Pawn(Color.BLACK, this)));
        squaresMap.put(Constants.G7, new Square(Constants.G7, new Pawn(Color.BLACK, this)));
        squaresMap.put(Constants.H7, new Square(Constants.H7, new Pawn(Color.BLACK, this)));

        //linia 8
        squaresMap.put(Constants.A8, new Square(Constants.A8, new Rook(Color.BLACK, this)));
        squaresMap.put(Constants.B8, new Square(Constants.B8, new Knight(Color.BLACK, this)));
        squaresMap.put(Constants.C8, new Square(Constants.C8, new Bishop(Color.BLACK, this)));
        squaresMap.put(Constants.D8, new Square(Constants.D8, new Queen(Color.BLACK, this)));
        squaresMap.put(Constants.E8, new Square(Constants.E8, new King(Color.BLACK, this)));
        squaresMap.put(Constants.F8, new Square(Constants.F8, new Bishop(Color.BLACK, this)));
        squaresMap.put(Constants.G8, new Square(Constants.G8, new Knight(Color.BLACK, this)));
        squaresMap.put(Constants.H8, new Square(Constants.H8, new Rook(Color.BLACK, this)));

    }

  
    public HashMap<Integer,Square> getSquares(){
        return this.squaresMap;
    }

    public boolean isKingBinded(Move move, Color kingColor){
        Piece initialDest = applyMove(move);
        boolean isChecked = isKingChecked(kingColor);
        undoMove(move, initialDest);
        return isChecked;
    }

    public boolean isKingChecked(Color kingColor){

        Square kingSq = null;

        char kingName = (kingColor == Color.WHITE) ? 'K' : 'k';

        for(Map.Entry<Integer,Square> entry : squaresMap.entrySet()){
            if(entry.getValue().hasPiece()){
                if(entry.getValue().getPiece().getName().equals(kingName)){
                    kingSq = entry.getValue();
                    break;
                }
            }
        }

        if(kingSq == null) return false;

        if(kingColor == Color.WHITE){
            for(Map.Entry<Integer,Square> entry : squaresMap.entrySet()) {
                Square sq = entry.getValue();
                if(sq.hasPiece()){
                    if(sq.getPiece().getColor() == Color.BLACK){
                        Piece black = sq.getPiece();
                        if(black.isChecking(sq.getPosition(), kingSq.getPosition())){
                            return true;
                        }
                    }
                }
            }
        }else{
            for(Map.Entry<Integer,Square> entry : squaresMap.entrySet()) {
                Square sq = entry.getValue();
                if(sq.hasPiece()){
                    if(sq.getPiece().getColor() == Color.WHITE){
                        Piece white = sq.getPiece();
                        if(white.isChecking(sq.getPosition(), kingSq.getPosition())){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public void updateTable(Move move){
        Square src = squaresMap.get(move.source);
        Square dest = squaresMap.get(move.dest);

        dest.setPiece(src.getPiece());
        src.setPiece(null);
    }

    public void undoMove(Move move, Piece initialDest){
        Square src = squaresMap.get(move.source);
        Square dest = squaresMap.get(move.dest);

        src.setPiece(dest.getPiece());
        dest.setPiece(initialDest);
    }

    public Piece applyMove(Move move){
        Square src = squaresMap.get(move.source);
        Square dest = squaresMap.get(move.dest);

        Piece initialDest = dest.getPiece();
        dest.setPiece(src.getPiece());
        src.setPiece(null);

        return initialDest;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Set<Integer> keys = squaresMap.keySet();
        ArrayList<Integer> keysList = new ArrayList<>();
        for(Integer i: keys) keysList.add(i);
        Collections.sort(keysList);

        int k = 0;
        sb.append('\n');
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                int key = keysList.get(k); k++;
                Square sq = squaresMap.get(key);
                if(sq.hasPiece()){
                    sb.append(sq.getPiece().getName() + " ");
                }else{
                    sb.append("- ");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

}
