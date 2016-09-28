package io.github.bi0qaw.particleplus.effect;

import io.github.bi0qaw.particleplus.util.ParticleEffect;
import io.github.bi0qaw.particleplus.util.DynamicLocation;
import io.github.bi0qaw.particleplus.util.TrigMath;
import io.github.bi0qaw.particleplus.util.VectorMath;
import io.github.bi0qaw.particleplus.util.GenericMath;
import org.bukkit.util.Vector;

public class Halo extends ParticlePlusEffect {

	ParticleEffect particle = ParticleEffect.FLAME;
	DynamicLocation location;
	double radius = 1;
	Vector vec;
	float angle = 90;
	float angleStep = 10;
	float yaw;

	public Halo(DynamicLocation location){
		this(location, ParticleEffect.FLAME);
	}

	public Halo(DynamicLocation location, ParticleEffect particle){
		this.particle = particle;
		this.location = location;
		this.setPulse(1);
		this.yaw = location.getYaw();
	}


	@Override
	public void onRun() {
		if (!location.needsUpdate()) {
			location.update();
			vec = VectorMath.fromCylindricalCoordinates(radius, yaw + angle, 2);
			angle = GenericMath.wrapAngleDeg(angle + angleStep);
			particle.display(0, 0, 0, 0, 1, location.getLocation().add(vec), 32);
		}
		else {
			location.update();
			angle = 90;
			yaw = location.getYaw();
		}
	}
}
