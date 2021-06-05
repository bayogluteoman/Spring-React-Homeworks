package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.CvService;
import kodlamaio.northwind.business.abstracts.EducationService;
import kodlamaio.northwind.business.abstracts.JobExperiencesService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.dataAccess.abstracts.CandidateRepository;
import kodlamaio.northwind.dataAccess.abstracts.CvRepository;
import kodlamaio.northwind.entities.concretes.Candidate;
import kodlamaio.northwind.entities.concretes.Cv;
import kodlamaio.northwind.entities.dto.CvDto;
import org.springframework.stereotype.Service;

@Service
public class CvServiceImplement implements CvService {

    private final CvRepository cvRepository;
    private final CandidateRepository candidateRepository;
    private final JobExperiencesService jobExperiencesService;
    private final EducationService educationService;

    public CvServiceImplement(CvRepository cvRepository, CandidateRepository candidateRepository, JobExperiencesService jobExperiencesService, EducationService educationService) {
        this.cvRepository = cvRepository;
        this.candidateRepository = candidateRepository;
        this.jobExperiencesService = jobExperiencesService;
        this.educationService = educationService;
    }

    @Override
    public DataResult<Cv> add(int candidateId, Cv cv) {
        Candidate candidate = candidateRepository.findById(candidateId).get();
        candidate.setCv(cv);
        candidateRepository.save(candidate);
        cv.setCandidate(candidate);
        cvRepository.save(cv);
        return new SuccessDataResult(cv,"Succesfuly added CV to system.");
    }

    @Override
    public DataResult<CvDto> getByCandidate_Id(int id) {
        Candidate candidate = candidateRepository.findById(id).get();

        CvDto cvDto = new CvDto();
        cvDto.setCoverLetter(candidate.getCv().getCoverLetter());
        cvDto.setDescription(candidate.getCv().getDescription());
        cvDto.setGithubAddress(candidate.getCv().getGithubAddress());
        cvDto.setLinkedinAddress(candidate.getCv().getLinkedinAddress());
        cvDto.setTechnologies(candidate.getCv().getTechnologies());
        cvDto.setCandidate(candidate);
        cvDto.setJobExperiences(jobExperiencesService.SortedJobExperiences(id).getData());
        cvDto.setEducationList(educationService.SortedEducation(id).getData());
        cvDto.setLanguageList(candidate.getLanguage());
        return new SuccessDataResult(cvDto);
    }
}
