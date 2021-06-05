package kodlamaio.northwind.entities.concretes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import kodlamaio.northwind.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_advertisement")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisement"})
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(hidden = true)
    private int id;

    @ManyToOne()
    @JoinColumn(name="position_id")
    private Job job;

    @Column(name="job_info")
    private String jobInfo;

    @ManyToOne
    @JoinColumn(name="city_id")
    private Cities cities;

    @Column(name = "min_wage")
    private int min_wage;

    @Column(name = "max_wage")
    private int max_wage;

    @Column(name = "num_of_position")
    private int num_of_position;

    @Column(name = "last_apply_date")
    private Date last_apply_date;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="publish_date", updatable = false)
    @ApiModelProperty(hidden = true)
    private Date publishDate;


    @Column(name = "is_activated")
    private boolean activated;



}