package de.Herbystar.HeadBanner.Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import de.Herbystar.HeadBanner.Main;

public class ItemHandler {
	
	public static class ToggleItem {
		String configPath = "";
		String material = "";

		public ToggleItem(String mat, String confPath) {
			this.configPath = confPath;
			this.material = mat;
		}
	}
	
	public static class Banner {
		public ItemStack item;
		public String id;
		
		public Banner(String id, String displayName, DyeColor baseColor) {
			this.id = id;
			this.item = createBanner(displayName, baseColor);
			
			bannerCollection.add(this);
		}
		
		public static Banner getBannerById(String id) {
			for(Banner b : bannerCollection) {
				if(b.id.equals(id)) {
					return b;
				}
			}
			return null;
		}
	}
	
	public static List<Banner> bannerCollection = new ArrayList<Banner>();
	
	//Normal Switch Items
	private static ToggleItem ti1;
	private static ToggleItem ti2;
	
	//Inventory Items
	private static ToggleItem tiIV1;
	private static ToggleItem tiIV2;
	private static ToggleItem tiIV3;
	private static ToggleItem tiIVF;
	
	@SuppressWarnings("deprecation")
	public static void createJoinItem(Player player, boolean setItem) {
		if(player == null) {
			return;
		}
		
		ItemStack HB = XMaterial.PLAYER_HEAD.parseItem();
	    SkullMeta HBM = (SkullMeta)Bukkit.getItemFactory().getItemMeta(XMaterial.PLAYER_HEAD.parseMaterial());
	    try {
		    HBM.setOwningPlayer(player);
	    } catch(NoSuchMethodError ex) {
	    	HBM.setOwner(player.getDisplayName());
	    }
	    HBM.setDisplayName(Main.instance.replaceString(Main.instance.getConfig().getString("HeadBanner.JoinItem.Name")));
	    HBM.setLore(Arrays.asList(Main.instance.replaceString(Main.instance.replaceString(Main.instance.getConfig().getString("HeadBanner.JoinItem.Lore")))));
	    HB.setItemMeta(HBM);
		
	    if(setItem == true) {
		    //Check if Slot is already taken
		    if(player.getInventory().getItem(Main.instance.getConfig().getInt("HeadBanner.JoinItem.Slot(0-8)")) == null) {
		    	player.getInventory().setItem(Main.instance.getConfig().getInt("HeadBanner.JoinItem.Slot(0-8)"), HB);
		    } else {
		    	player.getInventory().addItem(HB);
		    }
	    } else {
	    	if(player.getInventory().contains(HB.getType())) {
	    		player.getInventory().remove(HB.getType());
	    		player.updateInventory();
		    }
	    }
	}
	
	@SuppressWarnings("deprecation")
	private static ItemStack createBanner(String displayName, DyeColor baseColor) {
		ItemStack b = new ItemStack(XMaterial.matchXMaterial("BANNER").get().parseMaterial());
		BannerMeta bm = (BannerMeta) b.getItemMeta();
		bm.setDisplayName(Main.instance.replaceString(displayName));
		bm.setBaseColor(baseColor);
		b.setItemMeta(bm);
		
		return b;
	}
	
	public static Inventory getInventoryPageOne() {
		if(Main.instance.inv != null) {
			return Main.instance.inv;
		}
		Inventory i = Bukkit.getServer().createInventory(null, Main.instance.getConfig().getInt("HeadBanner.InventorySize.1"), 
				Main.instance.replaceString(Main.instance.getConfig().getString("HeadBanner.BannerInventory.Side1Title")));
		
		ItemStack B1 = new Banner("B1", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.1"), DyeColor.BLACK).item;
		ItemStack B2 = new Banner("B2", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.2"), DyeColor.WHITE).item;
		ItemStack B3 = new Banner("B3", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.3"), DyeColor.GRAY).item;
		ItemStack B4 = new Banner("B4", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.4"), DyeColor.BLUE).item;
		ItemStack B5 = new Banner("B5", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.5"), DyeColor.GREEN).item;
		ItemStack B6 = new Banner("B6", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.6"), DyeColor.CYAN).item;
		ItemStack B7 = new Banner("B7", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.7"), DyeColor.YELLOW).item;
		ItemStack B8 = new Banner("B8", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.8"), DyeColor.LIGHT_BLUE).item;
		ItemStack B9 = new Banner("B9", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.9"), DyeColor.RED).item;
		ItemStack B10 = new Banner("B10", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.10"), DyeColor.LIME).item;
		ItemStack B11 = new Banner("B11", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.11"), DyeColor.ORANGE).item;
		ItemStack B12 = new Banner("B12", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.12"), DyeColor.PINK).item;
		ItemStack B13 = new Banner("B13", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.13"), DyeColor.MAGENTA).item;
		ItemStack B14 = new Banner("B14", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.14"), DyeColor.LIGHT_GRAY).item;	
		
		ItemStack E = new ItemStack(Material.BARRIER);
		ItemMeta EM = E.getItemMeta();
		EM.setDisplayName(Main.instance.replaceString(Main.instance.getConfig().getString("HeadBanner.GUI.ClearHeadItemName")));
		E.setItemMeta(EM);
		
		ItemStack C = new ItemStack(Material.SLIME_BALL);
		ItemMeta CM = C.getItemMeta();
		CM.setDisplayName(Main.instance.replaceString(Main.instance.getConfig().getString("HeadBanner.GUI.CloseItemName")));
		C.setItemMeta(CM);
		
		ItemStack N = new ItemStack(Material.MAGMA_CREAM);
		ItemMeta NM = N.getItemMeta();
		NM.setDisplayName(Main.instance.replaceString(Main.instance.getConfig().getString("HeadBanner.GUI.NextSide")));
		N.setItemMeta(NM);
		
		ItemStack R = new ItemStack(Material.ARMOR_STAND);
		ItemMeta RM = R.getItemMeta();
		RM.setDisplayName(Main.instance.replaceString(Main.instance.getConfig().getString("HeadBanner.GUI.RotateItemName")));
		R.setItemMeta(RM);
		
		//1 Reihe
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.1") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.1"), B1);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.2") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.2"), B2);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.3") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.3"), B3);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.4") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.4"), B4);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.5") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.5"), B5);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.6") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.6"), B6);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.7") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.7"), B7);
		}
		
