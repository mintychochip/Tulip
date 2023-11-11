package mintychochip.orchid.builder;

import mintychochip.orchid.container.OrchidSpell;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PageSequencer {

    private String page;
    private OrchidSpell mainSpell;
    public PageSequencer(String page) {
        List<OrchidSpell> spells = null;
        this.page = page;
        for (String s : page.split(",")) {
            SpellSequencer spellSequencer = new SpellSequencer(s);
            if(spells == null) {
                spells = new ArrayList<>();
            }
            spells.add(spellSequencer.getOrchidSpell());
            
            Collections.reverse(spells);
            for(int i = 1; i < spells.size();i++) {
                OrchidSpell orchidSpell = spells.get(i);
                orchidSpell.getMechanic().setTransition(spells.get(i - 1));
            }
            mainSpell = spells.get(spells.size() - 1);
        }
        Collections.reverse(spells);
        for (OrchidSpell spell : spells) {
            if(spell.getMechanic().getTransition() == null) {
                Bukkit.broadcastMessage("is null check");
            } else {
                Bukkit.broadcastMessage("is good");
            }
        }

    }
    public OrchidSpell getMainSpell() {
        return mainSpell;
    }
}
