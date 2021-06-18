package com.spring.hrms.entities.concretes;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "employer_activation_by_employes")
public class EmployerActivationByEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(hidden = true)
    private int id;


    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    @Column(name = "confirmed_date")
    private Date confirmedDate;

    @OneToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
