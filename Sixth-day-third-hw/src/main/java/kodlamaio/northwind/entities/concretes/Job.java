package kodlamaio.northwind.entities.concretes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="job_titles")
@Data
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="job_title")
    private String jobTitle;

    @OneToMany(mappedBy = "job")
    private List<JobAdvertisement> jobAdvertisement;


}
