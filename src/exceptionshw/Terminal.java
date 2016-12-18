package exceptionshw;


import exceptionshw.exceptions.InvalidValue;

/**
 * Created by Administrator on 04.11.16.
 */
public interface Terminal {

    void putTheMoney(int sum) throws InvalidValue;

    int withdrawMoney(int sum);

    boolean hasEnoughMoney(int sum);

}
