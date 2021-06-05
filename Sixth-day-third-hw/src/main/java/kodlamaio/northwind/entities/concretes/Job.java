package kodlamaio.northwind.entities.concretes;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(hidden = true)
    private int id;

    @Column(name="job_title")
    private String jobTitle;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "job")
    @ApiModelProperty(hidden = true)
    private List<JobAdvertisement> jobAdvertisement;

    @OneToOne(mappedBy = "job")
    @ApiModelProperty(hidden = true)
    private JobExperiences jobExperinces;

}
