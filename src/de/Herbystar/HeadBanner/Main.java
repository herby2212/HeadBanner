package de.Herbystar.HeadBanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import de.Herbystar.HeadBanner.Commands.BannerCommand;
import de.Herbystar.HeadBanner.Commands.Commands;
import de.Herbystar.HeadBanner.Events.InventoryClickEvents;
import de.Herbystar.HeadBanner.Events.InventoryInteractEvents;
import de.Herbystar.HeadBanner.Events.PlayerDropItemEvents;
import de.Herbystar.HeadBanner.Events.PlayerInteractEvents;
import de.Herbystar.HeadBanner.Events.PlayerJoinEvents;
import de.Herbystar.HeadBanner.Events.PlayerQuitEvents;

public class Main extends JavaPlugin implements Listener {
	
	public String prefix = this.getConfig().getString("HeadBanner.CustomPrefix").replace("&", "§").replace("Oe", "§").replace("oe", "§").replace("Ue", "§").replace("Ae", "§").replace("ae", "§");
	
	public Inventory inv = null;
	public Inventory inv2 = null;
	public Inventory inv3 = null;
	
	public static Main instance;
	
	public ArrayList<String> HeadBannerToggle = new ArrayList<String>();
	
	public ArrayList<String> RB = new ArrayList<String>();
	
	public ArrayList<Player> BC = new ArrayList<Player>();
	
	public ArrayList<Player> B1 = new ArrayList<Player>();
	public ArrayList<Player> B2 = new ArrayList<Player>();
	public ArrayList<Player> B3 = new ArrayList<Player>();
	public ArrayList<Player> B4 = new ArrayList<Player>();
	public ArrayList<Player> B5 = new ArrayList<Player>();
	public ArrayList<Player> B6 = new ArrayList<Player>();
	public ArrayList<Player> B7 = new ArrayList<Player>();
	public ArrayList<Player> B8 = new ArrayList<Player>();
	public ArrayList<Player> B9 = new ArrayList<Player>();
	public ArrayList<Player> B10 = new ArrayList<Player>();
	public ArrayList<Player> B11 = new ArrayList<Player>();
	public ArrayList<Player> B12 = new ArrayList<Player>();
	public ArrayList<Player> B13 = new ArrayList<Player>();
	public ArrayList<Player> B14 = new ArrayList<Player>();
	
	List<ArrayList<Player>> pageOnePool = Arrays.asList(
			B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14);
	
	public ArrayList<Player> BP1 = new ArrayList<Player>();
	public ArrayList<Player> BP2 = new ArrayList<Player>();
	public ArrayList<Player> BP3 = new ArrayList<Player>();
	public ArrayList<Player> BP4 = new ArrayList<Player>();
	public ArrayList<Player> BP5 = new ArrayList<Player>();
	public ArrayList<Player> BP6 = new ArrayList<Player>();
	public ArrayList<Player> BP7 = new ArrayList<Player>();
	public ArrayList<Player> BP8 = new ArrayList<Player>();
	public ArrayList<Player> BP9 = new ArrayList<Player>();
	public ArrayList<Player> BP10 = new ArrayList<Player>();
	public ArrayList<Player> BP11 = new ArrayList<Player>();
	public ArrayList<Player> BP12 = new ArrayList<Player>();
	public ArrayList<Player> BP13 = new ArrayList<Player>();
	public ArrayList<Player> BP14 = new ArrayList<Player>();
	
	List<ArrayList<Player>> pageTwoPool = Arrays.asList(
			BP1, BP2, BP3, BP4, BP5, BP6, BP7, BP8, BP9, BP10, BP11, BP12, BP13, BP14);
	
	public ArrayList<Player> BA1 = new ArrayList<Player>();
	public ArrayList<Player> BA2 = new ArrayList<Player>();
	public ArrayList<Player> BA3 = new ArrayList<Player>();
	public ArrayList<Player> BA4 = new ArrayList<Player>();
	public ArrayList<Player> BA5 = new ArrayList<Player>();
	public ArrayList<Player> BA6 = new ArrayList<Player>();
	public ArrayList<Player> BA7 = new ArrayList<Player>();
	public ArrayList<Player> BA8 = new ArrayList<Player>();
	public ArrayList<Player> BA9 = new ArrayList<Player>();
	public ArrayList<Player> BA10 = new ArrayList<Player>();
	public ArrayList<Player> BA11 = new ArrayList<Player>();
	public ArrayList<Player> BA12 = new ArrayList<Player>();
	public ArrayList<Player> BA13 = new ArrayList<Player>();
	public ArrayList<Player> BA14 = new ArrayList<Player>();
	
