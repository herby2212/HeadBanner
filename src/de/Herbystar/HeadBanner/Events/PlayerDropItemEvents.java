package de.Herbystar.HeadBanner.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import de.Herbystar.HeadBanner.Main;
import de.Herbystar.HeadBanner.Utilities.XMaterial;

public class PlayerDropItemEvents implements Listener {
	
	Main plugin;
	public PlayerDropItemEvents(Main main) {
		plugin = main;
	}
	
	@EventHandler
	public void PlayerDropItemEvent(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if(plugin.getConfig().getBoolean("HeadBanner.Enabled") == true) {
	    	if(plugin.getConfig().getStringList("HeadBanner.Worlds").contains(p.getWorld().getName())) {
				if(plugin.getConfig().getBoolean("HeadBanner.JoinItem.AntiDrop") == true) {
					if(e.getItemDrop().getItemStack().getType().equals(XMaterial.matchXMaterial("BANNER").get().parseMaterial())) {
						if(e.getItemDrop() != null) {
							if(e.getItemDrop().getItemStack().hasItemMeta() && e.getItemDrop().getItemStack().getItemMeta().getDisplayName() != null) {
								if(e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.JoinItem.Name")))) {
									e.setCancelled(true);
								}
							}
						}				
					}
				}
	    	}
		}
	}

}
