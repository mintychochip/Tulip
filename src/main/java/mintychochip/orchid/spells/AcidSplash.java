package mintychochip.orchid.spells;

import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.OrchidProjectile;
import mintychochip.orchid.shape.implementation.ProjectileImplementation;

public class AcidSplash extends OrchidMechanic implements OrchidProjectile {
    @Override
    public int castProjectile() {
        ProjectileImplementation implementation = (ProjectileImplementation) getImplementation();
        return 0;
    }

    @Override
    public void effect() {

    }

    @Override
    public void applyParticleProjectile() {

    }
}
