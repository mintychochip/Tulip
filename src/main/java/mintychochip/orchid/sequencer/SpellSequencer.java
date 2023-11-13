package mintychochip.orchid.sequencer;

import mintychochip.orchid.container.*;
import mintychochip.orchid.registry.OrchidRegistry;
import mintychochip.orchid.shape.Shape;
import mintychochip.orchid.util.SpellTokenizer;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;

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
        String name = tokenizer.getMechanicName();

        if (name != null) {
            OrchidMechanic mechanic = OrchidRegistry.getMechanicAlias().get(name);
            mechanic.setName(name);
            orchidSpell = new OrchidSpell();
            try {
                orchidSpell.setMechanic(mechanic.getClass().getDeclaredConstructor().newInstance());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        List<PackagedModifier> packagedModifiers = tokenizer.getPackagedModifiers();
        if (packagedModifiers != null) {
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
                    case ENCHANTMENT: {
                        String v = packagedModifier.getValue();
                        //add a way to grab enchant from registry
                    }
                }
            }
            if (orchidSpell.getMechanic() != null) {
                orchidSpell.getMechanic().setOrchidModifier(orchidModifier);
            }
        }

        String shape = tokenizer.getShape();
        if (shape != null) {
            orchidSpell.getMechanic().setShape(OrchidRegistry.getShapeAlias().get(shape));
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
