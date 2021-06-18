package com.spring.hrms.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvDto {
    private int jobId;

    private int workTypeId;

    private int workTimeId;

    private int employerId;

    private int cityId;

    private String jobDescription;

    private boolean activationStatus;

    private int minWage;

    private int maxWage;

    private int numberOfPosition;

    private Date lastApplyDate;

    private Date publishDate;

}
