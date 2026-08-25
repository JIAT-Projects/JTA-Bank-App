package lk.jiat.bcd.jta.bank.ejb;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import lk.jiat.bcd.jta.bank.ejb.remote.AccountService;
import lk.jiat.bcd.jta.bank.ejb.remote.DepositService;
import lk.jiat.bcd.jta.bank.ejb.remote.TransactionLogService;
import lk.jiat.bcd.jta.bank.entity.Account;
import lk.jiat.bcd.jta.bank.entity.TransactionType;
import lk.jiat.bcd.jta.bank.exception.AccountNotFoundException;

import java.math.BigDecimal;

@Stateless
public class DepositServiceBean implements DepositService {


    @EJB
    private AccountService accountService;

    @EJB
    private TransactionLogService transactionLogService;

    @Override
    public void deposit(String accoutNo, double amount) throws AccountNotFoundException {
        accountService.creditToAccount(accoutNo, BigDecimal.valueOf(amount));

        Account account = accountService.findByAccountNo(accoutNo);// This line is to ensure that the account exists, will throw AccountNotFoundException if not found
        transactionLogService.log(accoutNo, TransactionType.DEPOSIT, amount, account.getBalance(), null);
    }
}
