package io.github.bi0qaw.particleplus.effect;

import io.github.bi0qaw.particleplus.util.*;
import org.bukkit.util.Vector;

public class SinHalo extends ParticlePlusEffect {

	ParticlePlusParticle particle;
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
		this(location, new ParticlePlusParticle());
	}

	public SinHalo(DynamicLocation location, ParticlePlusParticle particle){
		this.location = location;
		this.particle = particle;
		this.yaw = this.location.getYaw();
	}


	@Override
	public void onRun() {
		if (!location.needsUpdate()) {
			location.update();
			vec = VectorMath.fromCylindricalCoordinates(radius, yaw + angle, 2 + TrigMath.sin(height) * heightAmplitude);
			angle = GenericMath.wrapAngleDeg(angle + angleStep);
			height = GenericMath.wrapAngleRad(height + heightStep);
			particle.display(location.getLocation().add(vec));
		}
		else {
			location.update();
			angle = 90;
			height = 0;
			yaw = location.getYaw();
		}
	}
}
