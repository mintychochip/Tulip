package mintychochip.orchid.spells;

import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.OrchidAoe;
import mintychochip.orchid.shape.implementation.AoeImplementation;

public class Explosion extends OrchidMechanic implements OrchidAoe {


    @Override
    public boolean castAoe() {
        AoeImplementation implementation = new AoeImplementation(this, 5);
        implementation.castAoe();
        return true;
    }

    @Override
    public void applyParticleAoe() {

    }

    @Override
    public void effect() { //actual effect

    }
}
