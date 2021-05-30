package kodlamaio.northwind.entities.concretes;

import kodlamaio.northwind.entities.abstracts.User;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name="candidates")
public class Candidate extends User {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "tc_no")
    private String tc_no;

    @Column(name = "birth_day")
    private Date birthDay;

    @OneToOne(mappedBy = "candidate")
    private ActivationCodeCandidate activationCodeCandidate;
}
