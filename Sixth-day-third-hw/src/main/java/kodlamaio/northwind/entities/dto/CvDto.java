package kodlamaio.northwind.entities.dto;

import kodlamaio.northwind.entities.concretes.Candidate;
import kodlamaio.northwind.entities.concretes.Education;
import kodlamaio.northwind.entities.concretes.JobExperiences;
import kodlamaio.northwind.entities.concretes.Language;
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
