package mintychochip.orchid.shape.implementation;

import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.OrchidAoe;
import org.bukkit.Location;

public class AoeImplementation extends Implementation implements OrchidAoe {

    private final Location castLocation;

    public AoeImplementation(OrchidMechanic mechanic) {
        super(mechanic);
        castLocation = context.getHitLocation() != null ? context.getHitLocation() : player.getLocation();
    }

    @Override
    public boolean castAoe() {
        if (!(mechanic instanceof OrchidAoe aoe)) {
            return false;
        }
        return aoe.castAoe();
    }

    @Override
    public void applyParticleAoe() {
    }

    public Location getCastLocation() {
        return castLocation;
    }
}
