package mintychochip.orchid.util;

import mintychochip.orchid.container.Keyword;
import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.container.PackagedModifier;
import mintychochip.orchid.container.Modifier;
import mintychochip.orchid.registry.OrchidRegistry;
import mintychochip.orchid.shape.Shape;
import org.bukkit.Bukkit;

import java.util.*;

public class SpellTokenizer {
    private Map<String,Keyword> tokenizedSpell = new HashMap<>();
    private List<PackagedModifier> packagedModifiers;
    private List<Keyword> spellOrder;
    private String mechanicName;
    private String shape;

    private final String spell;

    public SpellTokenizer(String spell) {
        this.spell = spell;
        setup();
    }

    public void setup() {
        StringBuilder string = new StringBuilder();
        Keyword current = null;
        for (String s : spell.split(" ")) { //stirng,keyword format for easy parsing
            if (OrchidRegistry.getKeywordAlias().containsKey(s)) {
                tokenizedSpell.put(string.toString().strip(),current);
                current = OrchidRegistry.getKeywordAlias().get(s);
                string = new StringBuilder();
            }
            string.append(s).append(" ");
        }
        tokenizedSpell.put(string.toString(),current);
        setPackagedModifiers();

        mechanicName = getElement(Keyword.MECHANIC);
        shape = getElement(Keyword.SHAPE);
    }
    public void setPackagedModifiers() {
        List<String> checkableStrings = getCheckableStrings(Keyword.MODIFIER);
        for (String modifier : checkableStrings) {
            Modifier modifierType = null;
            String value = null;
            for (String token : modifier.split(" ")) {
                if(OrchidRegistry.getNumericalAlias().containsKey(token)) {
                    value = OrchidRegistry.getNumericalAlias().get(token);
                }
                if (OrchidRegistry.getModifierAlias().containsKey(token)) {
                    modifierType = OrchidRegistry.getModifierAlias().get(token);
                }
            }
            if(packagedModifiers == null) {
                packagedModifiers = new ArrayList<>();
            }
            packagedModifiers.add(new PackagedModifier(modifierType,value));
        }
    }
    public String getElement(Keyword keyword) {
        String holder = null;
        for (String s : tokenizedSpell.keySet()) {
            if(tokenizedSpell.get(s) == keyword) {
                holder = s;
                break;
            }
        }
        StringBuilder name = new StringBuilder();
        if(holder != null) {
            for (String s : holder.split(" ")) {
                if(!OrchidRegistry.getKeywordAlias().containsKey(s)) {
                    name.append(s).append(" ");
                }
            }
        }
        return name.toString().strip();
    }


    public List<String> getCheckableStrings(Keyword keyword) {
        List<String> result = new ArrayList<>();
        for (String s : tokenizedSpell.keySet()) {
            if(tokenizedSpell.get(s) == keyword) {
                result.add(s);
            }
        }
        return result;
    }

    public List<PackagedModifier> getPackagedModifiers() {
        return packagedModifiers;
    }

    public Map<String, Keyword> getTokenizedSpell() {
        return tokenizedSpell;
    }

    public String getMechanicName() {
        return mechanicName;
    }

    public String getShape() {
        return shape;
    }
}
