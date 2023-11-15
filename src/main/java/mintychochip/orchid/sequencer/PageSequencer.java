package mintychochip.orchid.sequencer;

import mintychochip.orchid.container.OrchidSpell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PageSequencer {

    private final String page;
    private OrchidSpell mainSpell;
    public PageSequencer(String page) {
        List<OrchidSpell> spells = null;
        this.page = page;
        for (String s : page.split(",")) {
            SpellSequencer spellSequencer = new SpellSequencer(s.strip());
            if(spells == null) {
                spells = new ArrayList<>();
            }
            spells.add(spellSequencer.getOrchidSpell());

        }
        if (spells != null) {
            Collections.reverse(spells);
            for (int i = 0; i < spells.size() - 1; i++) {
                OrchidSpell orchidSpell = spells.get(i + 1);
                orchidSpell.getMechanic().setTransition(spells.get(i));
            }
            mainSpell = spells.get(spells.size() - 1);
        }
    }

    public OrchidSpell getMainSpell() {
        return mainSpell;
    }
}
