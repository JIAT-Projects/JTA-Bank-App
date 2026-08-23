package lk.jiat.bcd.jta.bank.entity;

public enum TransactionType {
    DEPOSIT,
    WITHDRAWAL,
    CREDITED, //Transfer-In
    DEBITED //Transfer-Out
}
