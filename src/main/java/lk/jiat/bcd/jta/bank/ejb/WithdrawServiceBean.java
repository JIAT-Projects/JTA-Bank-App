package lk.jiat.bcd.jta.bank.ejb;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import lk.jiat.bcd.jta.bank.ejb.remote.AccountService;
import lk.jiat.bcd.jta.bank.ejb.remote.TransactionLogService;
import lk.jiat.bcd.jta.bank.ejb.remote.WithdrawService;
import lk.jiat.bcd.jta.bank.entity.Account;
import lk.jiat.bcd.jta.bank.entity.Transaction;
import lk.jiat.bcd.jta.bank.entity.TransactionType;
import lk.jiat.bcd.jta.bank.exception.AccountNotFoundException;
import lk.jiat.bcd.jta.bank.exception.InsufficientFundsException;


import java.math.BigDecimal;

@Stateless
public class WithdrawServiceBean implements WithdrawService {

    @EJB
    private AccountService accountService;

    @EJB
    private TransactionLogService transactionLogService;


    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void withdraw(String accoutNo, double amount) throws InsufficientFundsException, AccountNotFoundException {
        accountService.debitToAccount(accoutNo, BigDecimal.valueOf(amount));


        Account account = accountService.findByAccountNo(accoutNo);// This line is to ensure that the account exists, will throw AccountNotFoundException if not found
        transactionLogService.log(accoutNo, TransactionType.WITHDRAWAL, amount, account.getBalance(), null);


    }
}
