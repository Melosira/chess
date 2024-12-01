/**
 * Шахматная фигура
 */
public abstract class ChessPiece {
    /**
     * Цвет фигуры
     */
    private final String color;
    // boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    /**
     * Проверяет, может ли шахматная фигура ходить
     *
     * @param chessBoard - шахматная доска
     * @param line       - начальный y
     * @param column     - начальный x
     * @param toLine     - конечный y
     * @param toColumn   - конечный x
     * @return - true, если может ходить
     */
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    /**
     * Возвращает обозночение шахматной фигуры
     */
    public abstract String getSymbol();

    /**
     * Проверяет находится ли переданная значение x или y в пределах доски
     *
     * @param pos - x или y
     * @return - true, если находится в пределах доски
     */
    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}