package mintychochip.orchid.spells;

import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.OrchidAoe;
import mintychochip.orchid.shape.OrchidSelf;
import mintychochip.orchid.shape.implementation.AoeImplementation;
import org.bukkit.Location;

public class Fireblast extends OrchidMechanic implements OrchidSelf, OrchidAoe {
    @Override
    public boolean castAoe() {
        Location castLocation = ((AoeImplementation) getImplementation()).getCastLocation();

        return false;
    }

    @Override
    public boolean castSelf() {
        return false;
    }

    @Override
    public void applyParticleSelf() {

    }
}
