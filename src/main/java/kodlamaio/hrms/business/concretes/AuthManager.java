package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Company;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.dtos.CandidateRegisterDto;
import kodlamaio.hrms.entities.dtos.CompanyRegisterDto;
import kodlamaio.hrms.entities.dtos.UserLoginDto;

@Service
public class AuthManager implements AuthService {

	private UserService userService;
	private CandidateService candidateService;
	private CompanyService companyService;

	@Autowired
	public AuthManager(UserService userService, CandidateService candidateService, CompanyService companyService) {
		this.userService = userService;
		this.candidateService = candidateService;
		this.companyService = companyService;
	}

	@Override
	public Result login(UserLoginDto dto) {
		Result result = userService.controlLogin(dto.getEmail(), dto.getPassword());

		if (result.isSuccess()) {
			return new SuccessResult("Giriş uğurludur");
		}

		return new ErrorResult("Girişdə xəta baş verdi!");
	}

	@Override
	public Result registerCandidate(CandidateRegisterDto dto) {
		Candidate candidate = new Candidate(dto.getFirstName(), dto.getLastName(), dto.getNationalityId(),
				dto.getBirthDate());

		candidate.setUser(new User(dto.getEmail(), dto.getPassword(), LocalDateTime.now(), false));
		candidateService.add(candidate);
		return new SuccessResult("Namizəd əlavə edildi");
	}

	@Override
	public Result registerCompany(CompanyRegisterDto dto) {
		Company company = new Company(dto.getCompamyName(), dto.getWebSite(), dto.getPhone());
		company.setUser(new User(dto.getEmail(), dto.getPassword(), LocalDateTime.now(), false));

		companyService.add(company);
		return new SuccessResult("Şirkət əlavə edildi");

	}

}