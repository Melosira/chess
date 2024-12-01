public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (checkPos(toLine) && checkPos(toColumn)) {
            if (Math.abs(toLine - line) > 0 && Math.abs(toLine - line) == Math.abs(toColumn - column)) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }


}