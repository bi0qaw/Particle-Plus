package io.github.bi0qaw.particleplus.util;

import java.awt.Color;

public class Rainbow {

	private float[] hsb = new float[3];
	private float stepHue;
	private float stepSaturation;
	private float stepBrightness;
	private boolean changeHue = true;
	private boolean changeSaturation = false;
	private boolean changeBrightness = false;

	public Rainbow(Color color, float stepHue) {
		this(color, stepHue, 0F, 0F);
	}

	public Rainbow(Color color, float stepHue, float stepSaturation, float stepBrightness) {
		Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), this.hsb);
		this.stepHue = stepHue;
		this.stepSaturation = stepSaturation;
		this.stepBrightness = stepBrightness;
	}

	public Rainbow(float hue, float stepHue){
		this(hue, 0.999F, 0.999F, stepHue, 0F, 0F);
	}

	public Rainbow(float hue, float saturation, float brightness, float stepHue, float stepSaturation, float stepBrightness) {
		this.setHue(hue);
		this.setSaturation(saturation);
		this.setBrightness(brightness);
		this.stepHue = stepHue;
		this.stepSaturation = stepSaturation;
		this.stepBrightness = stepBrightness;
	}

	public Color getColor() {
		return new Color(Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]));
	}

	public Color nextColor() {
		if (changeHue) {
			setHue(hsb[0] + stepHue);
		}
		if (changeSaturation) {
			setSaturation(hsb[1] + stepSaturation);
		}
		if (changeBrightness){
			setBrightness(hsb[2] + stepBrightness);
		}
		return getColor();
	}

	public float getHue() {
		return hsb[0];
	}
	public float getSaturation() {
		return hsb[1];
	}
	public float getBrightness() {
		return hsb[2];
	}
	public float getHueStep() {
		return stepHue;
	}
	public float getSaturationStep() {
		return stepSaturation;
	}
	public float getBrightnessStep() {
		return stepBrightness;
	}
	public void setHue(float hue)	 {
		this.hsb[0] = hue - (float) Math.floor(hue);
	}
	public void setSaturation(float saturation)	{
		this.hsb[1] = saturation - (float) Math.floor(saturation);
	}
	public void setBrightness(float brightness) {
		this.hsb[2] = brightness - (float) Math.floor(brightness);
	}
	public void setHueStep(float stepHue) {
		this.stepHue = stepHue;
	}
	public void setSaturationStep(float stepSaturation) {
		this.stepSaturation = stepSaturation;
	}
	public void setBrightnessStep(float stepValue) {
		this.stepBrightness = stepValue;
	}

	public boolean isChangeBrightness() {
		return changeBrightness;
	}

	public void setChangeBrightness(boolean changeBrightness) {
		this.changeBrightness = changeBrightness;
	}

	public boolean isChangeHue() {
		return changeHue;
	}

	public void setChangeHue(boolean changeHue) {
		this.changeHue = changeHue;
	}

	public boolean isChangeSaturation() {
		return changeSaturation;
	}

	public void setChangeSaturation(boolean changeSaturation) {
		this.changeSaturation = changeSaturation;
	}

	public float[] getHsb() {
		return hsb;
	}

	public void setHsb(float[] hsb) {
		this.hsb = hsb;
	}

	public float getStepBrightness() {
		return stepBrightness;
	}

	public void setStepBrightness(float stepBrightness) {
		this.stepBrightness = stepBrightness;
	}

	public float getStepHue() {
		return stepHue;
	}

	public void setStepHue(float stepHue) {
		this.stepHue = stepHue;
	}

	public float getStepSaturation() {
		return stepSaturation;
	}

	public void setStepSaturation(float stepSaturation) {
		this.stepSaturation = stepSaturation;
	}
}
