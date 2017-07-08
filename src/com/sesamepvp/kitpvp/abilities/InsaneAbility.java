package com.sesamepvp.kitpvp.abilities;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class InsaneAbility implements Listener{

	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity();
		Player k = p.getKiller();
		
		if(k.getItemInHand().getType() == Material.DIAMOND_SWORD){
			if(k.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED+"Insane")){
				PotionEffect potionEffect = new PotionEffect(PotionEffectType.SPEED, 200, 1);
				PotionEffect potionEffect2 = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 1);
				PotionEffect potionEffect3 = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200,1);
				potionEffect.apply(k); 
				potionEffect2.apply(k);
				potionEffect3.apply(k);
			}
		}
	}
	
}
