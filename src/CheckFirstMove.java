/**
 * Проверка двигалась ли фигура
 */
public interface CheckFirstMove {

    /**
     * Устанавливает новое значение для firstMove
     */
    void negateFirstMove();

    /**
     * Проверяет ходила ли фигура.
     *
     * @return - True, если первый ход
     */
    boolean isFirstMove();
}