	public int rotate;
	public int rotateid;
		
	public boolean UpdateAviable;
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§4=========>[§aHeadBanner Terms§4]<=========");		
		Bukkit.getConsoleSender().sendMessage("§4-> You are not permitted to claim this plugin as your own!");
		Bukkit.getConsoleSender().sendMessage("§4-> You are not permitted to decompiling the plugin's sourcecode!");
		Bukkit.getConsoleSender().sendMessage("§4-> You are not permitted to modify the code or the plugin and call it your own!");
		Bukkit.getConsoleSender().sendMessage("§4-> You are not permitted to redistributing this plugin as your own!");
		Bukkit.getConsoleSender().sendMessage("§4=======>[§aTerms Accepted!§4]<=======");
		Bukkit.getConsoleSender().sendMessage("");
		rotate = 14;
		
		instance = this;
		
		getCommands();
		registerEvents();
		loadConfig();
		//StartMetrics();
		
		Server server = Bukkit.getServer();
	    ConsoleCommandSender console = server.getConsoleSender();
	    console.sendMessage("§4[§aHeadBanner§4] " + ChatColor.AQUA + "Version: " + getDescription().getVersion() + " §aby " + "§c" + getDescription().getAuthors() + ChatColor.GREEN + " enabled!");
	}
	
	/*
	private void StartMetrics() {
		try {
			Metrics m = new Metrics(this);
			m.start();
			Bukkit.getConsoleSender().sendMessage("§4[§aHeadBanner§4] §aStarted §eMetrics §asuccessful!");
		} catch (IOException e) {
			e.printStackTrace();
			Bukkit.getConsoleSender().sendMessage("§4[§aHeadBanner§4] §cFailed to start the §eMetrics§c!");
		}
	}
	*/
	
	public void addToBannerList(Player player, ArrayList<Player> toAddTo, int poolId) {
		if(poolId == 1) {
			for(ArrayList<Player> lPlayer : pageOnePool) {
				if(lPlayer == toAddTo) {
					lPlayer.add(player);
				} else {
					lPlayer.remove(player);
				}
			}
		} else if(poolId == 2) {
			for(ArrayList<Player> lPlayer : pageTwoPool) {
				if(lPlayer == toAddTo) {
					lPlayer.add(player);
				} else {
					lPlayer.remove(player);
				}
			}			
		} else if(poolId == 3) {
			
		}
	}
	
	public String replaceString(String string) {
		string = string.replace("&", "§");
		string = string.replace("Oe", "Ö");
		string = string.replace("oe", "ö");
		string = string.replace("Ue", "Ü");
		string = string.replace("Ae", "Ä");
		string = string.replace("ae", "ä");
		return string;
		
	}
	
	private void registerEvents() {
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoinEvents(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerQuitEvents(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerInteractEvents(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new InventoryClickEvents(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerDropItemEvents(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new InventoryInteractEvents(this), this);
		
	}
	private void getCommands() {
		getCommand("BannerItem").setExecutor(new Commands(this));
		getCommand("BI").setExecutor(new Commands(this));
		getCommand("Banners").setExecutor(new Commands(this));
		getCommand("Banner").setExecutor(new BannerCommand(this));
		getCommand("B").setExecutor(new BannerCommand(this));
		getCommand("BannerRotate").setExecutor(new Commands(this));
		getCommand("HeadBanner").setExecutor(new Commands(this));
	}
	public void loadConfig() {
		this.getConfig().options().copyDefaults(true);
		saveConfig();
		
	}
	public void onDisable() {
		Server server = Bukkit.getServer();
	    ConsoleCommandSender console = server.getConsoleSender();
	    console.sendMessage("§4[§aHeadBanner§4] " + ChatColor.AQUA + "Version: " + getDescription().getVersion() + " §aby " + "§c" + getDescription().getAuthors() + ChatColor.GREEN + ChatColor.RED + " disabled!");
	}
}
