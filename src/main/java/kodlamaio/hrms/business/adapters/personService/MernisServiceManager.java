package kodlamaio.hrms.business.adapters.personService;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class MernisServiceManager implements PersonService {

	@Override
	public boolean verify(Candidate candidate) {
		if (candidate.getNationalityId().length() < 11) {
			return false;
		}

		return true;
	}

}
