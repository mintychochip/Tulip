package mintychochip.orchid.events;

import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.Shape;
import org.bukkit.event.HandlerList;

public class LaserCastEvent extends OrchidEvent {
    public LaserCastEvent(Shape shape, OrchidMechanic mechanic) {
        super(shape, mechanic);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
