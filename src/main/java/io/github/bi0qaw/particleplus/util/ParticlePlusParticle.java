package io.github.bi0qaw.particleplus.util;

import org.bukkit.util.Vector;

import java.awt.*;

public class ParticlePlusParticle {

	public static final ParticleEffect DEF_PARTICLE = ParticleEffect.FLAME;
	public static final float DEF_OFFSET_X = 0;
	public static final float DEF_OFFSET_Y = 0;
	public static final float DEF_OFFSET_Z = 0;
	public static final float DEF_SPEED = 0;
	public static final int DEF_AMOUNT = 0;
	public static final Vector DEFAULT_DIRECTION = new Vector();
	public static final double DEF_RANGE = 0;



	ParticleEffect particle;
	float offsetX = 0;
	float offsetY = 0;
	float offsetZ = 0;
	float speed = 0;
	int amount = 1;

	Color color;

	public ParticlePlusParticle(){
	}


}
