package mintychochip.orchid.registry;

import mintychochip.orchid.container.Keyword;
import mintychochip.orchid.container.Modifier;
import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.Shape;
import mintychochip.orchid.events.OrchidEvent;
import mintychochip.orchid.spells.Explosion;
import mintychochip.orchid.spells.Fireball;

import java.util.HashMap;
import java.util.Map;

public class OrchidRegistry {

    private static final Map<String, Modifier> modifierAlias = new HashMap<>();
    private static final Map<String, Keyword> keywordAlias = new HashMap<>();
    private static final Map<String, String> numericalAlias = new HashMap<>();
    private static final Map<String,OrchidMechanic> mechanicAlias = new HashMap<>();
    private static final Map<Shape, OrchidEvent> eventRegistry = new HashMap<>();
    private static final Map<String,Shape> shapeAlias = new HashMap<>();
    public OrchidRegistry() {
        manual();
    }

    public void manual() {
        mechanicAlias.put("Fireball", new Fireball());
        keywordAlias.put("start",Keyword.START);
        keywordAlias.put("mechanic",Keyword.MECHANIC);
        keywordAlias.put("end",Keyword.END);
        keywordAlias.put("modifier",Keyword.MODIFIER);
        modifierAlias.put("velocity",Modifier.VELOCITY);
        modifierAlias.put("magnitude",Modifier.MAGNITUDE);
        numericalAlias.put("five","5.0f");
        mechanicAlias.put("Explosion", new Explosion());
        keywordAlias.put("shape",Keyword.SHAPE);
        shapeAlias.put("projectile",Shape.PROJECTILE);
        shapeAlias.put("aoe",Shape.AOE);
        keywordAlias.put("wait",Keyword.WAIT);

    }
    public static Map<String, Modifier> getModifierAlias() {
        return modifierAlias;
    }

    public static Map<String, Keyword> getKeywordAlias() {
        return keywordAlias;
    }

    public static Map<String, String> getNumericalAlias() {
        return numericalAlias;
    }

    public static Map<String, OrchidMechanic> getMechanicAlias() {
        return mechanicAlias;
    }

    public static Map<Shape, OrchidEvent> getEventRegistry() {
        return eventRegistry;
    }

    public static Map<String, Shape> getShapeAlias() {
        return shapeAlias;
    }
}
