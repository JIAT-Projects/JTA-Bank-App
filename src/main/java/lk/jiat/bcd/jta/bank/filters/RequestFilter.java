package lk.jiat.bcd.jta.bank.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = {
        "/home.jsp",
        "/deposit.jsp",
        "/withdraw.jsp",
        "/transfer.jsp",
        "/history.jsp",
        "/create-account.jsp",
        "/dashboard",
        "/deposit",
        "/withdraw",
        "/transfer",
        "/history",
        "/create-account",
        "/logout",
})
public class RequestFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getSession().getAttribute("user") != null) {
            chain.doFilter(request,response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}
