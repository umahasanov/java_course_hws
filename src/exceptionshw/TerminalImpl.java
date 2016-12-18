package exceptionshw;

import exceptionshw.exceptions.InvalidValue;

/**
 * Created by Administrator on 04.11.16.
 */
public class TerminalImpl implements Terminal {

    private final TerminalServer terminalServer;
    private final PinValidator pinValidator;

    public TerminalImpl(TerminalServer terminalServer, PinValidator pinValidator) {
        this.terminalServer = terminalServer;
        this.pinValidator = pinValidator;
        this.pinValidator.enterPinKod();
    }

    @Override
    public void putTheMoney(int sum) throws InvalidValue {
        if (sum > 0 && sum % 100 == 0) {
            terminalServer.putMoneyOnCurrentAccount(sum);
        } else {
            throw new InvalidValue();
        }
    }

    @Override
    public int withdrawMoney(int sum) {
        if (hasEnoughMoney(sum)) {
            return sum;
        } else {
            return 0;
        }
    }

    @Override
    public boolean hasEnoughMoney(int sum) {
        return terminalServer.getRestOfMoney() >= sum && sum % 100 == 0;
    }

    public static void main(String[] args) {

    }
}
