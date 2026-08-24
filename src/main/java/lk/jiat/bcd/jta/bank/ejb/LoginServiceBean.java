package lk.jiat.bcd.jta.bank.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import lk.jiat.bcd.jta.bank.ejb.remote.LoginService;
import lk.jiat.bcd.jta.bank.entity.User;

@Stateless
public class LoginServiceBean implements LoginService {

    @PersistenceContext(unitName = "BankPU")
    private EntityManager em;




    @Override
    public boolean Login(String email, String password) {
        try {
            em.createNamedQuery("User.findByEmailAndPassword")
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    public User findByEmail(String email) {

        try {
            return em.createNamedQuery("User.findByEmail", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }
}
