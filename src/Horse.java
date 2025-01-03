public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (checkPos(toLine) && checkPos(toColumn)) {
            return (Math.abs(toLine - line) == 2 && Math.abs(toColumn - column) == 1) ||
                    (Math.abs(toLine - line) == 1 && Math.abs(toColumn - column) == 2);
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }


}