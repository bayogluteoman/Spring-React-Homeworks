package com.spring.hrms.business.concretes;

import com.spring.hrms.adapter.abstracts.ServiceAdapter;
import com.spring.hrms.business.abstracts.ActivationCodeService;
import com.spring.hrms.business.abstracts.CandidateRegisterService;
import com.spring.hrms.core.utilities.results.*;
import com.spring.hrms.dataAccess.abstracts.ActivationCodeCandidateRepository;
import com.spring.hrms.dataAccess.abstracts.CandidateRepository;
import com.spring.hrms.entities.concretes.ActivationCodeCandidate;
import com.spring.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CandidateRegisterServiceImpl implements CandidateRegisterService {

    private final CandidateRepository candidateRepository;
    private final ServiceAdapter serviceAdapter;
    private final ActivationCodeService activationCodeService;
    private final ActivationCodeCandidateRepository activationCodeCandidateRepository;

    public CandidateRegisterServiceImpl(CandidateRepository candidateRepository, ServiceAdapter serviceAdapter, ActivationCodeService activationCodeService, ActivationCodeCandidateRepository activationCodeCandidateRepository) {
        this.candidateRepository = candidateRepository;
        this.serviceAdapter = serviceAdapter;
        this.activationCodeService = activationCodeService;
        this.activationCodeCandidateRepository = activationCodeCandidateRepository;
    }

    @Override
    public DataResult register(Candidate candidate) throws Exception {
        if (checkIfUserExistBefore(candidate))
            return new ErrorDataResult("There is same e-mail or nationality number before has been registered");
        if (!checkCanditateIfRealPerson(candidate))
            return new ErrorDataResult("Candidate doesn't match with mernis record.");
        if (!passwordIsMatch(candidate.getPassword(),candidate.getPassword()))
            return new ErrorDataResult("Entered password doesn't match. Try again");
        if (!notNullFields(candidate))
            return new ErrorDataResult("All field must be filled");

        candidateRepository.save(candidate);

        return new SuccessDataResult<>(candidate, "Succesfully registered to the system. Please verify your account from e-mail.");
    }

    @Override
    public boolean checkIfUserExistBefore(Candidate candidate) {
        List<Candidate> candidateList = candidateRepository.findAll();
        for (Candidate candidate1 : candidateList){
            if (candidate1.getEMail().equals(candidate.getEMail())||candidate1.getNationalityNumber().equals(candidate.getNationalityNumber()))
                return true;
        }
        return false;

    }

    @Override
    public boolean checkCanditateIfRealPerson(Candidate candidate) throws Exception {
        if (serviceAdapter.checkIfRealPerson(candidate))
            return true;
        else return false;
    }

    public boolean passwordIsMatch(String password, String repassword){
        if (password.equals(repassword)){
            return true;//return new SuccessResult();
        }else return false;

    }

    public boolean notNullFields(Candidate candidate){
        if (candidate.getFirstName() != null && candidate.getLastName() != null & candidate.getPassword()!=null && candidate.getEMail()!=null && candidate.getNationalityNumber()!=null && candidate.getBirthDate()!=null)
            return true;
        else return false;
    }
}
