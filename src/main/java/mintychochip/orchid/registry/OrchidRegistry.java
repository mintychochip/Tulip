package mintychochip.orchid.registry;

import mintychochip.orchid.Orchid;
import mintychochip.orchid.container.Keyword;
import mintychochip.orchid.container.Modifier;
import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.Shape;
import mintychochip.orchid.events.OrchidEvent;
import mintychochip.orchid.spells.*;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

public class OrchidRegistry {

    private static final Map<String, Modifier> modifierAlias = new HashMap<>();
    private static Map<String, Keyword> keywordAlias;
    private static final Map<String, String> numericalAlias = new HashMap<>();
    private static final Map<String,OrchidMechanic> mechanicAlias = new HashMap<>();
    private static final Map<String,Shape> shapeAlias = new HashMap<>();
    private static final Map<String, EntityType> projectileAlias = new HashMap<>();
    public OrchidRegistry() {
        manual();
        keywordAlias = Orchid.getRegistryConfig().getKeywords();

    }

    public void manual() {
        mechanicAlias.put("Fireball", new Fireball());

        modifierAlias.put("velocity",Modifier.VELOCITY);
        modifierAlias.put("magnitude",Modifier.MAGNITUDE);
        numericalAlias.put("five","5.0f");
        mechanicAlias.put("Explosion", new Explosion());
        shapeAlias.put("projectile",Shape.PROJECTILE);
        shapeAlias.put("aoe",Shape.AOE);
        mechanicAlias.put("Blink",new Blink());
        shapeAlias.put("self",Shape.SELF);
        projectileAlias.put("Fireball",EntityType.FIREBALL);
        mechanicAlias.put("Fireblast",new Fireblast());
        mechanicAlias.put("Immolate", new Immolate());

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

    public static Map<String, Shape> getShapeAlias() {
        return shapeAlias;
    }

    public static Map<String, EntityType> getProjectileAlias() {
        return projectileAlias;
    }
}
