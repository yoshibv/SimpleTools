package es.yoshibv.SimpleTools;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LightningCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
			
		if (args.length > 0) {
			if (player.hasPermission("SimpleTools.rayo")) {
				Player victim = Bukkit.getServer().getPlayer(args[0]);
				Integer lightningTimes = Integer.valueOf(args[1]);
				for (int i = 0; i < lightningTimes; i++) {
					victim.getPlayer().getWorld().strikeLightning(victim.getPlayer().getLocation());

					try {
						  Thread.sleep(150);
						} catch (InterruptedException e) {
						  Thread.currentThread().interrupt();
						}
					}	
				}
			} else {
				player.sendMessage("§7Necesitas especificar un §ajugador §7a quien tirarle el rayo");
			}
		
		return true;
	}
}

