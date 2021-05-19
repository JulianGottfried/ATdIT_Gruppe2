package main.java.model;

public class StageOfCOA implements Model {
	private Boolean[] stages;
	
	public StageOfCOA() {
	}

	public StageOfCOA(Boolean[] stages) {
		this.stages = stages;
	}

	public Boolean[] getStages() {
		return stages;
	}

	public void setStages(Boolean[] stages) {
		this.stages = stages;
	}
}
