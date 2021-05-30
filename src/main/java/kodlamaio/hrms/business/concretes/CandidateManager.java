package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.adapters.personService.PersonService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserService userService;
	private PersonService personService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserService userService, PersonService personService) {
		this.candidateDao = candidateDao;
		this.personService = personService;
		this.userService = userService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(), "Namizədlər listələndi");
	}

	@Override
	public Result add(Candidate candidate) {
		Result result = BusinessRules.run(CheckIfPersonValid(candidate));

		if (result == null) {
			userService.add(candidate.getUser());
			candidateDao.save(candidate);
			return new SuccessResult("Namizəd əlavə edildi");
		}

		return new ErrorResult(result.getMessage());

	}

	// business rules

	private Result CheckIfPersonValid(Candidate candidate) {

		return personService.verify(candidate) == true ? new SuccessResult()
				: new ErrorResult("İstifadəçi doğrulanmadı");
	}
}
