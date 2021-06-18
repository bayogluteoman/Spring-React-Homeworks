package com.spring.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "work_time_of_job")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})

public class WorkTimeOfJob {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "work_time")
    private String workTime;

    @OneToMany(mappedBy = "workTimeOfJobs")
    @ApiModelProperty(hidden = true)
    private List<JobAdvertisement> jobAdvertisements;
}
