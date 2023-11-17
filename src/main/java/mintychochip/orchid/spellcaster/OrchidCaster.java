package mintychochip.orchid.spellcaster;

import mintychochip.orchid.Orchid;
import mintychochip.orchid.container.Context;
import mintychochip.orchid.container.OrchidSpell;
import mintychochip.orchid.events.AoeCastEvent;
import mintychochip.orchid.events.LaserCastEvent;
import mintychochip.orchid.events.SelfCastEvent;
import mintychochip.orchid.handler.ProjectileHandler;
import mintychochip.orchid.shape.*;
import mintychochip.orchid.shape.implementation.AoeImplementation;
import mintychochip.orchid.shape.implementation.LaserImplementation;
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
                switch (shape) {
                    case PROJECTILE -> {
                        if (spell.getMechanic() instanceof OrchidProjectile) {
                            int projectileImplementation = new ProjectileImplementation(spell.getMechanic()).castProjectile();
                            if (projectileImplementation > 0) {
                                ProjectileHandler.getInstance().getHitMap().put(projectileImplementation, spell);
                            }
                        }
                    }
                    case AOE -> {
                        if (spell.getMechanic() instanceof OrchidAoe) {
                            boolean aoeImplementation = new AoeImplementation(spell.getMechanic()).castAoe();
                            if (aoeImplementation) {
                                Bukkit.getPluginManager().callEvent(new AoeCastEvent(shape, spell.getMechanic()));
                            }
                        }
                    }
                    case SELF -> {
                        if (spell.getMechanic() instanceof OrchidSelf self) {
                            boolean b = self.castSelf();
                            if (b) {
                                Bukkit.getPluginManager().callEvent(new SelfCastEvent(shape, spell.getMechanic()));
                                self.applyParticleSelf();
                            }
                        }
                    }
                    case LASER -> {
                        if (spell.getMechanic() instanceof OrchidLaser laser) {
                            int i = new LaserImplementation(spell.getMechanic()).castLaser();
                            if(i > 0) {
                                ProjectileHandler.getInstance().getHitMap().put(i, spell);

                                Bukkit.getPluginManager().callEvent(new LaserCastEvent(shape,spell.getMechanic()));
                            }

                    }
                    }
                    default -> {
                    }
                }
            }
        }.runTaskLater(Orchid.getInstance(), 0L);


    }

    public void callEvent() {

    }
}
