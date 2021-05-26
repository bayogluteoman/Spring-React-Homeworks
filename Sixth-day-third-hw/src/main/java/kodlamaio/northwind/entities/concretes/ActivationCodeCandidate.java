package kodlamaio.northwind.entities.concretes;

import kodlamaio.northwind.entities.abstracts.ActivationCodes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Data
@Table(name = "activation_code_candidates")
@EqualsAndHashCode(callSuper = true)
public class ActivationCodeCandidate extends ActivationCodes {

    @Column(name = "candidate_id")
    private int candidateId;

}