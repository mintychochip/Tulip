package mintychochip.orchid.events;

import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.Shape;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public abstract class OrchidEvent extends Event {

    private final Player player;
    private final Shape shape;
    private final OrchidMechanic mechanic;

    public OrchidEvent(Player player, Shape shape, OrchidMechanic mechanic) {
        this.player = player;
        this.shape = shape;
        this.mechanic = mechanic;
    }

    public Player getPlayer() {
        return player;
    }

    public Shape getShape() {
        return shape;
    }

    public OrchidMechanic getMechanic() {
        return mechanic;
    }

}
