package io.github.bi0qaw.particleplus.effect;

import io.github.bi0qaw.particleplus.util.ParticleEffect;
import io.github.bi0qaw.particleplus.util.DynamicLocation;
import io.github.bi0qaw.particleplus.util.TrigMath;
import io.github.bi0qaw.particleplus.util.VectorMath;
import io.github.bi0qaw.particleplus.util.GenericMath;
import org.bukkit.util.Vector;

public class SinHalo extends ParticlePlusEffect {

	ParticleEffect particle = ParticleEffect.FLAME;
	DynamicLocation location;
	double radius = 1;
	Vector vec;
	float angle = 90;
	float angleStep = 10;
	double height = 0;
	double heightStep = TrigMath.TWO_PI / 8;
	double heightAmplitude = 0.2;
	float yaw;

	public SinHalo(DynamicLocation location){
		this(location, ParticleEffect.FLAME);
	}

	public SinHalo(DynamicLocation location, ParticleEffect particle){
		this.location = location;
		this.particle = particle;
		this.setPulse(1);
		this.yaw = this.location.getYaw();
	}


	@Override
	public void onRun() {
		if (!location.needsUpdate()) {
			location.update();
			vec = VectorMath.fromCylindricalCoordinates(radius, yaw + angle, 2 + TrigMath.sin(height) * heightAmplitude);
			angle = GenericMath.wrapAngleDeg(angle + angleStep);
			height = GenericMath.wrapAngleRad(height + heightStep);
			particle.display(0, 0, 0, 0, 1, location.getLocation().add(vec), 32);
		}
		else {
			location.update();
			angle = 90;
			height = 0;
			yaw = location.getYaw();
		}
	}
}
