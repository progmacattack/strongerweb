package strongerweb.test.service;

import static org.junit.Assert.assertTrue;

import org.jboss.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import strongerweb.dao.Human;
import strongerweb.dao.Human.Sex;
import strongerweb.dao.HumanAbilities;
import strongerweb.service.InitialSetupService;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {	"classpath:strongerweb/xmlconfig/dao-context.xml",
		"classpath:strongerweb/xmlconfig/service-context.xml",
		"classpath:strongerweb/test/config/datasource.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class InitialSetupServiceTest {
	Logger logger = Logger.getLogger(this.getClass());
	
	private Human human;
	private HumanAbilities humanAbilities;
	
	@Before
	public void init() {
		human = new Human();
		humanAbilities = new HumanAbilities();
		human.setHumanAbilities(humanAbilities);
	}
	
	@Autowired
	private InitialSetupService initialSetupService;
	
	@Test
	public void testMaleNoEntry() {
		human.setSex(Sex.MALE);
		//maybe implement validators on human class
	}
	
	@Test
	public void testInvalidWeightEntry() {
		
		//maybe implement validators on human class
	}
	
	@Test
	public void testMaleZeroEntryNoAbilities() {
		human.setSex(Sex.MALE);
		human.setWeightInPounds(0);
		HumanAbilities humanAbilities = initialSetupService.guessAllHumanAbilities(human);
		assertTrue("Exercises are set",humanAbilities.getMaxHighBarbellBackSquat() > 0
				&& humanAbilities.getMaxBarbellPendlayRow() > 0
				&& humanAbilities.getMaxBarbellOverheadPress() > 0
				&& humanAbilities.getMaxBarbellFrontSquat() > 0
				&& humanAbilities.getMaxLowBarbellBackSquat() > 0
				&& humanAbilities.getMaxMachineCurl() > 0
				&& humanAbilities.getMaxSmithMachineCalfRaise() > 0
				&& humanAbilities.getMaxRomanianDeadlift() > 0);
	}
	
	@Test
	public void testMaleSomeWeightEntered() {
		human.setSex(Sex.MALE);
		human.setWeightInPounds(130);
		initialSetupService.guessAllHumanAbilities(human);
		assertTrue("Weight over 0 pounds is unchanged", human.getWeightInPounds() == 130);	
	}
	
	@Test
	public void testFemaleNoEntry() {
		human.setSex(Sex.FEMALE);
		//maybe implement validators on human class
	}
	
	@Test
	public void testFemaleZeroEntryNoAbilities() {
		human.setSex(Sex.FEMALE);
		human.setWeightInPounds(0);
		HumanAbilities humanAbilities = initialSetupService.guessAllHumanAbilities(human);
		assertTrue("Exercises are set",humanAbilities.getMaxHighBarbellBackSquat() > 0
				&& humanAbilities.getMaxBarbellPendlayRow() > 0
				&& humanAbilities.getMaxBarbellOverheadPress() > 0
				&& humanAbilities.getMaxBarbellFrontSquat() > 0
				&& humanAbilities.getMaxLowBarbellBackSquat() > 0
				&& humanAbilities.getMaxMachineCurl() > 0
				&& humanAbilities.getMaxSmithMachineCalfRaise() > 0
				&& humanAbilities.getMaxRomanianDeadlift() > 0);
	}
	
	@Test
	public void testFemaleSomeWeightEntered() {
		human.setSex(Sex.FEMALE);
		human.setWeightInPounds(130);
		initialSetupService.guessAllHumanAbilities(human);
		assertTrue("Weight over 0 pounds is unchanged", human.getWeightInPounds() == 130);	
	}	
}