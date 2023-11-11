package mintychochip.orchid.util;

import mintychochip.orchid.container.OrchidSpell;
import org.bukkit.Bukkit;

public class Diagnostics {

    public static void spellIterator(OrchidSpell spell) {
        Bukkit.broadcastMessage(spell.toString());
        if(spell.getMechanic().getTransition() != null) {
            spellIterator(spell.getMechanic().getTransition());
        }
    }
}
