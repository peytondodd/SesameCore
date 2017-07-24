package com.sesamepvp.essentials.commands.Locations.spawn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.kitpvp.configmanager.Manager;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Spawn implements CommandExecutor {
	Manager manager = Manager.getInstance();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("spawn")) {
			Player p = (Player) sender;
			if (args.length == 0) {
				Location spawnLocation = (Location) this.manager.getData().get("Spawn");
				if (spawnLocation == null) {
					p.sendMessage(Messages.prefix(Methods
							.format("&cWARNING: Spawn location is not defined, contact an administrator.")));
					return false;
				} else {

					p.teleport(spawnLocation);
				}
			} else {
				if (args.length == 1) {
					Player t = Bukkit.getServer().getPlayer(args[0]);
					if (t == null) {
						p.sendMessage(Messages.playerNull());
					} else {
						p.sendMessage(Messages.teleportedtargettoSpawn(t));
						t.sendMessage(Messages.teleportedtoSpawn());
						Location spawnLocation = (Location) this.manager.getData().get("Spawn");
						if (spawnLocation == null) {
							p.sendMessage(Messages.prefix(Methods
									.format("&cWARNING: Spawn location is not defined, contact an administrator.")));
							return false;
						} else {

							t.teleport(spawnLocation);
						}
					}

				} else {
					p.sendMessage(Messages.spawnUsage());
				}
			}
		}
		return true;
	}

}
