package de.Herbystar.HeadBanner.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import de.Herbystar.HeadBanner.Main;
import de.Herbystar.HeadBanner.Events.InventoryInteractEvents;
import de.Herbystar.HeadBanner.Utilities.ItemHandler;
import de.Herbystar.HeadBanner.Utilities.ItemHandler.Banner;

public class BannerCommand implements CommandExecutor {
	
	Main plugin;
	public BannerCommand(Main main) {
		plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			final Player p = (Player) sender;
			
			InventoryInteractEvents c = new InventoryInteractEvents(plugin);
			
			if(cmd.getName().equalsIgnoreCase("Banner") | (cmd.getName().equalsIgnoreCase("B"))) {
				if(plugin.getConfig().getBoolean("HeadBanner.Enabled") == true) {
					if(args.length == 0) {
						p.sendMessage(plugin.prefix + "§aUse §e/Banner <BannerName or Number(1-42)> §ato select a Banner manuel!");
						return true;
					}
					
					if(args.length == 1) {
						if(plugin.inv == null || plugin.inv2 == null || plugin.inv3 == null) {
							ItemHandler.getInventoryPageOne();
							ItemHandler.getInventoryPageTwo();
							ItemHandler.getInventoryPageThree();
						}
						/**
						 * Banner clear
						 */
						if(args[0].equalsIgnoreCase("Clear")) {
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
							return true;
						}
						/**
						 * Banners on Side 1
						 */
						if(args[0].equalsIgnoreCase("Black") | (args[0].equalsIgnoreCase("1"))) {
							if(p.hasPermission("HeadBanner.Banner.1")) {
								Banner b = ItemHandler.Banner.getBannerById("B1");
								if(!plugin.B1.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(1, p);
									Main.instance.addToBannerList(p, plugin.B1, 1);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("White") | (args[0].equalsIgnoreCase("2"))) {
							if(p.hasPermission("HeadBanner.Banner.2")) {
								Banner b = ItemHandler.Banner.getBannerById("B2");
								if(!plugin.B2.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(2, p);
									Main.instance.addToBannerList(p, plugin.B2, 1);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Gray") | (args[0].equalsIgnoreCase("3"))) {
							if(p.hasPermission("HeadBanner.Banner.3")) {
								Banner b = ItemHandler.Banner.getBannerById("B3");
								if(!plugin.B3.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(3, p);
									Main.instance.addToBannerList(p, plugin.B3, 1);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Blue") | (args[0].equalsIgnoreCase("4"))) {
							if(p.hasPermission("HeadBanner.Banner.4")) {
								Banner b = ItemHandler.Banner.getBannerById("B4");
								if(!plugin.B4.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(4, p);
									Main.instance.addToBannerList(p, plugin.B4, 1);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}	
							return true;
						}
						if(args[0].equalsIgnoreCase("Green") | (args[0].equalsIgnoreCase("5"))) {
							if(p.hasPermission("HeadBanner.Banner.5")) {
								Banner b = ItemHandler.Banner.getBannerById("B5");
								if(!plugin.B5.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(5, p);
									Main.instance.addToBannerList(p, plugin.B5, 1);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Cyan") | (args[0].equalsIgnoreCase("6"))) {
							if(p.hasPermission("HeadBanner.Banner.6")) {
								Banner b = ItemHandler.Banner.getBannerById("B6");
								if(!plugin.B6.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(6, p);
									Main.instance.addToBannerList(p, plugin.B6, 1);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}	
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Yellow") | (args[0].equalsIgnoreCase("7"))) {
							if(p.hasPermission("HeadBanner.Banner.7")) {
								Banner b = ItemHandler.Banner.getBannerById("B7");
								if(!plugin.B7.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(7, p);
									Main.instance.addToBannerList(p, plugin.B7, 1);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}	
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Light Blue") | (args[0].equalsIgnoreCase("8"))) {
							if(p.hasPermission("HeadBanner.Banner.8")) {
								Banner b = ItemHandler.Banner.getBannerById("B8");
								if(!plugin.B8.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(8, p);
									Main.instance.addToBannerList(p, plugin.B8, 1);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Red") | (args[0].equalsIgnoreCase("9"))) {
							if(p.hasPermission("HeadBanner.Banner.9")) {
								Banner b = ItemHandler.Banner.getBannerById("B9");
								if(!plugin.B9.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(9, p);
									Main.instance.addToBannerList(p, plugin.B9, 1);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Lime") | (args[0].equalsIgnoreCase("10"))) {
							if(p.hasPermission("HeadBanner.Banner.10")) {
								Banner b = ItemHandler.Banner.getBannerById("B10");
								if(!plugin.B10.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(10, p);
									Main.instance.addToBannerList(p, plugin.B10, 1);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Orange") | (args[0].equalsIgnoreCase("11"))) {
							if(p.hasPermission("HeadBanner.Banner.11")) {
								Banner b = ItemHandler.Banner.getBannerById("B11");
								if(!plugin.B11.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(11, p);
									Main.instance.addToBannerList(p, plugin.B11, 1);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Pink") | (args[0].equalsIgnoreCase("12"))) {
							if(p.hasPermission("HeadBanner.Banner.12")) {
								Banner b = ItemHandler.Banner.getBannerById("B12");
								if(!plugin.B12.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(12, p);
									Main.instance.addToBannerList(p, plugin.B12, 1);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Magenta") | (args[0].equalsIgnoreCase("13"))) {
							if(p.hasPermission("HeadBanner.Banner.13")) {
								Banner b = ItemHandler.Banner.getBannerById("B13");
								if(!plugin.B13.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(13, p);
									Main.instance.addToBannerList(p, plugin.B13, 1);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Silver") | (args[0].equalsIgnoreCase("14"))) {
							if(p.hasPermission("HeadBanner.Banner.14")) {
								Banner b = ItemHandler.Banner.getBannerById("B14");
								if(!plugin.B14.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(14, p);
									Main.instance.addToBannerList(p, plugin.B14, 1);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						/**
						 * Banners on Side 2
						 */
						if(args[0].equalsIgnoreCase("Deaths Head") | (args[0].equalsIgnoreCase("15"))) {
							if(p.hasPermission("HeadBanner.Banner.15")) {
								Banner b = ItemHandler.Banner.getBannerById("BP1");
								if(!plugin.BP1.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(15, p);
									Main.instance.addToBannerList(p, plugin.BP1, 2);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Watcher") | (args[0].equalsIgnoreCase("16"))) {
							if(p.hasPermission("HeadBanner.Banner.16")) {
								Banner b = ItemHandler.Banner.getBannerById("BP2");
								if(!plugin.BP2.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(16, p);
									Main.instance.addToBannerList(p, plugin.BP2, 2);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Star") | (args[0].equalsIgnoreCase("17"))) {
							if(p.hasPermission("HeadBanner.Banner.17")) {
								Banner b = ItemHandler.Banner.getBannerById("BP3");
								if(!plugin.BP3.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(17, p);
									Main.instance.addToBannerList(p, plugin.BP3, 2);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}	
							return true;
						}
						if(args[0].equalsIgnoreCase("Mojang") | (args[0].equalsIgnoreCase("18"))) {
							if(p.hasPermission("HeadBanner.Banner.18")) {
								Banner b = ItemHandler.Banner.getBannerById("BP4");
								if(!plugin.BP4.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(18, p);
									Main.instance.addToBannerList(p, plugin.BP4, 2);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Ocean Pearl") | (args[0].equalsIgnoreCase("19"))) {
							if(p.hasPermission("HeadBanner.Banner.19")) {
								Banner b = ItemHandler.Banner.getBannerById("BP5");
								if(!plugin.BP5.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(19, p);
									Main.instance.addToBannerList(p, plugin.BP6, 2);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Far Point") | (args[0].equalsIgnoreCase("20"))) {
							if(p.hasPermission("HeadBanner.Banner.20")) {
								Banner b = ItemHandler.Banner.getBannerById("BP6");
								if(!plugin.BP6.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(20, p);
									Main.instance.addToBannerList(p, plugin.BP6, 2);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Jail") | (args[0].equalsIgnoreCase("21"))) {
							if(p.hasPermission("HeadBanner.Banner.21")) {
								Banner b = ItemHandler.Banner.getBannerById("BP7");
								if(!plugin.BP7.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(21, p);
									Main.instance.addToBannerList(p, plugin.BP7, 2);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Broken Wall") | (args[0].equalsIgnoreCase("22"))) {
							if(p.hasPermission("HeadBanner.Banner.22")) {
								Banner b = ItemHandler.Banner.getBannerById("BP8");
								if(!plugin.BP8.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(22, p);
									Main.instance.addToBannerList(p, plugin.BP8, 2);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Light") | (args[0].equalsIgnoreCase("23"))) {
							if(p.hasPermission("HeadBanner.Banner.23")) {
								Banner b = ItemHandler.Banner.getBannerById("BP9");
								if(!plugin.BP9.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(23, p);
									Main.instance.addToBannerList(p, plugin.BP9, 2);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Cross") | (args[0].equalsIgnoreCase("24"))) {
							if(p.hasPermission("HeadBanner.Banner.24")) {
								Banner b = ItemHandler.Banner.getBannerById("BP10");
								if(!plugin.BP10.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(24, p);
									Main.instance.addToBannerList(p, plugin.BP10, 2);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Ghost Creeper") | (args[0].equalsIgnoreCase("25"))) {
							if(p.hasPermission("HeadBanner.Banner.25")) {
								Banner b = ItemHandler.Banner.getBannerById("BP11");
								if(!plugin.BP11.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(25, p);
									Main.instance.addToBannerList(p, plugin.BP11, 2);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;						
						}
						if(args[0].equalsIgnoreCase("Creeper") | (args[0].equalsIgnoreCase("26"))) {
							if(p.hasPermission("HeadBanner.Banner.26")) {
								Banner b = ItemHandler.Banner.getBannerById("BP12");
								if(!plugin.BP12.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(26, p);
									Main.instance.addToBannerList(p, plugin.BP12, 2);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Dark Outside") | (args[0].equalsIgnoreCase("27"))) {
							if(p.hasPermission("HeadBanner.Banner.27")) {
								Banner b = ItemHandler.Banner.getBannerById("BP13");
								if(!plugin.BP13.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(27, p);
									Main.instance.addToBannerList(p, plugin.BP13, 2);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Black and White") | (args[0].equalsIgnoreCase("28"))) {
							if(p.hasPermission("HeadBanner.Banner.28")) {
								Banner b = ItemHandler.Banner.getBannerById("BP14");
								if(!plugin.BP14.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(28, p);
									Main.instance.addToBannerList(p, plugin.BP14, 2);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						/**
						 * Banners on Side 3
						 */
						if(args[0].equalsIgnoreCase("Pokeball") | (args[0].equalsIgnoreCase("29"))) {
							if(p.hasPermission("HeadBanner.Banner.29")) {
								Banner b = ItemHandler.Banner.getBannerById("BA1");
								if(!plugin.BA1.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(29, p);
									Main.instance.addToBannerList(p, plugin.BA1, 3);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Panda") | (args[0].equalsIgnoreCase("30"))) {
							if(p.hasPermission("HeadBanner.Banner.30")) {
								Banner b = ItemHandler.Banner.getBannerById("BA2");
								if(!plugin.BA2.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(30, p);
									Main.instance.addToBannerList(p, plugin.BA2, 3);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Enderdragon") | (args[0].equalsIgnoreCase("31"))) {
							if(p.hasPermission("HeadBanner.Banner.31")) {
								Banner b = ItemHandler.Banner.getBannerById("BA3");
								if(!plugin.BA3.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(31, p);
									Main.instance.addToBannerList(p, plugin.BA3, 3);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Pineapple") | (args[0].equalsIgnoreCase("32"))) {
							if(p.hasPermission("HeadBanner.Banner.32")) {
								Banner b = ItemHandler.Banner.getBannerById("BA4");
								if(!plugin.BA4.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(32, p);
									Main.instance.addToBannerList(p, plugin.BA4, 3);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Villager") | (args[0].equalsIgnoreCase("33"))) {
							if(p.hasPermission("HeadBanner.Banner.33")) {
								Banner b = ItemHandler.Banner.getBannerById("BA5");
								if(!plugin.BA5.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(33, p);
									Main.instance.addToBannerList(p, plugin.BA5, 3);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Ship") | (args[0].equalsIgnoreCase("34"))) {
							if(p.hasPermission("HeadBanner.Banner.34")) {
								Banner b = ItemHandler.Banner.getBannerById("BA6");
								if(!plugin.BA6.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(34, p);
									Main.instance.addToBannerList(p, plugin.BA6, 3);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
						if(args[0].equalsIgnoreCase("Octopi") | (args[0].equalsIgnoreCase("35"))) {
							if(p.hasPermission("HeadBanner.Banner.35")) {
								Banner b = ItemHandler.Banner.getBannerById("BA7");
								if(!plugin.BA7.contains(p)) {
									p.getInventory().setHelmet(b.item);
									c.checkEffect(35, p);
									Main.instance.addToBannerList(p, plugin.BA7, 3);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								} else {
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", b.displayName));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
				} else {
					p.sendMessage(plugin.prefix + "§cThe plugin is not enabled!");
					return true;
				}
			}	
		} else {
			Bukkit.getConsoleSender().sendMessage(plugin.prefix + "§cUse can only use a command as a player!");
			return true;
		}
		return false;
	}

}
