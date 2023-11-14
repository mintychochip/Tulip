package mintychochip.orchid.container;

import mintychochip.orchid.shape.Shape;
import mintychochip.orchid.shape.implementation.Implementation;

public abstract class OrchidMechanic { //make all protected
    protected OrchidMechanicSettings mechanicSettings;
    protected Implementation implementation;
    protected OrchidSpell Transition;
    protected Context context;
    protected OrchidModifier orchidModifier;
    protected Shape shape;
    protected long delay;
    protected String name;

    public OrchidSpell getTransition() {
        return Transition;
    }

    public void setTransition(OrchidSpell transition) {
        Transition = transition;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public OrchidModifier getOrchidModifier() {
        return orchidModifier;
    }

    public void setOrchidModifier(OrchidModifier orchidModifier) {
        this.orchidModifier = orchidModifier;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Implementation getImplementation() {
        return implementation;
    }

    public void setImplementation(Implementation implementation) {
        this.implementation = implementation;
    }

    public OrchidMechanicSettings getMechanicSettings() {
        return mechanicSettings;
    }

    public void setMechanicSettings(OrchidMechanicSettings mechanicSettings) {
        this.mechanicSettings = mechanicSettings;
    }
}
