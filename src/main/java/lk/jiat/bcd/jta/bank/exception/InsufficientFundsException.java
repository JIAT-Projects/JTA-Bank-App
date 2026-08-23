package lk.jiat.bcd.jta.bank.exception;

import java.math.BigDecimal;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String accountNo, BigDecimal requested, BigDecimal available) {

        super("Insufficient Funds in account " + accountNo + " : " + requested
                + " but only " + available);
    }
}
