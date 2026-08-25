package lk.jiat.bcd.jta.bank.ejb.remote;

import jakarta.ejb.Local;
import lk.jiat.bcd.jta.bank.exception.AccountNotFoundException;
import lk.jiat.bcd.jta.bank.exception.InsufficientFundsException;

@Local
public interface WithdrawService {
    void withdraw(String accoutNo, double amount) throws InsufficientFundsException, AccountNotFoundException;
}
