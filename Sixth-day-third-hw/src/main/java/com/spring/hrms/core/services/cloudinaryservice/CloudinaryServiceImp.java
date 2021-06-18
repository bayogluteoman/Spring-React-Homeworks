package com.spring.hrms.core.services.cloudinaryservice;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryServiceImp implements CloudinaryService {
    Cloudinary cloudinary;
    private Map<String, String> valuesMap = new HashMap<>();

    public CloudinaryServiceImp(){

        valuesMap.put("cloud_name", "photosforhrms");
        valuesMap.put("api_key", "742474395866975");
        valuesMap.put("api_secret", "PGY63KCMHxTAm2bHGgLyqPtFU2A");
        cloudinary = new Cloudinary(valuesMap);
    }
    public Map upload(MultipartFile multipartFile) throws IOException {

        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();

        return result;
    }
}
