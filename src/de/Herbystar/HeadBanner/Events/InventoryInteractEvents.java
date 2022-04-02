package de.Herbystar.HeadBanner.Events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.Herbystar.HeadBanner.Main;
import de.Herbystar.HeadBanner.Utilities.ItemHandler;

public class InventoryInteractEvents implements Listener {
	
	Main plugin;
	public InventoryInteractEvents(Main main) {
		plugin = main;
	}
	
	@SuppressWarnings("deprecation")
	private String getInventoryName(InventoryClickEvent e) {
		try {
			return e.getView().getTitle();
		} catch(Exception ex) {
			return e.getInventory().getName();
		}
	}
	
	public void checkEffect(int bannerNumber, Player p) {
		if(bannerNumber != 0) {
			//HeadBanner.BannerEffect.NUMBER.Effect/Duration/Amplifier
			String effect = plugin.getConfig().getString("HeadBanner.BannerEffect." + Integer.toString(bannerNumber) + "." + "Effect");
			String duration_path = "HeadBanner.BannerEffect." + Integer.toString(bannerNumber) + "." + "Duration"; 
			String amplifier_path = "HeadBanner.BannerEffect." + Integer.toString(bannerNumber) + "." + "Amplifier";
			int duration = plugin.getConfig().getInt(duration_path);
			int amplifier = plugin.getConfig().getInt(amplifier_path);
			if(!effect.equalsIgnoreCase("NONE") && duration != 0) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(effect.toUpperCase()), duration, amplifier));
			}
		}
	}
	
	@EventHandler
	public void OnBannerMenuInvInteract(InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if(getInventoryName(e).equals(plugin.getConfig().getString("HeadBanner.BannerInventory.Side1Title").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null && e.getCurrentItem().getType().toString().contains("BANNER")) {
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.1").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.1")) {
						if(!plugin.B1.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B1").item);
							checkEffect(1, p);
							Main.instance.addToBannerList(p, plugin.B1, 1);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}		
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.2").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.2")) {
						if(!plugin.B2.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B2").item);
							checkEffect(2, p);
							Main.instance.addToBannerList(p, plugin.B2, 1);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.3").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.3")) {
						if(!plugin.B3.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B3").item);
							checkEffect(3, p);
							Main.instance.addToBannerList(p, plugin.B3, 1);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}	
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.4").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.4")) {
						if(!plugin.B4.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B4").item);
							checkEffect(4, p);
							Main.instance.addToBannerList(p, plugin.B4, 1);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}			
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.5").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.5")) {
						if(!plugin.B5.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B5").item);
							checkEffect(5, p);
							Main.instance.addToBannerList(p, plugin.B5, 1);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}	
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.6").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.6")) {
						if(!plugin.B6.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B6").item);
							checkEffect(6, p);
							Main.instance.addToBannerList(p, plugin.B6, 1);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}	
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}		
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.7").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.7")) {
						if(!plugin.B7.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B7").item);
							checkEffect(7, p);
							Main.instance.addToBannerList(p, plugin.B7, 1);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}	
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}	
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.8").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.8")) {
						if(!plugin.B8.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B8").item);
							checkEffect(8, p);
							Main.instance.addToBannerList(p, plugin.B8, 1);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}			
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.9").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.9")) {
						if(!plugin.B9.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B9").item);
							checkEffect(9, p);
							Main.instance.addToBannerList(p, plugin.B9, 1);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}				
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.10").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.10")) {
						if(!plugin.B10.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B10").item);
							checkEffect(10, p);
							Main.instance.addToBannerList(p, plugin.B10, 1);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.11").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.11")) {
						if(!plugin.B11.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B11").item);
							checkEffect(11, p);
							Main.instance.addToBannerList(p, plugin.B11, 1);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.12").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.12")) {
						if(!plugin.B12.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B12").item);
							checkEffect(12, p);
							Main.instance.addToBannerList(p, plugin.B12, 1);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.13").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.13")) {
						if(!plugin.B13.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B13").item);
							checkEffect(13, p);
							Main.instance.addToBannerList(p, plugin.B13, 1);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.14").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.14")) {
						if(!plugin.B14.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B14").item);
							checkEffect(14, p);
							Main.instance.addToBannerList(p, plugin.B14, 1);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}
				}
			}
			if(e.getCurrentItem().getType().equals(Material.BARRIER) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.GUI.ClearHeadItemName").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä")))) {
				if(!(p.getInventory().getHelmet() == null)) {
					Bukkit.getScheduler().cancelTask(plugin.rotateid);
					plugin.RB.remove(p.getName());
					p.getInventory().setHelmet(null);
					p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerClearMessage.Message").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
					plugin.B1.remove(p);
					plugin.B2.remove(p);
					plugin.B3.remove(p);
					plugin.B4.remove(p);
					plugin.B5.remove(p);
					plugin.B6.remove(p);
					plugin.B7.remove(p);
					plugin.B8.remove(p);
					plugin.B9.remove(p);
					plugin.B10.remove(p);
					plugin.B11.remove(p);
					plugin.B12.remove(p);
					plugin.B13.remove(p);
					plugin.B14.remove(p);
					
					plugin.BP1.remove(p);
					plugin.BP2.remove(p);
					plugin.BP3.remove(p);
					plugin.BP4.remove(p);
					plugin.BP5.remove(p);
					plugin.BP6.remove(p);
					plugin.BP7.remove(p);
					plugin.BP8.remove(p);
					plugin.BP9.remove(p);
					plugin.BP10.remove(p);
					plugin.BP11.remove(p);
					plugin.BP12.remove(p);
					plugin.BP13.remove(p);
					plugin.BP14.remove(p);
					
					plugin.BA1.remove(p);
					plugin.BA2.remove(p);
					plugin.BA3.remove(p);
					plugin.BA4.remove(p);
					plugin.BA5.remove(p);
					plugin.BA6.remove(p);
					plugin.BA7.remove(p);
					plugin.BA8.remove(p);
					plugin.BA9.remove(p);
					plugin.BA10.remove(p);
					plugin.BA11.remove(p);
					plugin.BA12.remove(p);
					plugin.BA13.remove(p);
					plugin.BA14.remove(p);
					
				} else {
					p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerClearMessage.NoHeadMessage").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				}
			}
			if(e.getCurrentItem().getType().equals(Material.SLIME_BALL) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.GUI.CloseItemName").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä")))) {
				p.closeInventory();
			}
			
			if(e.getCurrentItem().getType().equals(Material.MAGMA_CREAM) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.GUI.NextSide").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä")))) {
				p.openInventory(ItemHandler.getInventoryPageTwo());														
			}	
			
			if(e.getCurrentItem().getType().equals(Material.ARMOR_STAND) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.GUI.RotateItemName").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä")))) {
				if(p.hasPermission("HeadBanner.Rotate")) {
					if(!plugin.RB.contains(p.getName())) {
						plugin.RB.add(p.getName());
						plugin.rotateid = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

							@Override
							public void run() {
								plugin.rotate -= 1;
																
								if(plugin.rotate == 14) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B1").item);
								}						
								if(plugin.rotate == 13) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B2").item);
								}
								if(plugin.rotate == 12) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B3").item);
								}
								if(plugin.rotate == 11) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B4").item);	
								}
								if(plugin.rotate == 10) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B5").item);
								}
								if(plugin.rotate == 9) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B6").item);
								}
								if(plugin.rotate == 8) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B7").item);
								}
								if(plugin.rotate == 7) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B8").item);
								}
								if(plugin.rotate == 6) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B9").item);
								}
								if(plugin.rotate == 5) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B10").item);
								}
								if(plugin.rotate == 4) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B11").item);	
								}
								if(plugin.rotate == 3) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B12").item);	
								}
								if(plugin.rotate == 2) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B13").item);	
								}
								if(plugin.rotate == 1) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("B14").item);
								}
								if(plugin.rotate == 0) {
									plugin.rotate = 14; 
								}
							}					
						}
						, 0, 20L);
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.RotateEnabled").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
						p.closeInventory();
					} else {
						if(p.getInventory().getHelmet() != null) {
							if(p.getInventory().getHelmet().getType().toString().contains("BANNER")) {
								p.getInventory().setHelmet(null);
							}
						}
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.RotateDisabled").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
						Bukkit.getScheduler().cancelTask(plugin.rotateid);
						plugin.RB.remove(p.getName());
						plugin.rotate = 15;
						p.closeInventory();
					}			
				} else {
					p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				}
			}
			
		}				
	}
	
	@EventHandler
	public void OnBannerMenuInv2Interact(InventoryClickEvent e) {		
		final Player p = (Player) e.getWhoClicked();
		if(getInventoryName(e).equals(plugin.getConfig().getString("HeadBanner.BannerInventory.Side2Title").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null && e.getCurrentItem().getType().toString().contains("BANNER")) {
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.15").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.15")) {
						if(!plugin.BP1.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP1").item);
							checkEffect(15, p);
							Main.instance.addToBannerList(p, plugin.BP1, 2);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}		
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.16").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.16")) {
						if(!plugin.BP2.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP2").item);
							checkEffect(16, p);
							Main.instance.addToBannerList(p, plugin.BP2, 2);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}	
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.17").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.17")) {
						if(!plugin.BP3.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP3").item);
							checkEffect(17, p);
							Main.instance.addToBannerList(p, plugin.BP3, 2);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}		
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.18").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.18")) {
						if(!plugin.BP4.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP4").item);
							checkEffect(18, p);
							Main.instance.addToBannerList(p, plugin.BP4, 2);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}	
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.19").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.19")) {
						if(!plugin.BP5.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP5").item);
							checkEffect(19, p);
							Main.instance.addToBannerList(p, plugin.BP5, 2);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}		
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.20").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.20")) {
						if(!plugin.BP6.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP6").item);
							checkEffect(20, p);
							Main.instance.addToBannerList(p, plugin.BP6, 2);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}		
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.21").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.21")) {
						if(!plugin.BP7.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP7").item);
							checkEffect(21, p);
							Main.instance.addToBannerList(p, plugin.BP7, 2);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}		
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.22").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.22")) {
						if(!plugin.BP8.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP8").item);
							checkEffect(22, p);
							Main.instance.addToBannerList(p, plugin.BP8, 2);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}		
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.23").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.23")) {
						if(!plugin.BP9.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP9").item);
							checkEffect(23, p);
							Main.instance.addToBannerList(p, plugin.BP9, 2);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}	
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.24").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.24")) {
						if(!plugin.BP10.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP10").item);
							checkEffect(24, p);
							Main.instance.addToBannerList(p, plugin.BP10, 2);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}		
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.25").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.25")) {
						if(!plugin.BP11.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP11").item);
							checkEffect(25, p);
							Main.instance.addToBannerList(p, plugin.BP11, 2);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}	
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.26").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.26")) {
						if(!plugin.BP12.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP12").item);
							checkEffect(26, p);
							Main.instance.addToBannerList(p, plugin.BP12, 2);
							plugin.BP14.remove(p);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}		
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.27").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.27")) {
						if(!plugin.BP13.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP13").item);
							checkEffect(27, p);
							Main.instance.addToBannerList(p, plugin.BP13, 2);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}	
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.28").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.28")) {
						if(!plugin.BP14.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP14").item);
							checkEffect(28, p);
							Main.instance.addToBannerList(p, plugin.BP14, 2);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}	
				}
			}
			if(e.getCurrentItem().getType().equals(Material.SLIME_BALL) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.GUI.CloseItemName").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä")))) {
				p.closeInventory();
			}
			if(e.getCurrentItem().getType().equals(Material.MAGMA_CREAM) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.GUI.BackSide").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä")))) {
				p.openInventory(plugin.inv);
			}
			if(e.getCurrentItem().getType().equals(Material.ARMOR_STAND) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.GUI.RotateItemName").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä")))) {
				if(p.hasPermission("HeadBanner.Rotate")) {
					if(!plugin.RB.contains(p.getName())) {
						plugin.RB.add(p.getName());
						plugin.rotateid = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

							@Override
							public void run() {
								plugin.rotate -= 1;
																
								if(plugin.rotate == 14) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP1").item);
								}						
								if(plugin.rotate == 13) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP2").item);						
								}
								if(plugin.rotate == 12) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP3").item);
								}
								if(plugin.rotate == 11) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP4").item);	
								}
								if(plugin.rotate == 10) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP5").item);	
								}
								if(plugin.rotate == 9) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP6").item);
								}
								if(plugin.rotate == 8) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP7").item);
								}
								if(plugin.rotate == 7) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP8").item);
								}
								if(plugin.rotate == 6) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP9").item);
								}
								if(plugin.rotate == 5) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP10").item);
								}
								if(plugin.rotate == 4) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP11").item);	
								}
								if(plugin.rotate == 3) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP12").item);
								}
								if(plugin.rotate == 2) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP13").item);	
								}
								if(plugin.rotate == 1) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BP14").item);
								}
								if(plugin.rotate == 0) {
									plugin.rotate = 14; 
								}
							}					
						}
						, 0, 20L);
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.RotateEnabled").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
						p.closeInventory();
					} else {
						if(p.getInventory().getHelmet() != null) {
							if(p.getInventory().getHelmet().getType().toString().contains("BANNER")) {
								p.getInventory().setHelmet(null);
							}
						}
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.RotateDisabled").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
						Bukkit.getScheduler().cancelTask(plugin.rotateid);
						plugin.RB.remove(p.getName());
						plugin.rotate = 15;
						p.closeInventory();
					}			
				} else {
					p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				}
			}
			
			if(e.getCurrentItem().getType().equals(Material.MAGMA_CREAM) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.GUI.NextSide").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä")))) {				
				p.openInventory(ItemHandler.getInventoryPageThree());
			}
			
		}
		
	}
	
		
	@EventHandler
	public void OnBannerMenuInv3Interact(InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if(getInventoryName(e).equals(plugin.getConfig().getString("HeadBanner.BannerInventory.Side3Title").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null && e.getCurrentItem().getType().toString().contains("BANNER")) {
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.29").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.29")) {
						if(!plugin.BA1.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BA1").item);
							checkEffect(29, p);
							Main.instance.addToBannerList(p, plugin.BA1, 3);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.30").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.30")) {
						if(!plugin.BA2.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BA2").item);
							checkEffect(30, p);
							Main.instance.addToBannerList(p, plugin.BA2, 3);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.31").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.31")) {
						if(!plugin.BA3.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BA3").item);
							checkEffect(31, p);
							Main.instance.addToBannerList(p, plugin.BA3, 3);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.32").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.32")) {
						if(!plugin.BA4.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BA4").item);
							checkEffect(32, p);
							Main.instance.addToBannerList(p, plugin.BA4, 3);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.33").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.33")) {
						if(!plugin.BA5.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BA5").item);
							checkEffect(33, p);
							Main.instance.addToBannerList(p, plugin.BA5, 3);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.34").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.34")) {
						if(!plugin.BA6.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BA6").item);
							checkEffect(34, p);
							Main.instance.addToBannerList(p, plugin.BA6, 3);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.35").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.35")) {
						if(!plugin.BA7.contains(p)) {
							p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BA7").item);
							checkEffect(35, p);
							Main.instance.addToBannerList(p, plugin.BA7, 3);
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						} else {
							p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", e.getCurrentItem().getItemMeta().getDisplayName()));
						}
					} else {
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
					}
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.36").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.37").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.38").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.39").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.40").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.41").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					
				}
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.42").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					
				}
			}
			if(e.getCurrentItem().getType().equals(Material.SLIME_BALL) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.GUI.CloseItemName").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä")))) {
				p.closeInventory();
			}
			if(e.getCurrentItem().getType().equals(Material.MAGMA_CREAM) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.GUI.BackSide").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä")))) {
				p.openInventory(plugin.inv2);
			}
			if(e.getCurrentItem().getType().equals(Material.ARMOR_STAND) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.GUI.RotateItemName").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä")))) {
				if(p.hasPermission("HeadBanner.Rotate")) {
					if(!plugin.RB.contains(p.getName())) {
						plugin.RB.add(p.getName());
						plugin.rotateid = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

							@Override
							public void run() {
								plugin.rotate -= 1;
								
								if(plugin.rotate == 14) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BA1").item);
								}
								if(plugin.rotate == 13) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BA2").item);
								}
								if(plugin.rotate == 12) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BA3").item);
								}
								if(plugin.rotate == 11) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BA4").item);
								}
								if(plugin.rotate == 10) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BA5").item);
								}
								if(plugin.rotate == 9) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BA6").item);
								}
								if(plugin.rotate == 8) {
									p.getInventory().setHelmet(ItemHandler.Banner.getBannerById("BA7").item);
								}
								if(plugin.rotate == 7) {
									//TEMP
									plugin.rotate = 14;
								}
								if(plugin.rotate == 6) {
									
								}
								if(plugin.rotate == 5) {
									
								}
								if(plugin.rotate == 4) {
									
								}
								if(plugin.rotate == 3) {
									
								}
								if(plugin.rotate == 2) {
									
								}
								if(plugin.rotate == 1) {
									
								}
								if(plugin.rotate == 0) {
									plugin.rotate = 14;
								}								
							}								
						}
						, 0, 20L);
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.RotateEnabled").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
						p.closeInventory();
					}  else {
						if(p.getInventory().getHelmet() != null) {
							if(p.getInventory().getHelmet().getType().toString().contains("BANNER")) {
								p.getInventory().setHelmet(null);
							}
						}
						p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.RotateDisabled").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
						Bukkit.getScheduler().cancelTask(plugin.rotateid);
						plugin.RB.remove(p.getName());
						plugin.rotate = 15;
						p.closeInventory();
					}
				} else {
					p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				}
			}
			
		}
		
	}
}
