package mintychochip.orchid.spellcaster;

import mintychochip.orchid.Orchid;
import mintychochip.orchid.container.Context;
import mintychochip.orchid.container.OrchidSpell;
import mintychochip.orchid.handelr.ProjectileHandler;
import mintychochip.orchid.shape.Shape;
import mintychochip.orchid.events.AoeCastEvent;
import mintychochip.orchid.shape.OrchidAoe;
import mintychochip.orchid.shape.OrchidProjectile;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class OrchidCaster {

    private final OrchidSpell spell;

    public OrchidCaster(OrchidSpell spell) {
        this.spell = spell;
    }

    public void cast(Context context) {
        spell.getMechanic().setContext(context);
        Shape shape = spell.getMechanic().getShape();
        new BukkitRunnable() {

            @Override
            public void run() {
                switch(shape) {
                    case PROJECTILE -> {
                        if(spell.getMechanic() instanceof OrchidProjectile projectile) {
                            int i = projectile.castProjectile();
                            ProjectileHandler.getInstance().getHitMap().put(i,spell);
                            break;
                        }

                    }

                    case AOE -> {
                        if(spell.getMechanic() instanceof OrchidAoe aoe) {
                            Bukkit.broadcastMessage("explosion");
                            boolean b = aoe.castAoe();
                            Bukkit.getPluginManager().callEvent(new AoeCastEvent(shape,spell.getMechanic()));
                        }

                    }
                    default -> {
                    }
                }
            }
        }.runTaskLater(Orchid.getInstance(),5L);


    }
    public void callEvent() {

    }
}
