package strongerweb.dao.wrappers;

import org.jboss.logging.Logger;

import strongerweb.constraints.AValidWeight;
import strongerweb.dao.Human;
import strongerweb.dao.Human.Sex;


/**
 * @author Adam
 * A wrapper class to accept input from the web and then when it is clean create an object
 */
public class HumanWrapper {
	@AValidWeight
	public String weight;
	public String sex;
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "HumanWrapper [weight=" + weight + ", sex=" + sex + "]";
	}
	
}
