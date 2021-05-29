package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		userDao.save(user);
		return new SuccessResult("İstifadəçi əlavə edildi");
	}

	@Override
	public Result controlLogin(String email, String password) {
		User result = userDao.getByEmailAndPassword(email, password);

		if (result == null) {
			return new ErrorResult();
		}

		return new SuccessResult();
	}

}
