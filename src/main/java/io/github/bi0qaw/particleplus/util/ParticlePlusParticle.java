package io.github.bi0qaw.particleplus.util;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.util.Vector;

import java.awt.*;

public class ParticlePlusParticle {

	public static final ParticleEffect DEF_PARTICLE = ParticleEffect.FLAME;
	public static final float DEF_OFFSET_X = 0;
	public static final float DEF_OFFSET_Y = 0;
	public static final float DEF_OFFSET_Z = 0;
	public static final float DEF_SPEED = 0;
	public static final int DEF_AMOUNT = 0;
	public static final Vector DEF_DIRECTION = VectorMath.UNIT_Y;
	public static final double DEF_RANGE = 32;
	public static final ParticleEffect.ItemData DEF_ITEM_DATA =  new ParticleEffect.ItemData(Material.AIR,(byte) 0);
	public static final ParticleEffect.BlockData DEF_BLOCK_DATA = new ParticleEffect.BlockData(Material.AIR,(byte) 0);
	public static final Color DEF_COLOR = Color.RED;

	private ParticleEffect particle = DEF_PARTICLE;
	private float offsetX = DEF_OFFSET_X;
	private float offsetY = DEF_OFFSET_Y;
	private float offsetZ = DEF_OFFSET_Z;
	private float speed = DEF_SPEED;
	private int amount = DEF_AMOUNT;
	private Vector direction = DEF_DIRECTION;
	private double range = DEF_RANGE;
	private ParticleEffect.ItemData itemData = DEF_ITEM_DATA;
	private ParticleEffect.BlockData blockData = DEF_BLOCK_DATA;
	private Color color = DEF_COLOR;

	public ParticlePlusParticle(){
	}

	public void display(Location location){
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public ParticleEffect.BlockData getBlockData() {
		return blockData;
	}

	public void setBlockData(ParticleEffect.BlockData blockData) {
		this.blockData = blockData;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Vector getDirection() {
		return direction;
	}

	public void setDirection(Vector direction) {
		this.direction = direction;
	}

	public ParticleEffect.ItemData getItemData() {
		return itemData;
	}

	public void setItemData(ParticleEffect.ItemData itemData) {
		this.itemData = itemData;
	}

	public float getOffsetX() {
		return offsetX;
	}

	public void setOffsetX(float offsetX) {
		this.offsetX = offsetX;
	}

	public float getOffsetY() {
		return offsetY;
	}

	public void setOffsetY(float offsetY) {
		this.offsetY = offsetY;
	}

	public float getOffsetZ() {
		return offsetZ;
	}

	public void setOffsetZ(float offsetZ) {
		this.offsetZ = offsetZ;
	}

	public ParticleEffect getParticle() {
		return particle;
	}

	public void setParticle(ParticleEffect particle) {
		this.particle = particle;
	}

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = range;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
}
