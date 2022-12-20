package tp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kilometrageAvion")

public class KilometrageAvion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "AvionEnTravailid")
    private int avionentravailid;

    @Column(name = "horaire")
    private Date horaire;

    @Column(name = "debutkm")
    private float debutkm;

    @Column(name = "finkm")
    private float finkm;

    @Column(name = "carburantdepense")
    private float carburantdepense;
    


}
