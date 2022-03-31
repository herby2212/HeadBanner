package de.Herbystar.HeadBanner.Events;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;

import de.Herbystar.HeadBanner.Main;

public class PlayerInteractEvents implements Listener {
	
	Main plugin;
	public PlayerInteractEvents(Main main) {
		plugin = main;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onHBII(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(plugin.getConfig().getBoolean("HeadBanner.Enabled") == true) {
	    	if(plugin.getConfig().getStringList("HeadBanner.Worlds").contains(p.getWorld().getName())) {
				if((((e.getAction() == Action.RIGHT_CLICK_AIR ? 1 : 0) | (e.getAction() == Action.RIGHT_CLICK_BLOCK ? 1 : 0)) != 0)) {
					if(e.getItem() != null) {
						if(e.getMaterial().equals(Material.SKULL_ITEM)) {
							if(e.getItem().hasItemMeta() && e.getItem().getItemMeta().getDisplayName() != null) {
								if(e.getItem().hasItemMeta() && e.getItem().getItemMeta().getDisplayName().equals(plugin.getConfig().getString("HeadBanner.JoinItem.Name").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"))) {
									e.setCancelled(true);
									if(p.hasPermission("HeadBanner.Item.Open") | p.isOp()) {
										plugin.inv = p.getPlayer().getServer().createInventory(null, plugin.getConfig().getInt("HeadBanner.InventorySize.1"), plugin.getConfig().getString("HeadBanner.BannerInventory.Side1Title").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
										
										ItemStack B1 = new ItemStack(Material.BANNER);
										BannerMeta B1M = (BannerMeta) B1.getItemMeta();
										B1M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.1").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
										B1M.setBaseColor(DyeColor.BLACK);
										B1.setItemMeta(B1M);
										
										ItemStack B2 = new ItemStack(Material.BANNER);
										BannerMeta B2M = (BannerMeta) B2.getItemMeta();
										B2M.setBaseColor(DyeColor.WHITE);
										B2M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.2").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
										B2.setItemMeta(B2M);
										
										ItemStack B3 = new ItemStack(Material.BANNER);
										BannerMeta B3M = (BannerMeta) B3.getItemMeta();
										B3M.setBaseColor(DyeColor.GRAY);
										B3M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.3").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
										B3.setItemMeta(B3M);
										
										ItemStack B4 = new ItemStack(Material.BANNER);
										BannerMeta B4M = (BannerMeta) B4.getItemMeta();
										B4M.setBaseColor(DyeColor.BLUE);
										B4M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.4").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
										B4.setItemMeta(B4M);
										
										ItemStack B5 = new ItemStack(Material.BANNER);
										BannerMeta B5M = (BannerMeta) B5.getItemMeta();
										B5M.setBaseColor(DyeColor.GREEN);
										B5M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.5").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
										B5.setItemMeta(B5M);
										
										ItemStack B6 = new ItemStack(Material.BANNER);
										BannerMeta B6M = (BannerMeta) B4.getItemMeta();
										B6M.setBaseColor(DyeColor.CYAN);
										B6M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.6").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
										B6.setItemMeta(B6M);
										
										ItemStack B7 = new ItemStack(Material.BANNER);
										BannerMeta B7M = (BannerMeta) B7.getItemMeta();
										B7M.setBaseColor(DyeColor.YELLOW);
										B7M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.7").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
										B7.setItemMeta(B7M);
										
										ItemStack B8 = new ItemStack(Material.BANNER);
										BannerMeta B8M = (BannerMeta) B8.getItemMeta();
										B8M.setBaseColor(DyeColor.LIGHT_BLUE);
										B8M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.8").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
										B8.setItemMeta(B8M);
										
										ItemStack B9 = new ItemStack(Material.BANNER);
										BannerMeta B9M = (BannerMeta) B9.getItemMeta();
										B9M.setBaseColor(DyeColor.RED);
										B9M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.9").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
										B9.setItemMeta(B9M);
										
										ItemStack B10 = new ItemStack(Material.BANNER);
										BannerMeta B10M = (BannerMeta) B10.getItemMeta();
										B10M.setBaseColor(DyeColor.LIME);
										B10M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.10").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
										B10.setItemMeta(B10M);
										
										ItemStack B11 = new ItemStack(Material.BANNER);
										BannerMeta B11M = (BannerMeta) B11.getItemMeta();
										B11M.setBaseColor(DyeColor.ORANGE);
										B11M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.11").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
										B11.setItemMeta(B11M);
										
										ItemStack B12 = new ItemStack(Material.BANNER);
										BannerMeta B12M = (BannerMeta) B12.getItemMeta();
										B12M.setBaseColor(DyeColor.PINK);
										B12M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.12").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
										B12.setItemMeta(B12M);
										
										ItemStack B13 = new ItemStack(Material.BANNER);
										BannerMeta B13M = (BannerMeta) B13.getItemMeta();
										B13M.setBaseColor(DyeColor.MAGENTA);
										B13M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.13").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
										B13.setItemMeta(B13M);
										
										ItemStack B14 = new ItemStack(Material.BANNER);
										BannerMeta B14M = (BannerMeta) B14.getItemMeta();
										B14M.setBaseColor(DyeColor.SILVER);
										B14M.setDisplayName(plugin.getConfig().getString("HeadBanner.BannerDisplayNames.14").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
										B14.setItemMeta(B14M);
										
										
										ItemStack E = new ItemStack(Material.BARRIER);
										ItemMeta EM = E.getItemMeta();
										EM.setDisplayName(plugin.getConfig().getString("HeadBanner.GUI.ClearHeadItemName").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
										E.setItemMeta(EM);
										
										ItemStack C = new ItemStack(Material.SLIME_BALL);
										ItemMeta CM = C.getItemMeta();
										CM.setDisplayName(plugin.getConfig().getString("HeadBanner.GUI.CloseItemName").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
										C.setItemMeta(CM);
										
										ItemStack N = new ItemStack(Material.MAGMA_CREAM);
										ItemMeta NM = N.getItemMeta();
										NM.setDisplayName(plugin.getConfig().getString("HeadBanner.GUI.NextSide").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
										N.setItemMeta(NM);
										
										ItemStack R = new ItemStack(Material.ARMOR_STAND);
										ItemMeta RM = R.getItemMeta();
										RM.setDisplayName(plugin.getConfig().getString("HeadBanner.GUI.RotateItemName").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
										R.setItemMeta(RM);
										
										//1 Reihe
										if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.1") == false) {
											plugin.inv.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.1"), B1);
										}
										if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.2") == false) {
											plugin.inv.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.2"), B2);
										}
										if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.3") == false) {
											plugin.inv.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.3"), B3);
										}
										if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.4") == false) {
											plugin.inv.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.4"), B4);
										}
										if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.5") == false) {
											plugin.inv.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.5"), B5);
										}
										if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.6") == false) {
											plugin.inv.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.6"), B6);
										}
										if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.7") == false) {
											plugin.inv.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.7"), B7);
										}
										
										//2 Reihe
										if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.8") == false) {
											plugin.inv.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.8"), B8);
										}
										if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.9") == false) {
											plugin.inv.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.9"), B9);
										}
										if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.10") == false) {
											plugin.inv.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.10"), B10);
										}
										if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.11") == false) {
											plugin.inv.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.11"), B11);
										}
										if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.12") == false) {
											plugin.inv.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.12"), B12);
										}
										if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.13") == false) {
											plugin.inv.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.13"), B13);
										}
										if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.14") == false) {
											plugin.inv.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.14"), B14);
										}
										
										
										if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.RotateItem") == false) {
											plugin.inv.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.RotateItem1"), R);
										}
										if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.ClearHeadItem") == false) {
											plugin.inv.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.ClearHeadItem1"), E);
										}
										if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.CloseItem") == false) {
											plugin.inv.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.CloseItem1"), C);
										}
										if(plugin.getConfig().getBoolean("HeadBanner.FreeSlot.NextSide") == false) {
											plugin.inv.setItem(plugin.getConfig().getInt("HeadBanner.ItemSlot.NextSide1"), N);
										}
										p.openInventory(plugin.inv);
									}
								}
							}
						}
					}			
				}
	    	}
		}
	}

}
