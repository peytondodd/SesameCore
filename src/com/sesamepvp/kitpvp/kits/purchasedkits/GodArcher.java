package com.sesamepvp.kitpvp.kits.purchasedkits;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.sesamepvp.kitpvp.config.Manager;
import com.sesamepvp.kitpvp.managers.KitListener;
import com.sesamepvp.utilites.Messages;

public class GodArcher implements Listener {

	Manager manager = Manager.getInstance();

	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();

		if (event.getInventory().getTitle().equals("Kits")) {

			if (event.getCurrentItem() == null) {
				return;
			}
			if (event.getCurrentItem().getType() == Material.ARROW) {

				if (KitListener.kitselected.contains(p)) {
					event.setCancelled(true);
					event.getWhoClicked().closeInventory();
					p.sendMessage(Messages.kitSelected());
					return;

				} else {
					boolean KitGodArcherOwned = this.manager.getData()
							.getBoolean(p.getName() + ".Kits.GodArcher");
					if (KitGodArcherOwned == true) {
						p.getActivePotionEffects().clear();
						p.getInventory().clear();
						KitListener.kitselected.add(p);
						event.getWhoClicked().closeInventory();
						Bukkit.getServer().dispatchCommand(
								Bukkit.getServer().getConsoleSender(),
								"kit GodArcher "
										+ event.getWhoClicked().getName());
						p.getInventory().setLeggings(
								new ItemStack(Material.GOLD_LEGGINGS));
						p.getInventory().setHelmet(
								new ItemStack(Material.LEATHER_HELMET));
						p.getInventory().setChestplate(
								new ItemStack(Material.IRON_CHESTPLATE));
						p.getInventory().setBoots(
								new ItemStack(Material.IRON_BOOTS));
						p.addPotionEffect(new PotionEffect(
								PotionEffectType.SPEED, 40000, 1));
						p.addPotionEffect(new PotionEffect(
								PotionEffectType.INCREASE_DAMAGE, 40000, 0));
					} else {
						if (KitGodArcherOwned == false) {
							event.setCancelled(true);
							p.sendMessage(Messages.kitnotOwned());
							return;

						}
					}
				}
			}
		}
	}

}
