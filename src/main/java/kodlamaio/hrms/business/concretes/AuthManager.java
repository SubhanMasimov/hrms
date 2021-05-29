package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.dtos.CandidateRegisterDto;
import kodlamaio.hrms.entities.dtos.UserLoginDto;

@Service
public class AuthManager implements AuthService {

	private UserService userService;
	private CandidateService candidateService;

	@Autowired
	public AuthManager(UserService userService, CandidateService candidateService) {
		this.userService = userService;
		this.candidateService = candidateService;
	}

	@Override
	public Result login(UserLoginDto dto) {
		Result result = userService.controlLogin(dto.getEmail(), dto.getPassword());
		
		if(result.isSuccess()) {
			return new SuccessResult("Giriş uğurludur");
		}
		
		return new ErrorResult("Girişdə xəta baş verdi!");
	}

	@Override
	public Result registerCandidate(CandidateRegisterDto dto) {
		Candidate candidate = new Candidate(dto.getFirstName(), dto.getLastName(), dto.getNationalityId(),
				dto.getBirthDate());

		candidate.setUser(new User(dto.getEmail(), dto.getPassword(), dto.getBirthDate(), false));
		candidateService.add(candidate);
		return new SuccessResult("Namizəd əlavə edildi");
	}

}
