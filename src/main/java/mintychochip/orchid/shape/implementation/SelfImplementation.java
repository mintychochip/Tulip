package mintychochip.orchid.shape.implementation;

import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.OrchidSelf;

public class SelfImplementation extends Implementation implements OrchidSelf {

    protected SelfImplementation(OrchidMechanic mechanic) {
        super(mechanic);
    }

    @Override
    public boolean castSelf() {
        if (!(mechanic instanceof OrchidSelf self)) {
            return false;
        }
        return self.castSelf();
    }

    @Override
    public void applyParticleSelf() {

    }
}
