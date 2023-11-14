package mintychochip.orchid.spells;

import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.OrchidAoe;
import mintychochip.orchid.shape.implementation.AoeImplementation;
import org.bukkit.Location;

public class Explosion extends OrchidMechanic implements OrchidAoe {


    @Override
    public boolean castAoe() {
        AoeImplementation implementation = (AoeImplementation) getImplementation();
        Location castLocation = implementation.getCastLocation();
        if (castLocation.getWorld() == null) {
            return false;
        }
        castLocation.getWorld().createExplosion(castLocation, orchidModifier.getMagnitude());
        return true;
    }

    @Override
    public void applyParticleAoe() {

    }
}
