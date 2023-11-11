package mintychochip.orchid.listener;

import mintychochip.orchid.builder.PageSequencer;
import mintychochip.orchid.container.Context;
import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.container.OrchidSpell;
import mintychochip.orchid.events.AoeCastEvent;
import mintychochip.orchid.handelr.ProjectileHandler;
import mintychochip.orchid.shape.OrchidProjectile;
import mintychochip.orchid.spellcaster.OrchidCaster;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void playerInteract(PlayerInteractEvent e) {
        String page = "mechanic Fireball modifier velocity five modifier magnitude five,mechanic Explosion modifier velocity five modifier magnitude five";
        PageSequencer pageSequencer = new PageSequencer(page);
        OrchidSpell mainSpell = pageSequencer.getMainSpell();

        OrchidCaster.getInstance().
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        OrchidMechanic orchidMechanic = ProjectileHandler.getInstance().getHitMap().get(event.getEntity().getEntityId());
        if(orchidMechanic == null) {
            return;
        }
        if(orchidMechanic instanceof OrchidProjectile projectile) {
            if(orchidMechanic.getTransition() != null) {
                OrchidCaster caster = new OrchidCaster(orchidMechanic.getTransition());
                caster.cast(new Context()
            }
        }
    }

    @EventHandler
    public void onAoeCastEvent(AoeCastEvent event) {
        OrchidMechanic orchidMechanic = event.getMechanic();
        if(orchidMechanic == null) {
            return;
        }
        if(orchidMechanic.getTransition() != null) {
            OrchidCaster caster = new OrchidCaster(orchidMechanic.getTransition());
            caster.cast(new Context(event.getPlayer(),event.getLocation()));
        }
    }
}
