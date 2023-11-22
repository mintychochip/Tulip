package mintychochip.tulip.particles;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public abstract class ParticleShape {

    protected Entity entity;
    protected int particleCount = 1;
    protected boolean forceLoad = true;
    protected double randX = 0;
    protected double randY = 0;
    protected double randZ = 0;
    protected List<Particle> particle;
    protected int currentParticle = 0;

    public ParticleShape(Entity entity, int particleCount, boolean forceLoad, double randX, double randY, double randZ, List<Particle> particle) {
        this.entity = entity;
        this.particleCount = particleCount;
        this.forceLoad = forceLoad;
        this.randX = randX;
        this.randY = randY;
        this.randZ = randZ;
        this.particle = particle;
    }

    public ParticleShape(Entity entity, int particleCount, List<Particle> particle) {
        this.entity = entity;
        this.particleCount = particleCount;
        this.particle = particle;
    }

    public abstract void effect(Consumer<Location> particleLocation); //returns the location of the supposed particle

    public void step() {
        effect(location -> {
            try {
                if (location.getWorld() == null) {
                    return;
                }
                location.getWorld().spawnParticle(getParticle(), location, particleCount, randX, randY, randZ, forceLoad);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private Particle getParticle() throws IOException {
        if (particle.isEmpty()) {
            throw new IOException("needs atleast 1 Particle");
        }
        if (particle.size() != 1) {
            if (++currentParticle > particle.size()) {
                currentParticle = 0;
            }
            return particle.get(currentParticle - 1);
        }
        return particle.get(currentParticle);

    }
}
