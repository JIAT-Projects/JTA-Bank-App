package lk.jiat.bcd.jta.bank.ejb.remote;

import jakarta.ejb.Local;
import lk.jiat.bcd.jta.bank.exception.AccountNotFoundException;

@Local
public interface DepositService {
    void deposit(String accoutNo,double amount) throws AccountNotFoundException;
}
