package tp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tp.model.Admins;

public interface AdminRepository extends JpaRepository<Admins, Long> {

    @Query("from Admins where email = ?1 and password = ?2")
    public Admins findByEmail(String email, String password);

    @Query(value = "select * from v_AdminToken where token = ?1", nativeQuery = true)
    public Admins findUserByToken(String token);
}
