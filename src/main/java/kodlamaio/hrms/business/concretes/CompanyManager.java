package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrms.entities.concretes.Company;

@Service
public class CompanyManager implements CompanyService {

	private CompanyDao companyDao;
	private UserService userService;

	public CompanyManager(CompanyDao companyDao, UserService userService) {
		this.companyDao = companyDao;
		this.userService = userService;
	}

	@Override
	public DataResult<List<Company>> getAll() {
		return new SuccessDataResult<List<Company>>(companyDao.findAll(), "Şirkətlər listələndi");
	}

	@Override
	public Result add(Company company) {
		
		userService.add(company.getUser());
		companyDao.save(company);
		return new SuccessResult("Şirkət əlavə edildi");
	}
	
}
