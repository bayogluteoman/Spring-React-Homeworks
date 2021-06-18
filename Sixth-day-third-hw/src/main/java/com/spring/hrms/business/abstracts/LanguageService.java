package com.spring.hrms.business.abstracts;

import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.entities.concretes.Language;

public interface LanguageService {
    DataResult<Language> add(Language language,int candidateId);
}
