package mintychochip.tulip.handler;

import mintychochip.tulip.Tulip;
import mintychochip.tulip.particles.ParticleShape;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class ParticleManager {
    private final List<ParticleShape> effects = new ArrayList<>();

    private void run() {
        Bukkit.getScheduler().runTaskTimer(Tulip.getInstance(), () -> {
            if (!effects.isEmpty()) {
                for (ParticleShape effect : effects) {
                    effect.step();
                }
            }
        }, 0L, 2L);
    }

}
