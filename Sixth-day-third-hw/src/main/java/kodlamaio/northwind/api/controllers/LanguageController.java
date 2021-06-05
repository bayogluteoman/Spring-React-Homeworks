package kodlamaio.northwind.api.controllers;


import kodlamaio.northwind.business.abstracts.LanguageService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.entities.concretes.Language;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("/add")
    public DataResult<Language> add(@RequestBody Language language, @RequestParam int candidateId) {
        return languageService.add(language, candidateId);

    }
}