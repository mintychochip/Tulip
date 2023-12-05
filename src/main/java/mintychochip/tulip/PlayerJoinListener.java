package mintychochip.tulip;

import mintychochip.tulip.container.TulipPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event) {
        TulipPlayer player = new TulipPlayer(event.getPlayer());
    }
}
