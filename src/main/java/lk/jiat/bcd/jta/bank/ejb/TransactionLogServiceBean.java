package lk.jiat.bcd.jta.bank.ejb;

import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lk.jiat.bcd.jta.bank.ejb.remote.TransactionLogService;
import lk.jiat.bcd.jta.bank.entity.Transaction;
import lk.jiat.bcd.jta.bank.entity.TransactionType;

import java.util.List;

@Stateless
public class TransactionLogServiceBean implements TransactionLogService {

    @PersistenceContext(unitName = "BankPU")
    private EntityManager em;


    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void log(String accoutNo, TransactionType type, double amount, double balanceAfter, String relatedAccountNo) {
            Transaction transaction = new Transaction(accoutNo, type, amount, balanceAfter, relatedAccountNo);
            em.persist(transaction);

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Transaction> history(String accountNo) {
        return em.createNamedQuery("Transaction.findByAccountNo", Transaction.class)
                .setParameter("accountNo", accountNo)
                .getResultList();
    }
}
