package de.Herbystar.HeadBanner.Events;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import de.Herbystar.HeadBanner.Main;

public class PlayerJoinEvents implements Listener {
	
	Main plugin;
	public PlayerJoinEvents(Main main) {
		plugin = main;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(plugin.getConfig().getBoolean("HeadBanner.Enabled") == true) {
			if(p.isOp()) {
				if(plugin.UpdateAviable == true) {
					p.sendMessage("§4[§aHeadBanner§4] §a-=> Update is available! <=-");
					p.sendMessage("§aDownload: §ehttp://herbystar.eu/resources/headbanner-1-8-1-12-with-gui.16/");
				}
			}
	    	if(plugin.getConfig().getStringList("HeadBanner.Worlds").contains(p.getWorld().getName())) {
				if(plugin.getConfig().getBoolean("HeadBanner.JoinItem.GiveOnJoin") == true) {
					if(p.hasPermission("HeadBanner.Item.Join") | p.isOp()) {
						ItemStack HB = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
					    SkullMeta HBM = (SkullMeta)Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
					    try {
						    HBM.setOwningPlayer(p);
					    } catch(NoSuchMethodError ex) {
					    	HBM.setOwner(p.getDisplayName());
					    }
					    HBM.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.JoinItem.Name")));
					    HBM.setLore(Arrays.asList(plugin.replaceString(plugin.replaceString(plugin.getConfig().getString("HeadBanner.JoinItem.Lore")))));
					    HB.setItemMeta(HBM);
						
					    //Gucken ob der Slot bereits besetzt ist
					    if(p.getInventory().getItem(plugin.getConfig().getInt("HeadBanner.JoinItem.Slot(0-8)")) == null) {
							p.getInventory().setItem(plugin.getConfig().getInt("HeadBanner.JoinItem.Slot(0-8)"), HB);
					    } else {
					    	p.getInventory().addItem(HB);
					    }
					}
				} else {			
					ItemStack HB = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
				    SkullMeta HBM = (SkullMeta)Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
				    HBM.setOwningPlayer(p);
				    HBM.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.JoinItem.Name")));
				    HBM.setLore(Arrays.asList(plugin.replaceString(plugin.getConfig().getString("HeadBanner.JoinItem.Lore"))));
				    HB.setItemMeta(HBM);
				    if(p.getInventory().contains(HB.getType())) {
				    	p.getInventory().remove(HB.getType());
				    	p.updateInventory();
				    }   
				}
	    	}
		}
	}

}
