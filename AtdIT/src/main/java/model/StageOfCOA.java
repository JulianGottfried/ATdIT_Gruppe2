package main.java.model;
/**
* This class returns, sets and creates the Stage of the Change of Address (COA) process
* @author weilichsoheisse
* @version 16.05.2021
*
*/
public class StageOfCOA {
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
