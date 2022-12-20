package tp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import tp.model.Assurance;
import tp.model.Avion;
import tp.repository.AvionRepository;
import tp.exception.RessourceNotFoundException;

import javax.persistence.criteria.Join;
import java.util.Collections;
import java.util.List;

public class AvionDAO {
    public AvionDAO(){
    }

    //create
    public ResponseEntity<Avion> createAvionDAO(Avion avion,AvionRepository vr){
        System.out.println("mandalo createVehiculeDAO");
        vr.save(avion);
        return ResponseEntity.ok(avion);
    }

    //getAll
    public List<Avion> getAllAvionDAO(AvionRepository vr) {
        return vr.findAll();
    }

    //findID
    public List<Avion> getVehiculeById(long id,AvionRepository vr){
        List<Avion> avion = vr.findAllById(Collections.singleton(id));
        System.out.println("mandalo getVehiculeById");
        return avion;
    }

    //update
    public ResponseEntity<Avion> updateAvionDAO(long id,Avion avionDetails,AvionRepository vr){
        Avion updateVehicules = vr.findById(id)
                .orElseThrow(()-> new RessourceNotFoundException("id :"+ id +"of avion doesn't exists"));

        updateVehicules.setImmatriculation(avionDetails.getImmatriculation());
        updateVehicules.setPuissance(avionDetails.getPuissance());
        updateVehicules.setDateobtention(avionDetails.getDateobtention());
        updateVehicules.setCategorie(avionDetails.getCategorie());

        vr.save(updateVehicules);
        return ResponseEntity.ok(updateVehicules);
    }

    //delete
    public ResponseEntity<Avion> deleteVehiculeDAO(long id,AvionRepository vr){
        Avion avion = vr.findById(id)
                .orElseThrow(()-> new RessourceNotFoundException("id :"+ id +"of avion doesn't exists"));
        vr.delete(avion);
        return ResponseEntity.ok(avion);
    }

}
