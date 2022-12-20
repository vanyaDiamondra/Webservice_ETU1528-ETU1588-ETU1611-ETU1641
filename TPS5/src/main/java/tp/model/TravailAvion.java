package tp.model;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AvionEnTravail")
public class TravailAvion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="avionid")
    private int avionid;
    @Column(name="piloteid")
    private int idpilote;
    @Column(name="debuthoraire")
    private Timestamp debutHoraire;
    @Column(name="finhoraire")
    private Timestamp finHoraire;
    @Column(name="carburantdepart")
    private int carburantdepart;

}
