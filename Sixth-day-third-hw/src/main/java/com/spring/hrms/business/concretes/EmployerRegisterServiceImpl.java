package com.spring.hrms.business.concretes;

import com.spring.hrms.business.abstracts.ActivationCodeService;
import com.spring.hrms.business.abstracts.EmployerRegisterService;
import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.ErrorDataResult;
import com.spring.hrms.core.utilities.results.SuccessDataResult;
import com.spring.hrms.dataAccess.abstracts.ActivationCodeEmployerRepository;
import com.spring.hrms.dataAccess.abstracts.EmployeeRepository;
import com.spring.hrms.dataAccess.abstracts.EmployerRepository;
import com.spring.hrms.entities.concretes.ActivationCodeEmployer;
import com.spring.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployerRegisterServiceImpl implements EmployerRegisterService {

    private final EmployerRepository employerRepository;
    private final ActivationCodeService activationCodeService;
    private final EmployeeRepository employeeRepository;
    private final ActivationCodeEmployerRepository activationCodeEmployerRepository;

    public EmployerRegisterServiceImpl(EmployerRepository employerRepository, ActivationCodeService activationCodeService, EmployeeRepository employeeRepository, ActivationCodeEmployerRepository activationCodeEmployerRepository) {
        this.employerRepository = employerRepository;
        this.activationCodeService = activationCodeService;
        this.employeeRepository = employeeRepository;
        this.activationCodeEmployerRepository = activationCodeEmployerRepository;
    }

    @Override
    public DataResult register(Employer employer) throws Exception {
        if (checkIfEmployerExistBefore(employer))
            return new ErrorDataResult(employer,"There is a registered employer with same e-mail address.");
        if (!checkNullFields(employer))
            return new ErrorDataResult(employer,"Must be filled all fields.");
        employerRepository.save(employer);
        return new SuccessDataResult(employer,"Succesfully registered. Please activate your account.");
    }

    @Override
    public boolean checkIfEmployerExistBefore(Employer employer) {
        List<Employer> employerList = employerRepository.findAll();
        for (Employer employer2 : employerList){
            if (employer2.getEMail().equals(employer.getEMail()))
                return true;
        }
        return false;
    }

    @Override
    public boolean checkNullFields(Employer employer) {
        if (employer.getEMail() != null && employer.getCompanyName()!=null && employer.getTelephoneNumber() !=null && employer.getWebPage()!=null && employer.getPassword()!=null){
            return true;
        }else return false;
    }
}
