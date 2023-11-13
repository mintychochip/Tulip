package mintychochip.orchid.spells;

import mintychochip.orchid.container.OrchidMechanic;
import mintychochip.orchid.shape.OrchidAoe;
import mintychochip.orchid.shape.OrchidSelf;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class IcePrison extends OrchidMechanic implements OrchidAoe, OrchidSelf {
    @Override
    public boolean castAoe() {
        Location location;
        if(getContext().getHitEntity() == null) {

        }
         return false;
    }

    @Override
    public void applyParticleAoe() {

    }

    @Override
    public boolean castSelf() {
        Player player = getContext().getPlayer();
        if(player == null) {
            return false;
        }
        Location location = player.getLocation();
        return true;

    }

    @Override
    public void applyParticleSelf() {

    }
}
