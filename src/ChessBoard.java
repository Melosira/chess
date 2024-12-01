/**
 * Шахматная доска
 */
public class ChessBoard {
    /**
     * Игровое поле с шахматными фигурами
     */
    public ChessPiece[][] board = new ChessPiece[8][8]; // creating a field for game
    /**
     * Текущий игрок
     */
    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    /**
     * Возвращает цвет текущего игрока
     */
    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    /**
     * Проверяет, может ли шахматная фигура ходить
     *
     * @param startLine   - начальный y
     * @param startColumn - начальный x
     * @param endLine     - конечный y
     * @param endColumn   - конечный x
     * @return - true, если может ходить
     */
    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (checkPos(startLine) && checkPos(startColumn)) {

            if (!nowPlayer.equals(board[startLine][startColumn].getColor())) return false;

            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
                board[endLine][endColumn] = board[startLine][startColumn]; // if piece can move, we moved a piece
                board[startLine][startColumn] = null; // set null to previous cell
                this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";

                return true;
            } else return false;
        } else return false;
    }

    /**
     * Напечатать актуальное состояние шахматной доски
     */
    public void printBoard() {  //print board in console
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t1\t2\t3\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    /**
     * Проверяет находится ли переданная значение x или y в пределах доски
     *
     * @param pos - x или y
     * @return - true, если находится в пределах доски
     */
    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    /**
     * Выполнить рокировку короля с ладьёй с x=0
     *
     * @return - возвращает true, если успешно
     */
    public boolean castling0() {
        return false;
    }

    /**
     * Выполнить рокировку короля с ладьёй с x=7
     *
     * @return - возвращает true, если успешно
     */
    public boolean castling7() {
        return false;
    }

    /**
     * Устанавливает у фигуры по переданным координатам, что фигура двигалась, если это свойство поддерживается
     *
     * @param toLine   - актуальная позиция по y
     * @param toColumn - актуальная позиция по x
     */
    public void checkFirstMovePieces(int toLine, int toColumn) {
        ChessPiece chessPiece = board[toLine][toColumn];
        if (chessPiece instanceof CheckFirstMove) {
            ((CheckFirstMove) chessPiece).negateFirstMove();
        }
    }
}