package mintychochip.orchid.spells;

import mintychochip.orchid.container.Context;
import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.OrchidAoe;
import org.bukkit.Location;
import org.bukkit.block.Block;

public class Explosion extends OrchidMechanic implements OrchidAoe {


    @Override
    public boolean castAoe() {
        Location location;
        if(getContext().getHitLocation() != null) {
            location = getContext().getHitLocation();
        } else {
            location = getContext().getPlayer().getLocation();
        }
        location.getWorld().createExplosion(location, getOrchidModifier().getMagnitude());
        return true;
    }

    @Override
    public void applyParticleAoe() {

    }

}
