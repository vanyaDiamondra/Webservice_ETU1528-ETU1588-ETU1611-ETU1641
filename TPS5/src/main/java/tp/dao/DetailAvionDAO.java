package tp.dao;

import org.springframework.http.ResponseEntity;
import tp.exception.RessourceNotFoundException;
import tp.model.DetailAvion;
import tp.repository.DetailAvionRepository;

import java.util.List;

public class DetailAvionDAO {

    public DetailAvionDAO(){
    }

    public List<DetailAvion> getAllDetailAvionDAO(DetailAvionRepository dvr) {
        return dvr.findAll();
    }

    public List<DetailAvion> ExpiredInOneMonth(DetailAvionRepository dvr) {
        return dvr.ExpiredInOneMonth();
    }

    public List<DetailAvion> ExpiredInThreeMonth(DetailAvionRepository dvr) {
        return dvr.ExpiredInThreeMonth();
    }

    //findID
    public ResponseEntity<DetailAvion> getDetailAvionById(long id, DetailAvionRepository dvr){
        DetailAvion avion = dvr.findByIdAvion(id);
        return ResponseEntity.ok(avion);
    }
}
