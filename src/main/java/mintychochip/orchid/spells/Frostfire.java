package mintychochip.orchid.spells;

import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.OrchidProjectile;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class Frostfire extends OrchidMechanic implements OrchidProjectile {
    @Override
    public int castProjectile() {
        Location location = getContext().getPlayer().getLocation();
        Entity entity = location.getWorld().spawnEntity(location, EntityType.DRAGON_FIREBALL);
        return entity.getEntityId();
    }

    @Override
    public void effect() {

    }

    @Override
    public void applyParticleProjectile() {

    }
}
