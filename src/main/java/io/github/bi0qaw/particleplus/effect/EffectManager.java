package io.github.bi0qaw.particleplus.effect;

import io.github.bi0qaw.particleplus.ParticlePlus;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

public class EffectManager {

	private final static HashMap<String, ParticlePlusEffect> effectMap = new HashMap<String, ParticlePlusEffect>();

	public EffectManager(){
	}

	public void startEffect(final ParticlePlusEffect effect){
		if(!isRunning(effect)){
			final int taskId = Bukkit.getServer().getScheduler().runTaskTimer(ParticlePlus.particlePlus, new Runnable() {
				public void run() {
					effect.onRun();
				}
			}, effect.getDelay(), effect.getPulse()).getTaskId();
			effect.setTaskId(taskId);
			effectMap.put(effect.getId(),effect);
		}
	}

	public void stopEffect(ParticlePlusEffect effect){
		if (isRunning(effect)){
			Bukkit.getScheduler().cancelTask(effect.getTaskId());
			effectMap.remove(effect.getId());
		}
	}

	public void stopAll(){
		Object[] values = effectMap.values().toArray();
		for (Object effect : values) stopEffect((ParticlePlusEffect)effect);
	}

	public boolean isRunning(ParticlePlusEffect effect){
		if(effectMap.containsValue(effect)){
			return true;
		}
		return false;
	}

	public Optional<ParticlePlusEffect> getEffect(String id){
		if (effectMap.containsKey(id)){
			return Optional.of(effectMap.get(id));
		}
		return Optional.empty();
	}

	public Set<String> getKeys(){
		return effectMap.keySet();
	}

}
