package strongerweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import strongerweb.dao.UserAccount;
import strongerweb.dao.UserAccountDao;

@Service
public class UserAccountService {
	public UserAccountDao userAccountDao;

	@Autowired
	public void setUserAccountDao(UserAccountDao userAccountDao) {
		this.userAccountDao = userAccountDao;
	}
	
	public List<UserAccount> showCurrent() {
		List<UserAccount> userAccounts = userAccountDao.getUserAccounts();
		return userAccounts;
	}

	public void create(UserAccount userAccount) {
		userAccountDao.create(userAccount);
	}
	
	public void throwTestException() {
		userAccountDao.getUserAccount(99999);
	}


}
