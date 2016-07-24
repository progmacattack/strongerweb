package strongerweb.dao;

import strongerweb.utilities.Convert.Weight;

/**
 * @author Adam Sickmiller
 * This class describes different characteristics of a human body as a separate entity
 * from the user account or from the abilities of that human. Examples of human characteristics
 * might be weight, eye color, or number of fingers
 */

public class Human {
	public int weightInPounds = 0;
	Sex sex;
	HumanAbilities humanAbilities;
	AverageHumanWeight averageHumanWeight;
	
	public enum Sex {
		MALE,
		FEMALE;
	}
	
	//reference from anywhere to get an average bodyweight
	public enum AverageHumanWeight {
		MaleInUsa (194.7),
		FemaleInUsa (164.7);
		
		private final int weightInPounds; //in pounds
		private final int  weightInKilograms;
		
		AverageHumanWeight(double weightInPounds) {
			this.weightInPounds = (int) weightInPounds;
			this.weightInKilograms = (int) (weightInPounds * Weight.pounds.toKilograms());
		}
		
		public double inPounds() {
			return weightInPounds;
		}
		
		public double inKilograms() {
			return weightInKilograms;
		}
	}
		
	/**
	 * Default constructor 
	 */
	public Human() {
	}

	
	/**
	 * @return int of the human's weight in pounds
	 */
	public int getWeightInPounds() {
		return weightInPounds;
	}
	
	
	/**
	 * @param weightInPounds int of the human's bodyweight in pounds
	 */
	public void setWeightInPounds(int weightInPounds) {
		this.weightInPounds = weightInPounds;
	}
	
	
	/**
	 * @return Sex enum describing the biological sex of the human
	 */
	public Sex getSex() {
		return sex;
	}
	
	
	/**
	 * @param sex set enum describing the biological sex of the human. at minimum Sex.MALE or Sex.FEMALE
	 */
	public void setSex(Sex sex) {
		this.sex = sex;
	}

	/**
	 * @return object containing information about the human's performance in different categories, like max squat
	 */
	public HumanAbilities getHumanAbilities() {
		return humanAbilities;
	}

	/**
	 * @param humanAbilities an object with information about this human's abilities in different categories
	 */
	public void setHumanAbilities(HumanAbilities humanAbilities) {
		this.humanAbilities = humanAbilities;
	}

	@Override
	public String toString() {
		return "Human [weightInPounds=" + weightInPounds + ", sex=" + sex + ", humanAbilities=" + humanAbilities + "]";
	}
	
}
