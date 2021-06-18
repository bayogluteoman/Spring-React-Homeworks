package com.spring.hrms.dataAccess.abstracts;

import com.spring.hrms.entities.concretes.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image,Integer> {
    List<Image> getByCandidate_Id(int candidateId);

}
