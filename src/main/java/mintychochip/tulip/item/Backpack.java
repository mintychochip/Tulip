package mintychochip.tulip.item;

import mintychochip.tulip.GenericCustomItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Backpack extends GenericCustomItem { //add generated way to get a key, probably can just do instancing in abstract item

    private final Inventory inventory;


    public Backpack(Player player) {
        inventory = Bukkit.createInventory(player, 27, "Backpack");
        inventory.get
    }

    @Override
    protected void execute(Player player) {
        player.openInventory(inventory);
    }
}
