package io.github.bi0qaw.particleplus.effect;

import io.github.bi0qaw.particleplus.util.DynamicLocation;
import io.github.bi0qaw.particleplus.util.ParticlePlusParticle;

public class Aura extends ParticlePlusEffect {

	ParticlePlusParticle particle;
	DynamicLocation location;

	public Aura(DynamicLocation location){
		this(location, new ParticlePlusParticle());
	}

	public Aura(DynamicLocation location, ParticlePlusParticle particle){
		this.particle = particle;
		this.location = location;
		particle.setOffsetX(0.75F);
		particle.setOffsetY(1.25F);
		particle.setOffsetZ(0.75F);
	}

	@Override
	public void onRun() {
		particle.display(location.getLocation().add(0,1,0));
	}


}
