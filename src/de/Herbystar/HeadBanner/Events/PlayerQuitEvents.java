package de.Herbystar.HeadBanner.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import de.Herbystar.HeadBanner.Main;
import de.Herbystar.HeadBanner.Utilities.ItemHandler;
import de.Herbystar.HeadBanner.Utilities.XMaterial;

public class PlayerQuitEvents implements Listener {
	
	Main plugin;
	public PlayerQuitEvents(Main main) {
		plugin = main;
	}
	
	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if(plugin.getConfig().getBoolean("HeadBanner.Enabled") == true) {
	    	if(plugin.getConfig().getStringList("HeadBanner.Worlds").contains(p.getWorld().getName())) {
				if(p.getInventory().getHelmet() != null) {
					if(p.getInventory().getHelmet().getType().equals(XMaterial.matchXMaterial("BANNER").get().parseMaterial())) {
						if(p.getInventory().getHelmet().hasItemMeta()) {
							if(plugin.getConfig().getBoolean("HeadBanner.ClearBannerOnLeave") == true) {
								p.getInventory().setHelmet(null);
							}
						}
					}
				}
	    	}
	    	//false = to trigger check and removement of item if present
	    	ItemHandler.createJoinItem(p, false);
	    	/*
			ItemStack HB = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		    SkullMeta HBM = (SkullMeta)Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
		    try {
			    HBM.setOwningPlayer(p);
		    } catch(NoSuchMethodError ex) {
		    	HBM.setOwner(p.getDisplayName());
		    }
		    HBM.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.JoinItem.Name")));
		    HBM.setLore(Arrays.asList(plugin.replaceString(plugin.getConfig().getString("HeadBanner.JoinItem.Lore"))));
		    HB.setItemMeta(HBM);
		    
		    if(p.getInventory().contains(HB.getType())) {
		    	p.getInventory().remove(HB.getType());
		    	p.updateInventory();
		    } 
		    */    	
		}			
	}

}
