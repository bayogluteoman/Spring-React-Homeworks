package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.entities.concretes.Language;
import org.springframework.stereotype.Service;

@Service
public interface LanguageService {
    DataResult<Language> add(Language language, int candidateId);
}
