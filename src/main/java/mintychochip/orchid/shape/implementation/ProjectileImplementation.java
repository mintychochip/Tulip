package mintychochip.orchid.shape.implementation;

import mintychochip.orchid.container.Context;
import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.container.OrchidModifier;
import mintychochip.orchid.registry.OrchidRegistry;
import mintychochip.orchid.shape.OrchidProjectile;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;

public class ProjectileImplementation implements OrchidProjectile {

    private final OrchidMechanic mechanic;
    private Context context;
    private Player player;
    private Projectile spawnedProjectile;
    private EntityType type;
    private boolean magnitudeAffected;

    public ProjectileImplementation(OrchidMechanic mechanic) {
        this.mechanic = mechanic;
        String name = mechanic.getName();
        if(name != null) {
            this.type = OrchidRegistry.getProjectileAlias().get(name);
        }
        Context context = mechanic.getContext();
        if(context != null) {
            this.context = context;
            this.player = context.getPlayer(); // checked whether player is part of context, cannot instantiate a context object without player
        }
    }
    @Override
    public int castProjectile() { //generalized method to cast projectile objects
        Location playerLocation = player.getLocation();
        if(playerLocation.getWorld() != null && type != null) {
            spawnedProjectile = (Projectile) playerLocation.getWorld().spawnEntity(playerLocation, type); //cant have errors at this line, because type is pulled from hash
            spawnedProjectile.setVelocity(playerLocation.getDirection().multiply(mechanic.getOrchidModifier().getVelocity()));
            return spawnedProjectile.getEntityId();
        }
        return -1;
    }

    @Override
    public void effect() {
        if(mechanic instanceof OrchidProjectile projectile) {
            projectile.effect();
        }
    }

    @Override
    public void applyParticleProjectile() {
        if(spawnedProjectile != null) {//add this projectile, and give it effect, probs hash
        }
    }
}
