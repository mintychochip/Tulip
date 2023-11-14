package mintychochip.orchid.shape.implementation;

import mintychochip.orchid.container.Context;
import mintychochip.orchid.container.OrchidMechanic;
import org.bukkit.entity.Player;

public abstract class Implementation {

    protected final OrchidMechanic mechanic; // can generalize this, make a base class
    protected Context context;
    protected Player player;
    protected boolean magnitudeAffected;

    protected Implementation(OrchidMechanic mechanic, boolean magnitudeAffected) {
        this.mechanic = mechanic;
        Context context = null;
        if (mechanic != null) {
            mechanic.setImplementation(this);
            context = mechanic.getContext();
        }
        if (context != null) {
            this.context = context;
            this.player = context.getPlayer();
        }
        this.magnitudeAffected = magnitudeAffected;
    }

    protected Implementation(OrchidMechanic mechanic) {
        this(mechanic, false);
    }
}
