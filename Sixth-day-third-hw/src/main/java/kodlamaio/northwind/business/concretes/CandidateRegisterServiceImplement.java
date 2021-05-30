package kodlamaio.northwind.business.concretes;


import kodlamaio.northwind.adapter.abstracts.ServiceAdapter;
import kodlamaio.northwind.business.abstracts.ActivationCodeService;
import kodlamaio.northwind.business.abstracts.CandidateRegisterService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.dataAccess.abstratcs.CandidateRepository;
import kodlamaio.northwind.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateRegisterServiceImplement implements CandidateRegisterService {

    private final CandidateRepository candidateRepository;
    private final ServiceAdapter serviceAdapter;
    private final ActivationCodeService activationCodeService;

    public CandidateRegisterServiceImplement(CandidateRepository candidateRepository, ServiceAdapter serviceAdapter, ActivationCodeService activationCodeService) {
        this.candidateRepository = candidateRepository;
        this.serviceAdapter = serviceAdapter;
        this.activationCodeService = activationCodeService;
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
       // activationCodeService.activateCandidateAccountByEmail(candidate,"afff5aa472sssb");
        return new SuccessDataResult(candidate, "Succesfully registered to the system. Please verify your account from e-mail.");
    }

    @Override
    public boolean checkIfUserExistBefore(Candidate candidate) {
        List<Candidate> candidateList = candidateRepository.findAll();
        for (Candidate candidate1 : candidateList){
            if (candidate1.getEMail().equals(candidate.getEMail())||candidate1.getTc_no().equals(candidate.getTc_no()))
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
        if (candidate.getFirstName() != null && candidate.getLastName() != null & candidate.getPassword()!=null && candidate.getEMail()!=null && candidate.getTc_no()!=null && candidate.getBirthDay()!=null)
            return true;
        else return false;
    }
}
