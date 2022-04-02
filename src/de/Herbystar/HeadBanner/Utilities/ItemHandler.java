package de.Herbystar.HeadBanner.Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
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
		
		public Banner(String id, String displayName, XMaterial material, DyeColor baseColor) {
			this.id = id;
			this.item = createBanner(displayName, material, baseColor);
			
			bannerCollection.add(this);
		}
		
		public Banner(String id, String displayName, XMaterial material, DyeColor baseColor, List<Pattern> list) {
			this.id = id;
			this.item = createBanner(displayName, material, baseColor, list);
			
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
	
	private static ItemStack createBanner(String displayName, XMaterial material, DyeColor baseColor) {
		return createBanner(displayName, material, baseColor, null);
	}
	
	@SuppressWarnings("deprecation")
	private static ItemStack createBanner(String displayName, XMaterial material, DyeColor baseColor, List<Pattern> patterns) {
		Material m = material.parseMaterial();
		if(!XMaterial.isNewVersion()) {
			m = Material.valueOf("BANNER");
		}
		ItemStack b = new ItemStack(m);
		BannerMeta bm = (BannerMeta) b.getItemMeta();
		bm.setDisplayName(Main.instance.replaceString(displayName));
		bm.setBaseColor(baseColor);
		if(patterns != null) {
			for(Pattern pattern : patterns) {
				bm.addPattern(pattern);
			}
		}
		b.setItemMeta(bm);
		
		return b;
	}
	
	public static Inventory getInventoryPageOne() {
		if(Main.instance.inv != null) {
			return Main.instance.inv;
		}
		Inventory i = Bukkit.getServer().createInventory(null, Main.instance.getConfig().getInt("HeadBanner.InventorySize.1"), 
				Main.instance.replaceString(Main.instance.getConfig().getString("HeadBanner.BannerInventory.Side1Title")));
		
		ItemStack B1 = new Banner("B1", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.1"), XMaterial.BLACK_BANNER, DyeColor.BLACK).item;	
		ItemStack B2 = new Banner("B2", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.2"), XMaterial.WHITE_BANNER, DyeColor.WHITE).item;
		ItemStack B3 = new Banner("B3", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.3"), XMaterial.GRAY_BANNER, DyeColor.GRAY).item;
		ItemStack B4 = new Banner("B4", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.4"), XMaterial.BLUE_BANNER, DyeColor.BLUE).item;
		ItemStack B5 = new Banner("B5", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.5"), XMaterial.GREEN_BANNER, DyeColor.GREEN).item;
		ItemStack B6 = new Banner("B6", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.6"), XMaterial.CYAN_BANNER, DyeColor.CYAN).item;
		ItemStack B7 = new Banner("B7", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.7"), XMaterial.YELLOW_BANNER, DyeColor.YELLOW).item;
		ItemStack B8 = new Banner("B8", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.8"), XMaterial.LIGHT_BLUE_BANNER, DyeColor.LIGHT_BLUE).item;
		ItemStack B9 = new Banner("B9", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.9"), XMaterial.RED_BANNER, DyeColor.RED).item;
		ItemStack B10 = new Banner("B10", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.10"), XMaterial.LIME_BANNER, DyeColor.LIME).item;
		ItemStack B11 = new Banner("B11", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.11"), XMaterial.ORANGE_BANNER, DyeColor.ORANGE).item;
		ItemStack B12 = new Banner("B12", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.12"), XMaterial.PINK_BANNER, DyeColor.PINK).item;
		ItemStack B13 = new Banner("B13", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.13"), XMaterial.MAGENTA_BANNER, DyeColor.MAGENTA).item;
		DyeColor d;
		if(XMaterial.isNewVersion()) {
			d = DyeColor.valueOf("LIGHT_GRAY");
		} else {
			d = DyeColor.valueOf("SILVER");
		}
		ItemStack B14 = new Banner("B14", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.14"), XMaterial.LIGHT_GRAY_BANNER, d).item;
			
		
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
	
	public static Inventory getInventoryPageTwo() {
		if(Main.instance.inv2 != null) {
			return Main.instance.inv2;
		}
		Inventory i = Bukkit.getServer().createInventory(null, Main.instance.getConfig().getInt("HeadBanner.InventorySize.2"), 
				Main.instance.replaceString(Main.instance.getConfig().getString("HeadBanner.BannerInventory.Side2Title")));
		
		ItemStack BP1 = new Banner("BP1", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.15"), XMaterial.WHITE_BANNER, DyeColor.WHITE, 
				Arrays.asList(new Pattern(DyeColor.BLACK, PatternType.BORDER), new Pattern(DyeColor.BLACK, PatternType.SKULL))).item;	
		ItemStack BP2 = new Banner("BP2", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.16"), XMaterial.BLACK_BANNER, DyeColor.BLACK,
				Arrays.asList(
						new Pattern(DyeColor.BLACK, PatternType.HALF_HORIZONTAL),
						new Pattern(DyeColor.GREEN, PatternType.TRIANGLE_TOP),
						new Pattern(DyeColor.RED, PatternType.STRIPE_SMALL),
						new Pattern(DyeColor.GREEN, PatternType.SKULL),
						new Pattern(DyeColor.GREEN, PatternType.TRIANGLES_TOP),
						new Pattern(DyeColor.GREEN, PatternType.CURLY_BORDER))).item;
		ItemStack BP3 = new Banner("BP3", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.17"), XMaterial.LIME_BANNER, DyeColor.LIME,
				Arrays.asList(
						new Pattern(DyeColor.YELLOW, PatternType.RHOMBUS_MIDDLE),
						new Pattern(DyeColor.RED, PatternType.BORDER),
						new Pattern(DyeColor.YELLOW, PatternType.FLOWER),
						new Pattern(DyeColor.RED, PatternType.CIRCLE_MIDDLE))).item;
		ItemStack BP4 = new Banner("BP4", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.18"), XMaterial.BROWN_BANNER, DyeColor.BROWN,
				Arrays.asList(
						new Pattern(DyeColor.YELLOW, PatternType.MOJANG))).item;
		ItemStack BP5 = new Banner("BP5", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.19"), XMaterial.BLUE_BANNER, DyeColor.BLUE,
				Arrays.asList(
						new Pattern(DyeColor.LIGHT_BLUE, PatternType.CURLY_BORDER),
						new Pattern(DyeColor.LIGHT_BLUE, PatternType.FLOWER),
						new Pattern(DyeColor.LIGHT_BLUE, PatternType.TRIANGLES_TOP),
						new Pattern(DyeColor.LIGHT_BLUE, PatternType.TRIANGLES_BOTTOM),
						new Pattern(DyeColor.BLUE, PatternType.CIRCLE_MIDDLE))).item;
		ItemStack BP6 = new Banner("BP6", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.20"), XMaterial.BLACK_BANNER, DyeColor.BLACK,
				Arrays.asList(
						new Pattern(DyeColor.ORANGE, PatternType.TRIANGLE_BOTTOM),
						new Pattern(DyeColor.YELLOW, PatternType.RHOMBUS_MIDDLE),
						new Pattern(DyeColor.RED, PatternType.BORDER),
						new Pattern(DyeColor.RED, PatternType.TRIANGLES_TOP))).item;
		ItemStack BP7 = new Banner("BP7", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.21"), XMaterial.BLACK_BANNER, DyeColor.BLACK,
				Arrays.asList(
						new Pattern(DyeColor.GRAY, PatternType.BORDER),
						new Pattern(DyeColor.GRAY, PatternType.STRIPE_CENTER),
						new Pattern(DyeColor.RED, PatternType.SKULL))).item;
		ItemStack BP8 = new Banner("BP8", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.22"), XMaterial.LIME_BANNER, DyeColor.LIME,
				Arrays.asList(
						new Pattern(DyeColor.RED, PatternType.BRICKS),
						new Pattern(DyeColor.YELLOW, PatternType.FLOWER),
						new Pattern(DyeColor.YELLOW, PatternType.FLOWER),
						new Pattern(DyeColor.LIME, PatternType.CIRCLE_MIDDLE),
						new Pattern(DyeColor.RED, PatternType.BORDER))).item;
		ItemStack BP9 = new Banner("BP9", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.23"), XMaterial.BLACK_BANNER, DyeColor.BLACK,
				Arrays.asList(
						new Pattern(DyeColor.YELLOW, PatternType.CROSS),
						new Pattern(DyeColor.YELLOW, PatternType.STRAIGHT_CROSS),
						new Pattern(DyeColor.RED, PatternType.CURLY_BORDER))).item;
		ItemStack BP10 = new Banner("BP10", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.24"), XMaterial.BLACK_BANNER, DyeColor.BLACK,
				Arrays.asList(
						new Pattern(DyeColor.RED, PatternType.CROSS),
						new Pattern(DyeColor.RED, PatternType.BORDER))).item;
		ItemStack BP11 = new Banner("BP11", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.25"), XMaterial.BLACK_BANNER, DyeColor.BLACK,
				Arrays.asList(
						new Pattern(DyeColor.YELLOW, PatternType.CREEPER),
						new Pattern(DyeColor.LIME, PatternType.GRADIENT_UP))).item;
		ItemStack BP12 = new Banner("BP12", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.26"), XMaterial.YELLOW_BANNER, DyeColor.YELLOW,
				Arrays.asList(
						new Pattern(DyeColor.YELLOW, PatternType.BORDER),
						new Pattern(DyeColor.LIME, PatternType.CREEPER),
						new Pattern(DyeColor.LIME, PatternType.CREEPER))).item;
		ItemStack BP13 = new Banner("BP13", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.27"), XMaterial.BLACK_BANNER, DyeColor.BLACK,
				Arrays.asList(
						new Pattern(DyeColor.RED, PatternType.BRICKS),
						new Pattern(DyeColor.CYAN, PatternType.GRADIENT_UP),
						new Pattern(DyeColor.ORANGE, PatternType.GRADIENT),
						new Pattern(DyeColor.WHITE, PatternType.BORDER))).item;
		ItemStack BP14 = new Banner("BP14", Main.instance.getConfig().getString("HeadBanner.BannerDisplayNames.28"), XMaterial.WHITE_BANNER, DyeColor.WHITE,
				Arrays.asList(
						new Pattern(DyeColor.BLACK, PatternType.GRADIENT),
						new Pattern(DyeColor.BLACK, PatternType.CROSS),
						new Pattern(DyeColor.BLACK, PatternType.CURLY_BORDER))).item;

		ItemStack B = new ItemStack(Material.MAGMA_CREAM);
		ItemMeta BM = B.getItemMeta();
		BM.setDisplayName(Main.instance.replaceString(Main.instance.getConfig().getString("HeadBanner.GUI.BackSide")));
		B.setItemMeta(BM);
		
		ItemStack R = new ItemStack(Material.ARMOR_STAND);
		ItemMeta RM = R.getItemMeta();
		RM.setDisplayName(Main.instance.replaceString(Main.instance.getConfig().getString("HeadBanner.GUI.RotateItemName")));
		R.setItemMeta(RM);
		
		ItemStack N = new ItemStack(Material.MAGMA_CREAM);
		ItemMeta NM = N.getItemMeta();
		NM.setDisplayName(Main.instance.replaceString(Main.instance.getConfig().getString("HeadBanner.GUI.NextSide")));
		N.setItemMeta(NM);
		
		//1 Reihe
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.15") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.15"), BP1);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.16") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.16"), BP2);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.17") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.17"), BP3);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.18") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.18"), BP4);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.19") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.19"), BP5);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.20") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.20"), BP6);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.21") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.21"), BP7);
		}
		
		//2 Reihe
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.22") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.22"), BP8);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.23") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.23"), BP9);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.24") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.24"), BP10);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.25") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.25"), BP11);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.26") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.26"), BP12);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.27") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.27"), BP13);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.28") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.28"), BP14);
		}
		
		
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.RotateItem") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.RotateItem2"), R);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.BackSide") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.BackSide2"), B);
		}
		if(Main.instance.getConfig().getBoolean("HeadBanner.FreeSlot.NextSide") == false) {
			i.setItem(Main.instance.getConfig().getInt("HeadBanner.ItemSlot.NextSide2"), N);
		}
		
		Main.instance.inv2 = i;
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
