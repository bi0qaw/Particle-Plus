package io.github.bi0qaw.particleplus.command;

import io.github.bi0qaw.particleplus.ParticlePlus;
import io.github.bi0qaw.particleplus.effect.Aura;
import io.github.bi0qaw.particleplus.effect.SinHalo;
import io.github.bi0qaw.particleplus.effect.ParticlePlusEffect;
import io.github.bi0qaw.particleplus.effect.Spiral;
import io.github.bi0qaw.particleplus.util.DynamicLocation;
import io.github.bi0qaw.particleplus.util.ParticleEffect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ParticlePlusCommand implements CommandExecutor {

	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
		commandSender.sendMessage("At your service!");
		if (args[0].equals("help")){
			commandSender.sendMessage("/pp plz");
		}
		else if (args[0].equals("plz")){
			commandSender.sendMessage("NO!");
		}
		else if (args[0].equals("show")){
			if (commandSender instanceof Player){
				Player p = ((Player) commandSender).getPlayer();
				if (args[1].equals("aura")){
					ParticlePlusEffect aura = new Aura(DynamicLocation.init(p));
					ParticlePlus.getManager().startEffect(aura);
				}
				else if(args[1].equals("halo")){
					ParticlePlusEffect halo = new SinHalo(DynamicLocation.init(p));
					ParticlePlus.getManager().startEffect(halo);
				}
				else if(args[1].equals("spiral")){
					ParticlePlusEffect spiral = new Spiral(DynamicLocation.init(p));
					ParticlePlus.getManager().startEffect(spiral);
				}

			}
		}
		else if (args[0].equals("hide")){
			ParticlePlus.getManager().stopAll();
		}
		return true;
	}
}
