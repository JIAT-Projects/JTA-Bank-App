package lk.jiat.bcd.jta.bank.ejb.remote;

import lk.jiat.bcd.jta.bank.entity.AccountType;
import lk.jiat.bcd.jta.bank.exception.InsufficientFundsException;

import java.math.BigDecimal;

public interface AccountService {
    void createAccount(String email, AccountType type, BigDecimal openingBalance );

    void creditToAccount(String accountNo,BigDecimal amount);
    void debitToAccount(String accountNo,BigDecimal amount) throws InsufficientFundsException;



}
