package com.spring.hrms.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortedJobExperiencesWithCandidate {
    private int id;
    private String candidateName;
    private String candidateSurname;
    private String jobName;
    private String position;
    private Date startYear;
    private String graduateYear;

    public SortedJobExperiencesWithCandidate(int id, String candidateName, String candidateSurname, String jobName,String position, Date startYear, Date finishYear) {
        this.id = id;
        this.candidateName = candidateName;
        this.candidateSurname = candidateSurname;
        this.jobName = jobName;
        this.position = position;
        this.startYear = startYear;
        if (finishYear == null){
            this.graduateYear = "Okuyor";
        }else {
            int year = getYear(finishYear);
            this.graduateYear = String.valueOf(year);
        }
    }
    private int getYear(Date date){
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        return year;
    }
}
