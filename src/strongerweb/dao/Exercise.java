package strongerweb.dao;

import java.util.List;

import org.springframework.stereotype.Component;

public class Exercise {
	public String name;
	public String targetMuscles;
	public int currentMaxWeight;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getTargetMuscles() {
		return targetMuscles;
	}
	public void setTargetMuscles(String targetMuscles) {
		this.targetMuscles = targetMuscles;
	}

	@Override
	public String toString() {
		return "Exercise [name=" + name + ", targetMuscles=" + targetMuscles + "]";
	}	
}
