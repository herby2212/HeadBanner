package de.Herbystar.HeadBanner.Events;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.Herbystar.HeadBanner.Main;
import de.Herbystar.HeadBanner.Utilities.ItemHandler;
import de.Herbystar.HeadBanner.Utilities.XMaterial;

public class InventoryInteractEvents implements Listener {
	
	Main plugin;
	public InventoryInteractEvents(Main main) {
		plugin = main;
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
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void OnBannerMenuInvInteract(InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equals(plugin.getConfig().getString("HeadBanner.BannerInventory.Side1Title").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null && e.getCurrentItem().getType().equals(XMaterial.matchXMaterial("BANNER").get().parseMaterial())) {
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
			/*
			if(e.getCurrentItem().getType().equals(Material.MAGMA_CREAM) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.GUI.NextSide").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä")))) {
				plugin.inv2 = p.getPlayer().getServer().createInventory(null, plugin.getConfig().getInt("HeadBanner.InventorySize.2"), plugin.getConfig().getString("HeadBanner.BannerInventory.Side2Title").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				
				ItemStack BP1 = new ItemStack(Material.BANNER);
				BannerMeta BP1M = (BannerMeta) BP1.getItemMeta();
				BP1M.setBaseColor(DyeColor.WHITE);
				BP1M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.15").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				BP1M.addPattern(new Pattern(DyeColor.BLACK, PatternType.BORDER));
				BP1M.addPattern(new Pattern(DyeColor.BLACK, PatternType.SKULL));
				BP1.setItemMeta(BP1M);
				
				ItemStack BP2 = new ItemStack(Material.BANNER);
				BannerMeta BP2M = (BannerMeta) BP2.getItemMeta();
				BP2M.setBaseColor(DyeColor.BLACK);
				BP2M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.16").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				BP2M.addPattern(new Pattern(DyeColor.BLACK, PatternType.HALF_HORIZONTAL));
				BP2M.addPattern(new Pattern(DyeColor.GREEN, PatternType.TRIANGLE_TOP));
				BP2M.addPattern(new Pattern(DyeColor.RED, PatternType.STRIPE_SMALL));
				BP2M.addPattern(new Pattern(DyeColor.GREEN, PatternType.SKULL));
				BP2M.addPattern(new Pattern(DyeColor.GREEN, PatternType.TRIANGLES_TOP));
				BP2M.addPattern(new Pattern(DyeColor.GREEN, PatternType.CURLY_BORDER));
				BP2.setItemMeta(BP2M);
				
				ItemStack BP3 = new ItemStack(Material.BANNER);
				BannerMeta BP3M = (BannerMeta) BP3.getItemMeta();
				BP3M.setBaseColor(DyeColor.LIME);
				BP3M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.17").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				BP3M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.RHOMBUS_MIDDLE));
				BP3M.addPattern(new Pattern(DyeColor.RED, PatternType.BORDER));
				BP3M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.FLOWER));
				BP3M.addPattern(new Pattern(DyeColor.RED, PatternType.CIRCLE_MIDDLE));
				BP3.setItemMeta(BP3M);
				
				ItemStack BP4 = new ItemStack(Material.BANNER);
				BannerMeta BP4M = (BannerMeta) BP4.getItemMeta();
				BP4M.setBaseColor(DyeColor.BROWN);
				BP4M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.18").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				BP4M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.MOJANG));
				BP4.setItemMeta(BP4M);
				
				ItemStack BP5 = new ItemStack(Material.BANNER);
				BannerMeta BP5M = (BannerMeta) BP5.getItemMeta();
				BP5M.setBaseColor(DyeColor.BLUE);
				BP5M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.19").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				BP5M.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.CURLY_BORDER));
				BP5M.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.FLOWER));
				BP5M.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.TRIANGLES_TOP));
				BP5M.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.TRIANGLES_BOTTOM));
				BP5M.addPattern(new Pattern(DyeColor.BLUE, PatternType.CIRCLE_MIDDLE));
				BP5.setItemMeta(BP5M);
				
				ItemStack BP6 = new ItemStack(Material.BANNER);
				BannerMeta BP6M = (BannerMeta) BP6.getItemMeta();
				BP6M.setBaseColor(DyeColor.BLACK);
				BP6M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.20").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				BP6M.addPattern(new Pattern(DyeColor.ORANGE, PatternType.TRIANGLE_BOTTOM));
				BP6M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.RHOMBUS_MIDDLE));
				BP6M.addPattern(new Pattern(DyeColor.RED, PatternType.BORDER));
				BP6M.addPattern(new Pattern(DyeColor.RED, PatternType.TRIANGLES_TOP));
				BP6.setItemMeta(BP6M);
				
				ItemStack BP7 = new ItemStack(Material.BANNER);
				BannerMeta BP7M = (BannerMeta) BP7.getItemMeta();
				BP7M.setBaseColor(DyeColor.BLACK);
				BP7M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.21").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				BP7M.addPattern(new Pattern(DyeColor.GRAY, PatternType.BORDER));
				BP7M.addPattern(new Pattern(DyeColor.GRAY, PatternType.STRIPE_CENTER));
				BP7M.addPattern(new Pattern(DyeColor.RED, PatternType.SKULL));
				BP7.setItemMeta(BP7M);
				
				ItemStack BP8 = new ItemStack(Material.BANNER);
				BannerMeta BP8M = (BannerMeta) BP8.getItemMeta();
				BP8M.setBaseColor(DyeColor.LIME);
				BP8M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.22").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				BP8M.addPattern(new Pattern(DyeColor.RED, PatternType.BRICKS));
				BP8M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.FLOWER));
				BP8M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.FLOWER));
				BP8M.addPattern(new Pattern(DyeColor.LIME, PatternType.CIRCLE_MIDDLE));
				BP8M.addPattern(new Pattern(DyeColor.RED, PatternType.BORDER));
				BP8.setItemMeta(BP8M);
				
				ItemStack BP9 = new ItemStack(Material.BANNER);
				BannerMeta BP9M = (BannerMeta) BP9.getItemMeta();
				BP9M.setBaseColor(DyeColor.BLACK);
				BP9M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.23").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				BP9M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.CROSS));
				BP9M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.STRAIGHT_CROSS));
				BP9M.addPattern(new Pattern(DyeColor.RED, PatternType.CURLY_BORDER));
				BP9.setItemMeta(BP9M);
				
				ItemStack BP10 = new ItemStack(Material.BANNER);
				BannerMeta BP10M = (BannerMeta) BP10.getItemMeta();
				BP10M.setBaseColor(DyeColor.BLACK);
				BP10M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.24").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				BP10M.addPattern(new Pattern(DyeColor.RED, PatternType.CROSS));
				BP10M.addPattern(new Pattern(DyeColor.RED, PatternType.BORDER));
				BP10.setItemMeta(BP10M);
				
				ItemStack BP11 = new ItemStack(Material.BANNER);
				BannerMeta BP11M = (BannerMeta) BP11.getItemMeta();
				BP11M.setBaseColor(DyeColor.BLACK);
				BP11M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.25").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				BP11M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.CREEPER));
				BP11M.addPattern(new Pattern(DyeColor.LIME, PatternType.GRADIENT_UP));
				BP11.setItemMeta(BP11M);
				
				ItemStack BP12 = new ItemStack(Material.BANNER);
				BannerMeta BP12M = (BannerMeta) BP12.getItemMeta();
				BP12M.setBaseColor(DyeColor.YELLOW);
				BP12M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.26").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				BP12M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.BORDER));
				BP12M.addPattern(new Pattern(DyeColor.LIME, PatternType.CREEPER));
				BP12M.addPattern(new Pattern(DyeColor.LIME, PatternType.CREEPER));
				BP12.setItemMeta(BP12M);
				
				ItemStack BP13 = new ItemStack(Material.BANNER);
				BannerMeta BP13M = (BannerMeta) BP13.getItemMeta();
				BP13M.setBaseColor(DyeColor.BLACK);
				BP13M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.27").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				BP13M.addPattern(new Pattern(DyeColor.RED, PatternType.BRICKS));
				BP13M.addPattern(new Pattern(DyeColor.CYAN, PatternType.GRADIENT_UP));
				BP13M.addPattern(new Pattern(DyeColor.ORANGE, PatternType.GRADIENT));
				BP13M.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
				BP13.setItemMeta(BP13M);
				
				ItemStack BP14 = new ItemStack(Material.BANNER);
				BannerMeta BP14M = (BannerMeta) BP14.getItemMeta();
				BP14M.setBaseColor(DyeColor.WHITE);
				BP14M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.28").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				BP14M.addPattern(new Pattern(DyeColor.BLACK, PatternType.GRADIENT));
				BP14M.addPattern(new Pattern(DyeColor.BLACK, PatternType.CROSS));
				BP14M.addPattern(new Pattern(DyeColor.BLACK, PatternType.CURLY_BORDER));
				BP14.setItemMeta(BP14M);
				
				
				ItemStack B = new ItemStack(Material.MAGMA_CREAM);
				ItemMeta BM = B.getItemMeta();
				BM.setDisplayName(plugin.getConfig().getString("HeadBanner.GUI.BackSide").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				B.setItemMeta(BM);
				
				ItemStack R = new ItemStack(Material.ARMOR_STAND);
				ItemMeta RM = R.getItemMeta();
				RM.setDisplayName(plugin.getConfig().getString("HeadBanner.GUI.RotateItemName").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				R.setItemMeta(RM);
				
				ItemStack N = new ItemStack(Material.MAGMA_CREAM);
				ItemMeta NM = N.getItemMeta();
				NM.setDisplayName(plugin.getConfig().getString("HeadBanner.GUI.NextSide").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				N.setItemMeta(NM);
				
				//1 Reihe
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.15") == false) {
					plugin.inv2.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.15"), BP1);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.16") == false) {
					plugin.inv2.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.16"), BP2);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.17") == false) {
					plugin.inv2.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.17"), BP3);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.18") == false) {
					plugin.inv2.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.18"), BP4);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.19") == false) {
					plugin.inv2.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.19"), BP5);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.20") == false) {
					plugin.inv2.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.20"), BP6);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.21") == false) {
					plugin.inv2.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.21"), BP7);
				}
				
				//2 Reihe
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.22") == false) {
					plugin.inv2.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.22"), BP8);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.23") == false) {
					plugin.inv2.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.23"), BP9);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.24") == false) {
					plugin.inv2.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.24"), BP10);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.25") == false) {
					plugin.inv2.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.25"), BP11);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.26") == false) {
					plugin.inv2.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.26"), BP12);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.27") == false) {
					plugin.inv2.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.27"), BP13);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.28") == false) {
					plugin.inv2.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.28"), BP14);
				}
				
				
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.RotateItem") == false) {
					plugin.inv2.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.RotateItem2"), R);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.BackSide") == false) {
					plugin.inv2.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.BackSide2"), B);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.NextSide") == false) {
					plugin.inv2.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.NextSide2"), N);
				}
				p.openInventory(plugin.inv2);														
			}
			*/
			/*
			if(e.getCurrentItem().getType().equals(Material.ARMOR_STAND) && (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.GUI.RotateItemName").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä")))) {
				if(p.hasPermission("HeadBanner.Rotate")) {
					if(!plugin.RB.contains(p.getName())) {
						plugin.RB.add(p.getName());
						plugin.rotateid = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

							@Override
							public void run() {
								plugin.rotate -= 1;
																
								if(plugin.rotate == 14) {
									ItemStack R1 = new ItemStack(Material.BANNER);
									BannerMeta R1M = (BannerMeta) R1.getItemMeta();
									R1M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.1").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									R1M.setBaseColor(DyeColor.BLACK);
									R1.setItemMeta(R1M);
									p.getInventory().setHelmet(R1);
								}						
								if(plugin.rotate == 13) {
									ItemStack B2 = new ItemStack(Material.BANNER);
									BannerMeta B2M = (BannerMeta) B2.getItemMeta();
									B2M.setBaseColor(DyeColor.WHITE);
									B2M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.2").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B2.setItemMeta(B2M);
									p.getInventory().setHelmet(B2);							
								}
								if(plugin.rotate == 12) {
									ItemStack B3 = new ItemStack(Material.BANNER);
									BannerMeta B3M = (BannerMeta) B3.getItemMeta();
									B3M.setBaseColor(DyeColor.GRAY);
									B3M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.3").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B3.setItemMeta(B3M);
									p.getInventory().setHelmet(B3);
								}
								if(plugin.rotate == 11) {
									ItemStack B4 = new ItemStack(Material.BANNER);
									BannerMeta B4M = (BannerMeta) B4.getItemMeta();
									B4M.setBaseColor(DyeColor.BLUE);
									B4M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.4").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B4.setItemMeta(B4M);
									p.getInventory().setHelmet(B4);		
								}
								if(plugin.rotate == 10) {
									ItemStack B5 = new ItemStack(Material.BANNER);
									BannerMeta B5M = (BannerMeta) B5.getItemMeta();
									B5M.setBaseColor(DyeColor.GREEN);
									B5M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.5").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B5.setItemMeta(B5M);
									p.getInventory().setHelmet(B5);
								}
								if(plugin.rotate == 9) {
									ItemStack B6 = new ItemStack(Material.BANNER);
									BannerMeta B6M = (BannerMeta) B6.getItemMeta();
									B6M.setBaseColor(DyeColor.CYAN);
									B6M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.6").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B6.setItemMeta(B6M);
									p.getInventory().setHelmet(B6);
								}
								if(plugin.rotate == 8) {
									ItemStack B7 = new ItemStack(Material.BANNER);
									BannerMeta B7M = (BannerMeta) B7.getItemMeta();
									B7M.setBaseColor(DyeColor.YELLOW);
									B7M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.7").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B7.setItemMeta(B7M);
									p.getInventory().setHelmet(B7);	
								}
								if(plugin.rotate == 7) {
									ItemStack B8 = new ItemStack(Material.BANNER);
									BannerMeta B8M = (BannerMeta) B8.getItemMeta();
									B8M.setBaseColor(DyeColor.LIGHT_BLUE);
									B8M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.8").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B8.setItemMeta(B8M);
									p.getInventory().setHelmet(B8);	
								}
								if(plugin.rotate == 6) {
									ItemStack B9 = new ItemStack(Material.BANNER);
									BannerMeta B9M = (BannerMeta) B9.getItemMeta();
									B9M.setBaseColor(DyeColor.RED);
									B9M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.9").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B9.setItemMeta(B9M);
									p.getInventory().setHelmet(B9);	
								}
								if(plugin.rotate == 5) {
									ItemStack B10 = new ItemStack(Material.BANNER);
									BannerMeta B10M = (BannerMeta) B10.getItemMeta();
									B10M.setBaseColor(DyeColor.LIME);
									B10M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.10").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B10.setItemMeta(B10M);
									p.getInventory().setHelmet(B10);
								}
								if(plugin.rotate == 4) {
									ItemStack B11 = new ItemStack(Material.BANNER);
									BannerMeta B11M = (BannerMeta) B11.getItemMeta();
									B11M.setBaseColor(DyeColor.ORANGE);
									B11M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.11").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B11.setItemMeta(B11M);
									p.getInventory().setHelmet(B11);	
								}
								if(plugin.rotate == 3) {
									ItemStack B12 = new ItemStack(Material.BANNER);
									BannerMeta B12M = (BannerMeta) B12.getItemMeta();
									B12M.setBaseColor(DyeColor.PINK);
									B12M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.12").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B12.setItemMeta(B12M);
									p.getInventory().setHelmet(B12);	
								}
								if(plugin.rotate == 2) {
									ItemStack B13 = new ItemStack(Material.BANNER);
									BannerMeta B13M = (BannerMeta) B13.getItemMeta();
									B13M.setBaseColor(DyeColor.MAGENTA);
									B13M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.13").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B13.setItemMeta(B13M);
									p.getInventory().setHelmet(B13);	
								}
								if(plugin.rotate == 1) {
									ItemStack B14 = new ItemStack(Material.BANNER);
									BannerMeta B14M = (BannerMeta) B14.getItemMeta();
									B14M.setBaseColor(DyeColor.SILVER);
									B14M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.14").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B14.setItemMeta(B14M);
									p.getInventory().setHelmet(B14);
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
							if(p.getInventory().getHelmet().getType().equals(Material.BANNER)) {
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
			*/
		}				
	}
	
	
	
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void OnBannerMenuInv2Interact(InventoryClickEvent e) {
		/*
		final Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equals(plugin.getConfig().getString("HeadBanner.BannerInventory.Side2Title").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null && e.getCurrentItem().getType().equals(Material.BANNER)) {
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.15").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.15")) {
						if(!plugin.BP1.contains(p)) {
							ItemStack BP1 = new ItemStack(Material.BANNER);
							BannerMeta BP1M = (BannerMeta) BP1.getItemMeta();
							BP1M.setBaseColor(DyeColor.WHITE);
							BP1M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.15").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
							BP1M.addPattern(new Pattern(DyeColor.BLACK, PatternType.BORDER));
							BP1M.addPattern(new Pattern(DyeColor.BLACK, PatternType.SKULL));
							BP1.setItemMeta(BP1M);
							p.getInventory().setHelmet(BP1);
							checkEffect(15, p);
							plugin.BP1.add(p);
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
							ItemStack BP2 = new ItemStack(Material.BANNER);
							BannerMeta BP2M = (BannerMeta) BP2.getItemMeta();
							BP2M.setBaseColor(DyeColor.BLACK);
							BP2M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.16").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
							BP2M.addPattern(new Pattern(DyeColor.BLACK, PatternType.HALF_HORIZONTAL));
							BP2M.addPattern(new Pattern(DyeColor.GREEN, PatternType.TRIANGLE_TOP));
							BP2M.addPattern(new Pattern(DyeColor.RED, PatternType.STRIPE_SMALL));
							BP2M.addPattern(new Pattern(DyeColor.GREEN, PatternType.SKULL));
							BP2M.addPattern(new Pattern(DyeColor.GREEN, PatternType.TRIANGLES_TOP));
							BP2M.addPattern(new Pattern(DyeColor.GREEN, PatternType.CURLY_BORDER));
							BP2.setItemMeta(BP2M);
							p.getInventory().setHelmet(BP2);
							checkEffect(16, p);
							plugin.BP2.add(p);
							plugin.BP1.remove(p);
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
							ItemStack BP3 = new ItemStack(Material.BANNER);
							BannerMeta BP3M = (BannerMeta) BP3.getItemMeta();
							BP3M.setBaseColor(DyeColor.LIME);
							BP3M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.17").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
							BP3M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.RHOMBUS_MIDDLE));
							BP3M.addPattern(new Pattern(DyeColor.RED, PatternType.BORDER));
							BP3M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.FLOWER));
							BP3M.addPattern(new Pattern(DyeColor.RED, PatternType.CIRCLE_MIDDLE));
							BP3.setItemMeta(BP3M);
							p.getInventory().setHelmet(BP3);
							checkEffect(17, p);
							plugin.BP3.add(p);
							plugin.BP2.remove(p);
							plugin.BP1.remove(p);
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
							ItemStack BP4 = new ItemStack(Material.BANNER);
							BannerMeta BP4M = (BannerMeta) BP4.getItemMeta();
							BP4M.setBaseColor(DyeColor.BROWN);
							BP4M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.18").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
							BP4M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.MOJANG));
							BP4.setItemMeta(BP4M);
							p.getInventory().setHelmet(BP4);
							checkEffect(18, p);
							plugin.BP4.add(p);
							plugin.BP2.remove(p);
							plugin.BP3.remove(p);
							plugin.BP1.remove(p);
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
							ItemStack BP5 = new ItemStack(Material.BANNER);
							BannerMeta BP5M = (BannerMeta) BP5.getItemMeta();
							BP5M.setBaseColor(DyeColor.BLUE);
							BP5M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.19").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
							BP5M.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.CURLY_BORDER));
							BP5M.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.FLOWER));
							BP5M.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.TRIANGLES_TOP));
							BP5M.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.TRIANGLES_BOTTOM));
							BP5M.addPattern(new Pattern(DyeColor.BLUE, PatternType.CIRCLE_MIDDLE));
							BP5.setItemMeta(BP5M);
							p.getInventory().setHelmet(BP5);
							checkEffect(19, p);
							plugin.BP5.add(p);
							plugin.BP2.remove(p);
							plugin.BP3.remove(p);
							plugin.BP4.remove(p);
							plugin.BP1.remove(p);
							plugin.BP6.remove(p);
							plugin.BP7.remove(p);
							plugin.BP8.remove(p);
							plugin.BP9.remove(p);
							plugin.BP10.remove(p);
							plugin.BP11.remove(p);
							plugin.BP12.remove(p);
							plugin.BP13.remove(p);
							plugin.BP14.remove(p);
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
							ItemStack BP6 = new ItemStack(Material.BANNER);
							BannerMeta BP6M = (BannerMeta) BP6.getItemMeta();
							BP6M.setBaseColor(DyeColor.BLACK);
							BP6M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.20").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
							BP6M.addPattern(new Pattern(DyeColor.ORANGE, PatternType.TRIANGLE_BOTTOM));
							BP6M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.RHOMBUS_MIDDLE));
							BP6M.addPattern(new Pattern(DyeColor.RED, PatternType.BORDER));
							BP6M.addPattern(new Pattern(DyeColor.RED, PatternType.TRIANGLES_TOP));
							BP6.setItemMeta(BP6M);
							p.getInventory().setHelmet(BP6);
							checkEffect(20, p);
							plugin.BP6.add(p);
							plugin.BP2.remove(p);
							plugin.BP3.remove(p);
							plugin.BP4.remove(p);
							plugin.BP5.remove(p);
							plugin.BP1.remove(p);
							plugin.BP7.remove(p);
							plugin.BP8.remove(p);
							plugin.BP9.remove(p);
							plugin.BP10.remove(p);
							plugin.BP11.remove(p);
							plugin.BP12.remove(p);
							plugin.BP13.remove(p);
							plugin.BP14.remove(p);
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
							ItemStack BP7 = new ItemStack(Material.BANNER);
							BannerMeta BP7M = (BannerMeta) BP7.getItemMeta();
							BP7M.setBaseColor(DyeColor.BLACK);
							BP7M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.21").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
							BP7M.addPattern(new Pattern(DyeColor.GRAY, PatternType.BORDER));
							BP7M.addPattern(new Pattern(DyeColor.GRAY, PatternType.STRIPE_CENTER));
							BP7M.addPattern(new Pattern(DyeColor.RED, PatternType.SKULL));
							BP7.setItemMeta(BP7M);
							p.getInventory().setHelmet(BP7);
							checkEffect(21, p);
							plugin.BP7.add(p);
							plugin.BP2.remove(p);
							plugin.BP3.remove(p);
							plugin.BP4.remove(p);
							plugin.BP5.remove(p);
							plugin.BP6.remove(p);
							plugin.BP1.remove(p);
							plugin.BP8.remove(p);
							plugin.BP9.remove(p);
							plugin.BP10.remove(p);
							plugin.BP11.remove(p);
							plugin.BP12.remove(p);
							plugin.BP13.remove(p);
							plugin.BP14.remove(p);
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
							ItemStack BP8 = new ItemStack(Material.BANNER);
							BannerMeta BP8M = (BannerMeta) BP8.getItemMeta();
							BP8M.setBaseColor(DyeColor.LIME);
							BP8M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.22").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
							BP8M.addPattern(new Pattern(DyeColor.RED, PatternType.BRICKS));
							BP8M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.FLOWER));
							BP8M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.FLOWER));
							BP8M.addPattern(new Pattern(DyeColor.LIME, PatternType.CIRCLE_MIDDLE));
							BP8M.addPattern(new Pattern(DyeColor.RED, PatternType.BORDER));
							BP8.setItemMeta(BP8M);
							p.getInventory().setHelmet(BP8);
							checkEffect(22, p);
							plugin.BP8.add(p);
							plugin.BP2.remove(p);
							plugin.BP3.remove(p);
							plugin.BP4.remove(p);
							plugin.BP5.remove(p);
							plugin.BP6.remove(p);
							plugin.BP7.remove(p);
							plugin.BP1.remove(p);
							plugin.BP9.remove(p);
							plugin.BP10.remove(p);
							plugin.BP11.remove(p);
							plugin.BP12.remove(p);
							plugin.BP13.remove(p);
							plugin.BP14.remove(p);
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
							ItemStack BP9 = new ItemStack(Material.BANNER);
							BannerMeta BP9M = (BannerMeta) BP9.getItemMeta();
							BP9M.setBaseColor(DyeColor.BLACK);
							BP9M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.23").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
							BP9M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.CROSS));
							BP9M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.STRAIGHT_CROSS));
							BP9M.addPattern(new Pattern(DyeColor.RED, PatternType.CURLY_BORDER));
							BP9.setItemMeta(BP9M);
							p.getInventory().setHelmet(BP9);
							checkEffect(23, p);
							plugin.BP9.add(p);
							plugin.BP2.remove(p);
							plugin.BP3.remove(p);
							plugin.BP4.remove(p);
							plugin.BP5.remove(p);
							plugin.BP6.remove(p);
							plugin.BP7.remove(p);
							plugin.BP8.remove(p);
							plugin.BP1.remove(p);
							plugin.BP10.remove(p);
							plugin.BP11.remove(p);
							plugin.BP12.remove(p);
							plugin.BP13.remove(p);
							plugin.BP14.remove(p);
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
							ItemStack BP10 = new ItemStack(Material.BANNER);
							BannerMeta BP10M = (BannerMeta) BP10.getItemMeta();
							BP10M.setBaseColor(DyeColor.BLACK);
							BP10M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.24").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
							BP10M.addPattern(new Pattern(DyeColor.RED, PatternType.CROSS));
							BP10M.addPattern(new Pattern(DyeColor.RED, PatternType.BORDER));
							BP10.setItemMeta(BP10M);
							p.getInventory().setHelmet(BP10);
							checkEffect(24, p);
							plugin.BP10.add(p);
							plugin.BP2.remove(p);
							plugin.BP3.remove(p);
							plugin.BP4.remove(p);
							plugin.BP5.remove(p);
							plugin.BP6.remove(p);
							plugin.BP7.remove(p);
							plugin.BP8.remove(p);
							plugin.BP9.remove(p);
							plugin.BP1.remove(p);
							plugin.BP11.remove(p);
							plugin.BP12.remove(p);
							plugin.BP13.remove(p);
							plugin.BP14.remove(p);
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
							ItemStack BP11 = new ItemStack(Material.BANNER);
							BannerMeta BP11M = (BannerMeta) BP11.getItemMeta();
							BP11M.setBaseColor(DyeColor.BLACK);
							BP11M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.25").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
							BP11M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.CREEPER));
							BP11M.addPattern(new Pattern(DyeColor.LIME, PatternType.GRADIENT_UP));
							BP11.setItemMeta(BP11M);
							p.getInventory().setHelmet(BP11);
							checkEffect(25, p);
							plugin.BP11.add(p);
							plugin.BP2.remove(p);
							plugin.BP3.remove(p);
							plugin.BP4.remove(p);
							plugin.BP5.remove(p);
							plugin.BP6.remove(p);
							plugin.BP7.remove(p);
							plugin.BP8.remove(p);
							plugin.BP9.remove(p);
							plugin.BP10.remove(p);
							plugin.BP1.remove(p);
							plugin.BP12.remove(p);
							plugin.BP13.remove(p);
							plugin.BP14.remove(p);
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
							ItemStack BP12 = new ItemStack(Material.BANNER);
							BannerMeta BP12M = (BannerMeta) BP12.getItemMeta();
							BP12M.setBaseColor(DyeColor.YELLOW);
							BP12M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.26").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
							BP12M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.BORDER));
							BP12M.addPattern(new Pattern(DyeColor.LIME, PatternType.CREEPER));
							BP12M.addPattern(new Pattern(DyeColor.LIME, PatternType.CREEPER));
							BP12.setItemMeta(BP12M);
							p.getInventory().setHelmet(BP12);
							checkEffect(26, p);
							plugin.BP12.add(p);
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
							plugin.BP1.remove(p);
							plugin.BP13.remove(p);
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
							ItemStack BP13 = new ItemStack(Material.BANNER);
							BannerMeta BP13M = (BannerMeta) BP13.getItemMeta();
							BP13M.setBaseColor(DyeColor.BLACK);
							BP13M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.27").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
							BP13M.addPattern(new Pattern(DyeColor.RED, PatternType.BRICKS));
							BP13M.addPattern(new Pattern(DyeColor.CYAN, PatternType.GRADIENT_UP));
							BP13M.addPattern(new Pattern(DyeColor.ORANGE, PatternType.GRADIENT));
							BP13M.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
							BP13.setItemMeta(BP13M);
							p.getInventory().setHelmet(BP13);
							checkEffect(27, p);
							plugin.BP13.add(p);
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
							plugin.BP1.remove(p);
							plugin.BP14.remove(p);
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
							ItemStack BP14 = new ItemStack(Material.BANNER);
							BannerMeta BP14M = (BannerMeta) BP14.getItemMeta();
							BP14M.setBaseColor(DyeColor.WHITE);
							BP14M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.28").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
							BP14M.addPattern(new Pattern(DyeColor.BLACK, PatternType.GRADIENT));
							BP14M.addPattern(new Pattern(DyeColor.BLACK, PatternType.CROSS));
							BP14M.addPattern(new Pattern(DyeColor.BLACK, PatternType.CURLY_BORDER));
							BP14.setItemMeta(BP14M);
							p.getInventory().setHelmet(BP14);
							checkEffect(28, p);
							plugin.BP14.add(p);
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
							plugin.BP1.remove(p);
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
									ItemStack BP1 = new ItemStack(Material.BANNER);
									BannerMeta BP1M = (BannerMeta) BP1.getItemMeta();
									BP1M.setBaseColor(DyeColor.WHITE);
									BP1M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.15").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP1M.addPattern(new Pattern(DyeColor.BLACK, PatternType.BORDER));
									BP1M.addPattern(new Pattern(DyeColor.BLACK, PatternType.SKULL));
									BP1.setItemMeta(BP1M);
									p.getInventory().setHelmet(BP1);
								}						
								if(plugin.rotate == 13) {
									ItemStack BP2 = new ItemStack(Material.BANNER);
									BannerMeta BP2M = (BannerMeta) BP2.getItemMeta();
									BP2M.setBaseColor(DyeColor.BLACK);
									BP2M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.16").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP2M.addPattern(new Pattern(DyeColor.BLACK, PatternType.HALF_HORIZONTAL));
									BP2M.addPattern(new Pattern(DyeColor.GREEN, PatternType.TRIANGLE_TOP));
									BP2M.addPattern(new Pattern(DyeColor.RED, PatternType.STRIPE_SMALL));
									BP2M.addPattern(new Pattern(DyeColor.GREEN, PatternType.SKULL));
									BP2M.addPattern(new Pattern(DyeColor.GREEN, PatternType.TRIANGLES_TOP));
									BP2M.addPattern(new Pattern(DyeColor.GREEN, PatternType.CURLY_BORDER));
									BP2.setItemMeta(BP2M);
									p.getInventory().setHelmet(BP2);						
								}
								if(plugin.rotate == 12) {
									ItemStack BP3 = new ItemStack(Material.BANNER);
									BannerMeta BP3M = (BannerMeta) BP3.getItemMeta();
									BP3M.setBaseColor(DyeColor.LIME);
									BP3M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.17").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP3M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.RHOMBUS_MIDDLE));
									BP3M.addPattern(new Pattern(DyeColor.RED, PatternType.BORDER));
									BP3M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.FLOWER));
									BP3M.addPattern(new Pattern(DyeColor.RED, PatternType.CIRCLE_MIDDLE));
									BP3.setItemMeta(BP3M);
									p.getInventory().setHelmet(BP3);
								}
								if(plugin.rotate == 11) {
									ItemStack BP4 = new ItemStack(Material.BANNER);
									BannerMeta BP4M = (BannerMeta) BP4.getItemMeta();
									BP4M.setBaseColor(DyeColor.BROWN);
									BP4M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.18").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP4M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.MOJANG));
									BP4.setItemMeta(BP4M);
									p.getInventory().setHelmet(BP4);	
								}
								if(plugin.rotate == 10) {
									ItemStack BP5 = new ItemStack(Material.BANNER);
									BannerMeta BP5M = (BannerMeta) BP5.getItemMeta();
									BP5M.setBaseColor(DyeColor.BLUE);
									BP5M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.19").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP5M.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.CURLY_BORDER));
									BP5M.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.FLOWER));
									BP5M.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.TRIANGLES_TOP));
									BP5M.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.TRIANGLES_BOTTOM));
									BP5M.addPattern(new Pattern(DyeColor.BLUE, PatternType.CIRCLE_MIDDLE));
									BP5.setItemMeta(BP5M);
									p.getInventory().setHelmet(BP5);	
								}
								if(plugin.rotate == 9) {
									ItemStack BP6 = new ItemStack(Material.BANNER);
									BannerMeta BP6M = (BannerMeta) BP6.getItemMeta();
									BP6M.setBaseColor(DyeColor.BLACK);
									BP6M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.20").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP6M.addPattern(new Pattern(DyeColor.ORANGE, PatternType.TRIANGLE_BOTTOM));
									BP6M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.RHOMBUS_MIDDLE));
									BP6M.addPattern(new Pattern(DyeColor.RED, PatternType.BORDER));
									BP6M.addPattern(new Pattern(DyeColor.RED, PatternType.TRIANGLES_TOP));
									BP6.setItemMeta(BP6M);
									p.getInventory().setHelmet(BP6);	
								}
								if(plugin.rotate == 8) {
									ItemStack BP7 = new ItemStack(Material.BANNER);
									BannerMeta BP7M = (BannerMeta) BP7.getItemMeta();
									BP7M.setBaseColor(DyeColor.BLACK);
									BP7M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.21").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP7M.addPattern(new Pattern(DyeColor.GRAY, PatternType.BORDER));
									BP7M.addPattern(new Pattern(DyeColor.GRAY, PatternType.STRIPE_CENTER));
									BP7M.addPattern(new Pattern(DyeColor.RED, PatternType.SKULL));
									BP7.setItemMeta(BP7M);
									p.getInventory().setHelmet(BP7);	
								}
								if(plugin.rotate == 7) {
									ItemStack BP8 = new ItemStack(Material.BANNER);
									BannerMeta BP8M = (BannerMeta) BP8.getItemMeta();
									BP8M.setBaseColor(DyeColor.LIME);
									BP8M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.22").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP8M.addPattern(new Pattern(DyeColor.RED, PatternType.BRICKS));
									BP8M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.FLOWER));
									BP8M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.FLOWER));
									BP8M.addPattern(new Pattern(DyeColor.LIME, PatternType.CIRCLE_MIDDLE));
									BP8M.addPattern(new Pattern(DyeColor.RED, PatternType.BORDER));
									BP8.setItemMeta(BP8M);
									p.getInventory().setHelmet(BP8);	
								}
								if(plugin.rotate == 6) {
									ItemStack BP9 = new ItemStack(Material.BANNER);
									BannerMeta BP9M = (BannerMeta) BP9.getItemMeta();
									BP9M.setBaseColor(DyeColor.BLACK);
									BP9M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.23").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP9M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.CROSS));
									BP9M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.STRAIGHT_CROSS));
									BP9M.addPattern(new Pattern(DyeColor.RED, PatternType.CURLY_BORDER));
									BP9.setItemMeta(BP9M);
									p.getInventory().setHelmet(BP9);
								}
								if(plugin.rotate == 5) {
									ItemStack BP10 = new ItemStack(Material.BANNER);
									BannerMeta BP10M = (BannerMeta) BP10.getItemMeta();
									BP10M.setBaseColor(DyeColor.BLACK);
									BP10M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.24").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP10M.addPattern(new Pattern(DyeColor.RED, PatternType.CROSS));
									BP10M.addPattern(new Pattern(DyeColor.RED, PatternType.BORDER));
									BP10.setItemMeta(BP10M);
									p.getInventory().setHelmet(BP10);
								}
								if(plugin.rotate == 4) {
									ItemStack BP11 = new ItemStack(Material.BANNER);
									BannerMeta BP11M = (BannerMeta) BP11.getItemMeta();
									BP11M.setBaseColor(DyeColor.BLACK);
									BP11M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.25").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP11M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.CREEPER));
									BP11M.addPattern(new Pattern(DyeColor.LIME, PatternType.GRADIENT_UP));
									BP11.setItemMeta(BP11M);
									p.getInventory().setHelmet(BP11);	
								}
								if(plugin.rotate == 3) {
									ItemStack BP12 = new ItemStack(Material.BANNER);
									BannerMeta BP12M = (BannerMeta) BP12.getItemMeta();
									BP12M.setBaseColor(DyeColor.YELLOW);
									BP12M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.26").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP12M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.BORDER));
									BP12M.addPattern(new Pattern(DyeColor.LIME, PatternType.CREEPER));
									BP12M.addPattern(new Pattern(DyeColor.LIME, PatternType.CREEPER));
									BP12.setItemMeta(BP12M);
									p.getInventory().setHelmet(BP12);
								}
								if(plugin.rotate == 2) {
									ItemStack BP13 = new ItemStack(Material.BANNER);
									BannerMeta BP13M = (BannerMeta) BP13.getItemMeta();
									BP13M.setBaseColor(DyeColor.BLACK);
									BP13M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.27").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP13M.addPattern(new Pattern(DyeColor.RED, PatternType.BRICKS));
									BP13M.addPattern(new Pattern(DyeColor.CYAN, PatternType.GRADIENT_UP));
									BP13M.addPattern(new Pattern(DyeColor.ORANGE, PatternType.GRADIENT));
									BP13M.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
									BP13.setItemMeta(BP13M);
									p.getInventory().setHelmet(BP13);		
								}
								if(plugin.rotate == 1) {
									ItemStack BP14 = new ItemStack(Material.BANNER);
									BannerMeta BP14M = (BannerMeta) BP14.getItemMeta();
									BP14M.setBaseColor(DyeColor.WHITE);
									BP14M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.28").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP14M.addPattern(new Pattern(DyeColor.BLACK, PatternType.GRADIENT));
									BP14M.addPattern(new Pattern(DyeColor.BLACK, PatternType.CROSS));
									BP14M.addPattern(new Pattern(DyeColor.BLACK, PatternType.CURLY_BORDER));
									BP14.setItemMeta(BP14M);
									p.getInventory().setHelmet(BP14);	
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
							if(p.getInventory().getHelmet().getType().equals(Material.BANNER)) {
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
				plugin.inv3 = p.getPlayer().getServer().createInventory(null, plugin.getConfig().getInt("HeadBanner.InventorySize.3"), plugin.getConfig().getString("HeadBanner.BannerInventory.Side3Title").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				
				
				ItemStack BA1 = new ItemStack(Material.BANNER);
				BannerMeta BA1M = (BannerMeta) BA1.getItemMeta();
				BA1M.setBaseColor(DyeColor.RED);
				BA1M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.29").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				BA1M.addPattern(new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL_MIRROR));
				BA1M.addPattern(new Pattern(DyeColor.BLACK, PatternType.RHOMBUS_MIDDLE));
				BA1M.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
				BA1M.addPattern(new Pattern(DyeColor.WHITE, PatternType.CIRCLE_MIDDLE));
				BA1M.addPattern(new Pattern(DyeColor.RED, PatternType.STRIPE_TOP));
				BA1M.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_BOTTOM));
				BA1.setItemMeta(BA1M);
				
				ItemStack BA2 = new ItemStack(Material.BANNER);
				BannerMeta BA2M = (BannerMeta) BA2.getItemMeta();
				BA2M.setBaseColor(DyeColor.WHITE);
				BA2M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.30").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				BA2M.addPattern(new Pattern(DyeColor.BLACK, PatternType.FLOWER));
				BA2M.addPattern(new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL_MIRROR));
				BA2M.addPattern(new Pattern(DyeColor.BLACK, PatternType.TRIANGLES_TOP));
				BA2M.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_CENTER));
				BA2M.addPattern(new Pattern(DyeColor.BLACK, PatternType.CREEPER));
				BA2M.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_BOTTOM));
				BA2.setItemMeta(BA2M);
				
				ItemStack BA3 = new ItemStack(Material.BANNER);
				BannerMeta BA3M = (BannerMeta) BA3.getItemMeta();
				BA3M.setBaseColor(DyeColor.PURPLE);
				BA3M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.31").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				BA3M.addPattern(new Pattern(DyeColor.PURPLE, PatternType.STRIPE_MIDDLE));
				BA3M.addPattern(new Pattern(DyeColor.BLACK, PatternType.CREEPER));
				BA3M.addPattern(new Pattern(DyeColor.BLACK, PatternType.CURLY_BORDER));
				BA3M.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_CENTER));
				BA3M.addPattern(new Pattern(DyeColor.BLACK, PatternType.TRIANGLE_TOP));
				BA3.setItemMeta(BA3M);
				
				ItemStack BA4 = new ItemStack(Material.BANNER);
				BannerMeta BA4M = (BannerMeta) BA4.getItemMeta();
				BA4M.setBaseColor(DyeColor.ORANGE);
				BA4M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.32").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				BA4M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.BRICKS));
				BA4M.addPattern(new Pattern(DyeColor.CYAN, PatternType.HALF_HORIZONTAL));
				BA4M.addPattern(new Pattern(DyeColor.LIME, PatternType.FLOWER));
				BA4M.addPattern(new Pattern(DyeColor.CYAN, PatternType.BORDER));
				BA4M.addPattern(new Pattern(DyeColor.LIME, PatternType.CIRCLE_MIDDLE));
				BA4M.addPattern(new Pattern(DyeColor.CYAN, PatternType.CURLY_BORDER));
				BA4.setItemMeta(BA4M);
				
				ItemStack BA5 = new ItemStack(Material.BANNER);
				BannerMeta BA5M = (BannerMeta) BA5.getItemMeta();
				BA5M.setBaseColor(DyeColor.WHITE);
				BA5M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.33").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				BA5M.addPattern(new Pattern(DyeColor.GREEN, PatternType.RHOMBUS_MIDDLE));
				BA5M.addPattern(new Pattern(DyeColor.BROWN, PatternType.STRIPE_BOTTOM));
				BA5M.addPattern(new Pattern(DyeColor.ORANGE, PatternType.STRIPE_CENTER));
				BA5M.addPattern(new Pattern(DyeColor.BROWN, PatternType.BORDER));
				BA5M.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
				BA5M.addPattern(new Pattern(DyeColor.BLACK, PatternType.HALF_HORIZONTAL));
				BA5.setItemMeta(BA5M);
				
				ItemStack BA6 = new ItemStack(Material.BANNER);
				BannerMeta BA6M = (BannerMeta) BA6.getItemMeta();
				BA6M.setBaseColor(DyeColor.WHITE);
				BA6M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.34").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				BA6M.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.STRIPE_BOTTOM));
				BA6M.addPattern(new Pattern(DyeColor.BROWN, PatternType.STRAIGHT_CROSS));
				BA6M.addPattern(new Pattern(DyeColor.WHITE, PatternType.HALF_VERTICAL));
				BA6M.addPattern(new Pattern(DyeColor.BROWN, PatternType.TRIANGLES_TOP));
				BA6M.addPattern(new Pattern(DyeColor.BROWN, PatternType.HALF_HORIZONTAL_MIRROR));
				BA6M.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.CURLY_BORDER));
				BA6M.addPattern(new Pattern(DyeColor.BLUE, PatternType.STRIPE_BOTTOM));
				BA6.setItemMeta(BA6M);
				
				ItemStack BA7 = new ItemStack(Material.BANNER);
				BannerMeta BA7M = (BannerMeta) BA7.getItemMeta();
				BA7M.setBaseColor(DyeColor.RED);
				BA7M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.35").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				BA7M.addPattern(new Pattern(DyeColor.BLUE, PatternType.TRIANGLE_BOTTOM));
				BA7M.addPattern(new Pattern(DyeColor.RED, PatternType.STRIPE_SMALL));
				BA7M.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_MIDDLE));
				BA7M.addPattern(new Pattern(DyeColor.BLUE, PatternType.CURLY_BORDER));
				BA7M.addPattern(new Pattern(DyeColor.RED, PatternType.CIRCLE_MIDDLE));
				BA7M.addPattern(new Pattern(DyeColor.BLUE, PatternType.BORDER));
				BA7.setItemMeta(BA7M);
				
				
				ItemStack C = new ItemStack(Material.SLIME_BALL);
				ItemMeta CM = C.getItemMeta();
				CM.setDisplayName(plugin.getConfig().getString("HeadBanner.GUI.CloseItemName").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				C.setItemMeta(CM);
				
				ItemStack B = new ItemStack(Material.MAGMA_CREAM);
				ItemMeta BM = B.getItemMeta();
				BM.setDisplayName(plugin.getConfig().getString("HeadBanner.GUI.BackSide").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				B.setItemMeta(BM);
				
				ItemStack R = new ItemStack(Material.ARMOR_STAND);
				ItemMeta RM = R.getItemMeta();
				RM.setDisplayName(plugin.getConfig().getString("HeadBanner.GUI.RotateItemName").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
				R.setItemMeta(RM);
				
				//1 Reihe
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.29") == false) {
					plugin.inv3.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.29"), BA1);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.30") == false) {
					plugin.inv3.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.30"), BA2);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.31") == false) {
					plugin.inv3.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.31"), BA3);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.32") == false) {
					plugin.inv3.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.32"), BA4);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.33") == false) {
					plugin.inv3.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.33"), BA5);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.34") == false) {
					plugin.inv3.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.34"), BA6);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.35") == false) {
					plugin.inv3.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.35"), BA7);
				}
				
				//2 Reihe
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.36") == false) {
//					plugin.inv3.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.36"), BA8);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.37") == false) {
//					plugin.inv3.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.37"), BA9);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.38") == false) {
//					plugin.inv3.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.38"), BA10);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.39") == false) {
//					plugin.inv3.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.39"), BA11);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.40") == false) {
//					plugin.inv3.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.40"), BA12);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.41") == false) {
//					plugin.inv3.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.41"), BA13);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.42") == false) {
//					plugin.inv3.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.42"), BA14);				
				}
				
				
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.RotateItem") == false) {
					plugin.inv3.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.RotateItem3"), R);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.BackSide") == false) {
					plugin.inv3.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.BackSide3"), B);
				}
				if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.CloseItem") == false) {
					plugin.inv3.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.CloseItem3"), C);
				}				
								
				p.openInventory(plugin.inv3);
			}
		}
	}
	*/
		
		/*
	@SuppressWarnings("deprecation")
	@EventHandler
	public void OnBannerMenuInv3Interact(InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equals(plugin.getConfig().getString("HeadBanner.BannerInventory.Side3Title").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
			e.setCancelled(true);
			if(e.getCurrentItem() != null && e.getCurrentItem().getType().equals(Material.BANNER)) {
				if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.29").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
					if(p.hasPermission("HeadBanner.Banner.29")) {
						if(!plugin.BA1.contains(p)) {
							ItemStack BA1 = new ItemStack(Material.BANNER);
							BannerMeta BA1M = (BannerMeta) BA1.getItemMeta();
							BA1M.setBaseColor(DyeColor.RED);
							BA1M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.29").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
							BA1M.addPattern(new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL_MIRROR));
							BA1M.addPattern(new Pattern(DyeColor.BLACK, PatternType.RHOMBUS_MIDDLE));
							BA1M.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
							BA1M.addPattern(new Pattern(DyeColor.WHITE, PatternType.CIRCLE_MIDDLE));
							BA1M.addPattern(new Pattern(DyeColor.RED, PatternType.STRIPE_TOP));
							BA1M.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_BOTTOM));
							BA1.setItemMeta(BA1M);
							p.getInventory().setHelmet(BA1);
							checkEffect(29, p);
							plugin.BA1.add(p);
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
							ItemStack BA2 = new ItemStack(Material.BANNER);
							BannerMeta BA2M = (BannerMeta) BA2.getItemMeta();
							BA2M.setBaseColor(DyeColor.WHITE);
							BA2M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.30").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
							BA2M.addPattern(new Pattern(DyeColor.BLACK, PatternType.FLOWER));
							BA2M.addPattern(new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL_MIRROR));
							BA2M.addPattern(new Pattern(DyeColor.BLACK, PatternType.TRIANGLES_TOP));
							BA2M.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_CENTER));
							BA2M.addPattern(new Pattern(DyeColor.BLACK, PatternType.CREEPER));
							BA2M.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_BOTTOM));
							BA2.setItemMeta(BA2M);
							p.getInventory().setHelmet(BA2);
							checkEffect(30, p);
							plugin.BA2.add(p);
							plugin.BA1.remove(p);
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
							ItemStack BA3 = new ItemStack(Material.BANNER);
							BannerMeta BA3M = (BannerMeta) BA3.getItemMeta();
							BA3M.setBaseColor(DyeColor.PURPLE);
							BA3M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.31").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
							BA3M.addPattern(new Pattern(DyeColor.PURPLE, PatternType.STRIPE_MIDDLE));
							BA3M.addPattern(new Pattern(DyeColor.BLACK, PatternType.CREEPER));
							BA3M.addPattern(new Pattern(DyeColor.BLACK, PatternType.CURLY_BORDER));
							BA3M.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_CENTER));
							BA3M.addPattern(new Pattern(DyeColor.BLACK, PatternType.TRIANGLE_TOP));
							BA3.setItemMeta(BA3M);
							p.getInventory().setHelmet(BA3);
							checkEffect(31, p);
							plugin.BA3.add(p);
							plugin.BA2.remove(p);
							plugin.BA1.remove(p);
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
							ItemStack BA4 = new ItemStack(Material.BANNER);
							BannerMeta BA4M = (BannerMeta) BA4.getItemMeta();
							BA4M.setBaseColor(DyeColor.ORANGE);
							BA4M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.32").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
							BA4M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.BRICKS));
							BA4M.addPattern(new Pattern(DyeColor.CYAN, PatternType.HALF_HORIZONTAL));
							BA4M.addPattern(new Pattern(DyeColor.LIME, PatternType.FLOWER));
							BA4M.addPattern(new Pattern(DyeColor.CYAN, PatternType.BORDER));
							BA4M.addPattern(new Pattern(DyeColor.LIME, PatternType.CIRCLE_MIDDLE));
							BA4M.addPattern(new Pattern(DyeColor.CYAN, PatternType.CURLY_BORDER));
							BA4.setItemMeta(BA4M);
							p.getInventory().setHelmet(BA4);
							checkEffect(32, p);
							plugin.BA4.add(p);
							plugin.BA1.remove(p);
							plugin.BA2.remove(p);
							plugin.BA3.remove(p);
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
							ItemStack BA5 = new ItemStack(Material.BANNER);
							BannerMeta BA5M = (BannerMeta) BA5.getItemMeta();
							BA5M.setBaseColor(DyeColor.WHITE);
							BA5M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.33").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
							BA5M.addPattern(new Pattern(DyeColor.GREEN, PatternType.RHOMBUS_MIDDLE));
							BA5M.addPattern(new Pattern(DyeColor.BROWN, PatternType.STRIPE_BOTTOM));
							BA5M.addPattern(new Pattern(DyeColor.ORANGE, PatternType.STRIPE_CENTER));
							BA5M.addPattern(new Pattern(DyeColor.BROWN, PatternType.BORDER));
							BA5M.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
							BA5M.addPattern(new Pattern(DyeColor.BLACK, PatternType.HALF_HORIZONTAL));
							BA5.setItemMeta(BA5M);
							p.getInventory().setHelmet(BA5);
							checkEffect(33, p);
							plugin.BA5.add(p);
							plugin.BA1.remove(p);
							plugin.BA2.remove(p);
							plugin.BA3.remove(p);
							plugin.BA4.remove(p);
							plugin.BA6.remove(p);
							plugin.BA7.remove(p);
							plugin.BA8.remove(p);
							plugin.BA9.remove(p);
							plugin.BA10.remove(p);
							plugin.BA11.remove(p);
							plugin.BA12.remove(p);
							plugin.BA13.remove(p);
							plugin.BA14.remove(p);
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
							ItemStack BA6 = new ItemStack(Material.BANNER);
							BannerMeta BA6M = (BannerMeta) BA6.getItemMeta();
							BA6M.setBaseColor(DyeColor.WHITE);
							BA6M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.34").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
							BA6M.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.STRIPE_BOTTOM));
							BA6M.addPattern(new Pattern(DyeColor.BROWN, PatternType.STRAIGHT_CROSS));
							BA6M.addPattern(new Pattern(DyeColor.WHITE, PatternType.HALF_VERTICAL));
							BA6M.addPattern(new Pattern(DyeColor.BROWN, PatternType.TRIANGLES_TOP));
							BA6M.addPattern(new Pattern(DyeColor.BROWN, PatternType.HALF_HORIZONTAL_MIRROR));
							BA6M.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.CURLY_BORDER));
							BA6M.addPattern(new Pattern(DyeColor.BLUE, PatternType.STRIPE_BOTTOM));
							BA6.setItemMeta(BA6M);
							p.getInventory().setHelmet(BA6);
							checkEffect(34, p);
							plugin.BA6.add(p);
							plugin.BA1.remove(p);
							plugin.BA2.remove(p);
							plugin.BA3.remove(p);
							plugin.BA4.remove(p);
							plugin.BA5.remove(p);
							plugin.BA7.remove(p);
							plugin.BA8.remove(p);
							plugin.BA9.remove(p);
							plugin.BA10.remove(p);
							plugin.BA11.remove(p);
							plugin.BA12.remove(p);
							plugin.BA13.remove(p);
							plugin.BA14.remove(p);
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
							ItemStack BA7 = new ItemStack(Material.BANNER);
							BannerMeta BA7M = (BannerMeta) BA7.getItemMeta();
							BA7M.setBaseColor(DyeColor.RED);
							BA7M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.35").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
							BA7M.addPattern(new Pattern(DyeColor.BLUE, PatternType.TRIANGLE_BOTTOM));
							BA7M.addPattern(new Pattern(DyeColor.RED, PatternType.STRIPE_SMALL));
							BA7M.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_MIDDLE));
							BA7M.addPattern(new Pattern(DyeColor.BLUE, PatternType.CURLY_BORDER));
							BA7M.addPattern(new Pattern(DyeColor.RED, PatternType.CIRCLE_MIDDLE));
							BA7M.addPattern(new Pattern(DyeColor.BLUE, PatternType.BORDER));
							BA7.setItemMeta(BA7M);
							p.getInventory().setHelmet(BA7);
							checkEffect(35, p);
							plugin.BA7.add(p);
							plugin.BA1.remove(p);
							plugin.BA2.remove(p);
							plugin.BA3.remove(p);
							plugin.BA4.remove(p);
							plugin.BA5.remove(p);
							plugin.BA6.remove(p);
							plugin.BA8.remove(p);
							plugin.BA9.remove(p);
							plugin.BA10.remove(p);
							plugin.BA11.remove(p);
							plugin.BA12.remove(p);
							plugin.BA13.remove(p);
							plugin.BA14.remove(p);
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
									ItemStack BA1 = new ItemStack(Material.BANNER);
									BannerMeta BA1M = (BannerMeta) BA1.getItemMeta();
									BA1M.setBaseColor(DyeColor.RED);
									BA1M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.29").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BA1M.addPattern(new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL_MIRROR));
									BA1M.addPattern(new Pattern(DyeColor.BLACK, PatternType.RHOMBUS_MIDDLE));
									BA1M.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
									BA1M.addPattern(new Pattern(DyeColor.WHITE, PatternType.CIRCLE_MIDDLE));
									BA1M.addPattern(new Pattern(DyeColor.RED, PatternType.STRIPE_TOP));
									BA1M.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_BOTTOM));
									BA1.setItemMeta(BA1M);
									p.getInventory().setHelmet(BA1);
								}
								if(plugin.rotate == 13) {
									ItemStack BA2 = new ItemStack(Material.BANNER);
									BannerMeta BA2M = (BannerMeta) BA2.getItemMeta();
									BA2M.setBaseColor(DyeColor.WHITE);
									BA2M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.30").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BA2M.addPattern(new Pattern(DyeColor.BLACK, PatternType.FLOWER));
									BA2M.addPattern(new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL_MIRROR));
									BA2M.addPattern(new Pattern(DyeColor.BLACK, PatternType.TRIANGLES_TOP));
									BA2M.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_CENTER));
									BA2M.addPattern(new Pattern(DyeColor.BLACK, PatternType.CREEPER));
									BA2M.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_BOTTOM));
									BA2.setItemMeta(BA2M);
									p.getInventory().setHelmet(BA2);
								}
								if(plugin.rotate == 12) {
									ItemStack BA3 = new ItemStack(Material.BANNER);
									BannerMeta BA3M = (BannerMeta) BA3.getItemMeta();
									BA3M.setBaseColor(DyeColor.PURPLE);
									BA3M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.31").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BA3M.addPattern(new Pattern(DyeColor.PURPLE, PatternType.STRIPE_MIDDLE));
									BA3M.addPattern(new Pattern(DyeColor.BLACK, PatternType.CREEPER));
									BA3M.addPattern(new Pattern(DyeColor.BLACK, PatternType.CURLY_BORDER));
									BA3M.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_CENTER));
									BA3M.addPattern(new Pattern(DyeColor.BLACK, PatternType.TRIANGLE_TOP));
									BA3.setItemMeta(BA3M);
									p.getInventory().setHelmet(BA3);
								}
								if(plugin.rotate == 11) {
									ItemStack BA4 = new ItemStack(Material.BANNER);
									BannerMeta BA4M = (BannerMeta) BA4.getItemMeta();
									BA4M.setBaseColor(DyeColor.ORANGE);
									BA4M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.32").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BA4M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.BRICKS));
									BA4M.addPattern(new Pattern(DyeColor.CYAN, PatternType.HALF_HORIZONTAL));
									BA4M.addPattern(new Pattern(DyeColor.LIME, PatternType.FLOWER));
									BA4M.addPattern(new Pattern(DyeColor.CYAN, PatternType.BORDER));
									BA4M.addPattern(new Pattern(DyeColor.LIME, PatternType.CIRCLE_MIDDLE));
									BA4M.addPattern(new Pattern(DyeColor.CYAN, PatternType.CURLY_BORDER));
									BA4.setItemMeta(BA4M);
									p.getInventory().setHelmet(BA4);
								}
								if(plugin.rotate == 10) {
									ItemStack BA5 = new ItemStack(Material.BANNER);
									BannerMeta BA5M = (BannerMeta) BA5.getItemMeta();
									BA5M.setBaseColor(DyeColor.WHITE);
									BA5M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.33").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BA5M.addPattern(new Pattern(DyeColor.GREEN, PatternType.RHOMBUS_MIDDLE));
									BA5M.addPattern(new Pattern(DyeColor.BROWN, PatternType.STRIPE_BOTTOM));
									BA5M.addPattern(new Pattern(DyeColor.ORANGE, PatternType.STRIPE_CENTER));
									BA5M.addPattern(new Pattern(DyeColor.BROWN, PatternType.BORDER));
									BA5M.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
									BA5M.addPattern(new Pattern(DyeColor.BLACK, PatternType.HALF_HORIZONTAL));
									BA5.setItemMeta(BA5M);
									p.getInventory().setHelmet(BA5);
								}
								if(plugin.rotate == 9) {
									ItemStack BA6 = new ItemStack(Material.BANNER);
									BannerMeta BA6M = (BannerMeta) BA6.getItemMeta();
									BA6M.setBaseColor(DyeColor.WHITE);
									BA6M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.34").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BA6M.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.STRIPE_BOTTOM));
									BA6M.addPattern(new Pattern(DyeColor.BROWN, PatternType.STRAIGHT_CROSS));
									BA6M.addPattern(new Pattern(DyeColor.WHITE, PatternType.HALF_VERTICAL));
									BA6M.addPattern(new Pattern(DyeColor.BROWN, PatternType.TRIANGLES_TOP));
									BA6M.addPattern(new Pattern(DyeColor.BROWN, PatternType.HALF_HORIZONTAL_MIRROR));
									BA6M.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.CURLY_BORDER));
									BA6M.addPattern(new Pattern(DyeColor.BLUE, PatternType.STRIPE_BOTTOM));
									BA6.setItemMeta(BA6M);
									p.getInventory().setHelmet(BA6);
								}
								if(plugin.rotate == 8) {
									ItemStack BA7 = new ItemStack(Material.BANNER);
									BannerMeta BA7M = (BannerMeta) BA7.getItemMeta();
									BA7M.setBaseColor(DyeColor.RED);
									BA7M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.35").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BA7M.addPattern(new Pattern(DyeColor.BLUE, PatternType.TRIANGLE_BOTTOM));
									BA7M.addPattern(new Pattern(DyeColor.RED, PatternType.STRIPE_SMALL));
									BA7M.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_MIDDLE));
									BA7M.addPattern(new Pattern(DyeColor.BLUE, PatternType.CURLY_BORDER));
									BA7M.addPattern(new Pattern(DyeColor.RED, PatternType.CIRCLE_MIDDLE));
									BA7M.addPattern(new Pattern(DyeColor.BLUE, PatternType.BORDER));
									BA7.setItemMeta(BA7M);
									p.getInventory().setHelmet(BA7);
								}
								if(plugin.rotate == 7) {
									
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
							if(p.getInventory().getHelmet().getType().equals(Material.BANNER)) {
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
		*/
	}		
}
