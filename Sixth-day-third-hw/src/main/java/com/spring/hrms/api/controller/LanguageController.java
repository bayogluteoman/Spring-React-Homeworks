package com.spring.hrms.api.controller;

import com.spring.hrms.business.abstracts.LanguageService;
import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.entities.concretes.Language;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("/add")
    public DataResult<Language> add(@RequestBody Language language, @RequestParam int candidateId){
        return languageService.add(language,candidateId);

    }
}
