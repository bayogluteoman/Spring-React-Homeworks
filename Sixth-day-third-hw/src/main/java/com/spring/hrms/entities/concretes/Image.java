package com.spring.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="images")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employee"})
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @ApiModelProperty(hidden = true)
    private int id;

    @Column(name="url")
    private String url;

    @Column(name="PublicId")
    private String PublicId;

    @Column(name="uploadDate")
    private Date uploadDate;

    @ManyToOne
    @JoinColumn(name="candidateId")
    private Candidate candidate;

}
