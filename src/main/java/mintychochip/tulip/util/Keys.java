package mintychochip.tulip.util;

import mintychochip.tulip.Tulip;
import org.bukkit.NamespacedKey;

public class Keys {

    private static final NamespacedKey arrowKey = new NamespacedKey(Tulip.getInstance(), "arrow");

    public static NamespacedKey getArrowKey() {
        return arrowKey;
    }
}
