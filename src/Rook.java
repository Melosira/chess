public class Rook extends ChessPiece implements CheckFirstMove {

    /**
     * Был ли первый ход
     */
    private boolean firstMove;

    public Rook(String color) {
        super(color);
        this.firstMove = true;
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
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public void negateFirstMove() {
        this.firstMove = false;
    }

    @Override
    public boolean isFirstMove() {
        return firstMove;
    }
}