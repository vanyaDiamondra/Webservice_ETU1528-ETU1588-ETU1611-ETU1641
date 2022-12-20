package tp.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "tokenAdmin")

public class TokenUtils {
    @Id
    long id;
    long idadmin;
    String token;
    Timestamp expiration_date;


    public TokenUtils(String token, Timestamp EXPIRATION_DATE, Admins admin){
        this.token = token;
        this.expiration_date = EXPIRATION_DATE;
        this.idadmin = admin.getId();
    }

    public TokenUtils(){}

    public void setId(Long id) {
        this.id = id;
    }

    @javax.persistence.Id
    public Long getId() {
        return id;
    }
}
