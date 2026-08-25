package lk.jiat.bcd.jta.bank.ejb;

import jakarta.annotation.Resource;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.transaction.*;
import lk.jiat.bcd.jta.bank.ejb.remote.AccountService;
import lk.jiat.bcd.jta.bank.ejb.remote.TransactionLogService;
import lk.jiat.bcd.jta.bank.ejb.remote.TransferService;
import lk.jiat.bcd.jta.bank.entity.Account;
import lk.jiat.bcd.jta.bank.entity.TransactionType;
import lk.jiat.bcd.jta.bank.exception.AccountNotFoundException;
import lk.jiat.bcd.jta.bank.exception.InsufficientFundsException;

import java.math.BigDecimal;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class TransferServiceBean implements TransferService {

    @Resource
    private UserTransaction userTransaction;

    @EJB
    private AccountService accountService;

    @EJB
    private TransactionLogService transactionLogService;



    @Override
    public void transferAmount(String sourceAccountNo, String destinationAccountNo, double amount) throws InsufficientFundsException, AccountNotFoundException {
                if(amount <= 0){
                    throw new IllegalArgumentException("Amount must be greater than zero");
                }

                if(sourceAccountNo != null && sourceAccountNo.equals(destinationAccountNo)){
                    throw new IllegalArgumentException("Source and destination account numbers must be different");
                }

                accountService.findByAccountNo(sourceAccountNo);
                accountService.findByAccountNo(destinationAccountNo);

                try {
                    userTransaction.begin();
                    try {
                        accountService.debitToAccount(sourceAccountNo, BigDecimal.valueOf(amount));
                        accountService.creditToAccount(destinationAccountNo,BigDecimal.valueOf(amount));
                        userTransaction.commit();

                    } catch (InsufficientFundsException | RuntimeException e) {
                        safeRollback();
                        throw e;
                    }
                }catch (NotSupportedException | SystemException e){
                    throw new RuntimeException("Unable to start transaction for after transfer", e);
                }catch (RollbackException | HeuristicMixedException | HeuristicRollbackException e){
                    throw new RuntimeException("Transaction commit failed during transfer", e);
                }

        Account source = accountService.findByAccountNo(sourceAccountNo);
        Account destination = accountService.findByAccountNo(destinationAccountNo);

        transactionLogService.log(sourceAccountNo, TransactionType.DEBITED, amount, source.getBalance(), destinationAccountNo);
        transactionLogService.log(destinationAccountNo, TransactionType.CREDITED, amount, destination.getBalance(), sourceAccountNo);



    }

    private void safeRollback(){
        try {
            userTransaction.rollback();
        } catch (SystemException e) {
            throw new RuntimeException("Rollback failed after transfer error", e);
        }
    }
}
