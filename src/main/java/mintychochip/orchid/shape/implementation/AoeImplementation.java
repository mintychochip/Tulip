package mintychochip.orchid.shape.implementation;

import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.OrchidAoe;
import org.bukkit.Location;

public class AoeImplementation extends Implementation implements OrchidAoe {

    private final int range; //may rename aoe to area
    private final Location castLocation;

    public AoeImplementation(OrchidMechanic mechanic, int range) {
        super(mechanic);
        this.range = range;
        castLocation = context.getHitLocation() != null ? context.getHitLocation() : player.getLocation();
    }

    @Override
    public boolean castAoe() {
        if (mechanic instanceof OrchidAoe aoe) {
            aoe.castAoe();
        }
        return false;
    }

    @Override
    public void applyParticleAoe() {
    }

    @Override
    public void effect() {
        if (mechanic instanceof OrchidAoe aoe) {
            aoe.effect();
        }
    }
}
