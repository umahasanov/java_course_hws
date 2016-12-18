package exceptionshw.exceptions;

/**
 * Created by Administrator on 05.11.16.
 */
public class NotEnoughMoney extends RuntimeException {

    public NotEnoughMoney() {
        System.out.println("Недостаточно средств на счету");
    }

}
