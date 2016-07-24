package strongerweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import strongerweb.dao.Human;
import strongerweb.dao.HumanAbilities;
import strongerweb.service.InitialSetupService;

@Controller
public class InitialSetupController {
	@RequestMapping(value="/createprofile", method=RequestMethod.POST)
	public String createProfile(Model model, @ModelAttribute Human human, @ModelAttribute HumanAbilities humanAbilities, BindingResult result) {
		human.setHumanAbilities(humanAbilities);
		InitialSetupService iss = new InitialSetupService();
		iss.calculateHumanAbilities(human);
		return "initialprofile";
	}
}
