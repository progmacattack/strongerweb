package strongerweb.service;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import strongerweb.dao.Human;
import strongerweb.dao.Human.Sex;
import strongerweb.dao.HumanAbilities;
import strongerweb.dao.HumanAbilities.typicalMaxAsPercentBodyweight;
import strongerweb.dao.wrappers.HumanWrapper;

@Service
public class InitialSetupService {
	Logger logger = Logger.getLogger(this.getClass());
	public Human human;
	
	public InitialSetupService() {
		super();
	}

	public Human setupHuman (HumanWrapper humanWrapper) {
		Human human = new Human();
		String weight = humanWrapper.getWeight();
		String sex = humanWrapper.getSex();
		int weightInPounds = 0;
		
		try {
			weightInPounds = Integer.parseInt(weight);
		} catch (NumberFormatException nfe) {
			logger.info(nfe.getMessage() + " in " + nfe.getClass());
			logger.info("Couldn't convert " + weight + " to int :(");
		}
		
		human.setWeightInPounds(weightInPounds);
		logger.info("Sex received is: " + sex);
		if (sex.toLowerCase().equals("female")) {
			human.setSex(Sex.FEMALE);
		} else if (sex.toLowerCase().equals("male")) {
			human.setSex(Sex.MALE);
		} else {
			human.setSex(Sex.MALE);
		}
		
		HumanAbilities humanAbilities = guessAllHumanAbilities(human);
		human.setHumanAbilities(humanAbilities);
		return human;
	}

	
	
	public HumanAbilities guessAllHumanAbilities(Human human) {
		logger.info("Details as first noticed in calculateHumanAbilities: " + human);
		HumanAbilities abilities = new HumanAbilities();
		if (human.getSex() == Sex.MALE) {
			if (human.getWeightInPounds() <= 0) {
				human.setWeightInPounds((int)Human.AverageHumanWeight.MaleInUsa.inPounds());
			}
			int weight = human.getWeightInPounds();			
			abilities.setMaxBarbellBenchPress((int)(weight * typicalMaxAsPercentBodyweight.barbellBenchPress.untrainedMale()));
			abilities.setMaxHighBarbellBackSquat((int)(weight * typicalMaxAsPercentBodyweight.highBarbellBackSquat.untrainedMale()));
			abilities.setMaxBarbellPendlayRow((int)(weight * typicalMaxAsPercentBodyweight.barbellPendlayRow.untrainedMale()));
			abilities.setMaxBarbellOverheadPress((int)(weight * typicalMaxAsPercentBodyweight.barbellOverheadPress.untrainedMale()));
			abilities.setMaxBarbellFrontSquat((int)(weight * typicalMaxAsPercentBodyweight.barbellFrontSquat.untrainedMale()));
			abilities.setMaxLowBarbellBackSquat((int)(weight * typicalMaxAsPercentBodyweight.lowBarbellBackSquat.untrainedMale()));
			abilities.setMaxMachineCurl((int)(weight * typicalMaxAsPercentBodyweight.machineCurl.untrainedMale()));
			abilities.setMaxSmithMachineCalfRaise((int)(weight * typicalMaxAsPercentBodyweight.smithMachineCalfRaise.untrainedMale()));
			abilities.setMaxRomanianDeadlift((int)(weight * typicalMaxAsPercentBodyweight.romanianDeadlift.untrainedMale()));
	
		} else if (human.getSex() == Sex.FEMALE) {
			if (human.getWeightInPounds() <= 0) {
				human.setWeightInPounds((int) Human.AverageHumanWeight.FemaleInUsa.inPounds());
			}
			int weight = human.getWeightInPounds();
			abilities.setMaxBarbellBenchPress((int)(weight * typicalMaxAsPercentBodyweight.barbellBenchPress.untrainedFemale()));
			abilities.setMaxHighBarbellBackSquat((int)(weight * typicalMaxAsPercentBodyweight.highBarbellBackSquat.untrainedFemale()));
			abilities.setMaxBarbellPendlayRow((int)(weight * typicalMaxAsPercentBodyweight.barbellPendlayRow.untrainedFemale()));
			abilities.setMaxBarbellOverheadPress((int)(weight * typicalMaxAsPercentBodyweight.barbellOverheadPress.untrainedFemale()));
			abilities.setMaxBarbellFrontSquat((int)(weight * typicalMaxAsPercentBodyweight.barbellFrontSquat.untrainedFemale()));
			abilities.setMaxLowBarbellBackSquat((int)(weight * typicalMaxAsPercentBodyweight.lowBarbellBackSquat.untrainedFemale()));
			abilities.setMaxMachineCurl((int)(weight * typicalMaxAsPercentBodyweight.machineCurl.untrainedFemale()));
			abilities.setMaxSmithMachineCalfRaise((int)(weight * typicalMaxAsPercentBodyweight.smithMachineCalfRaise.untrainedFemale()));
			abilities.setMaxRomanianDeadlift((int)(weight * typicalMaxAsPercentBodyweight.romanianDeadlift.untrainedFemale()));
		}
		
		logger.info("Details after processing in getHumanAbilities method: " + human);
		
		return abilities;
	}
	
}
