package com.sesamepvp.essentials.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.sesamepvp.essentials.commands.List;

public class ListListener implements Listener{
		
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		if(List.onlinestaff.contains(e.getPlayer().getName())){
			List.onlinestaff.remove(e.getPlayer().getName());
		}
		if(List.playercount.contains(e.getPlayer().getName())){
			List.playercount.remove(e.getPlayer().getName());
		}
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		List.playercount.add(p.getName());
		if(p.hasPermission("core.stafflist") || p.isOp()){
			List.onlinestaff.add(p.getName());
		}else{
			return;
		}
	}
}
