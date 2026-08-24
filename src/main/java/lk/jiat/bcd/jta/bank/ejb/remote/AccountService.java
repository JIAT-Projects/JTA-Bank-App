package lk.jiat.bcd.jta.bank.ejb.remote;

import jakarta.ejb.Local;
import lk.jiat.bcd.jta.bank.entity.Account;
import lk.jiat.bcd.jta.bank.entity.AccountType;
import lk.jiat.bcd.jta.bank.exception.AccountNotFoundException;
import lk.jiat.bcd.jta.bank.exception.InsufficientFundsException;

import java.math.BigDecimal;
import java.util.List;

@Local
public interface AccountService {

    void creditToAccount(String accountNo,BigDecimal amount);
    void debitToAccount(String accountNo,BigDecimal amount) throws InsufficientFundsException;

    Account findByAccountNo(String accountNo) throws AccountNotFoundException;

    List<Account> findAccountsByUserEmail(String email);


    Account createAccount(String email, AccountType type, BigDecimal openingBalance );

    String generateAccountNumber(AccountType type);


}
