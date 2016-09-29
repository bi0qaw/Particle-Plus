package io.github.bi0qaw.particleplus.util;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

public class DynamicLocation extends Location {

	private Entity entity = null;
	private boolean dynamic = false;
	private float epsilon = 0.05F;
	private float epsilonSquared = epsilon*epsilon;

	public DynamicLocation(Location location){
		super(location.getWorld(), location.getX(), location.getY(), location.getZ());
	}

	public DynamicLocation(Entity entity) {
		super(entity.getWorld(), entity.getLocation().getX(), entity.getLocation().getY(), entity.getLocation().getZ(), entity.getLocation().getYaw(), entity.getLocation().getPitch());
		this.entity = entity;
		this.dynamic = true;
	}

	public DynamicLocation update(){
		if (dynamic) {
			this.setX(entity.getLocation().getX());
			this.setY(entity.getLocation().getY());
			this.setZ(entity.getLocation().getZ());
			this.setYaw(entity.getLocation().getYaw());
			this.setPitch(entity.getLocation().getPitch());
		}
		return this;
	}

	public boolean needsUpdate() {
		return dynamic && this.distanceSquared(entity.getLocation()) > epsilonSquared;
	}

	public boolean needsUpdate(long ticks) {
		return dynamic && this.distanceSquared(entity.getLocation()) > epsilonSquared / (ticks > 0 ? ticks : 1);
	}

	public boolean hasMoved() {
		return needsUpdate();
	}

	public boolean hasMoved(long ticks) {
		return needsUpdate(ticks);
	}

	public boolean isDynamic() {
		return dynamic;
	}

	public float getEpsilon() {
		return epsilon;
	}

	public void setEpsilon(float epsilon) {
		this.epsilon = epsilon;
		this.epsilonSquared = epsilon * epsilon;
	}

	public Entity getEntity() {
		return entity;
	}

	public Vector getVector() {
		return new Vector(this.getX(), this.getY(), this.getZ());
	}

	public Location getLocation() {
		return new Location(this.getWorld(), this.getX(), this.getY(), this.getZ());
	}

	/**
	 * Gets the displacement vector between the location and the
	 * entity's location divided by the time interval.
	 */
	public Vector getDisplacement(long pulseTick) {
		if (dynamic) {
			Vector displacement = this.getEntity().getLocation().toVector();
			displacement = displacement.add(this.getVector().multiply(-1)).multiply(1D / (pulseTick > 0 ? pulseTick : 1));
			return displacement;
		} else return new Vector();
	}

	public static DynamicLocation init(Object center) {
		if (center instanceof Entity) {
			return new DynamicLocation((Entity) center);
		}
		else if (center instanceof Location) {
			return new DynamicLocation((Location) center);
		}
		else {
			throw new IllegalArgumentException("The object is not of type Entity or Location");
		}
	}


}
