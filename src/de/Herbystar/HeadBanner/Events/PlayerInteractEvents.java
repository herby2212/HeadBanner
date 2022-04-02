package de.Herbystar.HeadBanner.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import de.Herbystar.HeadBanner.Main;
import de.Herbystar.HeadBanner.Utilities.ItemHandler;
import de.Herbystar.HeadBanner.Utilities.XMaterial;

public class PlayerInteractEvents implements Listener {
	
	Main plugin;
	public PlayerInteractEvents(Main main) {
		plugin = main;
	}
	
	@EventHandler
	public void onHBII(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(plugin.getConfig().getBoolean("HeadBanner.Enabled") == true) {
	    	if(plugin.getConfig().getStringList("HeadBanner.Worlds").contains(p.getWorld().getName())) {
				if((((e.getAction() == Action.RIGHT_CLICK_AIR ? 1 : 0) | (e.getAction() == Action.RIGHT_CLICK_BLOCK ? 1 : 0)) != 0)) {
					if(e.getItem() != null) {
						if(e.getMaterial().equals(XMaterial.PLAYER_HEAD.parseMaterial())) {
							if(e.getItem().hasItemMeta() && e.getItem().getItemMeta().getDisplayName() != null) {
								if(e.getItem().hasItemMeta() && e.getItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.JoinItem.Name").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
									e.setCancelled(true);
									if(p.hasPermission("HeadBanner.Item.Open") | p.isOp()) {
										p.openInventory(ItemHandler.getInventoryPageOne());
									}
								}
							}
						}
					}			
				}
	    	}
		}
	}

}
