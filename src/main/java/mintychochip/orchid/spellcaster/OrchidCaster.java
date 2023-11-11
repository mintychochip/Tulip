package mintychochip.orchid.spellcaster;

import mintychochip.orchid.container.Context;
import mintychochip.orchid.container.OrchidSpell;
import mintychochip.orchid.shape.Shape;
import mintychochip.orchid.events.AoeCastEvent;
import mintychochip.orchid.shape.OrchidAoe;
import mintychochip.orchid.shape.OrchidProjectile;
import org.bukkit.Bukkit;

public class OrchidCaster {

    private OrchidSpell spell;

    public OrchidCaster(OrchidSpell spell) {
        this.spell = spell;
    }

    public void cast(Context context) {
        spell.getMechanic().setContext(context);
        Shape shape = spell.getMechanic().getShape();
        switch(shape) {
            case PROJECTILE -> {
                if(spell instanceof OrchidProjectile projectile) {
                    int i = projectile.castProjectile();
                    Bukkit.getPluginManager().callEvent(new AoeCastEvent(context.getPlayer(),shape));
                }
            }
            case AOE -> {
                if(spell instanceof OrchidAoe aoe) {
                    boolean b = aoe.castAoe();

                }
            }
        }
    }
    public void callEvent() {

    }
}
