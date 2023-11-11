package mintychochip.orchid.listener;

import mintychochip.orchid.builder.PageSequencer;
import mintychochip.orchid.container.Context;
import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.container.OrchidSpell;
import mintychochip.orchid.events.AoeCastEvent;
import mintychochip.orchid.handelr.ProjectileHandler;
import mintychochip.orchid.spellcaster.OrchidCaster;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void playerInteract(PlayerInteractEvent event) {
        String page = "shape projectile mechanic Fireball modifier velocity five modifier magnitude five,shape aoe mechanic Explosion modifier velocity five modifier magnitude five,shape aoe mechanic Explosion modifier velocity five modifier magnitude five";
        PageSequencer pageSequencer = new PageSequencer(page);
        OrchidSpell mainSpell = pageSequencer.getMainSpell();

        OrchidCaster caster = new OrchidCaster(mainSpell);
        caster.cast(new Context(event.getPlayer()));
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        OrchidSpell orchidSpell = ProjectileHandler.getInstance().getHitMap().get(event.getEntity().getEntityId());
        if(orchidSpell == null) {
            return;
        }
        if(orchidSpell.getMechanic().getTransition() != null) {
            OrchidCaster caster = new OrchidCaster(orchidSpell.getMechanic().getTransition());
            Context context = orchidSpell.getMechanic().getContext();
            Location location = null;
            if(event.getHitBlock() == null) {
                location = event.getHitEntity().getLocation();
            } else {
                location = event.getHitBlock().getLocation();
            }
            caster.cast(new Context(context.getPlayer(),location,event.getHitBlock(),event.getHitEntity()));
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
            caster.cast(new Context(orchidMechanic.getContext().getPlayer(),orchidMechanic.getContext().getHitLocation()));
        }
    }
}
