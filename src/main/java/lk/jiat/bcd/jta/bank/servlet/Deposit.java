package lk.jiat.bcd.jta.bank.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.bcd.jta.bank.ejb.remote.AccountService;
import lk.jiat.bcd.jta.bank.ejb.remote.DepositService;
import lk.jiat.bcd.jta.bank.entity.Account;
import lk.jiat.bcd.jta.bank.exception.AccountNotFoundException;

import java.io.IOException;
import java.util.List;

@WebServlet("/deposit")
public class Deposit extends HttpServlet {


    @EJB
    private AccountService accountService;

    @EJB
    private DepositService depositService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getSession().getAttribute("user").toString();

        List<Account> accounts = accountService.findAccountsByUserEmail(email);

        req.setAttribute("accounts", accounts);
        req.getRequestDispatcher("/deposit.jsp").forward(req, resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accountNo = req.getParameter("accountNo");
        double amount = Double.parseDouble(req.getParameter("amount"));


        try {
            depositService.deposit(accountNo, amount);
            resp.sendRedirect(req.getContextPath() + "/dashboard");

        }catch (AccountNotFoundException e){
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/deposit.jsp").forward(req, resp);

        }

    }
}
