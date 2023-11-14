package mintychochip.orchid.spells;

import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.OrchidProjectile;
import mintychochip.orchid.shape.implementation.ProjectileImplementation;

public class Fireball extends OrchidMechanic implements OrchidProjectile {


    @Override
    public int castProjectile() {
        ProjectileImplementation implementation = (ProjectileImplementation) getImplementation();
        return implementation.castProjectile();
    }

    @Override
    public void effect() {

    }

    @Override
    public void applyParticleProjectile() {

    }
}
