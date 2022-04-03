package de.Herbystar.HeadBanner.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import de.Herbystar.HeadBanner.Main;
import de.Herbystar.HeadBanner.Utilities.ItemHandler;

public class Commands implements CommandExecutor {
	
	Main plugin;
	public Commands(Main main) {
		plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			final Player p = (Player) sender;
			
			if(cmd.getName().equalsIgnoreCase("BannerItem") | (cmd.getName().equalsIgnoreCase("BI"))) {
				if(plugin.getConfig().getBoolean("HeadBanner.Enabled") == true) {
					if(p.hasPermission("HeadBanner.Item.Cmd") | p.isOp()) {
						ItemHandler.createJoinItem(p, true);
						return true;
					} else {
						p.sendMessage(plugin.prefix + plugin.replaceString(plugin.getConfig().getString("HeadBanner.NoPermMessage")));
						return true;
					}
				} else {
					p.sendMessage(plugin.prefix + "§cThe plugin is not enabled!");
					return true;
				}
			}
			
			//Cmd to enable/disable the plugin
			if(cmd.getName().equalsIgnoreCase("HeadBanner")) {
				if(p.hasPermission("HeadBanner.toggle") | p.isOp()) {
					if(args.length == 0) {
						p.sendMessage(plugin.prefix + "§aUse §e/HeadBanner reload §aor §e/HeadBanner toggle §ato reload the configuration or enable/disable the plugin!");
						return true;
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Toggle")) {
							if(plugin.getConfig().getBoolean("HeadBanner.Enabled") == true) {
								plugin.getConfig().set("HeadBanner.Enabled", false);
								plugin.saveConfig();
								p.sendMessage(plugin.prefix + "§ePlugin §cdisabled!");
								return true;
							} else {
								plugin.getConfig().set("HeadBanner.Enabled", true);
								plugin.saveConfig();
								p.sendMessage(plugin.prefix + "§ePlugin §aenabled!");
								return true;
							}
						}
					}
					if(args.length == 1) {
						if(args[0].equalsIgnoreCase("Reload")) {
							plugin.reloadConfig();
							p.sendMessage(plugin.prefix + "§aConfiguration reloaded!");
							return true;
						}
					}
				}
			}
			
			//Banner Rotate Command
			if(cmd.getName().equalsIgnoreCase("BannerRotate")) {
				if(plugin.getConfig().getBoolean("HeadBanner.Enabled") == true) {
					if(p.hasPermission("HeadBanner.Rotate")) {
						if(!plugin.RB.contains(p.getName())) {
							if(args.length == 0) {
								p.sendMessage(plugin.prefix + "§aUse §e/BannerRotate <1-2> §ato rotate through the Banners of the first and second side!");
								return true;
							}
							if(args.length == 1) {
								if(args[0].equalsIgnoreCase("1")) {
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
									p.sendMessage(plugin.prefix + plugin.replaceString(plugin.getConfig().getString("HeadBanner.RotateEnabled")));
									return true;
								}
								if(args[0].equalsIgnoreCase("2")) {
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
									p.sendMessage(plugin.prefix + plugin.replaceString(plugin.getConfig().getString("HeadBanner.RotateEnabled")));
									return true;
								}
								
								if(args[0].equalsIgnoreCase("3")) {
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
									p.sendMessage(plugin.prefix + plugin.replaceString(plugin.getConfig().getString("HeadBanner.RotateEnabled")));
									return true;
								}
							}											
						} else {
							if(p.getInventory().getHelmet() != null) {
								if(p.getInventory().getHelmet().getType().toString().contains("BANNER")) {
									p.getInventory().setHelmet(null);
								}
							}
							p.sendMessage(plugin.prefix + plugin.replaceString(plugin.getConfig().getString("HeadBanner.RotateDisabled")));
							Bukkit.getScheduler().cancelTask(plugin.rotateid);
							plugin.RB.remove(p.getName());
							plugin.rotate = 15;					
							return true;
						}			
					} else {
						p.sendMessage(plugin.prefix + plugin.replaceString(plugin.getConfig().getString("HeadBanner.NoPermMessage")));
						return true;
					}
				} else {
					p.sendMessage(plugin.prefix + "§cThe plugin is not enabled!");
					return true;
				}
			}
			
			if(cmd.getName().equalsIgnoreCase("Banners")) {
				if(plugin.getConfig().getBoolean("HeadBanner.Enabled") == true) {
					if(p.hasPermission("HeadBanner.Item.Open") | p.isOp()) {
						p.openInventory(ItemHandler.getInventoryPageOne());
						return true;
					} else {
						p.sendMessage(plugin.prefix + plugin.replaceString(plugin.getConfig().getString("HeadBanner.NoPermMessage")));
						return true;
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
