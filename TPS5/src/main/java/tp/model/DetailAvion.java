package tp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.security.Timestamp;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "v_dernierekilometrage")
public class DetailAvion {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "immatriculation")
    private String immatriculation;

    @Column(name = "puissance")
    private int puissance;
    
    @Column(name = "dateobtention")
    private Date dateobtention;

    @Column(name = "photo")
    private String photo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categorieid",referencedColumnName = "id")
    private Categorie categorie;

    @Column(name="etatphysique")
    private String etatphysique;

    @Column(name="distance_parcourue")
    private float distance;
    
    @Column(name="carburantdepense")
    private float carburantdepense;

}
