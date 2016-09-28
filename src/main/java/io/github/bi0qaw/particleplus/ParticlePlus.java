package io.github.bi0qaw.particleplus;

import io.github.bi0qaw.particleplus.command.ParticlePlusCommand;
import io.github.bi0qaw.particleplus.effect.Aura;
import io.github.bi0qaw.particleplus.effect.EffectManager;
import io.github.bi0qaw.particleplus.effect.ParticlePlusEffect;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ParticlePlus extends JavaPlugin {

	private static ParticlePlus instance;
	public static ParticlePlus particlePlus;
	private static EffectManager effectManager;

	public ParticlePlus() {
		instance = this;
	}

	@Override
	public void onEnable() {
		particlePlus = this;
		effectManager = new EffectManager();
		this.getCommand("particleplus").setExecutor(new ParticlePlusCommand());
		Bukkit.getServer().getLogger().info("[ParticlePlus] Plugin has been Enabled");
	}

	@Override
	public void onDisable() {
		Bukkit.getServer().getLogger().info("[ParticlePlus] Plugin has been Disabled");
	}

	public static ParticlePlus getInstance() {
		return instance;
	}

	public static EffectManager getManager() {
		return effectManager;
	}

}


