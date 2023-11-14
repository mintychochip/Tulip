package mintychochip.orchid.spells;

import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.OrchidAoe;
import mintychochip.orchid.shape.OrchidSelf;
import mintychochip.orchid.shape.implementation.AoeImplementation;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import java.util.Collection;

public class Immolate extends OrchidMechanic implements OrchidSelf, OrchidAoe {
    @Override
    public boolean castAoe() {
        Location castLocation = ((AoeImplementation) getImplementation()).getCastLocation();
        if (castLocation.getWorld() == null) {
            return false;
        }
        int range = mechanicSettings.getRange(); //better way to do this probably, also add effects
        Collection<Entity> nearbyEntities = castLocation.getWorld().getNearbyEntities(castLocation, range, range, range);
        for (Entity nearbyEntity : nearbyEntities) {
            nearbyEntity.setFireTicks(mechanicSettings.getDuration());
        }
        return true;
    }

    @Override
    public void applyParticleAoe() {

    }

    @Override
    public boolean castSelf() {
        return false;
    }

    @Override
    public void applyParticleSelf() {

    }
}
