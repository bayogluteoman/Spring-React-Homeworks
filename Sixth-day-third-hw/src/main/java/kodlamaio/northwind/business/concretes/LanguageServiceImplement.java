package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.LanguageService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.dataAccess.abstracts.CandidateRepository;
import kodlamaio.northwind.dataAccess.abstracts.LanguageRepository;
import kodlamaio.northwind.entities.concretes.Candidate;
import kodlamaio.northwind.entities.concretes.Language;

public class LanguageServiceImplement implements LanguageService {

    public LanguageServiceImplement(LanguageRepository languageRepository, CandidateRepository candidateRepository) {
        this.languageRepository = languageRepository;
        this.candidateRepository = candidateRepository;
    }

    private final LanguageRepository languageRepository;
    private final CandidateRepository candidateRepository;

    @Override
    public DataResult<Language> add(Language language, int candidateId) {
        Candidate candidate = candidateRepository.findById(candidateId).get();
        language.setCandidate(candidate);
        candidate.getLanguage().add(language);
        languageRepository.save(language);
        return new SuccessDataResult(language,"Language added to system.");
    }
}
