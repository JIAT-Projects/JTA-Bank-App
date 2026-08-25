package lk.jiat.bcd.jta.bank.ejb.remote;

import jakarta.ejb.Local;
import lk.jiat.bcd.jta.bank.exception.AccountNotFoundException;
import lk.jiat.bcd.jta.bank.exception.InsufficientFundsException;

@Local
public interface TransferService {
    void transferAmount(String sourceAccountNo, String destinationAccountNo, double amount)
        throws InsufficientFundsException, AccountNotFoundException;
}
