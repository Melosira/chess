public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (checkPos(toLine) && checkPos(toColumn)) {
            if (Math.abs(toLine - line) > 0 && toColumn == column) { //передвижение по координате y по прямой
                return true;
            }
            if (Math.abs(toColumn - column) > 0 && toLine == line) {//передвижение по координате x по прямой
                return true;
            }
            if (Math.abs(toLine - line) > 0 && Math.abs(toLine - line) == Math.abs(toColumn - column)) {//передвижение по диагонали
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }


}