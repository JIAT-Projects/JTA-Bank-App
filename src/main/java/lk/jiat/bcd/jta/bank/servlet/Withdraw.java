package lk.jiat.bcd.jta.bank.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.bcd.jta.bank.ejb.remote.AccountService;
import lk.jiat.bcd.jta.bank.ejb.remote.WithdrawService;
import lk.jiat.bcd.jta.bank.entity.Account;
import lk.jiat.bcd.jta.bank.exception.AccountNotFoundException;
import lk.jiat.bcd.jta.bank.exception.InsufficientFundsException;

import java.io.IOException;
import java.util.List;

@WebServlet("/withdraw")
public class Withdraw extends HttpServlet {

    @EJB
    private AccountService accountService;

    @EJB
    private WithdrawService withdrawService;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getSession().getAttribute("user").toString();
        List<Account> accounts = accountService.findAccountsByUserEmail(email);
        req.setAttribute("accounts", accounts);
        req.getRequestDispatcher("/withdraw.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accountNo = req.getParameter("accountNo");
        double amount = Double.parseDouble(req.getParameter("amount"));

        try {
            withdrawService.withdraw(accountNo, amount);
            resp.sendRedirect(req.getContextPath() + "/dashboard");
        } catch (InsufficientFundsException | AccountNotFoundException e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/withdraw.jsp").forward(req, resp);
        }
    }
}