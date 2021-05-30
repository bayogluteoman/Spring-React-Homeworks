package kodlamaio.northwind.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kodlamaio.northwind.entities.abstracts.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "employees")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employerActivationByEmployee"})
public class Employee extends User {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne(mappedBy = "employee")
    private EmployerActivationByEmployee employerActivationByEmployee;

}
