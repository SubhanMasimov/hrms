package kodlamaio.hrms.business.adapters.personService;

import kodlamaio.hrms.entities.concretes.Candidate;

public class MernisServiceManager implements PersonService {

	@Override
	public boolean verify(Candidate candidate) {
		if (candidate.getNationalityId().length() <= 10) {
			return false;
		}

		return true;
	}

}
