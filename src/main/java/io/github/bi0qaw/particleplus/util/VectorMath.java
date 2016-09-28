package io.github.bi0qaw.particleplus.util;

import org.bukkit.util.Vector;


public class VectorMath {

	public static final Vector UNIT_X = new Vector(1,0,0);
	public static final Vector UNIT_Y = new Vector(0,1,0);
	public static final Vector UNIT_Z = new Vector(0,0,1);
	public static final Vector UNIT_XZ = new Vector(1,0,1).normalize();


	private VectorMath() {
	}

	public static Vector fromSphericalCoordinates(double radius, double theta, double phi) {
		double r = Math.abs(radius);
		double t = GenericMath.wrapAngleRad(theta * TrigMath.DEG_TO_RAD);
		double p = GenericMath.wrapAngleRad(phi * TrigMath.DEG_TO_RAD);
		double x = r * TrigMath.sin(t) * TrigMath.cos(p);
		double z = r * TrigMath.sin(t) * TrigMath.sin(p);
		double y = r * TrigMath.cos(t);
		return new Vector(x, y, z);
	}

	public static Vector fromCylindricalCoordinates(double radius, double phi, double height) {
		double r = Math.abs(radius);
		double p = GenericMath.wrapAngleRad(phi * TrigMath.DEG_TO_RAD);
		double x = r * TrigMath.cos(p);
		double z = r * TrigMath.sin(p);
		return new Vector(x, height, z);

	}

	public static Vector fromPitchAndYaw(float pitch, float yaw) {
		double y = TrigMath.sin(pitch);
		double div = TrigMath.cos(pitch);
		double x = TrigMath.cos(yaw);
		double z = TrigMath.sin(yaw);
		return new Vector(x,0,z).multiply(div).setY(y);
	}

	public static float getYaw(Vector vector) {
		return (float) (TrigMath.atan2(vector.getZ(), vector.getX()) * TrigMath.RAD_TO_DEG);
	}

	public static float getPitch(Vector vector) {
		double xy = GenericMath.sqrt(vector.getX() * vector.getX() + vector.getZ() * vector.getZ());
		return (float) (TrigMath.atan(vector.getY() / xy) * TrigMath.RAD_TO_DEG);
	}

	public static Vector setYaw(Vector vector, float yaw) {
		vector = fromPitchAndYaw(getPitch(vector), yaw);
		return vector;
	}

	public static Vector setPitch(Vector vector, float pitch) {
		vector = fromPitchAndYaw(pitch, getYaw(vector));
		return vector;
	}

	public static Vector rotX(Vector vector, double angle) {
		double sin = TrigMath.sin(GenericMath.wrapAngleRad(angle * TrigMath.DEG_TO_RAD));
		double cos = TrigMath.cos(GenericMath.wrapAngleRad(angle * TrigMath.DEG_TO_RAD));
		Vector vy = new Vector(0, cos, -sin);
		Vector vz = new Vector(0, sin, cos);
		vector.setY(vector.dot(vy));
		vector.setZ(vector.dot(vz));
		return vector;
	}

	public static Vector rotY(Vector vector, double angle) {
		double sin = TrigMath.sin(GenericMath.wrapAngleRad(angle * TrigMath.DEG_TO_RAD));
		double cos = TrigMath.cos(GenericMath.wrapAngleRad(angle * TrigMath.DEG_TO_RAD));
		Vector vx = new Vector(cos, 0, sin);
		Vector vz = new Vector(-sin, 0, cos);
		vector.setX(vector.dot(vx));
		vector.setZ(vector.dot(vz));
		return vector;
	}

	public static Vector rotZ(Vector vector, double angle) {
		double sin = TrigMath.sin(GenericMath.wrapAngleRad(angle * TrigMath.DEG_TO_RAD));
		double cos = TrigMath.cos(GenericMath.wrapAngleRad(angle * TrigMath.DEG_TO_RAD));
		Vector vx = new Vector(cos, -sin, 0);
		Vector vy = new Vector(sin, cos, 0);
		vector.setX(vector.dot(vx));
		vector.setY(vector.dot(vy));
		return vector;
	}

	public static Vector rot(Vector vector, Vector axis, double angle) {
		double sin = TrigMath.sin(GenericMath.wrapAngleRad(angle * TrigMath.DEG_TO_RAD));
		double cos = TrigMath.cos(GenericMath.wrapAngleRad(angle * TrigMath.DEG_TO_RAD));
		Vector a = axis.clone().normalize();
		double ax = a.getX();
		double ay = a.getY();
		double az = a.getZ();
		Vector rotx = new Vector(cos+ax*ax*(1-cos), ax*ay*(1-cos)-az*sin, ax*az*(1-cos)+ay*sin);
		Vector roty = new Vector(ay*ax*(1-cos)+az*sin, cos+ay*ay*(1-cos), ay*az*(1-cos)-ax*sin);
		Vector rotz = new Vector(az*ax*(1-cos)-ay*sin, az*ay*(1-cos)+ax*sin, cos+az*az*(1-cos));
		double x = rotx.dot(vector);
		double y = roty.dot(vector);
		double z = rotz.dot(vector);
		vector.setX(x).setY(y).setZ(z);
		return vector;
	}

}