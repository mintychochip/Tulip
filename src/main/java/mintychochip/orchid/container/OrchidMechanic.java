package mintychochip.orchid.container;

import mintychochip.orchid.shape.Shape;

public class OrchidMechanic {

    private OrchidSpell Transition;
    private Context context;
    private OrchidModifier orchidModifier;
    private Shape shape;
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
}
