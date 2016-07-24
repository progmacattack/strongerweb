package strongerweb.service;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import strongerweb.dao.Human;
import strongerweb.dao.Human.Sex;
import strongerweb.dao.HumanAbilities;
import strongerweb.dao.HumanAbilities.typicalMaxAsPercentBodyweight;

@Service
public class InitialSetupService {
	Logger logger = Logger.getLogger(this.getClass());
	public Human human;
	
	public InitialSetupService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setHuman (Human human) {
		this.human = human;
	}

	public HumanAbilities calculateHumanAbilities(Human human) {
		logger.info("Details as entered: " + human);
		HumanAbilities abilities = human.getHumanAbilities();
		if (human.getSex() == Sex.MALE) {
			if (human.getWeightInPounds() <= 0) {
				human.setWeightInPounds((int) Human.AverageHumanWeight.MaleInUsa.inPounds());
			}
			int weight = human.getWeightInPounds();
			
			//setup all the basic abilities based on guessing by bodyweight
			if (abilities.getMaxBarbellBenchPress() == 0 && abilities.getMaxHighBarbellBackSquat() == 0) {
				abilities.setMaxBarbellBenchPress((int)(weight * typicalMaxAsPercentBodyweight.barbellBenchPress.untrainedMale()));
				abilities.setMaxHighBarbellBackSquat((int)(weight * typicalMaxAsPercentBodyweight.highBarbellBackSquat.untrainedMale()));
				abilities.setMaxBarbellPendlayRow((int)(weight * typicalMaxAsPercentBodyweight.barbellPendlayRow.untrainedMale()));
				abilities.setMaxBarbellOverheadPress((int)(weight * typicalMaxAsPercentBodyweight.barbellOverheadPress.untrainedMale()));
				abilities.setMaxBarbellFrontSquat((int)(weight * typicalMaxAsPercentBodyweight.barbellFrontSquat.untrainedMale()));
				abilities.setMaxLowBarbellBackSquat((int)(weight * typicalMaxAsPercentBodyweight.lowBarbellBackSquat.untrainedMale()));
				abilities.setMaxMachineCurl((int)(weight * typicalMaxAsPercentBodyweight.machineCurl.untrainedMale()));
				abilities.setMaxSmithMachineCalfRaise((int)(weight * typicalMaxAsPercentBodyweight.smithMachineCalfRaise.untrainedMale()));
				abilities.setMaxRomanianDeadlift((int)(weight * typicalMaxAsPercentBodyweight.romanianDeadlift.untrainedMale()));
			}

		} else if (human.getSex() == Sex.FEMALE) {
			if (human.getWeightInPounds() <= 0) {
				human.setWeightInPounds((int) Human.AverageHumanWeight.FemaleInUsa.inPounds());
			}
			int weight = human.getWeightInPounds();
			//setup all the basic abilities based on guessing by bodyweight
			if (abilities.getMaxBarbellBenchPress() == 0 && abilities.getMaxHighBarbellBackSquat() == 0) {
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
		}
		
		logger.info("Details after processing: " + human);
		
		return abilities;
	}
	
}
