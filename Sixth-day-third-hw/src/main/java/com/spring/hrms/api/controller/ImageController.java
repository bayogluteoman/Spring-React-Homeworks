package com.spring.hrms.api.controller;

import com.spring.hrms.business.abstracts.ImageService;
import com.spring.hrms.core.services.cloudinaryservice.CloudinaryService;
import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.ErrorResult;
import com.spring.hrms.core.utilities.results.Result;
import com.spring.hrms.entities.concretes.Candidate;
import com.spring.hrms.entities.concretes.Image;
import lombok.var;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/api/photos")
public class ImageController {
    private final ImageService imageService;
    private final CloudinaryService cloudinaryService;

    public ImageController(ImageService imageService, CloudinaryService cloudinaryService) {
        this.imageService = imageService;
        this.cloudinaryService = cloudinaryService;
    }


    @PostMapping("/upload")
    public Result upload(@RequestParam MultipartFile multipartFile, int candidateId) throws IOException{
        if(!multipartFile.isEmpty()) {
            var uploadResult = this.cloudinaryService.upload(multipartFile);
            Image image = new Image(0,uploadResult.get("url").toString(),
                    uploadResult.get("public_id").toString(),new Date(),new Candidate(candidateId,null,null,null,null,null,null,null,null,null,null,null));
            return this.imageService.add(image);
        }
        return new ErrorResult("Resim seçmediniz");


    }
    @GetMapping("/getByCandidateId")
    public DataResult<List<Image>> getByCandidateId(@RequestParam int candidateId){
        return this.imageService.getByCandidateId(candidateId);
    }
}
