package io.github.bi0qaw.particleplus.effect;

import io.github.bi0qaw.particleplus.util.DynamicLocation;
import io.github.bi0qaw.particleplus.util.ParticleEffect;

public class Aura extends ParticlePlusEffect {

	ParticleEffect particle;
	DynamicLocation location;
	float offsetX = 0.75F;
	float offsetY = 1.25F;
	float offsetZ = 0.75F;
	float speed = 0;
	int amount = 1;
	double range = 32;

	public Aura(DynamicLocation location){
		this(location, ParticleEffect.FLAME);
	}

	public Aura(DynamicLocation location, ParticleEffect particle){
		this.particle = particle;
		this.location = location;
		this.setPulse(1);
	}

	@Override
	public void onRun() {
		particle.display(offsetX, offsetY, offsetZ, speed, amount, location.getLocation().add(0,1,0), range);
	}


}
