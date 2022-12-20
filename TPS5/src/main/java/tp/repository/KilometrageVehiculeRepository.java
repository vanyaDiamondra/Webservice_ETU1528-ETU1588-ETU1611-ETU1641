package tp.repository;

import tp.model.KilometrageAvion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface KilometrageVehiculeRepository extends JpaRepository<KilometrageAvion,Long> {
}
