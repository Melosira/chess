public class Pawn extends ChessPiece implements CheckFirstMove {
    /**
     * Был ли первый ход
     */
    private boolean firstMove;

    @Override
    public boolean isFirstMove() {
        return firstMove;
    }

    public Pawn(String color) {
        super(color);
        this.firstMove = true;
    }

    @Override
    public void negateFirstMove() {
        this.firstMove = false;
    }

    /**
     * Ходит прямо только на одну клетку
     * Первый ход - на 2 клетки вперёд возможно.
     * Ест по диагонали на 1 клетку.
     *
     * @param board    - шахматная доска
     * @param line     - начальный y
     * @param column   - начальный x
     * @param toLine   - конечный y
     * @param toColumn - конечный x
     */
    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (checkPos(toLine) && checkPos(toColumn)) {
            // Проверка на цвет. Если белый, то toLine > line, если черный - наоборот
            if (getColor().equals("White")) {
                if (isFirstMove()) {
                    if (toLine - line == 2 || toLine - line == 1) {
                        return true;
                    }
                }
                return toLine - line == 1;
            } else { // Если цвет черный
                if (isFirstMove()) {
                    if (toLine - line == -2 || toLine - line == -1) {
                        return true;
                    }
                }
                return toLine - line == -1;
            }
        }
        return false;
    }

    // Место для кода атаки. Пешка должна атаковать только по диагонали вперёд.

    @Override
    public String getSymbol() {
        return "P";
    }

}
