package exceptionshw.exceptions;

/**
 * Created by Administrator on 05.11.16.
 */
public class InvalidValue extends Exception {
    public InvalidValue() {
        System.out.println("Не верное значение. Сумма должна быть кратна 100");
    }
}
