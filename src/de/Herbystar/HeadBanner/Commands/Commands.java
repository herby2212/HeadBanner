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
			/*
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
												ItemStack R1 = new ItemStack(Material.BANNER);
												BannerMeta R1M = (BannerMeta) R1.getItemMeta();
												R1M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.1")));
												R1M.setBaseColor(DyeColor.BLACK);
												R1.setItemMeta(R1M);
												p.getInventory().setHelmet(R1);
											}						
											if(plugin.rotate == 13) {
												ItemStack B2 = new ItemStack(Material.BANNER);
												BannerMeta B2M = (BannerMeta) B2.getItemMeta();
												B2M.setBaseColor(DyeColor.WHITE);
												B2M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.2")));
												B2.setItemMeta(B2M);
												p.getInventory().setHelmet(B2);							
											}
											if(plugin.rotate == 12) {
												ItemStack B3 = new ItemStack(Material.BANNER);
												BannerMeta B3M = (BannerMeta) B3.getItemMeta();
												B3M.setBaseColor(DyeColor.GRAY);
												B3M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.3")));
												B3.setItemMeta(B3M);
												p.getInventory().setHelmet(B3);
											}
											if(plugin.rotate == 11) {
												ItemStack B4 = new ItemStack(Material.BANNER);
												BannerMeta B4M = (BannerMeta) B4.getItemMeta();
												B4M.setBaseColor(DyeColor.BLUE);
												B4M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.4")));
												B4.setItemMeta(B4M);
												p.getInventory().setHelmet(B4);		
											}
											if(plugin.rotate == 10) {
												ItemStack B5 = new ItemStack(Material.BANNER);
												BannerMeta B5M = (BannerMeta) B5.getItemMeta();
												B5M.setBaseColor(DyeColor.GREEN);
												B5M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.5")));
												B5.setItemMeta(B5M);
												p.getInventory().setHelmet(B5);
											}
											if(plugin.rotate == 9) {
												ItemStack B6 = new ItemStack(Material.BANNER);
												BannerMeta B6M = (BannerMeta) B6.getItemMeta();
												B6M.setBaseColor(DyeColor.CYAN);
												B6M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.6")));
												B6.setItemMeta(B6M);
												p.getInventory().setHelmet(B6);
											}
											if(plugin.rotate == 8) {
												ItemStack B7 = new ItemStack(Material.BANNER);
												BannerMeta B7M = (BannerMeta) B7.getItemMeta();
												B7M.setBaseColor(DyeColor.YELLOW);
												B7M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.7")));
												B7.setItemMeta(B7M);
												p.getInventory().setHelmet(B7);	
											}
											if(plugin.rotate == 7) {
												ItemStack B8 = new ItemStack(Material.BANNER);
												BannerMeta B8M = (BannerMeta) B8.getItemMeta();
												B8M.setBaseColor(DyeColor.LIGHT_BLUE);
												B8M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.8")));
												B8.setItemMeta(B8M);
												p.getInventory().setHelmet(B8);	
											}
											if(plugin.rotate == 6) {
												ItemStack B9 = new ItemStack(Material.BANNER);
												BannerMeta B9M = (BannerMeta) B9.getItemMeta();
												B9M.setBaseColor(DyeColor.RED);
												B9M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.9")));
												B9.setItemMeta(B9M);
												p.getInventory().setHelmet(B9);	
											}
											if(plugin.rotate == 5) {
												ItemStack B10 = new ItemStack(Material.BANNER);
												BannerMeta B10M = (BannerMeta) B10.getItemMeta();
												B10M.setBaseColor(DyeColor.LIME);
												B10M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.10")));
												B10.setItemMeta(B10M);
												p.getInventory().setHelmet(B10);
											}
											if(plugin.rotate == 4) {
												ItemStack B11 = new ItemStack(Material.BANNER);
												BannerMeta B11M = (BannerMeta) B11.getItemMeta();
												B11M.setBaseColor(DyeColor.ORANGE);
												B11M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.11")));
												B11.setItemMeta(B11M);
												p.getInventory().setHelmet(B11);	
											}
											if(plugin.rotate == 3) {
												ItemStack B12 = new ItemStack(Material.BANNER);
												BannerMeta B12M = (BannerMeta) B12.getItemMeta();
												B12M.setBaseColor(DyeColor.PINK);
												B12M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.12")));
												B12.setItemMeta(B12M);
												p.getInventory().setHelmet(B12);	
											}
											if(plugin.rotate == 2) {
												ItemStack B13 = new ItemStack(Material.BANNER);
												BannerMeta B13M = (BannerMeta) B13.getItemMeta();
												B13M.setBaseColor(DyeColor.MAGENTA);
												B13M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.13")));
												B13.setItemMeta(B13M);
												p.getInventory().setHelmet(B13);	
											}
											if(plugin.rotate == 1) {
												ItemStack B14 = new ItemStack(Material.BANNER);
												BannerMeta B14M = (BannerMeta) B14.getItemMeta();
												B14M.setBaseColor(DyeColor.SILVER);
												B14M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.14")));
												B14.setItemMeta(B14M);
												p.getInventory().setHelmet(B14);
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
												ItemStack BP1 = new ItemStack(Material.BANNER);
												BannerMeta BP1M = (BannerMeta) BP1.getItemMeta();
												BP1M.setBaseColor(DyeColor.WHITE);
												BP1M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.15")));
												BP1M.addPattern(new Pattern(DyeColor.BLACK, PatternType.BORDER));
												BP1M.addPattern(new Pattern(DyeColor.BLACK, PatternType.SKULL));
												BP1.setItemMeta(BP1M);
												p.getInventory().setHelmet(BP1);
											}						
											if(plugin.rotate == 13) {
												ItemStack BP2 = new ItemStack(Material.BANNER);
												BannerMeta BP2M = (BannerMeta) BP2.getItemMeta();
												BP2M.setBaseColor(DyeColor.BLACK);
												BP2M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.16")));
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
												BP3M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.17")));
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
												BP4M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.18")));
												BP4M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.MOJANG));
												BP4.setItemMeta(BP4M);
												p.getInventory().setHelmet(BP4);	
											}
											if(plugin.rotate == 10) {
												ItemStack BP5 = new ItemStack(Material.BANNER);
												BannerMeta BP5M = (BannerMeta) BP5.getItemMeta();
												BP5M.setBaseColor(DyeColor.BLUE);
												BP5M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.19")));
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
												BP6M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.20")));
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
												BP7M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.21")));
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
												BP8M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.22")));
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
												BP9M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.23")));
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
												BP10M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.24")));
												BP10M.addPattern(new Pattern(DyeColor.RED, PatternType.CROSS));
												BP10M.addPattern(new Pattern(DyeColor.RED, PatternType.BORDER));
												BP10.setItemMeta(BP10M);
												p.getInventory().setHelmet(BP10);
											}
											if(plugin.rotate == 4) {
												ItemStack BP11 = new ItemStack(Material.BANNER);
												BannerMeta BP11M = (BannerMeta) BP11.getItemMeta();
												BP11M.setBaseColor(DyeColor.BLACK);
												BP11M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.25")));
												BP11M.addPattern(new Pattern(DyeColor.YELLOW, PatternType.CREEPER));
												BP11M.addPattern(new Pattern(DyeColor.LIME, PatternType.GRADIENT_UP));
												BP11.setItemMeta(BP11M);
												p.getInventory().setHelmet(BP11);	
											}
											if(plugin.rotate == 3) {
												ItemStack BP12 = new ItemStack(Material.BANNER);
												BannerMeta BP12M = (BannerMeta) BP12.getItemMeta();
												BP12M.setBaseColor(DyeColor.YELLOW);
												BP12M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.26")));
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
												BP13M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.27")));
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
												BP14M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.28")));
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
												ItemStack BA1 = new ItemStack(Material.BANNER);
												BannerMeta BA1M = (BannerMeta) BA1.getItemMeta();
												BA1M.setBaseColor(DyeColor.RED);
												BA1M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.29")));
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
												BA2M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.30")));
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
												BA3M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.31")));
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
												BA4M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.32")));
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
												BA5M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.33")));
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
												BA6M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.34")));
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
												BA7M.setDisplayName(plugin.replaceString(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.35")));
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
									p.sendMessage(plugin.prefix + plugin.replaceString(plugin.getConfig().getString("HeadBanner.RotateEnabled")));
									return true;
								}
							}											
						} else {
							if(p.getInventory().getHelmet() != null) {
								if(p.getInventory().getHelmet().getType().equals(Material.BANNER)) {
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
			*/
			
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
