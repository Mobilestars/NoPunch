package de.scholle.noPunch;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;

public class PunchEnchantBlocker implements Listener {

    private final NoPunch plugin;

    public PunchEnchantBlocker(NoPunch plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEnchantItem(EnchantItemEvent event) {
        boolean allowPunch = plugin.getConfig().getBoolean("allow-punch", false);
        if (allowPunch) return;

        ItemStack item = event.getItem();
        if (item == null || !item.getType().toString().contains("BOW")) return;

        if (event.getEnchantsToAdd().containsKey(Enchantment.ARROW_KNOCKBACK)) {
            event.getEnchantsToAdd().remove(Enchantment.ARROW_KNOCKBACK);
            if (event.getEnchanter() instanceof Player) {
                Player player = (Player) event.getEnchanter();
                player.sendMessage("§cPunch is disabled!");
            }
        }
    }

    @EventHandler
    public void onPrepareAnvil(PrepareAnvilEvent event) {
        boolean allowPunch = plugin.getConfig().getBoolean("allow-punch", false);
        if (allowPunch) return;

        AnvilInventory inv = event.getInventory();
        ItemStack first = inv.getItem(0);
        ItemStack second = inv.getItem(1);

        if (first == null || second == null) return;
        if (!first.getType().toString().contains("BOW")) return;

        if (second.containsEnchantment(Enchantment.ARROW_KNOCKBACK)) {
            event.setResult(null);
        }
    }

    @EventHandler
    public void onAnvilClick(InventoryClickEvent event) {
        boolean allowPunch = plugin.getConfig().getBoolean("allow-punch", false);
        if (allowPunch) return;

        if (event.getInventory().getType() != InventoryType.ANVIL) return;
        if (event.getRawSlot() != 2) return;

        ItemStack result = event.getCurrentItem();
        if (result == null || !result.getType().toString().contains("BOW")) return;

        if (result.containsEnchantment(Enchantment.ARROW_KNOCKBACK)) {
            event.setCancelled(true);
            if (event.getWhoClicked() instanceof Player player) {
                player.sendMessage("§cPunch is disabled!");
            }
        }
    }
}
