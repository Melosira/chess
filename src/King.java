public class King extends ChessPiece implements CheckFirstMove {
    /**
     * Был ли первый ход
     */
    private boolean firstMove;

    public King(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (checkPos(toLine) && checkPos(toColumn)) {
            return (Math.abs(toLine - line) <= 1 && Math.abs(toColumn - column) <= 1);
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    @Override
    public void negateFirstMove() {
        this.firstMove = false;
    }

    @Override
    public boolean isFirstMove() {
        return firstMove;
    }

    // Шах
    // private boolean isUnderAttak(ChessBoard, int line, int column) {};

}