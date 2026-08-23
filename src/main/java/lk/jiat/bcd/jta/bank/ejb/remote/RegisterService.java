package lk.jiat.bcd.jta.bank.ejb.remote;


import jakarta.ejb.Local;
import lk.jiat.bcd.jta.bank.exception.DuplicateEmailException;


import java.rmi.RemoteException;

@Local
public interface RegisterService {
    void registerUser(String name, String email, String password) throws DuplicateEmailException;

}
