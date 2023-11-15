package mintychochip.orchid.spells;

import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.OrchidAoe;
import mintychochip.orchid.shape.OrchidSelf;
import mintychochip.orchid.shape.implementation.AoeImplementation;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;

public class Ablaze extends OrchidMechanic implements OrchidAoe, OrchidSelf {
    @Override
    public boolean castAoe() {
        List<Entity> nearbyEntities = ((AoeImplementation) getImplementation()).getNearbyEntities();
        if (nearbyEntities == null) {
            return false;
        }
        for (Entity nearbyEntity : nearbyEntities) {
            if (nearbyEntity instanceof Player player) {
                if (player.getFireTicks() > 0) {
                    //add potion effects
                }
            }
        }
        return true;
    }

    @Override
    public boolean castSelf() {
        //add potion effects
        return context.getPlayer().getFireTicks() > 0;
    }

    @Override
    public void applyParticleSelf() {

    }
}
