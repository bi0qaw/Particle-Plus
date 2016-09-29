package io.github.bi0qaw.particleplus.effect;

import io.github.bi0qaw.particleplus.util.*;
import org.bukkit.util.Vector;

public class Halo extends ParticlePlusEffect {

	ParticlePlusParticle particle;
	DynamicLocation location;
	double radius = 1;
	Vector vec;
	float angle = 90;
	float angleStep = 10;
	float yaw;

	public Halo(DynamicLocation location){
		this(location, new ParticlePlusParticle());
	}

	public Halo(DynamicLocation location, ParticlePlusParticle particle){
		this.particle = particle;
		this.location = location;
		this.yaw = location.getYaw();
	}

	@Override
	public void onRun() {
		if (!location.needsUpdate()) {
			location.update();
			vec = VectorMath.fromCylindricalCoordinates(radius, yaw + angle, 2);
			angle = GenericMath.wrapAngleDeg(angle + angleStep);
			particle.display(location.getLocation().add(vec));
		}
		else {
			location.update();
			angle = 90;
			yaw = location.getYaw();
		}
	}
}
