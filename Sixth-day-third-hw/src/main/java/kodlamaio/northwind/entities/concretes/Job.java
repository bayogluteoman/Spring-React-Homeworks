package kodlamaio.northwind.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="job_titles")
@Data
public class Job {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="job_title")
    private String jobTitle;

    public Job(){}
}
