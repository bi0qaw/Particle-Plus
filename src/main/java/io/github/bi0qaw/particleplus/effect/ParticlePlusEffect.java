package io.github.bi0qaw.particleplus.effect;

import java.util.UUID;

public abstract class ParticlePlusEffect {

	private String id;
	private int taskId = -1;

	private int delay = 0;
	private int pulse = 1;


	public ParticlePlusEffect(){
		this.id = UUID.randomUUID().toString();
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public int getTaskId(){
		return taskId;
	}

	protected void setTaskId(final int task){
		this.taskId = task;
	}

	public int getDelay(){
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public int getPulse() {
		return pulse;
	}

	public void setPulse(int pulse) {
		this.pulse = pulse;
	}

	public abstract void onRun();

}
