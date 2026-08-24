package lk.jiat.bcd.jta.bank.ejb.remote;

import lk.jiat.bcd.jta.bank.entity.User;

public interface LoginService {
    boolean Login(String email, String password);
    User findByEmail(String email);

}
