package kodlamaio.northwind.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kodlamaio.northwind.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidates")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","activationCodeCandidate","educations","candidate","cv"})
public class Candidate extends User {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "tc_no")
    private String tc_no;

    @Column(name = "birth_day")
    private Date birthDay;

    @OneToOne(mappedBy = "candidate",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore()
    private ActivationCodeCandidate activationCodeCandidate;

    @OneToMany(mappedBy = "candidate",cascade = CascadeType.ALL)
    @JsonIgnore()
    private List<JobExperiences> jobExperiences;

    @OneToMany(mappedBy = "candidate",cascade = CascadeType.ALL)
    @JsonIgnore()
    private List<Education> educations;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    @JsonIgnore()
    private List<Language> language;

    @OneToOne(mappedBy = "candidate",cascade = CascadeType.ALL)
    @JsonIgnore()
    private Cv cv;

    public Candidate(int id,String email,String password,String firstName, String lastName, String nationalityNumber, Date birthDate, ActivationCodeCandidate activationCodeCandidate, List<Education> educations, List<JobExperiences> jobExperiences, List<Language> language, Cv cv) {
        super();
        this.setId(id);
        this.setEMail(email);
        this.setPassword(password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.tc_no = nationalityNumber;
        this.birthDay = birthDate;
        this.activationCodeCandidate = activationCodeCandidate;
        this.educations = educations;
        this.jobExperiences = jobExperiences;
        this.language = language;
        this.cv = cv;
    }

}
