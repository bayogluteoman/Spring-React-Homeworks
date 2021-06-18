package com.spring.hrms.business.concretes;

import com.spring.hrms.business.abstracts.ImageService;
import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.Result;
import com.spring.hrms.core.utilities.results.SuccessDataResult;
import com.spring.hrms.core.utilities.results.SuccessResult;
import com.spring.hrms.dataAccess.abstracts.ImageRepository;
import com.spring.hrms.entities.concretes.Image;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Result add(Image image) {
        imageRepository.save(image);
        return new SuccessResult("Photo added");
    }

    @Override
    public DataResult<List<Image>> getByCandidateId(int candidateId) {
        return new SuccessDataResult(this.imageRepository.getByCandidate_Id(candidateId));

    }
}
