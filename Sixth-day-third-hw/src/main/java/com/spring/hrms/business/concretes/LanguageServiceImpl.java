package com.spring.hrms.business.concretes;

import com.spring.hrms.business.abstracts.LanguageService;
import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.SuccessDataResult;
import com.spring.hrms.dataAccess.abstracts.CandidateRepository;
import com.spring.hrms.dataAccess.abstracts.LanguageRepository;
import com.spring.hrms.entities.concretes.Candidate;
import com.spring.hrms.entities.concretes.Language;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;
    private final CandidateRepository candidateRepository;

    public LanguageServiceImpl(LanguageRepository languageRepository, CandidateRepository candidateRepository) {
        this.languageRepository = languageRepository;
        this.candidateRepository = candidateRepository;
    }

    @Override
    public DataResult<Language> add(Language language,int candidateId) {
        Candidate candidate = candidateRepository.findById(candidateId).get();
        language.setCandidate(candidate);
        candidate.getLanguage().add(language);
        languageRepository.save(language);
        return new SuccessDataResult(language,"Language added to system.");
    }
}