		//2 Reihe
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.8") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.8"), B8);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.9") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.9"), B9);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.10") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.10"), B10);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.11") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.11"), B11);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.12") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.12"), B12);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.13") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.13"), B13);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.14") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.14"), B14);
		}
		
		
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.RotateItem") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.RotateItem1"), R);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.ClearHeadItem") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.ClearHeadItem1"), E);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.CloseItem") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.CloseItem1"), C);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.NextSide") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.NextSide1"), N);
		}
		Main.instance.inv = i;
		return i;

	}
	
	public static void createToggleItem(int id, Player player, boolean setItem, boolean updateInv) {
		ItemHandler.pullMatsAndPath();
		
		if(player == null) {
			return;
		}
		
		String configPath = ItemHandler.getToggleItemBasedOnID(id).configPath;
		String material = ItemHandler.getToggleItemBasedOnID(id).material;
				
		XMaterial xm = XMaterial.matchXMaterial(material).get();

		ItemStack PS = xm.parseItem();
//	    ItemStack PS3 = new ItemStack(plugin.getConfig().getInt("PlayerToggle.Items.Toggler1.ID"), 1, (byte)plugin.getConfig().getInt("PlayerToggle.Items.Toggler1.DataValue"));
	    ItemMeta PSMeta = PS.getItemMeta();
	    PSMeta.setLore(Arrays.asList(new String[] { Main.instance.getConfig().getString(configPath + "Lore").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä") }));
	    PSMeta.setDisplayName(Main.instance.getConfig().getString(configPath + "Name").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
	    PS.setItemMeta(PSMeta);
	    
	    if(setItem == true) {
		    player.getInventory().setItem(Main.instance.getConfig().getInt(configPath + "Slot(0-8)"), PS);
	    }
	    if(updateInv == true && player.getInventory().contains(PS)) {
		      player.getInventory().remove(PS);
		      player.updateInventory();
	    }
	}
	
	public static ItemStack returnCustomizedItemStack(int id) {
		ItemHandler.pullMatsAndPath();
		
		String configPath = ItemHandler.getToggleItemBasedOnID(id).configPath;
		String material = ItemHandler.getToggleItemBasedOnID(id).material;
				
		XMaterial xm = XMaterial.matchXMaterial(material).get();

		ItemStack PS = xm.parseItem();
	    ItemMeta PSMeta = PS.getItemMeta();
	    PSMeta.setLore(Arrays.asList(new String[] { Main.instance.getConfig().getString(configPath + "Lore").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä") }));
	    PSMeta.setDisplayName(Main.instance.getConfig().getString(configPath + "Name").replace("&", "§").replace("Oe", "Ö").replace("oe", "ö").replace("Ue", "Ü").replace("Ae", "Ä").replace("ae", "ä"));
	    PS.setItemMeta(PSMeta);
	    
	    return PS;
	}
	
	public static boolean compareMaterials(Material mat, int id) {
		XMaterial xm = XMaterial.matchXMaterial(ItemHandler.getToggleItemBasedOnID(id).material).get();
//		if(mat == xm.parseMaterial()) {
//			return true;
//		}
		 return false;
	}
	
	private static void pullMatsAndPath() {
		if(ti1 != null && ti2 != null && tiIV1 != null && tiIV2 != null && tiIV3 != null && tiIVF != null) {
			return;
		}
		ti1 = new ToggleItem(Main.instance.getConfig().getString("PlayerToggle.Items.Toggler1.Material"), "PlayerToggle.Items.Toggler1.");
		
		ti2 = new ToggleItem(Main.instance.getConfig().getString("PlayerToggle.Items.Toggler2.Material"), "PlayerToggle.Items.Toggler2.");
		
		tiIV1 = new ToggleItem(Main.instance.getConfig().getString("PlayerToggle.Inventory.Item1.Material"), "PlayerToggle.Inventory.Item1.");
		
		tiIV2 = new ToggleItem(Main.instance.getConfig().getString("PlayerToggle.Inventory.Item2.Material"), "PlayerToggle.Inventory.Item2.");
		
		tiIV3 = new ToggleItem(Main.instance.getConfig().getString("PlayerToggle.Inventory.Item3.Material"), "PlayerToggle.Inventory.Item3.");
		
		tiIVF = new ToggleItem(Main.instance.getConfig().getString("PlayerToggle.Inventory.Filler.Material"), "PlayerToggle.Inventory.Filler.");
		
	}
	
	private static ToggleItem getToggleItemBasedOnID(int id) {
		if(id == 1) {
			return ti1;
		} else if(id == 2) {
			return ti2;
		} else if(id == 5) {
			return tiIV1;
		} else if(id == 6) {
			return tiIV2;
		} else if(id == 7) {
			return tiIV3;
		} else if(id == 10) {
			return tiIVF;
		}
		return null;
	}

}
