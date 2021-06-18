package com.spring.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_advertisement")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisement"})
@EqualsAndHashCode(callSuper = false)
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(hidden = true)
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_positions_id")
    private Job job;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name="is_active")
    private boolean activationStatus;

    @Column(name = "min_wage")
    private int minWage;

    @Column(name = "max_wage")
    private int maxWage;

    @Column(name = "number_of_position")
    private int numberOfPosition;

    @Column(name = "last_apply_date")
    private Date lastApplyDate;

    @ManyToOne
    @JoinColumn(name = "work_time")
    private WorkTimeOfJob workTimeOfJobs;

    @ManyToOne
    @JoinColumn(name = "work_type")
    private WorkTypeOfJob workTypeOfJobs;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="publish_date", updatable = false)
    @ApiModelProperty(hidden = true)
    private Date publishDate;

    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;



}
