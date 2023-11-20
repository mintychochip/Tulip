package mintychochip.tulip.items;

import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class Quiver {

    private final Inventory inventory;

    private final List<Arrow> arrowOrder = new ArrayList<>();

    public Quiver(int size, Player player) {
        inventory = Bukkit.createInventory(player, size, player.getDisplayName() + "'s quiver");
    }

    public Quiver(Player player) {
        this(27, player);
    }

    public void loadArrowOrder() {
        inventory.

    }

    public Inventory getInventory() {
        return inventory;
    }
}
