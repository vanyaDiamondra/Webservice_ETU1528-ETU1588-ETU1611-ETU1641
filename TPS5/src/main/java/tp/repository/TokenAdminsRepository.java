package tp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tp.model.Admins;
import tp.model.TokenUtils;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class TokenAdminsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveAdminToken(TokenUtils tokenUtils){

        entityManager.createNativeQuery("insert into tokenAdmin values (default, ?, ?, ?)")
                .setParameter(1, tokenUtils.getIdadmin())
                .setParameter(2, tokenUtils.getToken())
                .setParameter(3, tokenUtils.getExpiration_date())
                .executeUpdate();
    }

    @Transactional
    public List<TokenUtils> findToken(String token){
        List<TokenUtils> result = entityManager.createNativeQuery("select * from tokenAdmin where token = ?", TokenUtils.class)
                .setParameter(1, token)
                .getResultList();

        return result;
    }

}
