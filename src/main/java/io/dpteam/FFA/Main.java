package io.dpteam.FFA;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin implements Listener {
	public Main() {
		super();
	}

	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		this.getServer().getLogger().info("[FFA] Plugin loaded and enabled");
	}

	@Override
	public void onDisable() {
		this.getServer().getLogger().info("[FFA] Plugin unloaded and disabled");
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		killer.getInventory().addItem(new ItemStack[]{new ItemStack(Material.LEGACY_ARROW, 5)});
		killer.getInventory().addItem(new ItemStack[]{new ItemStack(Material.LEGACY_FIREBALL, 1)});
		killer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 70, 3));
		event.getDrops().clear();
	}

	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.LEGACY_IRON_SWORD, 1)});
		player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.LEGACY_FISHING_ROD, 1)});
		player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.LEGACY_BOW, 1)});
		player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.LEGACY_FIREBALL, 1)});
		player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.LEGACY_ARROW, 30)});
		player.getInventory().setHelmet(new ItemStack(Material.LEGACY_IRON_HELMET));
		player.getInventory().setChestplate(new ItemStack(Material.LEGACY_IRON_CHESTPLATE));
		player.getInventory().setLeggings(new ItemStack(Material.LEGACY_IRON_LEGGINGS));
		player.getInventory().setBoots(new ItemStack(Material.LEGACY_IRON_BOOTS));
	}
}
