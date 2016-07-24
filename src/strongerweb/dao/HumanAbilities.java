package strongerweb.dao;

/**
 * @author Adam Sickmiller
 * A class describing the abilities of a particular human. This is separate from human characteristics like
 * bodyweight or eye color.
 * 
 * New exercises should be added to this class. Don't forget to add an enum with calculations related to each
 *
 */
public class HumanAbilities {
	public int maxLowBarbellBackSquat;
	public int maxHighBarbellBackSquat;
	public int maxBarbellFrontSquat;
	public int maxBarbellBenchPress;
	public int maxBarbellOverheadPress;
	public int maxBarbellPendlayRow;
	public int maxMachineCurl;
	public int maxSmithMachineCalfRaise;
	public int maxRomanianDeadlift;
	
	//the general ability of the human
	public enum generalAbility {
		untrained,
		novice,
		intermediate,
		advanced
	}
	
	//enum describing typical max ability for different exercises. should have one for every exercise
	public enum typicalMaxAsPercentBodyweight {
		lowBarbellBackSquat (0.735, 0.4725),
		highBarbellBackSquat (0.7, 0.45),
		barbellFrontSquat (0.525, 0.3375),
		barbellBenchPress (0.66, 0.5),
		barbellOverheadPress (0.4, 0.25),
		barbellPendlayRow (0.45, 0.3),
		machineCurl (0.33, 0.25),
		smithMachineCalfRaise (0.45, 0.35),
		romanianDeadlift (0.4, 0.3);
		
		private final double untrainedMale;
		private final double untrainedFemale;
		
		typicalMaxAsPercentBodyweight(double untrainedMale, double untrainedFemale) {
			this.untrainedMale = untrainedMale;
			this.untrainedFemale = untrainedFemale;
		}
		
		public double untrainedMale() {
			return untrainedMale;
		}
		
		public double untrainedFemale() {
			return untrainedFemale;
		}
	}
	
	public HumanAbilities() {
	}

	@Override
	public String toString() {
		return "HumanAbilities [maxLowBarbellBackSquat=" + maxLowBarbellBackSquat + ", maxHighBarbellBackSquat="
				+ maxHighBarbellBackSquat + ", maxBarbellFrontSquat=" + maxBarbellFrontSquat + ", maxBarbellBenchPress="
				+ maxBarbellBenchPress + ", maxBarbellOverheadPress=" + maxBarbellOverheadPress
				+ ", maxBarbellPendlayRow=" + maxBarbellPendlayRow + ", maxMachineCurl=" + maxMachineCurl
				+ ", maxSmithMachineCalfRaise=" + maxSmithMachineCalfRaise + ", maxRomanianDeadlift="
				+ maxRomanianDeadlift + "]";
	}
	
	public int getMaxLowBarbellBackSquat() {
		return maxLowBarbellBackSquat;
	}
	public void setMaxLowBarbellBackSquat(int maxLowBarbellBackSquat) {
		this.maxLowBarbellBackSquat = maxLowBarbellBackSquat;
	}
	public int getMaxHighBarbellBackSquat() {
		return maxHighBarbellBackSquat;
	}
	public void setMaxHighBarbellBackSquat(int maxHighBarbellBackSquat) {
		this.maxHighBarbellBackSquat = maxHighBarbellBackSquat;
	}
	public int getMaxBarbellFrontSquat() {
		return maxBarbellFrontSquat;
	}
	
	public void setMaxBarbellFrontSquat(int maxBarbellFrontSquat) {
		this.maxBarbellFrontSquat = maxBarbellFrontSquat;
	}
	public int getMaxBarbellBenchPress() {
		return maxBarbellBenchPress;
	}
	public void setMaxBarbellBenchPress(int maxBarbellBenchPress) {
		this.maxBarbellBenchPress = maxBarbellBenchPress;
	}
	public int getMaxBarbellOverheadPress() {
		return maxBarbellOverheadPress;
	}
	public void setMaxBarbellOverheadPress(int maxBarbellOverheadPress) {
		this.maxBarbellOverheadPress = maxBarbellOverheadPress;
	}
	public int getMaxBarbellPendlayRow() {
		return maxBarbellPendlayRow;
	}
	public void setMaxBarbellPendlayRow(int maxBarbellPendlayRow) {
		this.maxBarbellPendlayRow = maxBarbellPendlayRow;
	}

	public int getMaxMachineCurl() {
		return maxMachineCurl;
	}

	public void setMaxMachineCurl(int maxMachineCurl) {
		this.maxMachineCurl = maxMachineCurl;
	}

	public int getMaxSmithMachineCalfRaise() {
		return maxSmithMachineCalfRaise;
	}

	public void setMaxSmithMachineCalfRaise(int maxSmithMachineCalfRaise) {
		this.maxSmithMachineCalfRaise = maxSmithMachineCalfRaise;
	}

	public int getMaxRomanianDeadlift() {
		return maxRomanianDeadlift;
	}

	public void setMaxRomanianDeadlift(int maxRomanianDeadlift) {
		this.maxRomanianDeadlift = maxRomanianDeadlift;
	}
}
