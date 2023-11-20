package mintychochip.tulip.flags;

import mintychochip.tulip.util.Lists;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.List;

public class FlagListener implements Listener {

    public List<Player> playersCurrentlyInsideForest = new ArrayList<>();

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerLandonLeaves(final EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }
        if (!(event.getCause() == EntityDamageEvent.DamageCause.FALL)) {
            return;
        }
        Location subtract = player.getLocation().subtract(0f, 1f, 0f);
        if (Lists.materialListContains("LEAVES").contains(subtract.getBlock().getType())) {
            double fall = event.getDamage();
            if (fall > player.getHealth()) {
                player.setHealth(1.0f);
            } else {
                event.setDamage(fall / 2.0f);
            }
        }
    }

    @EventHandler
    public void playerInsideForest(final PlayerMoveEvent event) {
        if (event.getTo() == event.getFrom()) {
            return;
        }
        Location goingTo = event.getTo();
        if (goingTo != null) {
            if (Lists.biomeListContains("FOREST").contains(goingTo.getBlock().getBiome())) { //something here with the scheduler, just check if theey are in the list 
                // add permissions check here
                if (!playersCurrentlyInsideForest.contains(event.getPlayer())) {
                    playersCurrentlyInsideForest.add(event.getPlayer());
                }
            } else {
                playersCurrentlyInsideForest.remove(event.getPlayer());
            }
        }

    }
