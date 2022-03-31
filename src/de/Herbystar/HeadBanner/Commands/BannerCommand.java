package de.Herbystar.HeadBanner.Commands;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

import de.Herbystar.HeadBanner.Main;
import de.Herbystar.HeadBanner.Events.InventoryInteractEvents;

public class BannerCommand implements CommandExecutor {
	
	Main plugin;
	public BannerCommand(Main main) {
		plugin = main;
	}

	@SuppressWarnings("deprecation")
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
					//Banner clear
					if(args.length == 1) {
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
					}
					//Banners on 1 Side
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Black") | (args[0].equalsIgnoreCase("1"))) {
							if(p.hasPermission("HeadBanner.Banner.1")) {
								if(!plugin.B1.contains(p)) {
									ItemStack B1 = new ItemStack(Material.BANNER);
									BannerMeta B1M = (BannerMeta) B1.getItemMeta();
									B1M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.1").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B1M.setBaseColor(DyeColor.BLACK);
									B1.setItemMeta(B1M);
									p.getInventory().setHelmet(B1);
									c.checkEffect(1, p);
									plugin.B1.add(p);
									plugin.B14.remove(p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B1.getItemMeta().getDisplayName()));
								} else {
									ItemStack B1 = new ItemStack(Material.BANNER);
									BannerMeta B1M = (BannerMeta) B1.getItemMeta();
									B1M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.1").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B1M.setBaseColor(DyeColor.BLACK);
									B1.setItemMeta(B1M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B1.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("White") | (args[0].equalsIgnoreCase("2"))) {
							if(p.hasPermission("HeadBanner.Banner.2")) {
								if(!plugin.B2.contains(p)) {
									ItemStack B2 = new ItemStack(Material.BANNER);
									BannerMeta B2M = (BannerMeta) B2.getItemMeta();
									B2M.setBaseColor(DyeColor.WHITE);
									B2M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.2").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B2.setItemMeta(B2M);
									p.getInventory().setHelmet(B2);
									c.checkEffect(2, p);
									plugin.B2.add(p);
									plugin.B1.remove(p);
									plugin.B14.remove(p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B2.getItemMeta().getDisplayName()));
								} else {
									ItemStack B2 = new ItemStack(Material.BANNER);
									BannerMeta B2M = (BannerMeta) B2.getItemMeta();
									B2M.setBaseColor(DyeColor.WHITE);
									B2M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.2").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B2.setItemMeta(B2M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B2.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Gray") | (args[0].equalsIgnoreCase("3"))) {
							if(p.hasPermission("HeadBanner.Banner.3")) {
								if(!plugin.B3.contains(p)) {
									ItemStack B3 = new ItemStack(Material.BANNER);
									BannerMeta B3M = (BannerMeta) B3.getItemMeta();
									B3M.setBaseColor(DyeColor.GRAY);
									B3M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.3").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B3.setItemMeta(B3M);
									p.getInventory().setHelmet(B3);
									c.checkEffect(3, p);
									plugin.B3.add(p);
									plugin.B1.remove(p);
									plugin.B2.remove(p);
									plugin.B14.remove(p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B3.getItemMeta().getDisplayName()));
								} else {
									ItemStack B3 = new ItemStack(Material.BANNER);
									BannerMeta B3M = (BannerMeta) B3.getItemMeta();
									B3M.setBaseColor(DyeColor.GRAY);
									B3M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.3").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B3.setItemMeta(B3M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B3.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Blue") | (args[0].equalsIgnoreCase("4"))) {
							if(p.hasPermission("HeadBanner.Banner.4")) {
								if(!plugin.B4.contains(p)) {
									ItemStack B4 = new ItemStack(Material.BANNER);
									BannerMeta B4M = (BannerMeta) B4.getItemMeta();
									B4M.setBaseColor(DyeColor.BLUE);
									B4M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.4").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B4.setItemMeta(B4M);
									p.getInventory().setHelmet(B4);
									c.checkEffect(4, p);
									plugin.B4.add(p);
									plugin.B1.remove(p);
									plugin.B2.remove(p);
									plugin.B3.remove(p);
									plugin.B14.remove(p);
									plugin.B5.remove(p);
									plugin.B6.remove(p);
									plugin.B7.remove(p);
									plugin.B8.remove(p);
									plugin.B9.remove(p);
									plugin.B10.remove(p);
									plugin.B11.remove(p);
									plugin.B12.remove(p);
									plugin.B13.remove(p);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B4.getItemMeta().getDisplayName()));
								} else {
									ItemStack B4 = new ItemStack(Material.BANNER);
									BannerMeta B4M = (BannerMeta) B4.getItemMeta();
									B4M.setBaseColor(DyeColor.BLUE);
									B4M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.4").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B4.setItemMeta(B4M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B4.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}	
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Green") | (args[0].equalsIgnoreCase("5"))) {
							if(p.hasPermission("HeadBanner.Banner.5")) {
								if(!plugin.B5.contains(p)) {
									ItemStack B5 = new ItemStack(Material.BANNER);
									BannerMeta B5M = (BannerMeta) B5.getItemMeta();
									B5M.setBaseColor(DyeColor.GREEN);
									B5M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.5").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B5.setItemMeta(B5M);
									p.getInventory().setHelmet(B5);
									c.checkEffect(5, p);
									plugin.B5.add(p);
									plugin.B1.remove(p);
									plugin.B2.remove(p);
									plugin.B3.remove(p);
									plugin.B4.remove(p);
									plugin.B14.remove(p);
									plugin.B6.remove(p);
									plugin.B7.remove(p);
									plugin.B8.remove(p);
									plugin.B9.remove(p);
									plugin.B10.remove(p);
									plugin.B11.remove(p);
									plugin.B12.remove(p);
									plugin.B13.remove(p);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B5.getItemMeta().getDisplayName()));
								} else {
									ItemStack B5 = new ItemStack(Material.BANNER);
									BannerMeta B5M = (BannerMeta) B5.getItemMeta();
									B5M.setBaseColor(DyeColor.GREEN);
									B5M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.5").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B5.setItemMeta(B5M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B5.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Cyan") | (args[0].equalsIgnoreCase("6"))) {
							if(p.hasPermission("HeadBanner.Banner.6")) {
								if(!plugin.B6.contains(p)) {
									ItemStack B6 = new ItemStack(Material.BANNER);
									BannerMeta B6M = (BannerMeta) B6.getItemMeta();
									B6M.setBaseColor(DyeColor.CYAN);
									B6M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.6").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B6.setItemMeta(B6M);
									p.getInventory().setHelmet(B6);
									c.checkEffect(6, p);
									plugin.B6.add(p);
									plugin.B1.remove(p);
									plugin.B2.remove(p);
									plugin.B3.remove(p);
									plugin.B4.remove(p);
									plugin.B5.remove(p);
									plugin.B14.remove(p);
									plugin.B7.remove(p);
									plugin.B8.remove(p);
									plugin.B9.remove(p);
									plugin.B10.remove(p);
									plugin.B11.remove(p);
									plugin.B12.remove(p);
									plugin.B13.remove(p);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B6.getItemMeta().getDisplayName()));
								} else {
									ItemStack B6 = new ItemStack(Material.BANNER);
									BannerMeta B6M = (BannerMeta) B6.getItemMeta();
									B6M.setBaseColor(DyeColor.CYAN);
									B6M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.6").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B6.setItemMeta(B6M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B6.getItemMeta().getDisplayName()));
								}	
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Yellow") | (args[0].equalsIgnoreCase("7"))) {
							if(p.hasPermission("HeadBanner.Banner.7")) {
								if(!plugin.B7.contains(p)) {
									ItemStack B7 = new ItemStack(Material.BANNER);
									BannerMeta B7M = (BannerMeta) B7.getItemMeta();
									B7M.setBaseColor(DyeColor.YELLOW);
									B7M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.7").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B7.setItemMeta(B7M);
									p.getInventory().setHelmet(B7);
									c.checkEffect(7, p);
									plugin.B7.add(p);
									plugin.B1.remove(p);
									plugin.B2.remove(p);
									plugin.B3.remove(p);
									plugin.B4.remove(p);
									plugin.B5.remove(p);
									plugin.B6.remove(p);
									plugin.B14.remove(p);
									plugin.B8.remove(p);
									plugin.B9.remove(p);
									plugin.B10.remove(p);
									plugin.B11.remove(p);
									plugin.B12.remove(p);
									plugin.B13.remove(p);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B7.getItemMeta().getDisplayName()));
								} else {
									ItemStack B7 = new ItemStack(Material.BANNER);
									BannerMeta B7M = (BannerMeta) B7.getItemMeta();
									B7M.setBaseColor(DyeColor.YELLOW);
									B7M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.7").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B7.setItemMeta(B7M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B7.getItemMeta().getDisplayName()));
								}	
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Light Blue") | (args[0].equalsIgnoreCase("8"))) {
							if(p.hasPermission("HeadBanner.Banner.8")) {
								if(!plugin.B8.contains(p)) {
									ItemStack B8 = new ItemStack(Material.BANNER);
									BannerMeta B8M = (BannerMeta) B8.getItemMeta();
									B8M.setBaseColor(DyeColor.LIGHT_BLUE);
									B8M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.8").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B8.setItemMeta(B8M);
									p.getInventory().setHelmet(B8);
									c.checkEffect(8, p);
									plugin.B8.add(p);
									plugin.B1.remove(p);
									plugin.B2.remove(p);
									plugin.B3.remove(p);
									plugin.B4.remove(p);
									plugin.B5.remove(p);
									plugin.B6.remove(p);
									plugin.B7.remove(p);
									plugin.B14.remove(p);
									plugin.B9.remove(p);
									plugin.B10.remove(p);
									plugin.B11.remove(p);
									plugin.B12.remove(p);
									plugin.B13.remove(p);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B8.getItemMeta().getDisplayName()));
								} else {
									ItemStack B8 = new ItemStack(Material.BANNER);
									BannerMeta B8M = (BannerMeta) B8.getItemMeta();
									B8M.setBaseColor(DyeColor.LIGHT_BLUE);
									B8M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.8").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B8.setItemMeta(B8M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B8.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Red") | (args[0].equalsIgnoreCase("9"))) {
							if(p.hasPermission("HeadBanner.Banner.9")) {
								if(!plugin.B9.contains(p)) {
									ItemStack B9 = new ItemStack(Material.BANNER);
									BannerMeta B9M = (BannerMeta) B9.getItemMeta();
									B9M.setBaseColor(DyeColor.RED);
									B9M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.9").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B9.setItemMeta(B9M);
									p.getInventory().setHelmet(B9);
									c.checkEffect(9, p);
									plugin.B9.add(p);
									plugin.B1.remove(p);
									plugin.B2.remove(p);
									plugin.B3.remove(p);
									plugin.B4.remove(p);
									plugin.B5.remove(p);
									plugin.B6.remove(p);
									plugin.B7.remove(p);
									plugin.B8.remove(p);
									plugin.B14.remove(p);
									plugin.B10.remove(p);
									plugin.B11.remove(p);
									plugin.B12.remove(p);
									plugin.B13.remove(p);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B9.getItemMeta().getDisplayName()));
								} else {
									ItemStack B9 = new ItemStack(Material.BANNER);
									BannerMeta B9M = (BannerMeta) B9.getItemMeta();
									B9M.setBaseColor(DyeColor.RED);
									B9M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.9").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B9.setItemMeta(B9M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B9.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Lime") | (args[0].equalsIgnoreCase("10"))) {
							if(p.hasPermission("HeadBanner.Banner.10")) {
								if(!plugin.B10.contains(p)) {
									ItemStack B10 = new ItemStack(Material.BANNER);
									BannerMeta B10M = (BannerMeta) B10.getItemMeta();
									B10M.setBaseColor(DyeColor.LIME);
									B10M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.10").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B10.setItemMeta(B10M);
									p.getInventory().setHelmet(B10);
									c.checkEffect(10, p);
									plugin.B10.add(p);
									plugin.B1.remove(p);
									plugin.B2.remove(p);
									plugin.B3.remove(p);
									plugin.B4.remove(p);
									plugin.B5.remove(p);
									plugin.B6.remove(p);
									plugin.B7.remove(p);
									plugin.B8.remove(p);
									plugin.B9.remove(p);
									plugin.B14.remove(p);
									plugin.B11.remove(p);
									plugin.B12.remove(p);
									plugin.B13.remove(p);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B10.getItemMeta().getDisplayName()));
								} else {
									ItemStack B10 = new ItemStack(Material.BANNER);
									BannerMeta B10M = (BannerMeta) B10.getItemMeta();
									B10M.setBaseColor(DyeColor.LIME);
									B10M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.10").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B10.setItemMeta(B10M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B10.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Orange") | (args[0].equalsIgnoreCase("11"))) {
							if(p.hasPermission("HeadBanner.Banner.11")) {
								if(!plugin.B11.contains(p)) {
									ItemStack B11 = new ItemStack(Material.BANNER);
									BannerMeta B11M = (BannerMeta) B11.getItemMeta();
									B11M.setBaseColor(DyeColor.ORANGE);
									B11M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.11").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B11.setItemMeta(B11M);
									p.getInventory().setHelmet(B11);
									c.checkEffect(11, p);
									plugin.B11.add(p);
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
									plugin.B14.remove(p);
									plugin.B12.remove(p);
									plugin.B13.remove(p);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B11.getItemMeta().getDisplayName()));
								} else {
									ItemStack B11 = new ItemStack(Material.BANNER);
									BannerMeta B11M = (BannerMeta) B11.getItemMeta();
									B11M.setBaseColor(DyeColor.ORANGE);
									B11M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.11").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B11.setItemMeta(B11M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B11.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Pink") | (args[0].equalsIgnoreCase("12"))) {
							if(p.hasPermission("HeadBanner.Banner.12")) {
								if(!plugin.B12.contains(p)) {
									ItemStack B12 = new ItemStack(Material.BANNER);
									BannerMeta B12M = (BannerMeta) B12.getItemMeta();
									B12M.setBaseColor(DyeColor.PINK);
									B12M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.12").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B12.setItemMeta(B12M);
									p.getInventory().setHelmet(B12);
									c.checkEffect(12, p);
									plugin.B12.add(p);
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
									plugin.B13.remove(p);
									plugin.B14.remove(p);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B12.getItemMeta().getDisplayName()));
								} else {
									ItemStack B12 = new ItemStack(Material.BANNER);
									BannerMeta B12M = (BannerMeta) B12.getItemMeta();
									B12M.setBaseColor(DyeColor.PINK);
									B12M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.12").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B12.setItemMeta(B12M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B12.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Magenta") | (args[0].equalsIgnoreCase("13"))) {
							if(p.hasPermission("HeadBanner.Banner.13")) {
								if(!plugin.B13.contains(p)) {
									ItemStack B13 = new ItemStack(Material.BANNER);
									BannerMeta B13M = (BannerMeta) B13.getItemMeta();
									B13M.setBaseColor(DyeColor.MAGENTA);
									B13M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.13").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B13.setItemMeta(B13M);
									p.getInventory().setHelmet(B13);
									c.checkEffect(13, p);
									plugin.B13.add(p);
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
									plugin.B14.remove(p);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B13.getItemMeta().getDisplayName()));
								} else {
									ItemStack B13 = new ItemStack(Material.BANNER);
									BannerMeta B13M = (BannerMeta) B13.getItemMeta();
									B13M.setBaseColor(DyeColor.MAGENTA);
									B13M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.13").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B13.setItemMeta(B13M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B13.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Silver") | (args[0].equalsIgnoreCase("14"))) {
							if(p.hasPermission("HeadBanner.Banner.14")) {
								if(!plugin.B14.contains(p)) {
									ItemStack B14 = new ItemStack(Material.BANNER);
									BannerMeta B14M = (BannerMeta) B14.getItemMeta();
									B14M.setBaseColor(DyeColor.SILVER);
									B14M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.14").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B14.setItemMeta(B14M);
									p.getInventory().setHelmet(B14);
									c.checkEffect(14, p);
									plugin.B14.add(p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B14.getItemMeta().getDisplayName()));
								} else {
									ItemStack B14 = new ItemStack(Material.BANNER);
									BannerMeta B14M = (BannerMeta) B14.getItemMeta();
									B14M.setBaseColor(DyeColor.SILVER);
									B14M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.14").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									B14.setItemMeta(B14M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", B14.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					
					//Banners on 2 Side
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Deaths Head") | (args[0].equalsIgnoreCase("15"))) {
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
									c.checkEffect(15, p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP1.getItemMeta().getDisplayName()));
								} else {
									ItemStack BP1 = new ItemStack(Material.BANNER);
									BannerMeta BP1M = (BannerMeta) BP1.getItemMeta();
									BP1M.setBaseColor(DyeColor.WHITE);
									BP1M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.15").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP1M.addPattern(new Pattern(DyeColor.BLACK, PatternType.BORDER));
									BP1M.addPattern(new Pattern(DyeColor.BLACK, PatternType.SKULL));
									BP1.setItemMeta(BP1M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP1.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Watcher") | (args[0].equalsIgnoreCase("16"))) {
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
									c.checkEffect(16, p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP2.getItemMeta().getDisplayName()));
								} else {
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP2.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Star") | (args[0].equalsIgnoreCase("17"))) {
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
									c.checkEffect(17, p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP3.getItemMeta().getDisplayName()));
								} else {
									ItemStack BP3 = new ItemStack(Material.BANNER);
									BannerMeta BP3M = (BannerMeta) BP3.getItemMeta();
									BP3M.setBaseColor(DyeColor.LIME);
									BP3M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.17").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP3M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.RHOMBUS_MIDDLE));
									BP3M.addPattern(new Pattern(DyeColor.RED, PatternType.BORDER));
									BP3M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.FLOWER));
									BP3M.addPattern(new Pattern(DyeColor.RED, PatternType.CIRCLE_MIDDLE));
									BP3.setItemMeta(BP3M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP3.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}	
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Mojang") | (args[0].equalsIgnoreCase("18"))) {
							if(p.hasPermission("HeadBanner.Banner.18")) {
								if(!plugin.BP4.contains(p)) {
									ItemStack BP4 = new ItemStack(Material.BANNER);
									BannerMeta BP4M = (BannerMeta) BP4.getItemMeta();
									BP4M.setBaseColor(DyeColor.BROWN);
									BP4M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.18").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP4M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.MOJANG));
									BP4.setItemMeta(BP4M);
									p.getInventory().setHelmet(BP4);
									c.checkEffect(18, p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP4.getItemMeta().getDisplayName()));
								} else {
									ItemStack BP4 = new ItemStack(Material.BANNER);
									BannerMeta BP4M = (BannerMeta) BP4.getItemMeta();
									BP4M.setBaseColor(DyeColor.BROWN);
									BP4M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.18").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP4M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.MOJANG));
									BP4.setItemMeta(BP4M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP4.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Ocean Pearl") | (args[0].equalsIgnoreCase("19"))) {
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
									c.checkEffect(19, p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP5.getItemMeta().getDisplayName()));
								} else {
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP5.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Far Point") | (args[0].equalsIgnoreCase("20"))) {
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
									c.checkEffect(20, p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP6.getItemMeta().getDisplayName()));
								} else {
									ItemStack BP6 = new ItemStack(Material.BANNER);
									BannerMeta BP6M = (BannerMeta) BP6.getItemMeta();
									BP6M.setBaseColor(DyeColor.BLACK);
									BP6M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.20").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP6M.addPattern(new Pattern(DyeColor.ORANGE, PatternType.TRIANGLE_BOTTOM));
									BP6M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.RHOMBUS_MIDDLE));
									BP6M.addPattern(new Pattern(DyeColor.RED, PatternType.BORDER));
									BP6M.addPattern(new Pattern(DyeColor.RED, PatternType.TRIANGLES_TOP));
									BP6.setItemMeta(BP6M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP6.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Jail") | (args[0].equalsIgnoreCase("21"))) {
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
									c.checkEffect(21, p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP7.getItemMeta().getDisplayName()));
								} else {
									ItemStack BP7 = new ItemStack(Material.BANNER);
									BannerMeta BP7M = (BannerMeta) BP7.getItemMeta();
									BP7M.setBaseColor(DyeColor.BLACK);
									BP7M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.21").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP7M.addPattern(new Pattern(DyeColor.GRAY, PatternType.BORDER));
									BP7M.addPattern(new Pattern(DyeColor.GRAY, PatternType.STRIPE_CENTER));
									BP7M.addPattern(new Pattern(DyeColor.RED, PatternType.SKULL));
									BP7.setItemMeta(BP7M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP7.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Broken Wall") | (args[0].equalsIgnoreCase("22"))) {
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
									c.checkEffect(22, p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP8.getItemMeta().getDisplayName()));
								} else {
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP8.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Light") | (args[0].equalsIgnoreCase("23"))) {
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
									c.checkEffect(23, p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP9.getItemMeta().getDisplayName()));
								} else {
									ItemStack BP9 = new ItemStack(Material.BANNER);
									BannerMeta BP9M = (BannerMeta) BP9.getItemMeta();
									BP9M.setBaseColor(DyeColor.BLACK);
									BP9M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.23").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP9M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.CROSS));
									BP9M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.STRAIGHT_CROSS));
									BP9M.addPattern(new Pattern(DyeColor.RED, PatternType.CURLY_BORDER));
									BP9.setItemMeta(BP9M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP9.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Cross") | (args[0].equalsIgnoreCase("24"))) {
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
									c.checkEffect(24, p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP10.getItemMeta().getDisplayName()));
								} else {
									ItemStack BP10 = new ItemStack(Material.BANNER);
									BannerMeta BP10M = (BannerMeta) BP10.getItemMeta();
									BP10M.setBaseColor(DyeColor.BLACK);
									BP10M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.24").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP10M.addPattern(new Pattern(DyeColor.RED, PatternType.CROSS));
									BP10M.addPattern(new Pattern(DyeColor.RED, PatternType.BORDER));
									BP10.setItemMeta(BP10M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP10.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Ghost Creeper") | (args[0].equalsIgnoreCase("25"))) {
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
									c.checkEffect(25, p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP11.getItemMeta().getDisplayName()));
								} else {
									ItemStack BP11 = new ItemStack(Material.BANNER);
									BannerMeta BP11M = (BannerMeta) BP11.getItemMeta();
									BP11M.setBaseColor(DyeColor.BLACK);
									BP11M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.25").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP11M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.CREEPER));
									BP11M.addPattern(new Pattern(DyeColor.LIME, PatternType.GRADIENT_UP));
									BP11.setItemMeta(BP11M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP11.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;						
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Creeper") | (args[0].equalsIgnoreCase("26"))) {
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
									c.checkEffect(26, p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP12.getItemMeta().getDisplayName()));
								} else {
									ItemStack BP12 = new ItemStack(Material.BANNER);
									BannerMeta BP12M = (BannerMeta) BP12.getItemMeta();
									BP12M.setBaseColor(DyeColor.YELLOW);
									BP12M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.26").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP12M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.BORDER));
									BP12M.addPattern(new Pattern(DyeColor.LIME, PatternType.CREEPER));
									BP12M.addPattern(new Pattern(DyeColor.LIME, PatternType.CREEPER));
									BP12.setItemMeta(BP12M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP12.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Dark Outside") | (args[0].equalsIgnoreCase("27"))) {
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
									c.checkEffect(27, p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP13.getItemMeta().getDisplayName()));
								} else {
									ItemStack BP13 = new ItemStack(Material.BANNER);
									BannerMeta BP13M = (BannerMeta) BP13.getItemMeta();
									BP13M.setBaseColor(DyeColor.BLACK);
									BP13M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.27").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP13M.addPattern(new Pattern(DyeColor.RED, PatternType.BRICKS));
									BP13M.addPattern(new Pattern(DyeColor.CYAN, PatternType.GRADIENT_UP));
									BP13M.addPattern(new Pattern(DyeColor.ORANGE, PatternType.GRADIENT));
									BP13M.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
									BP13.setItemMeta(BP13M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP13.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Black and White") | (args[0].equalsIgnoreCase("28"))) {
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
									c.checkEffect(28, p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP14.getItemMeta().getDisplayName()));
								} else {
									ItemStack BP14 = new ItemStack(Material.BANNER);
									BannerMeta BP14M = (BannerMeta) BP14.getItemMeta();
									BP14M.setBaseColor(DyeColor.WHITE);
									BP14M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.28").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
									BP14M.addPattern(new Pattern(DyeColor.BLACK, PatternType.GRADIENT));
									BP14M.addPattern(new Pattern(DyeColor.BLACK, PatternType.CROSS));
									BP14M.addPattern(new Pattern(DyeColor.BLACK, PatternType.CURLY_BORDER));
									BP14.setItemMeta(BP14M);
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BP14.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					//Banner Side 3
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Pokeball") | (args[0].equalsIgnoreCase("29"))) {
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
									c.checkEffect(29, p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BA1.getItemMeta().getDisplayName()));
								} else {
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BA1.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Panda") | (args[0].equalsIgnoreCase("30"))) {
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
									c.checkEffect(30, p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BA2.getItemMeta().getDisplayName()));
								} else {
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BA2.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Enderdragon") | (args[0].equalsIgnoreCase("31"))) {
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
									c.checkEffect(31, p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BA3.getItemMeta().getDisplayName()));
								} else {
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BA3.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Pineapple") | (args[0].equalsIgnoreCase("32"))) {
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
									c.checkEffect(32, p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BA4.getItemMeta().getDisplayName()));
								} else {
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BA4.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Villager") | (args[0].equalsIgnoreCase("33"))) {
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
									c.checkEffect(33, p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BA5.getItemMeta().getDisplayName()));
								} else {
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BA5.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Ship") | (args[0].equalsIgnoreCase("34"))) {
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
									c.checkEffect(34, p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BA6.getItemMeta().getDisplayName()));
								} else {
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BA6.getItemMeta().getDisplayName()));
								}
							} else {
								p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.NoPermMessage").replace("&", "§"));
							}
							return true;
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Octopi") | (args[0].equalsIgnoreCase("35"))) {
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
									c.checkEffect(35, p);
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageNewBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BA7.getItemMeta().getDisplayName()));
								} else {
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
									p.sendMessage(plugin.prefix + plugin.getConfig().getString("HeadBanner.HeadBannerSelectMessage.MessageTheSameBanner").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä").replace("[ITEM]", BA7.getItemMeta().getDisplayName()));
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
