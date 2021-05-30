package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateRegisterDto;
import kodlamaio.hrms.entities.dtos.CompanyRegisterDto;
import kodlamaio.hrms.entities.dtos.UserLoginDto;

public interface AuthService {

	Result login(UserLoginDto dto);

	Result registerCompany(CompanyRegisterDto dto);

	Result registerCandidate(CandidateRegisterDto dto);

}
