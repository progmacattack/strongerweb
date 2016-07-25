package strongerweb.controllers;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import strongerweb.dao.Human;
import strongerweb.dao.wrappers.HumanWrapper;
import strongerweb.service.InitialSetupService;

@Controller
public class InitialSetupController {
	Logger logger = Logger.getLogger(this.getClass());
	@RequestMapping(value="/createprofile", method=RequestMethod.POST)
	public String createProfile(Model model, @Valid HumanWrapper humanWrapper, BindingResult result) {
		InitialSetupService iss = new InitialSetupService();
		Human human = iss.setupHuman(humanWrapper);
		logger.info("Setup human as follows: " + human);
		
		if (result.hasErrors()) {
			return "home";
		} else {
			return "initialprofile";
		}
	}
}
