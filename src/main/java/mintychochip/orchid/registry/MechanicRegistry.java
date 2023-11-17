package mintychochip.orchid.registry;

import mintychochip.orchid.Orchid;
import mintychochip.orchid.config.MechanicConfig;
import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.container.OrchidMechanicSettings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MechanicRegistry {

    private final MechanicConfig mechanicConfig;
    private static Map<String, OrchidMechanic> mechanics;
    private static Map<String,OrchidMechanicSettings> loadedSettings;

    public MechanicRegistry() {
        mechanicConfig = Orchid.getMechanicConfig();
    }
    public void registerMechanics() {
        for (String key : mechanicConfig.getKeys()) {
            OrchidMechanic mechanic = mechanicConfig.getMechanic(key);
            if(mechanic == null) {
                return;
            }
            List<String> keywords = mechanicConfig.getMechanicSettings(key).getKeywords();
            if(mechanics == null) {
                mechanics = new HashMap<>();
                loadedSettings = new HashMap<>();
            }
            registerAlias(keywords,mechanic);
        }
    }

    public void registerAlias(List<String> alias, OrchidMechanic mechanic) {
        for (String s : alias) {
            mechanics.put(s,mechanic);
        }
    }

    public static Map<String, OrchidMechanic> getMechanics() {
        return mechanics;
    }
}
