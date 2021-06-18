package com.spring.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidate"})
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(hidden = true)
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "github_address")
    private String githubAddress;

    @Column(name = "linkedin_address")
    private String linkedinAddress;

    @Column(name = "technologies")
    private String technologies;

    @Column(name = "cover_letter")
    private String coverLetter;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "candidate_id")
    @JsonIgnore()
    private Candidate candidate;






}
