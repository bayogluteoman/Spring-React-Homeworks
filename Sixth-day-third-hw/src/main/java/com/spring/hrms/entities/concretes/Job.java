package com.spring.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="job_positions")
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisement","jobExperiences"})

public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @ApiModelProperty(hidden = true)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name="position")
    private String position;


    @OneToMany(mappedBy = "job")
    @ApiModelProperty(hidden = true)
    private List<JobAdvertisement> jobAdvertisement;

    @OneToOne(mappedBy = "job")
    @ApiModelProperty(hidden = true)
    private JobExperiences jobExperiences;




}
