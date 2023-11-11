package mintychochip.orchid.events;

import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.Shape;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class AoeCastEvent extends OrchidEvent {

    private final Location location;

    public AoeCastEvent(Player player, Shape shape, OrchidMechanic orchidMechanic, Location location) {
        super(player, shape, orchidMechanic);
        this.location = location;
    }

    @Override
    public HandlerList getHandlers() {
        return null;
    }

    public Location getLocation() {
        return location;
    }

}

