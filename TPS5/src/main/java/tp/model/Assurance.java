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
@Table(name = "assurancevehicule")
public class Assurance {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehiculeid",referencedColumnName = "id")
    private Avion vehicule;
    @Column(name = "dateassurance")
    Date dateassurance;
    @Column(name = "dateexpiration")
    Date dateexpiraton;
    @Column(name = "montant")
    double montant;


}
