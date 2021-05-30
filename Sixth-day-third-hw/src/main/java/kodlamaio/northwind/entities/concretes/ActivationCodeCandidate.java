package kodlamaio.northwind.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kodlamaio.northwind.entities.abstracts.ActivationCodes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "activation_code_candidates")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidate"})
public class ActivationCodeCandidate extends ActivationCodes {

    @OneToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

}