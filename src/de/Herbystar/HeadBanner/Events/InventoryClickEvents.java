package de.Herbystar.HeadBanner.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.Herbystar.HeadBanner.Main;
import de.Herbystar.HeadBanner.Utilities.XMaterial;

public class InventoryClickEvents implements Listener {
	
	Main plugin;
	public InventoryClickEvents(Main main) {
		plugin = main;
	}
	
	//AntiItemMove JoinItem / Banner (Head)
	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if(plugin.getConfig().getBoolean("HeadBanner.Enabled") == true) {
	    	if(plugin.getConfig().getStringList("HeadBanner.Worlds").contains(p.getWorld().getName())) {
				if(plugin.getConfig().getBoolean("HeadBanner.JoinItem.AntiMove") == true) {
					if(e.getCurrentItem() != null) {
						if(e.getCurrentItem().getType().equals(XMaterial.PLAYER_HEAD.parseMaterial())) {
							if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.JoinItem.Name")))) {
								e.setCancelled(true);
							}
						}
					}
				}
				if(plugin.getConfig().getBoolean("HeadBanner.HeadSlotLock") == true) {
					if(e.getCurrentItem() != null) {
						if(e.getCurrentItem().getType().toString().contains("BANNER")) {
							if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.1")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.2")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.3")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.4")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.5")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.6")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.7")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.8")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.9")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.10")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.11")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.12")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.13")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.14")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.15")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.16")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.17")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.18")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.19")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.20")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.21")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.22")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.23")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.24")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.25")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.26")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.27")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.28")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.29")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.30")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.31")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.32")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.33")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.34")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.35")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.36")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.37")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.38")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.39")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.40")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.41")))) {
									e.setCancelled(true);
								}
								if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.42")))) {
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
