package mintychochip.orchid.spells;

import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.OrchidProjectile;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Fireball extends OrchidMechanic implements OrchidProjectile {


    @Override
    public int castProjectile() {
        Location location = getContext().getPlayer().getLocation();
        Player player = getContext().getPlayer();
        Entity entity = location.getWorld().spawnEntity(location, EntityType.FIREBALL);
        entity.setVelocity(player.getLocation().getDirection().multiply(5.0f));
        return entity.getEntityId();
    }

    @Override
    public void effect() {

    }

    @Override
    public void applyParticleProjectile() {

    }
}
