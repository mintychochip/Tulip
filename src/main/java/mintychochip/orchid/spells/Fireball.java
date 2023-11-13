package mintychochip.orchid.spells;

import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.OrchidProjectile;
import mintychochip.orchid.shape.implementation.ProjectileImplementation;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Fireball extends OrchidMechanic implements OrchidProjectile {


    @Override
    public int castProjectile() {
        ProjectileImplementation projectileImplementation = new ProjectileImplementation(this); //cleaner way of spawning a projectile, have to just put the fireball in the map
        return projectileImplementation.castProjectile();
    }

    @Override
    public void effect() {

    }

    @Override
    public void applyParticleProjectile() {

    }
}
