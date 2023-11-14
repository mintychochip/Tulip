package mintychochip.orchid.spellcaster;

import mintychochip.orchid.Orchid;
import mintychochip.orchid.container.Context;
import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.container.OrchidSpell;
import mintychochip.orchid.events.AoeCastEvent;
import mintychochip.orchid.events.SelfCastEvent;
import mintychochip.orchid.handler.ProjectileHandler;
import mintychochip.orchid.shape.OrchidAoe;
import mintychochip.orchid.shape.OrchidProjectile;
import mintychochip.orchid.shape.OrchidSelf;
import mintychochip.orchid.shape.Shape;
import mintychochip.orchid.shape.implementation.ProjectileImplementation;
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
                            OrchidMechanic mechanic = spell.getMechanic();
                            mechanic.setImplementation(new ProjectileImplementation(mechanic));
                            int i = projectile.castProjectile();
                            if (i > 0) {
                                ProjectileHandler.getInstance().getHitMap().put(i, spell);
                                //broadcast event here
                            }
                        }

                    }

                    case AOE -> {
                        if(spell.getMechanic() instanceof OrchidAoe aoe) {
                            Bukkit.broadcastMessage("explosion");
                            boolean b = aoe.castAoe();
                            if(b) {
                                Bukkit.getPluginManager().callEvent(new AoeCastEvent(shape,spell.getMechanic()));
                            }
                        }
                    }
                    case SELF -> {
                        if(spell.getMechanic() instanceof OrchidSelf self) {
                            Bukkit.broadcastMessage("casted");
                            boolean b = self.castSelf();
                            if(b) {
                                Bukkit.getPluginManager().callEvent(new SelfCastEvent(shape,spell.getMechanic()));
                                self.applyParticleSelf();
                            }

                        }
                    }
                    default -> {
                    }
                }
            }
        }.runTaskLater(Orchid.getInstance(),0L);


    }
    public void callEvent() {

    }
}
