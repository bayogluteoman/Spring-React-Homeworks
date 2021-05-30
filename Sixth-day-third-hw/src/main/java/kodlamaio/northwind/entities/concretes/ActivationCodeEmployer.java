package kodlamaio.northwind.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kodlamaio.northwind.entities.abstracts.ActivationCodes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "activation_code_employers")
@Data
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employer"})
public class ActivationCodeEmployer extends ActivationCodes {

    @OneToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;
}