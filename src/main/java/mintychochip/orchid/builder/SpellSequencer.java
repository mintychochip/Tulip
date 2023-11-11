package mintychochip.orchid.builder;

import mintychochip.orchid.container.*;
import mintychochip.orchid.registry.OrchidRegistry;
import mintychochip.orchid.util.SpellTokenizer;
import org.bukkit.Bukkit;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class SpellSequencer {

    private OrchidSpell orchidSpell;
    private SpellTokenizer tokenizer;
    private String spell;

    public SpellSequencer(String spell) {
        this.spell = spell;
        tokenizer = new SpellTokenizer(spell);
        setup();
    }
    public void setup() {
        OrchidMechanic orchidMechanic = OrchidRegistry.getMechanicAlias().get(tokenizer.getMechanicName());
        if(orchidMechanic != null) {
            orchidSpell = new OrchidSpell();
            try {
                orchidSpell.setMechanic(orchidMechanic.getClass().getDeclaredConstructor().newInstance());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        List<PackagedModifier> packagedModifiers = tokenizer.getPackagedModifiers();
        if(packagedModifiers != null) {
            OrchidModifier orchidModifier = new OrchidModifier();
            for (PackagedModifier packagedModifier : tokenizer.getPackagedModifiers()) {
                switch (packagedModifier.getType()) {
                    case VELOCITY: {
                        float v = Float.parseFloat(packagedModifier.getValue());
                        orchidModifier.setVelocity(v);
                    }
                    case MAGNITUDE: {
                        float v = Float.parseFloat(packagedModifier.getValue());
                        orchidModifier.setMagnitude(v);
                    }
                }
            }
            if(orchidSpell.getMechanic() != null) {
                orchidSpell.getMechanic().setOrchidModifier(orchidModifier);
            }
        }
    }

    public OrchidSpell getOrchidSpell() {
        return orchidSpell;
    }

    public String getSpell() {
        return spell;
    }

    public SpellTokenizer getTokenizer() {
        return tokenizer;
    }
}
