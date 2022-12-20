package tp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "avion")
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Immatriculation")
    private String immatriculation;
    @Column(name = "Puissance")
    private int puissance;
    @Column(name = "dateobtention")
    private Date dateobtention;
    @Column(name = "Photo")
    private String photo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categorieid",referencedColumnName = "id")
    private Categorie categorie;
    
}
