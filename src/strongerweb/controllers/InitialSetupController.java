package strongerweb.controllers;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import strongerweb.dao.Human;
import strongerweb.dao.HumanAbilities;
import strongerweb.dao.wrappers.HumanWrapper;
import strongerweb.service.InitialSetupService;

@Controller
public class InitialSetupController {
	Logger logger = Logger.getLogger(this.getClass());
	@RequestMapping(value="/createprofile", method=RequestMethod.POST)
	public String createProfile(Model model, @Valid HumanWrapper humanWrapper, BindingResult result) {
		InitialSetupService iss = new InitialSetupService();
		
		if (result.hasErrors()) {
			return "home";
		} else {
			Human human = iss.setupHuman(humanWrapper);
			logger.info("Setup human as follows: " + human + " in " + this.getClass());
			HumanAbilities humanAbilities = human.getHumanAbilities();
			logger.info("Human abilities are as follows..." + humanAbilities + "...adding to model");
			model.addAttribute("humanAbilities", humanAbilities);
			return "initialprofile";
		}
	}
}
