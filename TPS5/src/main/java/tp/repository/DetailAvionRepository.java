package tp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tp.dao.DetailAvionDAO;
import tp.model.Admins;
import tp.model.DetailAvion;

import java.util.List;

@Repository
public interface DetailAvionRepository extends JpaRepository<DetailAvion,Long> {

    @Query(value = "select * from v_dernierekilometrage where id = ?1 limit 1", nativeQuery = true)
    public DetailAvion findByIdAvion(long id);

    @Query(value = "select * from v_ExpiredInOneMonth", nativeQuery = true)
    public List<DetailAvion> ExpiredInOneMonth();

    @Query(value = "select * from v_ExpiredInThreeMonth", nativeQuery = true)
    public List<DetailAvion> ExpiredInThreeMonth();
}
