package strongerweb.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import strongerweb.dao.UserAccount;
import strongerweb.service.UserAccountService;

@Controller
public class UserAccountController {
	private UserAccountService userAccountService;
	
	@Autowired
	public void setUserAccountService(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}
	
	@RequestMapping("/newuser")
	public String newUser(Model model) {
		return "newUser";
	}
	
	@RequestMapping("/docreate")
	public String doCreate(Model model, @Valid UserAccount userAccount, BindingResult result) {
		if (result.hasErrors()) {
			return "newUser";
		}
		userAccountService.create(userAccount);
		return "newusercreated";
	}

}
