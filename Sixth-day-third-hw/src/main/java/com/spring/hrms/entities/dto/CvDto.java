package com.spring.hrms.entities.dto;

import com.spring.hrms.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
    private Candidate candidate;
    private String description;
    private String githubAddress;
    private String linkedinAddress;
    private String technologies;
    private String coverLetter;
    private List<Education> educationList;
    private List<JobExperiences> jobExperiences;
    private List<Language> languageList;

}
