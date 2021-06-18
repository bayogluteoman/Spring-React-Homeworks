package com.spring.hrms.core.services.cloudinaryservice;

import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.Result;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CloudinaryService {
    Map upload(MultipartFile multipartFile) throws IOException;
}
