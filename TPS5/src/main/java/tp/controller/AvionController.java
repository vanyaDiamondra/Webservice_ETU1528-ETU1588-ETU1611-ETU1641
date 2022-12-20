package tp.controller;

import org.springframework.stereotype.Controller;
import tp.dao.AvionDAO;
import tp.dao.DetailAvionDAO;
import tp.model.Avion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.repository.DetailAvionRepository;
import tp.repository.AvionRepository;
import tp.service.DataResponse;

@Controller
@CrossOrigin("*")
@RequestMapping("/flotte/avion")
public class AvionController {


    DetailAvionDAO  detailAvionDAO = new DetailAvionDAO();
    AvionDAO avionDAO = new AvionDAO();
    @Autowired
    DetailAvionRepository detailAvionRepository;
    @Autowired
    AvionRepository avionRepository;

    //create vehicule
    @PostMapping
    public ResponseEntity<Avion> createAvion(@RequestBody Avion vehicule){
        System.out.println("MANADALO createAvion");
        return avionDAO.createAvionDAO(vehicule, avionRepository);
    }

    // get all vehicules assurance expired in one month
    @GetMapping
    @ResponseBody
    @RequestMapping("/oneMonth")
    public ResponseEntity<DataResponse> getExpiredInOneMonth() {
        DataResponse dr = new DataResponse();
        dr.setData(detailAvionDAO.ExpiredInOneMonth(detailAvionRepository));
        return ResponseEntity.accepted().body(dr);
    }

    //get all vehicules
    @GetMapping
    @ResponseBody
    @RequestMapping
    public ResponseEntity<DataResponse> AllAvion() {
        DataResponse dr = new DataResponse();
        dr.setData(avionDAO.getAllAvionDAO(avionRepository));
        return ResponseEntity.accepted().body(dr);
    }


    //getall vehicules assurance expired in 3 month
    @GetMapping
    @ResponseBody
    @RequestMapping("/threeMonth")
    public ResponseEntity<DataResponse> getExpiredInThreeMonth() {
        DataResponse dr = new DataResponse();
        dr.setData(detailAvionDAO.ExpiredInThreeMonth(detailAvionRepository));
        return ResponseEntity.accepted().body(dr);
    }

    //find by id
    @GetMapping("/{id}")
    public ResponseEntity<DataResponse> getDetailAvion(@PathVariable long id){
        DataResponse dr = new DataResponse();
        dr.setData(detailAvionDAO.getDetailAvionById(id, detailAvionRepository));
        return ResponseEntity.accepted().body(dr);
    }

    //update a vehicule
    @PutMapping("/{id}")
    public ResponseEntity<Avion> updateVehicule(@PathVariable long id, @RequestBody Avion vehiculeDetails){
        return avionDAO.updateAvionDAO(id,vehiculeDetails,avionRepository);
    }

    //delete by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Avion> deleteVehicule(@PathVariable long id){
        return avionDAO.deleteVehiculeDAO(id,avionRepository);
    }
}
