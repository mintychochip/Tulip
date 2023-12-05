package mintychochip.tulip.item.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemListener implements Listener {

    @EventHandler
    public void onItemClick(final PlayerInteractEvent event) {
        if (event.getPlayer().get)
    }

    @EventHandler
    public void itemCloseInventoryListener(final InventoryCloseEvent event) {
        ItemStack itemInUse = event.getPlayer().getItemInUse();
    }
}
