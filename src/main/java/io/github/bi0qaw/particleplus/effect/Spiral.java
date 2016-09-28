package io.github.bi0qaw.particleplus.effect;


import io.github.bi0qaw.particleplus.util.DynamicLocation;
import io.github.bi0qaw.particleplus.util.GenericMath;
import io.github.bi0qaw.particleplus.util.ParticleEffect;
import io.github.bi0qaw.particleplus.util.VectorMath;
import org.bukkit.util.Vector;

public class Spiral extends ParticlePlusEffect {

	ParticleEffect particle;
	DynamicLocation location;
	double radius = 0.75;
	float angle = 90;
	float angleStep = 15;
	double height = 0;
	double minHeight = 0;
	double maxHeight = 2;
	double heightStep = 0.04;
	double yaw;

	Vector vec;

	public Spiral(DynamicLocation location){
		this(location, ParticleEffect.FLAME);
	}

	public Spiral(DynamicLocation location, ParticleEffect particle){
		this.location = location;
		this.particle = particle;
		this.yaw = location.getYaw();
	}


	@Override
	public void onRun() {
		if (!location.needsUpdate()) {
			vec = VectorMath.fromCylindricalCoordinates(radius, angle + yaw, height);
			angle = GenericMath.wrapAngleDeg(angle + angleStep);
			if (height > maxHeight || height < minHeight) {
				heightStep *= -1;
			}
			height += heightStep;
			particle.display(0, 0, 0, 0, 1, location.getLocation().add(vec), 32);
			particle.display(0, 0, 0, 0, 1, location.getLocation().add(-vec.getX(),vec.getY(), -vec.getZ()), 32);
		}
		else {
			location.update();
			yaw = location.getYaw();
			height = 0;
			heightStep = heightStep > 0 ? heightStep : -heightStep;
		}
	}
}
