package mintychochip.tulip.particles;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;

import java.util.List;
import java.util.function.Consumer;

public class Helix extends ParticleShape {

    public Helix(Entity entity, int particleCount, boolean forceLoad, double randX, double randY, double randZ, List<Particle> particle) {
        super(entity, particleCount, forceLoad, randX, randY, randZ, particle);
    }

    public Helix(Entity entity, int particleCount, List<Particle> particle) {
        super(entity, particleCount, particle);
    }

    @Override
    public void effect(Consumer<Location> particleLocation) {

    }
}
