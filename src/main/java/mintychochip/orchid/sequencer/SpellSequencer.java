package mintychochip.orchid.sequencer;

import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.container.OrchidModifier;
import mintychochip.orchid.container.OrchidSpell;
import mintychochip.orchid.container.PackagedModifier;
import mintychochip.orchid.registry.OrchidRegistry;
import mintychochip.orchid.util.SpellTokenizer;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class SpellSequencer {

    private OrchidSpell orchidSpell;
    private final SpellTokenizer tokenizer;
    private final String spell;

    public SpellSequencer(String spell) {
        this.spell = spell;
        tokenizer = new SpellTokenizer(spell);
        setup();
        if (!isValidSpell()) {
            spell = null;
        }
    }
    public void setup() {
        String name = tokenizer.getMechanicName();
        if (name != null) {
            orchidSpell = new OrchidSpell();
            OrchidMechanic mechanic = OrchidRegistry.getMechanicAlias().get(name);
            try {
                orchidSpell.setMechanic(mechanic.getClass().getDeclaredConstructor().newInstance());
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            orchidSpell.getMechanic().setName(name);
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

    public boolean isValidSpell() {
        return orchidSpell.getMechanic() != null;
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
