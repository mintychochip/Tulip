package mintychochip.orchid.events;

import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.Shape;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class OrchidEvent extends Event {
    public static final HandlerList handlers = new HandlerList();
    private final Shape shape;
    private final OrchidMechanic mechanic;

    public OrchidEvent(Shape shape, OrchidMechanic mechanic) {
        this.shape = shape;
        this.mechanic = mechanic;
    }

    public Shape getShape() {
        return shape;
    }

    public OrchidMechanic getMechanic() {
        return mechanic;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
