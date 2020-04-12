import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(Color color, Table table){
        this.setColor(color);
        this.setTable(table);
        this.setName(color==Color.WHITE? 'B' : 'b');
        this.setValue(Constants.BISHOP_VALUE);
    }


    public ArrayList<Move> searchMoves(int src){
        return null;
    }

    /*
    @Override
    public ArrayList<String> getAllPossibleMoves() {
        if(isCaptured())
            return null;
        ArrayList<String> moves = new ArrayList<>();

        int[] rowOff = {-1, 1, 1, -1};
        int[] colOff = {-1, -1, 1, 1};
        Position currPosition = this.getPosition();
        int column = Math.abs((int) currPosition.letter - 104); //get matrix row index
        int row = currPosition.digit-1;

        for(int i = 0; i < rowOff.length; i++){
            int increment = 1;
            boolean found = false;
            while(!found){
                int newRow = row + rowOff[i] * increment;
                int newCol = column + colOff[i] * increment;
                if(newRow < 0 || newRow >=8 || newCol < 0 || newCol >= 8){
                    found = true;
                    continue;
                }
                Piece p = getTable().getConfiguration()[newRow][newCol];
                if(p.getName().equals('-')){
                    moves.add(Table.generateMoveCommand(currPosition,rowOff[i]*increment,colOff[i]*increment));
                    increment++;
                    continue;
                }
                if(p.getColor() == Color.WHITE && this.getColor()==Color.WHITE){
                    found = true;
                    continue;
                }
                if(p.getColor() == Color.BLACK && this.getColor() == Color.BLACK){
                    found = true;
                    continue;
                }
                if(p.getName().equals('K') || p.getName().equals('k')){
                    found = true;
                    continue;
                }
                moves.add(Table.generateMoveCommand(currPosition,rowOff[i]*increment,colOff[i]*increment));
                found = true;
            }
        }

        if(moves.isEmpty())
            System.out.println("Nu s-a gasit nicio mutare pentru nebunul de pe: "
                    + this.getPosition().letter
                    + this.getPosition().digit);

        return moves;
    }*/
}
