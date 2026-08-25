package lk.jiat.bcd.jta.bank.ejb.remote;

import jakarta.ejb.Local;
import lk.jiat.bcd.jta.bank.entity.Transaction;
import lk.jiat.bcd.jta.bank.entity.TransactionType;
import lk.jiat.bcd.jta.bank.exception.AccountNotFoundException;

import java.util.List;

@Local
public interface TransactionLogService {
    void log(String accoutNo, TransactionType type, double amount, double balanceAfter, String relatedAccountNo);
    List<Transaction> history(String accountNo);
}
