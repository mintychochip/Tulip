package mintychochip.orchid.events;

import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.Shape;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class AoeCastEvent extends OrchidEvent {

    public AoeCastEvent(Shape shape, OrchidMechanic orchidMechanic) {
        super(shape, orchidMechanic);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }


}

