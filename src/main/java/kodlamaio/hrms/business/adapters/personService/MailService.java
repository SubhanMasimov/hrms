package kodlamaio.hrms.business.adapters.personService;

import kodlamaio.hrms.entities.concretes.User;

public interface MailService {

	boolean verify(User user);
}
