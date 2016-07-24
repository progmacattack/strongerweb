package strongerweb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import strongerweb.dao.Human;
import strongerweb.dao.HumanAbilities;
import strongerweb.dao.UserAccount;
import strongerweb.service.UserAccountService;

@Controller
public class HomeController {
	private UserAccountService userAccountService;

	@Autowired
	public void setUserAccountService(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}

	@RequestMapping("/")
	public String showHome(Model model) {
		List<UserAccount> userAccounts = userAccountService.showCurrent();
		model.addAttribute("userAccounts",userAccounts);
		HumanAbilities humanAbilities = new HumanAbilities();
		Human human = new Human();
		model.addAttribute("human", human);
		model.addAttribute("humanAbilities", humanAbilities);
		return "home";
	}
	

}
